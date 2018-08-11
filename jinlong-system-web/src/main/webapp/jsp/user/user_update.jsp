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
							修改用户信息
			            </div>
			            <div class="con_con_top_ri">
			                <button id="update" class="button">保存</button>
			            </div>
			        </div>
		        	<form id="update_base_form" name="update_base_form" method="post" class="form">
			       		<div class="con_con_user_base">
							用户基础信息
			            </div>
		            	<div class="con_box">
		                    <ul class="cy">
		                        <li>
		                        	<!-- 用户ID -->
		                        	<input type="hidden" id="userId" name="userId" value="<%=request.getParameter("userId")%>"/>
		                        	<span>用户名称：</span>
		                        	<input type="text" id="userName" name="userName" />
		                        </li>
		                        <li>
		                        	<span>用户角色：</span>
		                        	<select id="roleId" name="roleId" style="border:1px solid #ccc;with:500px;margin-left:30px;border-radius:5px;padding:5px 36px;"></select>
		                        </li>
		                        <li>
		                        	<span>手机号： </span>
		                        	<input type="text" id="mobilePhone" name="mobilePhone" />
		                        </li>
		                        <li>
		                        	<span>电子邮箱： </span>
		                        	<input type="text" id="email" name="email" />
		                        </li>
		                        <li>
		                        	<span>用户状态： </span>
		                        	<select id="state" name="state" style="border:1px solid #ccc;with:500px;margin-left:30px;border-radius:5px;padding:5px 36px;"></select>
		                        </li>
		                    </ul>
		                </div>
		            </form>
		        	<form id="update_info_form" name="update_info_form" method="post" class="form">
			       		<div class="con_con_user_info">
							用户详细信息
			            </div>
		        		<div class="con_box2">
		                    <ul class="cy2">
		                        <li>
		                        	<!-- 用户ID -->
		                        	<input type="hidden" id="userId" name="userId" value="<%=request.getParameter("userId")%>"/>
		                        	<span>真实姓名：</span>
		                        	<input type="text" id="realName" name="realName" />
		                        </li>
		                        <li>
		                        	<span>用户昵称：</span>
		                        	<input type="text" id="nickName" name="nickName" />
		                        </li>
		                        <li>
		                        	<span>性别：</span>
             						<label style="margin-left:30px;">男</label>
                                    <input type="radio" id="gender" name="gender" value="1" style="display: inline-block; width: 20px;height: 15px;"/>
             						<label>女</label>
                                    <input type="radio" id="gender" name="gender" value="2" style="display: inline-block; width: 15px;height: 15px;"/>
		                        </li>
		                        <li>
		                        	<span>年龄： </span>
		                        	<input type="text" id="age" name="age" />
		                        </li>
		                        <li>
		                        	<span>身份证号码： </span>
		                        	<input type="text" id="idNumber" name="idNumber" />
		                        </li>
		                        <li>
		                        	<span>座机号码： </span>
		                        	<input type="text" id="telephone" name="telephone" />
		                        </li>
		                        <li>
		                        	<span>用户所在地： </span>
		                        	<!-- 省 -->
		                            <select id="province" name="province" style="border:1px solid #ccc;width:100px;border-radius:5px;padding:5px;margin-left:30px;"></select>
		                            <!-- 市 -->
		                            <select id="city" name="city" style="border:1px solid #ccc;width:100px;border-radius:5px;padding:5px;"></select>
		                            <!-- 区县 -->
		                            <select id="region" name="zoneId" style="border:1px solid #ccc;width:100px;border-radius:5px;padding:5px;" ></select>
		                        </li>
                                <li>
                                	<span>用户地址：</span>
                                	<input type="text" id="address" name="address" />
                                </li>
                                <li>
                                	<span>邮编号码：</span>
		                        	<input type="text" id="postCode" name="postCode" />
                                </li>
                                <li>
                                	<span>个人主页：</span>
		                        	<input type="text" id="homePage" name="homePage" />
                                </li>
                                <li>
                                	<span>用户QQ：</span>
		                        	<input type="text" id="qqNumber" name="qqNumber" />
                                </li>
                                <li>
                                	<span>用户支付宝：</span>
		                        	<input type="text" id="aliPay" name="aliPay" />
                                </li>
		                    </ul>
		            	</div>
			            <div class="js clear">
                        	<div class="description_title">用户详情：</div>
                            <textarea id="description" name="description" class="description" ></textarea>
			            </div>
		        	</form>
					<!-- 日起插件 -->
					<script type="text/javascript" charset="utf-8" src="<%=path%>/js/user/user_update.js"></script>