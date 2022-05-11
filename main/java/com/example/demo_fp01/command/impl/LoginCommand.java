package com.example.demo_fp01.command.impl;

import com.example.demo_fp01.command.Command;
import com.example.demo_fp01.exception.CommandException;
import com.example.demo_fp01.exception.ServiceException;
import com.example.demo_fp01.service.UserService;
import com.example.demo_fp01.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String login = request.getParameter("login");
        String password = request.getParameter("pass");
        UserService userService = UserServiceImpl.getInstance();
        String page;
        HttpSession session = request.getSession();
        try {
            if (userService.authenticate(login, password)){
                request.setAttribute("user", login);

                session.setAttribute("user_name", login);
                page = "pages/main.jsp";

            } else {
                request.setAttribute("login_msg", "incorrect login or pass");
                page = "index.jsp";
            }
            session.setAttribute("current_page", page);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return page;
    }
}
