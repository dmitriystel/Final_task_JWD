package com.example.demo_fp01.service.impl;

import com.example.demo_fp01.dao.impl.UserDaoImpl;
import com.example.demo_fp01.exception.DaoException;
import com.example.demo_fp01.exception.ServiceException;
import com.example.demo_fp01.service.UserService;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = new UserServiceImpl();

    public UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean authenticate(String login, String password) throws ServiceException {
        // validate login, pass + md5
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        boolean match = false;
        try {
            match = userDao.authenticate(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return match;
    }
}
