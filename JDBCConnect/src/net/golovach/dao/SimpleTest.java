package net.golovach.dao;

import net.golovach.dao.bean.User;
import net.golovach.dao.dao.UserDao;
import net.golovach.dao.dao.impl.UserDaoJdbc;
import net.golovach.dao.exception.DBException;

public class SimpleTest {

    public static void main(String[] args) throws DBException {
        UserDao dao = new UserDaoJdbc();
        System.out.println("ALL CURRENT USERS:");
        for (User user : dao.selectAll()) {
            System.out.println("    " + user.toString());
        }

        System.out.println("DELETE:");
        for (User user : dao.selectAll()) {
            dao.deleteById(user.getId());
            System.out.println("    User with id = " + user.getId() + " deleted");
        }

        System.out.println("INSERT NEW:");
        dao.insert(newUser(1, "Mike", "x@a.com"));
        System.out.println("    'Mike' inserted");
        dao.insert(newUser(2, "Sara", "y@b.com"));
        System.out.println("    'Sara' inserted");
        dao.insert(newUser(3, "Anna", "zcx.com"));
        System.out.println("    'Anna' inserted");

        System.out.println("ALL CURRENT USERS:");
        for (User user : dao.selectAll()) {
            System.out.println("    " + user.toString());
        }

    }

    public static User newUser(int id, String login, String email) {
        User result = new User(id);
        result.setLogin(login);
        result.setEmail(email);
        return result;
    }
}
