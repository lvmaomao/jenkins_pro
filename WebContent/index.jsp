<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.appmarket.index.AppBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width"/>
<meta name="viewport" content="initial-scale=1.0,user-scalable=no"/>
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link rel="stylesheet" type="text/css" href="css/list.css">
<title>轻松筹Android APK下载</title>
<link href="./resource/list.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div class="header"><p><a href=""></a><span>轻松筹Android APK下载</span></p></div>
<div class="list">
     <ul>
      <c:forEach items="${appBeans}" var="appBean">
          <li><a href="${appBean.appUrl}"><p>${appBean.appName}&nbsp;&nbsp;&nbsp; <span>下载</span></p></a></li>
      </c:forEach>
     </ul>
</div>
</body>
</html>