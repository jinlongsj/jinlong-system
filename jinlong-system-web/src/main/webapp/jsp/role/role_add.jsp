<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

					<link rel="stylesheet" type="text/css" href="<%=path%>/css/role.css" />
			        <div class="con_ri_head">
			            <span>首页</span> > <span>角色信息管理</span>> <span>添加角色信息</span>
			        </div>
		            <div class="con_con_top">
		                <div class="con_con_top_le">
							添加角色信息
		                </div>
		                <div class="con_con_top_ri">
		                    <button id="add" class="button">添加</button>
		                </div>
		            </div>
					<input type="hidden" id="menuIds" name="menuIds"/>
		        	<form id="add_form" name="add_form" method="post" class="form">
		            	<div class="con_box">
		                    <ul class="cy">
		                        <li>
		                        	<span>角色类型：</span>
		                        	<select id="typeId" name="typeId" style="border:1px solid #ccc;with:500px;margin-left:30px;border-radius:5px;padding:5px 36px;"></select>
		                        </li>
		                        <li>
		                        	<span>角色编码：</span>
		                        	<input type="text" id="roleCode" name="roleCode" />
		                        </li>
		                        <li>
		                        	<span>角色名称：</span>
		                        	<input type="text" id="roleName" name="roleName" />
		                        </li>
                                <li class="li_description">
                                	<span>角色详情：</span>
                                	<textarea id="description" name="description" class="role_description" ></textarea>
                                </li>
		                        <li>
		                        	<span>角色状态：</span>
		                        	<select id="state" name="state" style="border:1px solid #ccc;with:500px;margin-left:30px;border-radius:5px;padding:5px 36px;"></select>
		                        </li>
		                        <li>
		                        	<span>菜单分配：</span>
		                        </li>
		                    </ul>
		                </div>
		            </form>
					<div class="menuTree" style="border 1px soiled black;">
						<ul id="menuTree" class="tree" ></ul>
					</div>
					<!-- 日起插件 -->
					<script type="text/javascript" charset="utf-8" src="<%=path%>/js/role/role_add.js"></script>