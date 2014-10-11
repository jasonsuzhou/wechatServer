<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width" />
<link rel="stylesheet" href="css/jquery.mobile-1.4.4.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/jquery.mobile-1.4.4.min.js"></script>
<title>Login</title>
</head>
<body>
<div data-role="page">
	<div data-role="header">
		<h1 data-icon="error">Error</h1>
	</div>
	<div data-role="content">
		<%  
		Exception e = (Exception)request.getAttribute("exception");  
		out.print(e.getMessage());  
		%> 
	</div>
	<div data-role="footer">
		<a href="/adminlogin" data-role="button" data-icon="home">Home</a>
		<a href="/adminlogin" data-role="button" data-icon="back" class="ui-btn-right">Back</a>
	</div>
</div>
</body>  
</html>