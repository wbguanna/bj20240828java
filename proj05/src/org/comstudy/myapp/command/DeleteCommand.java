package org.comstudy.myapp.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.myapp.Phone;
import org.comstudy.myapp.PhoneBookApp;

class DeleteCommand implements Command {
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 즉시 삭제 후 list 페이지로 이동
		ArrayList<Phone> list = PhoneBookApp.phoneList;
		int no = Integer.parseInt(req.getParameter("no"));
		int idx = list.indexOf(new Phone(no));
		if(idx != -1) {
			list.remove(idx);
			System.out.println("삭제 완료!");
		}
		resp.sendRedirect("list.phone");
	}
}