<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd“>
<html lang="zh-CN">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>登陆丨金龙工业物联网云管理平台</title>
	<!-- jQuery UI的CSS样式 -->
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/lib/jquery-ui-1.9.2.custom.min.css" />
	<%-- <link rel="stylesheet" type="text/css" href="<%=path%>/css/lib/jquery.validationEngine.css" /> --%>
	<!-- 登录CSS -->
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/login.css" />
	<body>
		<div class="login-container">
<%-- 			<h1><img src="<%=path%>/images/logo1_03.png" /></h1> --%>
			<div class="connect">
				<p></p>
			</div>
			<form id="loginForm" action="/loginExit/login" method="post" >
				<div>
					<input type="text" id="username" name="username" class="username" placeholder="用户名" />
					<span id="validate.info" class="validate"></span>
				</div>
				<div>
					<input type="password" id="password" name="password" class="password" placeholder="密码" />
					<span class="validate"></span>
				</div>
		        <div class="item col-xs-12" style="position: relative;">
		        	<input id="checkCode" name="checkCode" type="text" maxlength="4" class="txt03 f-r3 f-fl " placeholder="验证码" tabindex="4" style="width:167px" />
		            <span class="ie8 icon-close close hide"></span>
		            <label class="f-size12 c-999 f-fl f-pl10" style="float: right;margin-top: 54px;margin-right: 34px">
				        <img style="CURSOR:pointer" id="imgVcode" src="<%=path%>/loginExit/code?t='+Math.random();" title="看不清，换一张，点击刷新验证码 " onclick="this.src='<%=path%>/loginExit/checkCode!code.action?t='+Math.random()" />
		            </label>
		            <label class="icon-sucessfill blank hide" style="left:380px"></label>
		            <label class="focusa">看不清？<span onclick="document.getElementById('imgVcode').src='<%=path%>/loginExit/code?t='+Math.random();" class="c-blue">换一张</span></label>
		            <label id="checkCode.info" class="focus valid" style="left:370px"></label>
		            <span class="validate"></span>
		        </div>
		        <input type="submit" id="login" value="登 陆" />
				<!-- <button id="login" type="button">登 陆</button> -->
			</form>
			<a href="register.jsp">
				<button type="button" class="register-tis"> 还有没有账号？</button>
			</a>
		</div>
	</body>
	<!-- jQuery UI库 -->
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jquery-1.9.1.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jquery.alerts.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/grid.locale-cn.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jquery.form.js"></script>
	<!-- validate 验证插件 -->
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jquery.validate.min.js"></script>
	<!-- 登录页面JS -->
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/login/login.js" ></script>
</html>