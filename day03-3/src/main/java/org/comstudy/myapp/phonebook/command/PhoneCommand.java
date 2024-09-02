package org.comstudy.myapp.phonebook.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class PhoneCommand {
	public abstract void process(HttpServletRequest res, HttpServletResponse resp) throws ServletException, IOException; 
}
