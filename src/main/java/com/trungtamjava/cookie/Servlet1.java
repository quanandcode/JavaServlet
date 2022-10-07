package com.trungtamjava.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
@WebServlet(urlPatterns = {"/servlet1"})
public class Servlet1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		Cookie cookie = new Cookie("Name", "Quan");
		cookie.setMaxAge(5);
		resp.addCookie(cookie);
		Cookie cookie2 = new Cookie("age", "20");
		cookie2.setMaxAge(10);
		resp.addCookie(cookie2);
	}
}	
