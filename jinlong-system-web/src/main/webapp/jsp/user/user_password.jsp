<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

				    <link rel="stylesheet" type="text/css" href="<%=path%>/css/user.css" />
			        <div class="con_ri_head">
			            <span>首页</span> > <span>用户信息管理</span>> <span>修改用户信息</span>
			        </div>
			        <div class="con_con_top">
			        	<div class="con_con_top_le">
							重置用户密码
			            </div>
			            <div class="con_con_top_ri">
			                <button id="update" class="button">保存</button>
			            </div>
			        </div>
		        	<form id="update_form" name="update_form" method="post" class="form">
			       		<div class="con_con_user_base">
							用户基础信息
			            </div>
		            	<div class="con_box">
		                    <ul class="cy3">
		                        <li>
		                        	<!-- 用户ID -->
		                        	<input type="hidden" id="userId" name="userId" value="<%=request.getParameter("userId")%>" />
		                        	<span>用户名称：</span>
		                        	<input type="text" id="userName" name="userName" disabled="disabled" />
		                        </li>
		                        <li>
		                        	<span>密码：</span>
		                        	<input type="password" id="password" name="pwd" />
		                        </li>
		                        <li>
		                        	<span>确认密码： </span>
		                        	<input type="password" id="rePassword" name="password" />
		                        </li>
		                    </ul>
		                </div>
		            </form>
					<!-- 日起插件 -->
					<script type="text/javascript" charset="utf-8" src="<%=path%>/js/user/user_password.js"></script>