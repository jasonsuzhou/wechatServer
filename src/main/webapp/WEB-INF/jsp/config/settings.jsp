<div data-role="page" id="settings">
   <div data-role="header">
    <h1>WeChat Console</h1>
    <div data-role="navbar">
      <ul>
        <li><a href="#pageone" data-icon="home">Home</a></li>
        <li><a href="#" class="ui-btn-active ui-state-persist" data-icon="gear">Settings</a></li>
      </ul>
    </div>
  </div>

  <div data-role="content">
  	<div data-role="collapsible-set">
	    <div data-role="collapsible" data-collapsed="false">
	      <h1>Interface Configuration</h1>
	      <p>APP ID:
	      	<input type="text" name="app-id" id="app-id">
	      </p> 
	      <p>APP SECRET:
	      	<input type="text" name="app-secret" id="app-secret">
	      </p>
	      <p>WECHAT TOKEN:
	      	<input type="text" name="wechat-token" id="wechat-token">
	      </p>
	      <p>
	      	<button class="ui-btn ui-corner-all ui-btn-b" id="modify-btn">Save Changes</button>
	      </p>
	    </div>
	    <div data-role="collapsible">
	      <h1>API Configuration</h1>
	      <p>
	      	Get Access Token API:
	      	<input type="text" name="access-token" id="access-token">
	      </p>
	      <p>Create Menu API:
	      	<input type="text" name="create-menu" id="create-menu">
	      </p>
	      <p>Query Menu API:
	      	<input type="text" name="query-menu" id="query-menu">
	      </p>
	      <p>Delete Menu API:
	      	<input type="text" name="delete-menu" id="delete-menu">
	      </p>
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
  	$(document).on('pageshow', '#settings', function(){
  		$.ajax({
  			url : 'syscfg',
  			type : 'GET',
  			dataType : 'json',
  			success : function(data) {
  				$('#app-id').val(data.app_id);
  				$('#app-secret').val(data.app_secret);
  				$('#wechat-token').val(data.wechat_token);
  				$('#access-token').val(data.access_token_url);
  				$('#create-menu').val(data.create_menu_api);
  				$('#query-menu').val(data.query_menu_api);
  				$('#delete-menu').val(data.delete_menu_api);
  			},
  			error : function(data) {
  				alert(data);
  			}
  		});
  	});
  </script>
</div>