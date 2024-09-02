package org.comstudy.myweb;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {

	String views = "";
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
//		super.init();
		views = this.getInitParameter("views");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		ServletContext app = req.getServletContext();
		String servletData = app.getInitParameter("ServletDataFile");
		out.write("servletDataFile : " + servletData+ "<br />");
		out.write("views: " +views);
		
		System.out.println(views + servletData);
		InputStream is = this.getClass().getResourceAsStream(servletData);
		Scanner fileScanner = new Scanner(is);
		while(fileScanner.hasNext()) {
			System.out.println(fileScanner.nextLine());
		}
		out.close();
	}
	
}
