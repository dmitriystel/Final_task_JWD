package com.example.demo_fp01.controller.listener;

import com.example.demo_fp01.pool.ConnectionPool;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

@WebListener
public class ServletContextListenerImpl implements ServletContextListener {
    static Logger logger = (Logger) LogManager.getLogger();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ConnectionPool.getInstance();
        logger.log(Level.INFO, "++++++++ contextInitialized: " + sce.getServletContext().getContextPath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.log(Level.INFO, "-------- contextDestroyed: " + sce.getServletContext().getContextPath());
        ConnectionPool.getInstance().destroyPool();
    }

}
