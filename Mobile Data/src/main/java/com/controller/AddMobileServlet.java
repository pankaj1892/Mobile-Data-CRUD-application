package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import com.dao.MobileDAO;
import com.entity.Mobile;
import com.service.MobieServiceImpl;
import com.service.MobileService;

@WebServlet("/AddMobileServlet")
public class AddMobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MobileService service;

	@Override
	public void init() throws ServletException {
		service = new MobieServiceImpl();
	}

	public AddMobileServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String modelNo = request.getParameter("modelNo");
		String name = request.getParameter("name");
		try {
			double price = Double.parseDouble(request.getParameter("price"));

			String date = request.getParameter("launchDate");
			LocalDate date1 = LocalDate.parse(date);

			Mobile mobile = new Mobile(modelNo, name, price, date1);
			int res = service.addMobile(mobile);
			if (res > 0) {
				out.print("<h2>Add Success </h2>");
			} else {

				out.print("<h2>data not add </h2>");

			}

		} catch (Exception e) {
			out.print("ADDMobileServlet " + e);
		}

	}

}
