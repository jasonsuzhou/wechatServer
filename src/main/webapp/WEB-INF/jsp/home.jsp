<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<div data-role="page" id="pageone">
  <div data-role="header" data-position="fixed">
    <h1>WeChat Console</h1>
    <div data-role="navbar">
      <ul>
        <li><a href="#" class="ui-btn-active ui-state-persist" data-icon="home">Home</a></li>
        <li><a href="#pagetwo" data-icon="arrow-r">Menu</a></li>
      </ul>
    </div>
  </div>

  <div data-role="content">
    <p>TODO</p>
  </div>

  <div data-role="footer">
    <div data-role="navbar">
    	<ul>
    		<li><a href="#page-changepwd" data-icon="edit">Change Password</a></li>
    		<li><a href="../logout" data-icon="action">Logout</a></li>
    	</ul>
    </div>
  </div> 
</div> 

<div data-role="page" id="pagetwo">
   <div data-role="header">
    <h1>WeChat Console</h1>
    <div data-role="navbar">
      <ul>
        <li><a href="#pageone" data-icon="home">Home</a></li>
        <li><a href="#" class="ui-btn-active ui-state-persist" data-icon="arrow-r">Menu</a></li>
      </ul>
    </div>
  </div>

  <div data-role="content">
    <p>TODO</p>
  </div>

  <div data-role="footer">
    <div data-role="navbar">
    	<ul>
    		<li><a href="#page-changepwd" data-icon="edit">Change Password</a></li>
    		<li><a href="../logout" data-icon="action">Logout</a></li>
    	</ul>
    </div>
  </div>
</div> 

<div data-role="page" id="page-changepwd">
	TODO
</div>

</body>
</html>