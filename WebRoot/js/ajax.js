function Login(LogAccount, LogPwd, callback) {
	var params = {
		'user.FName' : LogAccount,
		'user.FEmail' : LogPwd
	};
	$.ajax({
		type : "POST",
		url : "loadInfo.action",
		data : params,
		dataType : "text",
		success : function(json) {
			var obj = $.parseJSON(json);
			var state_value = obj.result;
			// callback();
			alert(state_value);
			callback();
		},
		error : function(json) {
			alert("json=" + json);
			return false;
		},
		statusCode : {
			404 : function() {
				alert("page not found");
			}
		}
	});
}