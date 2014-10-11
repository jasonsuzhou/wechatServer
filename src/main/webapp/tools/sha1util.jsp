<%@page import="com.mh.wechat.util.WeChatUtil"%>
<%@page import="java.security.MessageDigest"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SHA-1 Utility</title>
</head>
<body>

<form action="sha1util.jsp" method="post">
	<input type="text" name="argument" required="required" size="50">
	<input type="submit" value="Submit">
</form>
<%
	String result = "";
	String argument = request.getParameter("argument");
	if (argument != null && argument.length() > 0) {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		byte[] digest = md.digest(argument.getBytes());
		result = WeChatUtil.byteToStr(digest);
	}
%>
<br />
<%=result %>
</body>
</html>