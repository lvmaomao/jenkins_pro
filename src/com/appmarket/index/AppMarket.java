package com.appmarket.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kuangwen.jenkins.util.PropertiesUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class AppMarketService
 */
@WebServlet("/AppMarket")
public class AppMarket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AppMarket() {
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
		PrintWriter out = response.getWriter();
		List<AppBean> appBeans = FileUtil.getFiles(PropertiesUtil.getValue(PropertiesUtil.DOWN_LOAD_PATH));
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();

		if (appBeans != null && !appBeans.isEmpty()) {

			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for (AppBean appBean : appBeans) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("app_name", appBean.appName);
				map.put("app_length", appBean.appLength);
				map.put("app_url", appBean.appUrl);
				map.put("app_date", appBean.appDate);
				list.add(map);
			}

			for (Object object : list) {
				jsonArray.add(object);
			}

			jsonObject.put("data", jsonArray);
			jsonObject.put("error", "");

		} else {
			jsonObject.put("data", jsonArray);
			jsonObject.put("error", "no data found");
		}
		out.println(jsonObject.toString());
		out.flush();
		out.close();
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
