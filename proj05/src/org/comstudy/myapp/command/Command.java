package org.comstudy.myapp.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.comstudy.myapp.IOException;

interface Command {
	void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
