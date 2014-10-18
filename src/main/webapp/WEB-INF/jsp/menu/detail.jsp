<%@page import="com.mh.wechat.entity.MenuButton"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
MenuButton menuButton = (MenuButton) request.getAttribute("data");
%>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width" />
<link rel="stylesheet" href="../css/jquery.mobile-1.4.4.min.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/jquery.mobile-1.4.4.min.js"></script>
<title>Login</title>
</head>
<body>
<div data-role="page" id="page-local-menu-detail">
<%
MenuButton menu = (MenuButton) request.getAttribute("data");
%>
	<div data-role="header">
		<h3>Menu Detail</h3>
		<a data-role="button" data-rel="back" data-mini="true" data-icon="back">Back</a>
	</div>
	<div data-role="content">
		<div data-role="fieldcontain">
			<label for="key">Key:</label>
			<input type="text" name="key" id="key" value="<%=menu.getKey()%>">
			<label for="type">Type:</label>
			<input type="text" name="type" id="type" value="<%=menu.getType()%>">
			<label for="name">Name:</label>
			<input type="text" name="name" id="name" value="<%=menu.getName()%>">
			<label for="url">URL:</label>
			<input type="text" name="url" id="url" value="<%=menu.getUrl()%>">
		</div>
		<button class="ui-btn ui-corner-all ui-btn-b" id="page-local-menu-detail-modify-btn">Save Changes</button>
	</div>
	<script type="text/javascript">
	$(document).on('pageshow', '#page-local-menu-detail', pageShow);
	function pageShow() {
		//$(document).unbind('pageshow');
		$(document).off('pageshow', '#page-local-menu-detail');
	}
	</script>
</div>
</body>