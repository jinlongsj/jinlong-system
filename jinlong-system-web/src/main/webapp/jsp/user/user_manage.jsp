<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

			    <link rel="stylesheet" type="text/css" href="<%=path%>/css/user.css"/>
				<link rel="stylesheet" type="text/css" href="<%=path%>/css/manage.css"/>
				<link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap.min.css"/>
		        <div class="con_ri_head">
		            <span>首页</span> > <span>用户信息管理</span>
		        </div>
		        <div class="con_con">
		            <div class="con_con_top">
		                <div class="con_con_top_le">
							用户信息管理
		                </div>
		                <div class="con_con_top_ri">
		                    <button id="add" class="button">新增用户</button>
		                </div>
		            </div>
		        	<form id="user_form" name="user_form" method="post" class="form">
	            		<div class="con_box">
	                    	<ul class="ul_li">
	                        	<li>
		                        	<span>用户名称：</span>
		                        	<input type="text" id="userName" name="userName" />
	                            </li>
	                            <li>
		                        	<span>用户角色：</span>
		                        	<select id="roleId" name="roleId" style="border:1px solid #ccc;with:500px;border-radius:5px;padding:5px 36px;"></select>
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
		                        	<span>真实姓名：</span>
		                        	<input type="text" id="realName" name="realName" />
		                        </li>
		                        <li>
		                        	<span>用户昵称：</span>
		                        	<input type="text" id="nickName" name="nickName" />
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
		                        	<span>地区：</span>
		                        	<!-- 省 -->
		                            <select id="province" name="provinceId" style="width:100px;"></select>
		                            <!-- 市 -->
		                            <select id="city" name="cityId" style="width:100px;"></select>
		                            <!-- 区县 -->
		                            <select id="region" name="zoneId" style="width:100px;" ></select>
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
		                        <li>
		                        	<span>流程状态： </span>
		                        	<select id="processState" name="processState" style="border:1px solid #ccc;with:500px;border-radius:5px;padding:5px 36px;"></select>
		                        </li>
	                        </ul>
	                 	</div>
			            <div class="operate_bar">
			                <div class="operate_button">
		                    	<input type="button" value="批量删除" id="batchDelete" class="button"/>
			                </div>
			                <div class="operate_button">
		                    	<input type="button" value="查询" id="find" class="button"/>
			                </div>
			                <div class="operate_button">
		                    	<input type="button" value="模板下载" id="download" class="button"/>
			                </div>
			                <div class="operate_button">
		                    	<input type="button" value="导入" id="import" class="button"/>
			                </div>
			                <div class="operate_button">
		                    	<input type="button" value="导出" id="export" class="button"/>
			                </div>
			                <div class="operate_button">
		                    	<input type="button" value="批量审核" id="bathExamine" class="button"/>
			                </div>
			            </div>
	                </form>
		            <div class="con_box">
		            	<!-- 表格 -->
		                <table id="user_list" class="table table-bordered"></table>
			            <!-- 分页组件 -->
			            <div id="user_list_pager"></div>
		      		</div>
		        </div>
				<script type="text/javascript" src="<%=path%>/js/user/user_manage.js"></script>