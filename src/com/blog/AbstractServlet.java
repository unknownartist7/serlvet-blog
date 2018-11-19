package com.blog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 抽象Servlet方法
 * @author 最红
 *
 */
public abstract class AbstractServlet extends HttpServlet{

	private static final long serialVersionUID = 5891989491783275480L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request,response);
	}
}
