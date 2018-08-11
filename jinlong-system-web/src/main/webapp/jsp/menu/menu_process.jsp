<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

			    <link rel="stylesheet" type="text/css" href="<%=path%>/css/menu_process.css"/>
				<link rel="stylesheet" type="text/css" href="<%=path%>/css/manage.css"/>
				<link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap.min.css"/>
		        <div class="con_ri_head">
		            <span>首页</span> > <span>菜单流程信息管理</span>
		        </div>
		        <div class="con_con">
		            <div class="con_con_top">
		                <div class="con_con_top_le">
							菜单流程信息管理
		                </div>
		            </div>
		        	<form id="menu_process_form" name="menu_process_form" method="post" class="form">
	            		<div class="con_box">
	                    	<ul class="ul_li">
	                        	<li>
		                        	<!-- 菜单ID -->
		                        	<input type="hidden" id="menuId" name="menuId" value="<%=request.getParameter("menuId")%>"/>
		                        	<span>菜单名称：</span>
		                        	<input type="text" id="menuName" name="menuName" />
	                            </li>
	                            <li>
		                        	<span>审核人名称：</span>
		                        	<input type="text" id="menuName" name="menuName" />
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
		                    	<button id="find" class="button">查询</button>
			                </div>
			            </div>
	                </form>
		            <div class="con_box">
		            	<!-- 表格 -->
		                <table id="menu_process" class="table table-bordered"></table>
			            <!-- 分页组件 -->
			            <div id="menu_process_pager"></div>
		      		</div>
		        </div>
				<script type="text/javascript" src="<%=path%>/js/menu/menu_process.js"></script>