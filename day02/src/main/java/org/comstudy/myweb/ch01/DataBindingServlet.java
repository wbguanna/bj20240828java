package org.comstudy.myweb.ch01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DataBindingServlet
 */
@WebServlet("/ch01/proc/result.do")
public class DataBindingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataBindingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest res, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setAttribute("name", null);
//		req.getSession().setAttribute("email", null);
		req.getSession().invalidate();

//		String path ="/WEB-INF/views/result.jsp";
//		RequestDispatcher view = req.getRequestDispatcher(path);
//		view.forward(req,  resp);
//		resp.sendRedirect("/ch01/input.jsp");
		resp.sendRedirect("http://localhost:8088/day02/ch01/result.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest res, HttpServletResponse resp)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		System.out.printf("전달받은 이름은:%s, 메일은:%s 이다", name, email);
		
		// request 에 바인딩
		req.setAttribute("name",name);
		
		// session 에 바인딩
		HttpSession session = req.getSession();
		session.setAttribute("email", email);
		

		String path ="/WEB-INF/views/result.jsp";
		RequestDispatcher view = req.getRequestDispatcher(path);
		view.forward(req,  resp);
	}

}
