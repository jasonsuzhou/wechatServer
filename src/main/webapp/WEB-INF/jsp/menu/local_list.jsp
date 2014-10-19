<div data-role="page" id="page-local-menu">
	<div data-role="header" data-position="fixed">
		<h1>Menu List</h1>
		<a href="#" data-role="button" data-rel="back" data-icon="back">Back</a>
		<a href="#" data-role="button" data-icon="check" class="ui-btn-right">Done</a>
	</div>
	<div data-role="content" id="page-local-menu-content">
		
	</div>
	<div data-role="footer" style="text-align:center;">
		<a href="#myPopup" data-position-to="#page-local-menu-content" data-rel="popup" class="ui-btn ui-icon-plus ui-btn-icon-left">Push To Server</a>
		<div data-transition="flow" data-role="popup" id="myPopup" class="ui-content">
			<a href="#" data-rel="back" class="ui-btn ui-corner-all ui-shadow ui-btn ui-icon-delete ui-btn-icon-notext ui-btn-right">Close</a>
  			<div data-role="main" class="ui-content">
  				<h2>Overwritten server menu?</h2>
  				<a href="#" data-mini="true" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-btn-b ui-icon-back ui-btn-icon-left" data-rel="back">Go Back</a>
  				<a href="#" data-mini="true" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-btn-a ui-icon-check ui-btn-icon-left">Continue</a>
  			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).on('pageshow', '#page-local-menu', function(){
			$.ajax({
				url : 'localMenuList',
				type : 'GET',
				dataType : 'json',
				success : function(data) {
					$('#page-local-menu-content').empty();
					var result = "<div data-role=\"collapsible-set\">";
					$.each(data, function(i, item){
						result += "<div data-role=\"collapsible\">";
						result += "<h1>" + item.name + "</h1>";
						result += "<ol data-role=\"listview\"  data-inset=\"true\">";
						$.each(item.sub_button, function(i, subitem) {
							var para = "{dataUrl:'home#page-local-menu-detail', type:'post', data:{key:"+subitem.key+"}}";
							result += "<li><a data-rel=\"dialog\" data-transition=\"pop\"  href=\"javascript:$.mobile.changePage('showLocalMenuDetail',"+para+")\">" + subitem.name + "</a></li>";
						});
						result += "</ol>";
						result += "</div>";
					});
					result += "</div>";
					$('#page-local-menu-content').append(result);
					$('#page-local-menu-content').trigger("create");
				},
				error : function(data) {
					alert("error");
				}
			});
		});
	</script>
</div>
