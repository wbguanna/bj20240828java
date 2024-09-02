package org.comstudy.myapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.comstudy.myapp.command.*; 


// 매핑 - 브라우저 주소창의 URI와 실행 할 클랙스를 연결 
@WebServlet("*.phone")
public class PhoneBookApp extends HttpServlet {
	public static ArrayList<Phone> phoneList = new ArrayList<Phone>();
	// 폰 번호 클래스 새로 하나 두기..
	static int phoneSeq = 1;
	static {
		phoneList.add(new Phone(phoneSeq++, "홍길동", "010-1111-1111"));
		phoneList.add(new Phone(phoneSeq++, "김길동", "010-1111-2222"));
		phoneList.add(new Phone(phoneSeq++, "박길동", "010-1111-3333"));
	}
	
	static HashMap<String, Command> cmdMap = new HashMap<String, Command>();
	static {
		cmdMap.put("/list.phone", new ListCommand());
		cmdMap.put("/input.phone", new InputCommand());
		cmdMap.put("/search.phone", new SearchCommand());
		cmdMap.put("/modify.phone", new ModifyCommand());
		cmdMap.put("/delete.phone", new DeleteCommand());
	}
	
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		//System.out.println(req.getMethod() + " - PhoneBookApp 요청");
		//System.out.println("ContextPath: " + req.getContextPath());
		//System.out.println("RequestURI: " + req.getRequestURI());
		int beginIndex = req.getContextPath().length();
		String endPoint = req.getRequestURI().substring(beginIndex);
		System.out.println("endPoint => " + endPoint);
		Command cmd = cmdMap.get(endPoint);
		if(cmd == null) {
			System.out.println(">>>>> 요청 한 path가 존재 하지 않습니다.");
			cmd = cmdMap.get("/list.do");
		}
		cmd.process(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
}
