<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


                <div class="part4 text-center" style="display:none">
                    <h3>恭喜  <span id="span">ewrty</span> ，您已注册成功，等待审核通过！</h3>
                </div>
				<!-- 用户注册成功页面JS -->
				<script type="text/javascript" src="<%=path%>/js/register/register_success.js"></script>