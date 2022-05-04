package com.example.demo_fp01.dao.impl;

import com.example.demo_fp01.dao.BaseDao;
import com.example.demo_fp01.dao.UserDao;
import com.example.demo_fp01.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
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
    public boolean authenticate(String login, String password) {
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/testphones";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "pass");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useSSL", "true");
        prop.put("useJDBCCompliantTimezoneShift", "true");
        prop.put("useLegacyDatetimeCode", "false");
        prop.put("serverTimezone", "UTC");
        prop.put("serverSslCert", "classpath:server.crt");
        try (Connection connection = DriverManager.getConnection(url, prop);
            Statement statement = connection.createStatement()){
            String sql = "SELECT idphonebook, lastname, phone FROM phonebook";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Abonent> abonents = new ArrayList<>();
            while (resultSet.next()) {
        return false;
    }
}
