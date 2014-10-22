<div data-role="page" id="page-server-menu">
	<div data-role="header" data-position="fixed">
		<h1>Menu List</h1>
		<a href="#" data-role="button" data-rel="back" data-icon="back">Back</a>
		<a href="#" data-role="button" data-icon="check" class="ui-btn-right">Done</a>
	</div>
	<div data-role="content" id="page-server-menu-content">
		
	</div>
	<div data-role="footer" style="text-align:center;">
		<a href="#page-server-menu-myPopup" data-position-to="#page-server-menu-content" data-rel="popup" class="ui-btn ui-icon-delete ui-btn-icon-left">Delete All</a>
		<div data-role="popup" id="page-server-menu-myPopup" class="ui-content">
			<a href="#" data-rel="back" class="ui-btn ui-corner-all ui-shadow ui-btn ui-icon-delete ui-btn-icon-notext ui-btn-right">Close</a>
  			<div data-role="main" class="ui-content">
  				<h2>Sure to delete?</h2>
  				<a href="#" data-mini="true" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-btn-b ui-icon-back ui-btn-icon-left" data-rel="back">Go Back</a>
  				<a href="#" id="page-server-menu-continue-btn" data-mini="true" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-btn-a ui-icon-check ui-btn-icon-left">Continue</a>
  			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).on('pageshow', '#page-server-menu', function(){
			$.ajax({
				url : 'serverMenuList',
				type : 'GET',
				dataType : 'json',
				success : function(data) {
					var menu = data.menu;
					var buttons = menu.button;
					$('#page-server-menu-content').empty();
					var result = "<div data-role=\"collapsible-set\">";
					$.each(buttons, function(i, item){
						result += "<div data-role=\"collapsible\">";
						result += "<h1>" + item.name + "</h1>";
						result += "<ol data-role=\"listview\" data-filter=\"true\" data-filter-placeholder=\"Search...\">";
						$.each(item.sub_button, function(i, subitem) {
							result += "<li><a>" + subitem.name + "</a></li>";
						});
						result += "</ol>";
						result += "</div>";
					});
					result += "</div>";
					$('#page-server-menu-content').append(result);
					$('#page-server-menu-content').trigger("create");
				},
				error : function(data) {
					alert("error");
				}
			});
			$('#page-server-menu-continue-btn').click(function(){
				$('#page-server-menu-myPopup').popup("close");
				$.ajax({
					url : 'deleteAllServerMenu',
					type : 'GET',
					dataType : 'json',
					success : function(data) {
						if(data.result == 'success') {
							alert("Delete Success");
							$('#page-server-menu').trigger("create");
						} else {
							alert("Delete Failed");
						}
					},
					error: function(data) {
						alert('Error');
					}
				});
			});
		});
	</script>
</div>