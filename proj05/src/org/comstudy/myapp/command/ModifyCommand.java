package org.comstudy.myapp.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.myapp.Phone;
import org.comstudy.myapp.PhoneBookApp;

class ModifyCommand implements Command {
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Phone> list = PhoneBookApp.phoneList;
		int no = Integer.parseInt(req.getParameter("no"));
		int idx = list.indexOf(new Phone(no));
		if("POST".equals(req.getMethod())) {
			//  수정 처리 후 리스트로 이동
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			PhoneBookApp.phoneList.get(idx).setName(name); 
			PhoneBookApp.phoneList.get(idx).setPhone(phone); 
			resp.sendRedirect("list.phone");
		}
		Phone phone = list.get(idx);
		PrintWriter out = resp.getWriter();
		out.write("<!DOCTYPE html>\r\n");
		out.write("<html>\r\n");
		out.write("<head>\r\n");
		out.write("<meta charset=\"UTF-8\">\r\n");
		out.write("<title>index.jsp</title>\r\n");
		out.write("</head>\r\n");
		out.write("<body>\r\n");
		out.write("<h2>전화 번호 수정</h2>\r\n");
		out.write(String.format("<form action=\"modify.phone\" method=\"POST\">\r\n" + 
				"<table>\r\n" + 
				"<tr>\r\n" + 
				"<th>NO</th>\r\n" + 
				"<td><input type=\"hidden\" name=\"no\" value=\"%d\">%d</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<th>성명</th>\r\n" + 
				"<td><input type=\"text\" name=\"name\" value=\"%s\"></td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<th>성명</th>\r\n" + 
				"<td><input type=\"text\" name=\"phone\" value=\"%s\"></td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td colspan=\"2\"><input type=\"submit\" value=\"저장\"></td>\r\n" + 
				"</tr>\r\n" + 
				"</table>\r\n" + 
				"</form>", 
				phone.getNo(), 
				phone.getNo(), 
				phone.getName(), 
				phone.getPhone()));
		out.write("</body>\r\n");
		out.write("</html>");
		out.close();
	}
}