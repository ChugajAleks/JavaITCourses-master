package net.golovach.dao.dao;

import net.golovach.dao.bean.User;
import net.golovach.dao.exception.DBException;
import net.golovach.dao.exception.NotUniqueUserEmailException;
import net.golovach.dao.exception.NotUniqueUserLoginException;

import java.util.List;

public interface UserDao {

    public List<User> selectAll() throws DBException;

    public int deleteById(int id) throws DBException;

    public void insert(User user) throws DBException, NotUniqueUserLoginException, NotUniqueUserEmailException;
}
