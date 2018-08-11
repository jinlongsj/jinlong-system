<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>



					<div class="part1">
	                	<!-- 驾校注册页面提交的表单 -->
	                	<form id="register_user_form" name="register_user_form" method="post">
		                    <div class="item col-xs-12">
		                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>用户名称：</span>
		                        <div class="f-fl item-ifo">
		                         	<input name="user.roleId" type="hidden" value="3" />
 		                            <input id="userName" name="user.userName" type="text" class="txt03"/>
		                    		<div class="focus">用户名称填写请保持在1-50个字符以内，其中1个汉字等于2个字符</div>
		                    	</div>
		                    </div>
		                    <div class="item col-xs-12">
		                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>手机号：</span>
		                        <div class="f-fl item-ifo">
		                        	<input id="mobilePhone" name="user.mobilePhone" type="text" class="txt03" maxlength="11" />
<!-- 		                            <input id="mobilephone" name="user.mobilePhone" type="text" class="txt03 f-r3 required" /> -->
		                    		<div class="focus">请填写11位有效的手机号码</div>
<!-- 		                            <input name="user.mobilePhone" type="text" class="txt03 f-r3 required" keycodes="tel" tabindex="2" data-valid="isNonEmpty||isPhone" data-error="手机号码不能为空||手机号码格式不正确" maxlength="11" id="phone" /> -->
<%-- 		                            <span class="ie8 icon-close close hide"></span> --%>
<!-- 		                            <label class="icon-sucessfill blank hide"></label> -->
<!-- 		                            <label id="mobilePhone.info" class="focus valid"></label> -->
		                        </div>
		                    </div>
		                    <div class="item col-xs-12">
		                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>密码：</span>
		                        <div class="f-fl item-ifo">
		                            <input type="password" id="password" name="password" class="txt03" maxlength="20" />
		                    		<div class="focus">6-20位英文（区分大小写）、数字、字符的组合</div>
<!-- 		                            <input type="password" id="password" name="password" maxlength="20" class="txt03 f-r3 required" tabindex="3" style="ime-mode:disabled;" onpaste="return  false" autocomplete="off" data-valid="isNonEmpty||between:6-20||level:2" data-error="  ||密码长度6-20位||该密码太简单，有被盗风险，建议字母+数字的组合" /> -->
		                            <span class="ie8 icon-close close hide" style="right:55px"></span>
		                            <span class="showpwd" data-eye="password"></span>
<!-- 		                            <label class="icon-sucessfill blank hide"></label> -->
<!-- 		                            <label class="focus valid"></label> -->
<%-- 		                            <span class="clearfix"></span> --%>
		                            <label class="strength">
		                                <span class="f-fl f-size12">安全程度：</span>
		                                <b><i>弱</i><i>中</i><i>强</i></b>
		                            </label>
		                        </div>
		                    </div>
		                    <div class="item col-xs-12" >
		                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>确认密码：</span>
		                        <div class="f-fl item-ifo">
		                            <input id="rePassword" name="user.password" type="password" class="txt03" maxlength="20" />
		                    		<div class="focus">请再输入一遍上面的密码</div>
<!-- 		                            <input name="user.password" type="password" maxlength="20" class="txt03 f-r3 required" tabindex="4" style="ime-mode:disabled;" onpaste="return  false" autocomplete="off" data-valid="isNonEmpty||between:6-16||isRepeat:password" data-error="密码不能为空||密码长度6-16位||两次密码输入不一致" id="rePassword" /> -->
		                            <span class="ie8 icon-close close hide" style="right:55px"></span>
		                            <span class="showpwd" data-eye="rePassword"></span>
<!-- 		                            <label class="icon-sucessfill blank hide"></label> -->
<!-- 		                            <label class="focus valid"></label> -->
		                        </div>
		                    </div>
		                    <div class="item col-xs-12">
		                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>验证码：</span>
		                        <div class="f-fl item-ifo">
		        					<input id="checkCode" name="checkCode" type="text" maxlength="4" class="txt03 f-r3 f-fl " tabindex="4" style="width:167px" />
<!-- 		                            <input id="checkCode" name="checkCode" type="text" maxlength="4" class="txt03" style="width:167px" /> -->
<!-- 		                            <input id="checkCode" name="checkCode" type="text" maxlength="4" class="txt03 f-r3 f-fl required" tabindex="4" style="width:167px" id="randCode" data-valid="isNonEmpty" data-error="验证码不能为空" /> -->
<%-- 		                            <span class="ie8 icon-close close hide"></span> --%>
		                            <label class="f-size12 c-999 f-fl f-pl10">
				          				<img style="CURSOR:pointer" id="imgVcode" src="<%=path%>/userRegister/checkCode!code.action" title="点击刷新验证码 " onclick="this.src='<%=path%>/userRegister/checkCode!code.action?t='+Math.random()" />
		                            </label>
<!-- 		                            <label class="icon-sucessfill blank hide" style="left:380px"></label> -->
		                            <label class="checkCode">看不清？<span onclick="document.getElementById('imgVcode').src='<%=path%>/userRegister/checkCode!code.action?t='+Math.random();" class="c-blue">换一张</span></label>
		                            <label id="checkCode.info" class="focus valid" style="left:370px"></label>
		                        </div>
		                    </div>
		                    <div class="item col-xs-12">
		                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>手机验证码：</span>
		                        <div class="f-fl item-ifo">
		                            <input id="verifyNo" name="verifyNo" type="text" maxlength="4" class="txt03 f-r3 f-fl" tabindex="4" style="width:167px" />
		                            <span class="btn btn-gray f-r3 f-ml5 f-size13" id="time_box" disabled style="width:97px;display:none;">发送验证码</span>
		                            <span class="btn btn-gray f-r3 f-ml5 f-size13" id="verifyYz" style="width:97px;">发送验证码</span>
		                            <span class="ie8 icon-close close hide" style="right:130px"></span>
		                            <label class="icon-sucessfill blank hide"></label>
		                            <div class="focus">
		                            	请查收手机短信，并填写短信中的验证码（此验证码3分钟内有效）
		                            </div>
		                        </div>
		                    </div>
		                    <div class="item col-xs-12" style="height:auto">
		                        <span class="intelligent-label f-fl">&nbsp;</span>
		                        <p class="f-size14 required"  data-valid="isChecked" data-error="请先同意条款">
		                            <input type="checkbox" checked="checked" /><a href="javascript:showoutc();" class="f-ml5">我已阅读并同意条款</a>
		                        </p>
		                        <label class="focus valid"></label>
		                    </div>
		                    <div class="item col-xs-12">
		                        <span class="intelligent-label f-fl">&nbsp;</span>
		                        <div class="f-fl item-ifo">
                            	<a href="javascript:;" class="btn btn-blue f-r3" id="register_part1">注册</a>
                            	<a href="login.jsp" >已有账号，点击登录</a>
		                        </div>
		                    </div>
		            	</form>
	                </div>
					<!-- 用户基础信息注册页面JS -->
					<script type="text/javascript" src="<%=path%>/js/register/register_user.js"></script>