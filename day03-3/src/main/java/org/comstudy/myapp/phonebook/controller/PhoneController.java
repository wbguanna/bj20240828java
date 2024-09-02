package org.comstudy.myapp.phonebook.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.myapp.phonebook.command.*;


// 컨트롤러는 spring 에서는 구현부를 가져다 쓰는 느낌임
// 서블릿에서는 구현해볼 예정...

@WebServlet("/phone/*") // 또는 .phone 요런 식으로
public class PhoneController extends HttpServlet {

	static Map<String,PhoneCommand> cmdMap = new HashMap<String, PhoneCommand>();
	
	static {
		cmdMap.put("/list.do", new PhoneListCommandImpl());
		cmdMap.put("/input.do", new PhoneInputCommandImpl());
		cmdMap.put("/search.do", new PhoneSearchCommandImpl());
		cmdMap.put("/modify.do", new PhoneModifyCommandImpl());
		cmdMap.put("/delete.do", new PhoneDeleteCommandImpl());
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		
		String METHOD = req.getMethod();
		System.out.printf("####### %s doProccess() - PhoneController\n", METHOD);
		
		
		String path = req.getRequestURI().substring((req.getContextPath()+"/phone/").length());
		System.out.println(path);
		// if-else 대신 map 사용...
		
		
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
