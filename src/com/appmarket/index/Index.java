package com.appmarket.index;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kuangwen.jenkins.util.NetUtil;

/**
 * Servlet implementation class IndexService
 */
@WebServlet("/Index")
public class Index extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String rootPath = getServletContext().getRealPath("/").replace("\\", "/");
		String path = rootPath + FileUtil.DIR;
		List<AppBean> appBeans = FileUtil.getFiles(path);
		if (appBeans != null && !appBeans.isEmpty()) {
			request.setAttribute("appBeans", appBeans);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "no data found");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
