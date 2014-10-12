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
    <div data-role="navbar">
    	<ul>
    		<li><a href="#page-local-menu" data-icon="search">Local Menu</a></li>
    		<li><a href="#page-server-menu" data-icon="search">Server Menu</a></li>
    	</ul>
    </div>
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
  	<div data-role="collapsible-set">
	    <div data-role="collapsible">
	      <h1>Interface Configuration</h1>
	      <p>APP ID:
	      	<input type="text" name="app-id" id="app-id">
	      </p> 
	      <p>APP SECRET:
	      	<input type="text" name="app-secret" id="app-secret">
	      </p>
	      <p>
	      	<button class="ui-btn ui-corner-all ui-btn-b" id="modify-btn">Save Changes</button>
	      </p>
	    </div>
	    <div data-role="collapsible" data-collapsed="false">
	      <h1>API Configuration</h1>
	      <p>Create Menu URL:</p>
	      <p>Query Menu URL:</p>
	      <p>Delete Menu URL:</p>
	    </div>
    </div>
  </div>

  <div data-role="footer">
    <div data-role="navbar">
    	<ul>
    		<li><a href="#page-changepwd" data-icon="edit">Change Password</a></li>
    		<li><a href="../logout" data-icon="action">Logout</a></li>
    	</ul>
    </div>
  </div>
  <script type="text/javascript">
  	$(document).on('pageshow', '#pagetwo', function(){
  		$.ajax({
  			url : 'syscfg',
  			type : 'GET',
  			dataType : 'json',
  			success : function(data) {
  				$('#app-id').val(data.app_id);
  				$('#app-secret').val(data.app_secret);
  			},
  			error : function(data) {
  				alert(data);
  			}
  		});
  	});
  </script>
</div>

 
<jsp:include page="menu/local_list.jsp"></jsp:include>
<jsp:include page="menu/server_list.jsp"></jsp:include>

<jsp:include page="user/change_pwd.jsp"></jsp:include>

</body>
</html>