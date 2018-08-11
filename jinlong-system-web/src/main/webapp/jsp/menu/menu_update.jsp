<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

				    <link rel="stylesheet" type="text/css" href="<%=path%>/css/menu.css" />
			        <div class="con_ri_head">
			            <span>首页</span> > <span>菜单信息管理</span>> <span>修改菜单信息</span>
			        </div>
			        <div class="con_con_top">
			        	<div class="con_con_top_le">
							修改菜单信息
			            </div>
			            <div class="con_con_top_ri">
			                <button id="update" class="button">保存</button>
			            </div>
			        </div>
		        	<form id="update_form" name="update_form" method="post" class="form">
		            	<div class="con_box">
		                    <ul class="cy">
		                        <li>
		                        	<!-- 菜单ID -->
		                        	<input type="hidden" id="menuId" name="menuId" value="<%=request.getParameter("menuId")%>"/>
		                        	<span>菜单类型：</span>
		                        	<select id="typeId" name="typeId" style="border:1px solid #ccc;with:500px;margin-left:30px;border-radius:5px;padding:5px 36px;"></select>
		                        </li>
		                        <li>
		                        	<span>菜单名称：</span>
		                        	<input type="text" id="roleName" name="roleName" />
		                        </li>
                                <li class="li_description">
                                	<span>菜单详情：</span>
                                	<textarea id="description" name="description" class="description" ></textarea>
                                </li>
		                        <li>
		                        	<span>菜单状态：</span>
		                        	<select id="state" name="state" style="border:1px solid #ccc;with:500px;margin-left:30px;border-radius:5px;padding:5px 36px;"></select>
		                        </li>
		                    </ul>
							<div class="menuTree">
								<ul id="menuTree" class="tree" ></ul>
							</div>
		                </div>
		            </form>
					<!-- 日起插件 -->
					<script type="text/javascript" charset="utf-8" src="<%=path%>/js/menu/menu_update.js"></script>