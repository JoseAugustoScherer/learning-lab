package org.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.dao.UserDAO;
import org.example.entitie.User;

import java.io.IOException;
import java.sql.SQLException;

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

    UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login    = req.getParameter( "login" );
        String password = req.getParameter( "password" );

        User user = null;
        try {
            user = userDAO.findUserByLogin( login );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if ( user != null && user.getPassword().equals( password ) ) {
            HttpSession session = req.getSession();
            session.setAttribute( "LoggedInUser", user );

            resp.sendRedirect( req.getContextPath() + "/dashboard" );
        } else {
            req.setAttribute( "errorMessage", "Invalid login or password" );

            RequestDispatcher rd = req.getRequestDispatcher( "/WEB-INF/jsp/login.jsp" );
            rd.forward( req, resp );
        }

    }
}
