<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="title">
    <div class="titlename">账户编辑</div>
</div>
<div class="container">
	<form class="customForm" id="user_edit_form" name="user_edit_form">
		<table  class="table-edit">
			<tr>
				<td align="right"><span class="star">*</span>账号类型</td>
				<td>
					<span>
						<select id="role_id_add" name="userBase.roleId">
							<option value="0">请选择</option>
						</select>
						<span class="font03"></span>
					</span>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<span >
						<label class="star">*</label>账号状态
					</span>
					<span class="star">
						<select id="user_type" name="userBase.usersState">
							<option value="0">请选择</option>
						</select>
						<span class="font03"></span>
					</span>
				</td>
			</tr>
			<tr>
					<td width="200" align="right">邀请码</td>
					<td>
						<input id="invitation_code" name="userBase.invitationCode"
						 value="<s:property value="userBaseVO.invitationCode" />" style="width:150px;" />
						<span class="font03">1~20位字母、数字、中划线，不能以中划线开头或结尾</span>
					</td>
				</tr>
			<tr>
				<td width="200" align="right">姓名/企业名称</td>
				<td>
					<input id="admin_realname" name="userBase.userRealName" 
						value="<s:property value="userBaseVO.userRealName" />" />
					<span class="font03">个人真实姓名或公司注册名称,限20个字符</span>
				</td>
			</tr>
			<tr>
				<td align="right">账号</td>
				<td>
					<input disabled="disabled" id="admin_username" name="userBase.userName" 
						value="<s:property value="userBaseVO.userName"/>" />
					<span class="font03">4-20位字母、数字、下划线，不能以下划线开头或结尾</span>
				</td>
			</tr>
			<tr>
				<td align="right">email</td>
				<td>
					<input id="admin_email" disabled="disabled" name="userBase.email" 
						value="<s:property value="userBaseVO.email"/>" />
					<span class="font03">常用邮箱地址</span>
				</td>
			</tr>
			<tr id="phone_input">
				<td align="right"><span class="star">*</span>手机</td>
				<td>
					<input id="admin_phoneNo" name="userBase.phoneNo" 
						value="<s:property value="userBaseVO.phoneNo"/>" />
					<span class="font03">常用手机号码</span>
				</td>
			</tr>
			<tr id="phone_input">
				<td align="right"></td>
				<td>
					<a id="paswd_edit_btn" href="">显示修改密码框</a>
				</td>
			</tr>
				<tr class="dispaswd disable">
					<td align="right">密码</td>
					<td>
						<input type="password" onpaste="return false" id="admin_password" name="userBase.password"/>
						<span class="font03">6-16位数字、字母、特殊字符组成，字母区分大小写</span>
					</td>
				</tr>
				<tr class="dispaswd disable">
					<td align="right">确认密码</td>
					<td>
						<input type="password" onpaste="return false" id="admin_password1" name="determinepassword" />
						<span class="font03">再次填写密码</span>
					</td>
				</tr>
			<tr>
				<td align="right">备注信息</td>
				<td>
					<textarea class="textarea-two" id="admin_remarks" name="userBase.remarks" rows="3" cols="70"><s:property value="userBaseVO.remarks"/></textarea>
					<span class="font03">限200个字符</span>
				</td>
			</tr>
		</table>
		<input type="hidden" id="hidden_user_id" name="userBase.id" value="<s:property value="userBase.id" />" />
	</form>
		<input type="hidden" id="hidden_role_id"  value="<s:property value="userBase.id" />" />
		<input type="hidden" id="hidden_user_type"  value="<s:property value="userBase.id" />" />
	<div class="formbutton">
		<input type="button" class="btn-active w100 mt10" id="update_admin_return"
		name="detailTestcaseReturn" value="保存" />
		<input type="button" class="btn-active w100 mt10" id="edit_admin_return"
		name="detailTestcaseReturn" value="返回" />
	</div>
</div>
<script type="text/javascript" src="js/admin/admin_edit.js"></script>
