<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

			    <link rel="stylesheet" type="text/css" href="<%=path%>/css/menu.css"/>
				<link rel="stylesheet" type="text/css" href="<%=path%>/css/manage.css"/>
				<link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap.min.css"/>
		        <div class="con_ri_head">
		            <span>首页</span> > <span>菜单信息管理</span>
		        </div>
		        <div class="con_con">
		            <div class="con_con_top">
		                <div class="con_con_top_le">
							菜单信息管理
		                </div>
		                <div id="add" class="con_con_top_ri">
		                    <button id="add" class="button">新增菜单</button>
		                </div>
		            </div>
		        	<form id="menu_form" name="menu_form" method="post" class="form">
	            		<div class="con_box">
	                    	<ul class="ul_li">
	                        	<li>
		                        	<span>菜单名称：</span>
		                        	<input type="text" id="menuName" name="menuName" />
	                            </li>
	                            <li>
		                        	<span>菜单类型：</span>
		                        	<select id="typeId" name="typeId" style="border:1px solid #ccc;with:500px;border-radius:5px;padding:5px 36px;"></select>
	                            </li>
	                            <li>
		                        	<span>菜单级别：</span>
		                        	<select id="levalId" name="levalId" style="border:1px solid #ccc;with:500px;border-radius:5px;padding:5px 36px;"></select>
	                            </li>
	                        	<li>
		                        	<span>菜单地址：</span>
		                        	<input type="text" id="menuUrl" name="menuUrl" />
	                            </li>
	                            <li>
		                        	<span>菜单状态： </span>
		                        	<select id="state" name="state" style="border:1px solid #ccc;with:500px;border-radius:5px;padding:5px 36px;"></select>
	                            </li>
	                            <li>
		                        	<span>菜单流程状态： </span>
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
		                <table id="menu_list" class="table table-bordered"></table>
			            <!-- 分页组件 -->
			            <div id="menu_list_pager"></div>
		      		</div>
		        </div>
				<script type="text/javascript" src="<%=path%>/js/menu/menu_manage.js"></script>