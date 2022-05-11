package com.example.demo_fp01.service;

import com.example.demo_fp01.exception.ServiceException;

import java.security.Provider;

public interface UserService {
    boolean authenticate(String login, String password) throws ServiceException;
}
