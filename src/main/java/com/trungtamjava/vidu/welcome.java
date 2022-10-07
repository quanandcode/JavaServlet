package com.trungtamjava.vidu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/welcome" })
public class welcome extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		Cookie[] cookies = req.getCookies();
		String name = "";
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("name")) {
					name = c.getValue();
				}
			}
			if (name == "") {
				resp.sendRedirect("/CookieTest/login");
			}else {
				printWriter.println("Hi "+ name +" welcome to GDSVCG Y Duoc");
			}
			
		} else {
			resp.sendRedirect("/CookieTest/login");
		}

	}
}
