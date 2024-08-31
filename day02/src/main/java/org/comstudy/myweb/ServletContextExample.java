package org.comstudy.myweb;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletContextExample")
public class ServletContextExample extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        context.setAttribute("appName", "MyWebApp");

        response.getWriter().write("Application name: " + context.getAttribute("appName"));

        HttpSession session = request.getSession();
        session.setAttribute("username", "john_doe");

        response.getWriter().write("Logged in user: " + session.getAttribute("username"));
    }
}