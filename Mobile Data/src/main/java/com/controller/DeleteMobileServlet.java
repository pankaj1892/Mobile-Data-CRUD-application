package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MobieServiceImpl;
import com.service.MobileService;

@WebServlet("/DeleteMobileServlet")
public class DeleteMobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MobileService service;

	@Override
	public void init() throws ServletException {

		service = new MobieServiceImpl();
	}

	public DeleteMobileServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
		  String id = request.getParameter("id");

			int res = service.removeMobile(id);
			RequestDispatcher rd = request.getRequestDispatcher("readMobile.jsp");
			if (res > 0) {
				out.print("<h2>delete date success</h2>");
				rd.include(request, response);
			} else {
				out.print("<h2>data not delete</h2>");
			}

		} catch (Exception e) {
			out.print("DeleteMobileServlet " + e);
		}

	}
}
