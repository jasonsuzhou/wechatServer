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
<div data-role="page" id="login-page">
	<div data-role="header">
		<h1>Login</h1>
	</div>
	<div data-role="content">
		<div data-role="fieldcontain">
			<label for="text-basic">User Name:</label>
			<input type="text" name="username" id="username">
			<label for="password">Password:</label>
			<input type="password" name="password" id="password" autocomplete="off">
		</div>
		<button class="ui-btn ui-corner-all ui-btn-b" id="login-btn">Sign In</button>
		<input type="reset" class="ui-btn ui-btn-a" id="reset-btn" value="Reset">
	</div>
	<div data-role="footer">
		<h1>Copyright©2014</h1>
	</div>
<script type="text/javascript">
$(document).on('pageshow','#login-page', function(){
	$('#login-btn').click(function(){
		var username = $('#username').val();
		var password = $('#password').val();
		$.ajax({
			url : 'adminlogin',
			type : 'POST',
			dataType : 'json',
			data : {username : username, password : password},
			success : function(data) {
				if(data.result == 'success') {
					self.location = 'admin/home';
				}
			}, 
			error : function(data) {
				alert(data.result);
			}
		});
	});
});
</script>
</div>
</body>
</html>