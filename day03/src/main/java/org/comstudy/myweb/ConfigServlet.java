package org.comstudy.myweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigServlet extends HttpServlet {

    private String views;

    @Override
    public void init() throws ServletException {
        // init-param에서 authorName 가져오기
        views= getInitParameter("views");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // context-param에서 appTitle 가져오기
        String servletData = getServletContext().getInitParameter("ServletDataFile");

        out.println("<html><head><title>Config Example</title></head><body>");
        out.println("<h1>" + views + "</h1>");
        out.println("<p>Author: " + servletData + "</p>");
        out.println("</body></html>");
        out.close();
    }
}
