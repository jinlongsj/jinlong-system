<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

				    <link rel="stylesheet" type="text/css" href="<%=path%>/css/role.css" />
			        <div class="con_ri_head">
			            <span>首页</span> > <span>角色信息管理</span>> <span>审核角色信息</span>
			        </div>
			        <div class="con_con_top">
			        	<div class="con_con_top_le">
							审核角色信息
			            </div>
			            <div class="con_con_top_ri">
			                <button id="examine" class="button">保存</button>
			            </div>
			        </div>
		            <div class="con_box">
		                <ul class="cy">
		                    <li>
		                        <!-- 用户ID -->
		                        <input type="hidden" id="roleId" name="userId" value="<%=request.getParameter("roleId")%>"/>
		                        <span>角色类型：</span>
		                        <select id="typeId" name="typeId" disabled="disabled" style="border:1px solid #ccc;with:500px;margin-left:30px;border-radius:5px;padding:5px 36px;"></select>
		                  	</li>
		                    <li>
		                        <span>角色编码：</span>
		                        <input type="text" id="roleCode" name="roleCode" />
		                    </li>
		                	<li>
		                        <span>角色名称：</span>
		                        <input type="text" id="roleName" name="roleName" disabled="disabled"/>
		                    </li>
                            <li class="li_description">
                                <span>角色详情：</span>
                                <textarea id="role_description" name="role_description" class="role_description" disabled="disabled" ></textarea>
                         	</li>
		                    <li>
		                        <span>角色状态：</span>
		                        <select id="state" name="state" disabled="disabled" style="border:1px solid #ccc;with:500px;margin-left:30px;border-radius:5px;padding:5px 36px;"></select>
		                 	</li>
		                    <li>
		                        <span>绑定菜单：</span>
		                    </li>
		            	</ul>
						<div class="menuTree">
							<ul id="menuTree" class="tree" ></ul>
						</div>
		            </div>
			       	<div class="con_con_user_info">
						用户信息审核
			       	</div>
		        	<form id="examine_form" name="examine_form" method="post" class="form">
			        	<div class="con_box2">
			            	<ul class="cy2">
			                    <li>
			                        <!-- 用户ID -->
			                        <input type="hidden" id="userId" name="userId" value="<%=request.getParameter("userId")%>"/>
			                        <span>审核状态：</span>
	             					<label style="margin-left:30px;">审核通过</label>
	                                <input type="radio" id="pass" name="pass" value="1" checked="checked" style="display: inline-block; width: 20px;height: 15px;" />
	             					<label>审核不通过</label>
	                               	<input type="radio" id="pass" name="pass" value="2" style="display: inline-block; width: 15px;height: 15px;" />
			                	</li>
			               	</ul>
			           	</div>
				       	<div class="js clear">
	                        <div class="description_title">审核意见：</div>
	                        <textarea id="description" name="description" class="description" ></textarea>
				       	</div>
			       	</form>
					<!-- 日起插件 -->
					<script type="text/javascript" charset="utf-8" src="<%=path%>/js/role/role_examine.js"></script>