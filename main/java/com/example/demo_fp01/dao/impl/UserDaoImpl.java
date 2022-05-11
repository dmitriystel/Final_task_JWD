package com.example.demo_fp01.dao.impl;

import com.example.demo_fp01.dao.BaseDao;
import com.example.demo_fp01.dao.UserDao;
import com.example.demo_fp01.entity.User;
import com.example.demo_fp01.exception.DaoException;
import com.example.demo_fp01.pool.ConnectionPool;
import com.mysql.cj.jdbc.Driver;
import org.intellij.lang.annotations.Language;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    public static final String SELECT_LOGIN_PASSWORD = "SELECT password FROM users WHERE lastnmane = ?";

    private static UserDaoImpl instance = new UserDaoImpl();
    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance() {
        return instance;
    }

    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        throw new UnsupportedOperationException("delete unsupported");
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean authenticate(String login, String password) throws DaoException {
        boolean match = false;  //  объявляю переменную, совпал-не совпал

        try (Connection connection = ConnectionPool.getInstance().getConnection();    //  открыл конекшн
             PreparedStatement statement = connection.prepareStatement(SELECT_LOGIN_PASSWORD)) {  //  создал Statement
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();  //  выполнил запрос
            String passFromDb;
            if (resultSet.next()) { //  если есть там что-то
                passFromDb = resultSet.getString(1);    //  получили пассворд
                match = password.equals(passFromDb);
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return match;
    }
}
