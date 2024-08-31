package org.comstudy.myweb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todo/*")
public class TodoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static ArrayList<TodoVo> todoList  = new ArrayList<TodoVo>();;
	static {
		todoList.add(new TodoVo(101,"새 할일",  false));
		todoList.add(new TodoVo(101,"새 할일",  false));
		todoList.add(new TodoVo(101,"새 할일",  false));
	}
	
	public TodoController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("##### doget - todoCont");
		
		String reqUri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		
		int beginIndex = reqUri.lastIndexOf(ctxPath);
		String path = reqUri.substring(beginIndex);
		System.out.println("reqUri >>> " + reqUri);
		System.out.println("ctxPath >>> " + ctxPath);
		System.out.println("path >>> " + path);
		
		String viewName = "";
		// 방법은 만들어 내려면 어떤 방법이든 만들어 낼 수 있다...
		if("/todo/input".contentEquals(path)) {
			// 파라미터 받아오기
			String title = req.getParameter("title");
			viewName = "WEB-INF/views/TodoInput.jsp";
		} else if("/todo/detail".contentEquals(path)) {
			viewName = "WEB-INF/views/TodoDetail.jsp";
		} else if("/todo/modify".contentEquals(path)) {
			viewName = "WEB-INF/views/TodoModify.jsp";
		} else if("/todo/delete".contentEquals(path)) {
			viewName = "WEB-INF/views/TodoDelete.jsp";
		} else {
			viewName = "WEB-INF/views/TodoList.jsp";
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	
	
}
