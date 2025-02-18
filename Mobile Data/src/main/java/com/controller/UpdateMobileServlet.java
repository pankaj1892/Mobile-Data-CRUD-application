package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Mobile;
import com.service.MobieServiceImpl;
import com.service.MobileService;

@WebServlet("/UpdateMobileServlet")
public class UpdateMobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MobileService service;

	@Override
	public void init() throws ServletException {
		service = new MobieServiceImpl();
	}

	public UpdateMobileServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String name = request.getParameter("name");

		double price = Double.parseDouble(request.getParameter("price"));
		String date = request.getParameter("launchDate");
		LocalDate date1 = LocalDate.parse(date);
		Mobile mob = new Mobile(id, name, price, date1);
		RequestDispatcher rd = request.getRequestDispatcher("readMobile.jsp");
		int res = service.modifyMobile(mob);
		if (res > 0) {
			out.print("<h2>data update</h2>");
			rd.include(request, response);
		} else {
			out.print("<h2>data not update</h2>");
		}
	}

}
