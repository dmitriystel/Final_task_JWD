package com.example.demo_fp01.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter( urlPatterns = { "/pages/*"},
    initParams = { @WebInitParam(name = "INDEX_PATH", value = "/index.jsp")})

public class SecurityFilter implements Filter {
    private String indexPath;
    public void init(FilterConfig fConfig) throws ServletException {
        indexPath = fConfig.getInitParameter("INDEX_PATH");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.sendRedirect (httpRequest.getContextPath() + indexPath);
        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}