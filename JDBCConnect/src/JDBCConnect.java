import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 05.01.13
 * Time: 16:10
 * To change this template use File | Settings | File Templates.
 */
public class JDBCConnect {
    public static void main(String[] args) throws SQLException {
        /**
         * эта строка загружает драйвер DB.
         * раскомментируйте если прописываете драйвер вручную
         */
        //Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/javalearning",
                "root", "root");

        if (conn == null) {
            System.out.println("Нет соединения с БД!");
            System.exit(0);
        }

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM t");

        while (rs.next()) {
            System.out.println(rs.getInt("id") + "_" + rs.getString("name") + "_" + rs.getInt("age"));
        }

        /**
         * stmt.close();
         * При закрытии Statement автоматически закрываются
         * все связанные с ним открытые объекты ResultSet
         */
        stmt.close();
    }
}
