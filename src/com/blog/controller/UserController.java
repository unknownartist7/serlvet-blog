package com.blog.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.AbstractServlet;

@WebServlet(urlPatterns = "/user",name = "user" , displayName = "user")
public class UserController extends AbstractServlet{

	private static final long serialVersionUID = 5114278730024173652L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> list = new ArrayList<>();
		
		for(int i = 0;i < 50;i++){
			list.add("Lucy"+i);
		}
		
		request.setAttribute("users", list);
		request.getRequestDispatcher("/WEB-INF/pages/user.jsp").forward(request, response);;
	}
}
