package org.comstudy.common.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command {
	
	
	/**
	 * @return String 타입의 뷰네임 반환
	 * */
	public abstract String process (HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException;
	
}