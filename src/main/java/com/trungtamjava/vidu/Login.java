package com.trungtamjava.vidu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<form action='/CookieTest/login' method='post'>");
		printWriter.println("Username :<input name='username' type='text'>");
		printWriter.println("Password :<input name='password' type='password'>");
		printWriter.println("<input value='Login' type='submit'>");
		printWriter.println("</form>");
		printWriter.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if(username.equals("quan9acn@gmail.com") && password.equals("123456789")) {
			
			Cookie cookie = new Cookie("name", username);
			cookie.setMaxAge(50);
			resp.addCookie(cookie);
			resp.sendRedirect("/CookieTest/welcome");
		}else {
			resp.sendRedirect("/CookieTest/login");
		}
		
	}
}
