<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

			    <link rel="stylesheet" type="text/css" href="<%=path%>/css/user_process.css"/>
				<link rel="stylesheet" type="text/css" href="<%=path%>/css/manage.css"/>
				<link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap.min.css"/>
		        <div class="con_ri_head">
		            <span>首页</span> > <span>用户流程信息管理</span>
		        </div>
		        <div class="con_con">
		            <div class="con_con_top">
		                <div class="con_con_top_le">
							用户流程信息管理
		                </div>
		            </div>
		        	<form id="user_process_form" name="user_process_form" method="post" class="form">
	            		<div class="con_box">
	                    	<ul class="ul_li">
	                        	<li>
		                        	<!-- 用户ID -->
		                        	<input type="hidden" id="userId" name="userId" value="<%=request.getParameter("userId")%>"/>
		                        	<span>用户名称：</span>
		                        	<input type="text" id="userName" name="userName" />
	                            </li>
	                            <li>
		                        	<span>审核人名称：</span>
		                        	<input type="text" id="userName" name="userName" />
	                            </li>
	                            <li>
		                        	<span>流程节点时间： </span>
		                        	<input type="text" id="startTime" name="startTime" style="width: 150px;height: 30px;" type="text" class="Wdate" onFocus="WdatePicker({isShowClear:false,dateFmt:'yyyy-MM-dd'})" />
		                        	<input type="text" id="endTime" name="endTime" style="width: 150px;height: 30px;" type="text" class="Wdate" onFocus="WdatePicker({isShowClear:false,dateFmt:'yyyy-MM-dd'})" />
	                            </li>
		                        <li>
		                        	<span>是否通过： </span>
             						<label style="margin-left:30px;">是</label>
                                    <input type="radio" id="pass" name="pass" value="1" style="display: inline-block; width: 20px;height: 15px;"/>
             						<label>否</label>
                                    <input type="radio" id="pass" name="pass" value="2" style="display: inline-block; width: 15px;height: 15px;"/>
		                        </li>
		                        <li>
		                        	<span>流程节点状态： </span>
		                        	<select id="state" name="state" style="border:1px solid #ccc;with:500px;border-radius:5px;padding:5px 36px;"></select>
		                        </li>
	                        </ul>
	                 	</div>
			            <div class="operate_bar">
			                <div class="operate_button">
		                    	<input type="button" value="查询" id="find" class="button">
			                </div>
			            </div>
	                </form>
		            <div class="con_box">
		            	<!-- 表格 -->
		                <table id="user_process" class="table table-bordered"></table>
			            <!-- 分页组件 -->
			            <div id="user_process_pager"></div>
		      		</div>
		        </div>
				<script type="text/javascript" src="<%=path%>/js/user/user_process.js"></script>