package net.golovach.dao.dao.impl;

import net.golovach.dao.bean.User;
import net.golovach.dao.dao.UserDao;
import net.golovach.dao.exception.DBException;
import net.golovach.dao.exception.NotUniqueUserEmailException;
import net.golovach.dao.exception.NotUniqueUserLoginException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbc implements UserDao {
    //public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/production_eshop";
    public static final String LOGIN = "root";
    public static final String PASSWORD = "root";

    public static final String SELECT_ALL_SQL = "SELECT id, login, email FROM user";
    public static final String DELETE_BY_ID_SQL = "DELETE FROM user WHERE id = ?";
    public static final String INSERT_SQL = "INSERT INTO user (login, email) VALUES (?, ?)";
    public static final String SELECT_BY_LOGIN = "SELECT id FROM user WHERE login=?";
    public static final String SELECT_BY_EMAIL = "SELECT id FROM user WHERE email=?";

/*    static {
        JdbcUtils.initDriver(DRIVER_CLASS_NAME);
    }*/

    private Connection getConnection() throws DBException {
        try {

            return DriverManager.getConnection(JDBC_URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            throw new DBException("Can't create connection", e);
        }
    }

    @Override
    public List<User> selectAll() throws DBException {
        Connection conn = getConnection();
        Statement statement = null;
        ResultSet rs = null;
        try {
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(false);
            statement = conn.createStatement();
            rs = statement.executeQuery(SELECT_ALL_SQL);
            List<User> result = new ArrayList<User>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String login = rs.getString("login");
                String email = rs.getString("email");
                User user = new User(id);
                user.setLogin(login);
                user.setEmail(email);
                result.add(user);
            }
            conn.commit();
            return result;
        } catch (SQLException e) {
            JdbcUtils.rollbackQuietly(conn);
            throw new DBException("Can't execute SQL = '" + SELECT_ALL_SQL + "'", e);
        } finally {
            JdbcUtils.closeQuietly(rs);
            JdbcUtils.closeQuietly(statement);
            JdbcUtils.closeQuietly(conn);
        }
    }

    @Override
    public int deleteById(int id) throws DBException {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        try {
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(DELETE_BY_ID_SQL);
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            conn.commit();
            return result;
        } catch (SQLException e) {
            JdbcUtils.rollbackQuietly(conn);
            throw new DBException("Can't execute SQL = '" + DELETE_BY_ID_SQL + "'", e);
        } finally {
            JdbcUtils.closeQuietly(ps);
            JdbcUtils.closeQuietly(conn);
        }
    }

    @Override
    public void insert(User user) throws DBException, NotUniqueUserLoginException, NotUniqueUserEmailException {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        try {
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(false);

            if (existWithLogin0(conn, user.getLogin())) {
                throw new NotUniqueUserLoginException("Login '" + user.getLogin() + "' doubled");
            }
            if (existWithEmail0(conn, user.getEmail())) {
                throw new NotUniqueUserEmailException("Email '" + user.getEmail() + "' doubled");
            }

            ps = conn.prepareStatement(INSERT_SQL);

            ps.setString(1, user.getLogin());
            ps.setString(2, user.getEmail());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            JdbcUtils.rollbackQuietly(conn);
            e.printStackTrace();
            throw new DBException("Can't execute SQL = '" + INSERT_SQL + "'", e);

        } finally {
            JdbcUtils.closeQuietly(ps);
            JdbcUtils.closeQuietly(conn);
        }
    }

    private boolean existWithLogin0(Connection conn, String login) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(SELECT_BY_LOGIN);
        ps.setString(1, login);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    private boolean existWithEmail0(Connection conn, String email) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(SELECT_BY_EMAIL);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
}

