package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author José Augusto Scherer - jose.a.scherer@gmail.com
 * @file LoginController
 * @since 30/09/2025 - 14:24
 * --------------------
 * WebServlet responsible for handling login and logout requests.
 * --------------------
 */

@WebServlet ( name = "LoginController", urlPatterns = { "/login", "/logout" })
public class LoginController
    extends
        HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }
}
