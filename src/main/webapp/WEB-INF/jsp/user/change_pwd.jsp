<div data-role="page" id="page-changepwd">
	<div data-role="header" data-position="fixed">
		<h1>Change Password</h1>
		<a href="#" data-role="button" data-rel="back" data-icon="back">Back</a>
		<a href="#" data-role="button" data-icon="check" class="ui-btn-right">Done</a>
	</div>
	<div data-role="content">
		<label>Old Password:<span style="color: red" id="old-password-msg"></span></label>
		<input type="password" name="old-password" id="old-password">
		<label>New Password:<span style="color: red" id="new-password-msg"></span></label>
		<input type="password" name="new-password" id="new-password">
		<label>Confirm Password:<span style="color: red" id="confirm-password-msg"></span></label>
		<input type="password" name="confirm-password" id="confirm-password">
		<button class="ui-btn ui-corner-all ui-btn-b" id="page-changepwd-modify-btn">Submit</button>
		<button class="ui-btn ui-corner-all ui-btn-a" id="page-changepwd-reset-btn">Reset</button>
	</div>
	<script type="text/javascript">
		$(document).on('pageshow', '#page-changepwd', function(){
			$('#page-changepwd-modify-btn').click(function(){
				cleanChangePwdMsg();
				var oldpassword = $('#old-password').val();
				if(oldpassword == null || "" == oldpassword) {
					$('#old-password-msg').html("required");
					return false;
				}
				var newpassword = $('#new-password').val();
				if(newpassword == null || "" == newpassword) {
					$('#new-password-msg').html("required");
					return false;
				}
				var confirmpassword = $('#confirm-password').val();
				if(confirmpassword == null || "" == confirmpassword) {
					$('#confirm-password-msg').html("required");
					return false;
				}
				if (newpassword != confirmpassword) {
					$('#confirm-password-msg').html("mismatch");
					return false;
				}
				alert("Success");
			});
			$('#page-changepwd-reset-btn').click(function(){
				cleanChangePwdMsg();
				cleanChangePwdInput();
			});
		});
		function cleanChangePwdMsg() {
			$('#old-password-msg').empty();
			$('#new-password-msg').empty();
			$('#confirm-password-msg').empty();
		}
		function cleanChangePwdInput() {
			$('#old-password').val("");
			$('#new-password').val("");
			$('#confirm-password').val("");
		}
	</script>
</div>