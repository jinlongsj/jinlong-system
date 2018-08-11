<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

			    <link rel="stylesheet" type="text/css" href="<%=path%>/css/role.css"/>
				<link rel="stylesheet" type="text/css" href="<%=path%>/css/manage.css"/>
				<link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap.min.css"/>
		        <div class="con_ri_head">
		            <span>首页</span> > <span>角色信息管理</span>
		        </div>
		        <div class="con_con">
		            <div class="con_con_top">
		                <div class="con_con_top_le">
							角色信息管理
		                </div>
		                <div id="add" class="con_con_top_ri">
		                    <button id="add" class="button">新增角色</button>
		                </div>
		            </div>
		        	<form id="role_form" name="role_form" method="post" class="form">
	            		<div class="con_box">
	                    	<ul class="ul_li">
	                        	<li>
		                        	<span>角色名称：</span>
		                        	<input type="text" id="roleName" name="roleName" />
	                            </li>
	                            <li>
		                        	<span>角色类型：</span>
		                        	<select id="typeId" name="typeId" style="border:1px solid #ccc;with:500px;border-radius:5px;padding:5px 36px;"></select>
	                            </li>
	                            <li>
		                        	<span>角色状态： </span>
		                        	<select id="state" name="state" style="border:1px solid #ccc;with:500px;border-radius:5px;padding:5px 36px;"></select>
	                            </li>
	                            <li>
		                        	<span>角色流程状态： </span>
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
		                <table id="role_list" class="table table-bordered"></table>
			            <!-- 分页组件 -->
			            <div id="role_list_pager"></div>
		      		</div>
		        </div>
				<script type="text/javascript" src="<%=path%>/js/role/role_manage.js"></script>