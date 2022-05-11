package com.example.demo_fp01.command;

import com.example.demo_fp01.exception.CommandException;
import com.example.demo_fp01.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
@FunctionalInterface
public interface Command {
    String execute (HttpServletRequest request) throws CommandException;
    default void refresh(){}
}
