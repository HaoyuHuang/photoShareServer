<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<link href="styles/core.css" type="text/css" rel="stylesheet" />
<script src="js/jquery-1.4.2.min.js" type="text/javascript"
	language="javascript"></script>
<script src="js/popup_layer.js" type="text/javascript"
	language="javascript"></script>
<script type="text/javascript" language="javascript" src="js/ajax.js"></script>
<script language="javascript">
	$(document)
			.ready(
					function() {
						var popLayout = new PopupLayer({
							trigger : "#popupLayoutTrigger",
							popupBlk : "#popupLayout",
							closeBtn : "#popupLayoutCloseBtn",
							useOverlay : true,
							useFx : true,
							offsets : {
								x : 0,
								y : -41
							}
						});
						popLayout.doEffects = function(way) {
							if (way == "open") {
								this.popupLayer
										.css({
											opacity : 0.3
										})
										.show(
												0,
												function() {
													this.popupLayer
															.animate(
																	{
																		left : ($(
																				document)
																				.width() - this.popupLayer
																				.width()) / 2,
																		top : (document.documentElement.clientHeight - this.popupLayer
																				.height())
																				/ 2
																				+ $(
																						document)
																						.scrollTop(),
																		opacity : 0.8
																	},
																	0,// duration
																	function() {
																		this.popupLayer
																				.css(
																						"opacity",
																						1);
																	} // callback
																			.binding(this));
												}.binding(this));
							} else {
								this.popupLayer.animate({
									left : this.trigger.offset().left,
									top : this.trigger.offset().top,
									opacity : 0.1
								}, {
									duration : 500,
									complete : function() {
										this.popupLayer.css("opacity", 1);
										this.popupLayer.hide();
									}.binding(this)
								});
							}
						};
						$("#popupLayoutSubmitBtn").click(
								function() {
									Login($("#LogAccount").val(), $("#LogPwd")
											.val(), function() {
										popLayout.close();
									});
								});
					});
</script>
</head>
<body>

	<div class="content">
		
	</div>
	<div class="popupLayout">
		<div class="clearner_w30"></div>
		<div>
			<ul>
				<li id="popupLayoutTrigger">您的账号</li>
				<li><a>新突破</a></li>
				<li><a>新发现</a></li>
				<li><a>联系我们</a></li>
			</ul>
		</div>
		<div class="clearner_w30"></div>
		<div class="clr"></div>
		<div id="popupLayout" class="blk" style="display: none;">
			<div class="head">
				<div class="head-right"></div>
			</div>
			<div class="main">
				<h2>请登录</h2>
				<a href="javascript:void(0)" id="popupLayoutCloseBtn" class="Btn">关闭</a>
				<div>
					用户名:&nbsp;&nbsp;<input id="LogAccount" type="text" class="textbox" />
				</div>
				<div>
					密码：&nbsp;&nbsp;<input id="LogPwd" type="text" class="textbox" />
				</div>
				<div>
					<a href="javascript:void(0)" id="popupLayoutSubmitBtn">登录</a>
				</div>
			</div>
			<div class="footer"></div>
		</div>
	</div>
</body>
</html>

