package com.example.demo_fp01.dao;

public interface UserDao {
    boolean authenticate(String login, String password);
}
