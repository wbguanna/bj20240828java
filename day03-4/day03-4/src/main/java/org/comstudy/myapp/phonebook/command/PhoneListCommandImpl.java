package org.comstudy.myapp.phonebook.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.myapp.phonebook.model.Phone;
import org.comstudy.myapp.phonebook.model.PhoneDAO;


//@WebServlet("phone/list.do") // 
public class PhoneListCommandImpl implements PhoneCommand {

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Phone> list = PhoneDAO.phoneList;
		String name = req.getParameter("name");
		if(name != null && !name.equals("")) {
			// 새 목록 생성
			System.out.println("name이 있다!");
			ArrayList<Phone> newList = new ArrayList<Phone>();
			for(Phone phone : PhoneDAO.phoneList) {
				if(phone.getName().indexOf(name) != -1) {
					newList.add(phone);
				}
			}
			list = newList;
		}
		
		// 리스트 데이터 바인딩
		req.setAttribute("list", list);
		// 리스트.jsp 페이지로 forward
		// forward 경로 지정 (init-param 지정, string 하드코딩)
		String viewName = "/WEB-INF/views/list.jsp"; 
		req.getRequestDispatcher(viewName).forward(req, resp);
	}

}
