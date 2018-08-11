<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="title">
	<div class="titlename">账户列表</div>
	<div type="button" class="addaccount" id="admin_add_btn">
		<a>新增账户</a>
	</div>
</div>
<div class="container">
	<div class="query">
		<form id="userBase_search_form">
			<span>账号：</span><input type="text" class="query-input" id="userBase.userName" name="userBase.userName" /> 
			<span>姓名：</span><input type="text" class="query-input" id="userBase.userRealName" name="userBase.userRealName" /> 
			<span>账号类型：</span> <select	id="role_id" name="userBase.roleId">
				<option value="0" selected>全部</option>
			</select> 
			<span>审核状态：</span> <select	id="review_id" name="userBase.reviewType">
				<option value="0" selected>全部</option>
				<option value="1">审核中</option>
				<option value="2">已审核</option>
				<option value="3">未通过</option>
			</select>
			<input type="button" value="查询" class="query-button" id="admin_btn" />
		</form>
	</div>
	<div class="con-table">
		<table id="admin_jqgrid_data"></table>
		<div id="admin_jqgrid_pager"></div>
	</div>
</div>
<script type="text/javascript" src="${baseUrl}/js/admin/admin_manage.js"></script>