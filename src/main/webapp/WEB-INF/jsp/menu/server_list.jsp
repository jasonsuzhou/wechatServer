<div data-role="page" id="page-server-menu">
	<div data-role="header" data-position="fixed">
		<h1>Menu List</h1>
		<a href="#" data-role="button" data-rel="back" data-icon="back">Back</a>
		<a href="#" data-role="button" data-icon="check" class="ui-btn-right">Done</a>
	</div>
	<div data-role="content" id="page-server-menu-content">
		
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
						result += "<ol data-role=\"listview\">";
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
		});
	</script>
</div>