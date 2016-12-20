package com.kuangwen.jenkins;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kuangwen.jenkins.util.NetUtil;

/**
 * Servlet implementation class PrController
 */
@WebServlet("/PrController")
public class PrController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String no = request.getParameter("no");
		String platform = request.getParameter("platform");
		String resultStr = request.getParameter("result");
		
		System.out.println(no);
		System.out.println(platform);
		System.out.println(resultStr);
		
		boolean result = Boolean.parseBoolean(resultStr);
		String body = "";
		if (result) {
			body = "{\"body\":\"测试已通过\"}";
		} else {
			body = "{\"body\":\"测试未通过\"}";
		}
		String responseStr="";
		if("android".equals(platform)){
			responseStr = NetUtil.sendPatch("https://api.github.com/repos/joysae/qschou_android/pulls/" + no, body);			
		}else{
			responseStr = NetUtil.sendPatch("https://api.github.com/repos/joysae/qschou_ios/pulls/" + no, body);			
		}
		response.setHeader("content-type","text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("反馈成功，测试结论是：Pull Request #"+no + (result?" 通过":" 不通过"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
