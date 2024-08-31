package org.comstudy.myweb;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어노테이션을 이용해서 URL 매핑을 하는 대신 web.xml에 URL 매핑한다..
public class LifecycleServlet extends HttpServlet {

	
	public LifecycleServlet() {
		System.out.println("######### 1. 생성자() - LifecycleServlet");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("######### 3. service() - LifecycleServlet");
        // 요청 처리 및 응답 생성
		resp.setContentType("text/html");
        ServletOutputStream out = resp.getOutputStream();
        out.println("<html><body>");
        out.println("<h1>Hello, Servlet!</h1>");
        out.println("</body></html>");
        out.close();
	}

	@Override
	public void destroy() {
		System.out.println("######### 4. destroy() - LifecycleServlet");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("######### 2. init() - LifecycleServlet");
	}

	@Override
	public void log(String message, Throwable t) {
		// TODO Auto-generated method stub
		super.log(message, t);
	}

	@Override
	public void log(String msg) {
		// TODO Auto-generated method stub
		super.log(msg);
	}
	

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
	
	

}
