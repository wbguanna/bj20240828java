package org.comstudy.myweb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todo/input")
public class TodoInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoInput() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String path ="/WEB-INF/views/TodoInput.jsp";
		RequestDispatcher view = req.getRequestDispatcher(path);
		view.forward(req,  res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		doGet(req, res);
	}

}
