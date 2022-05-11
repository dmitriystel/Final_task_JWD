package com.example.demo_fp01.dao;

import com.example.demo_fp01.exception.DaoException;

public interface UserDao {
    boolean authenticate(String login, String password) throws DaoException;
}
