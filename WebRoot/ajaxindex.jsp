<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btnGet").click(function() {
			//提交的参数，name和inch是和struts action中对应的接收变量
			var params = {
				name : $("#xm").val(),
				inch : $("#sg").val()
			};
			$.ajax({
				type : "POST",
				url : "loadInfo.action",
				data : params,
				dataType : "text", //ajax返回值设置为text（json格式也可用它返回，可打印出结果，也可设置成json）
				success : function(json) {
					var obj = $.parseJSON(json); //使用这个方法解析json
					var state_value = obj.result; //result是和action中定义的result变量的get方法对应的
					alert(state_value);
				},
				error : function(json) {
					alert("json=" + json);
					return false;
				}
			});
		});
	});
</script>
</head>
<body>
	<span>姓名：</span>
	<input id="xm" type="text">
	<br />
	<span>身高：</span>
	<input id="sg" type="text">
	<br />
	<input type="button" value="获取" id="btnGet" />
	<div id="info"></div>
</body>
</html>