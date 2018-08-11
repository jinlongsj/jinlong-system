<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="title">
    <div class="titlename">账户新增</div>
</div>
<div class="container">
	<div class="table-edit">
		<form class="customForm" id="user_add_form" name="user_add_form">
			<table class="table-edit">
				<tr>
					<td width="200" align="right">邀请码</td>
					<td>
						<input id="invitation_code" name="userBase.invitationCode" style="width:150px;" />
						<span class="font03">1~20位字母、数字、中划线，不能以中划线开头或结尾</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<span class="star">*</span>账号类型
					</td>
					<td>
						<span>
							<select id="role_type" name="userBase.roleId">
								<option value="0">请选择</option>
							</select>
							<span class="font03"></span>
						</span>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span>
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
					<td width="200" align="right">姓名/企业名称</td>
					<td>
						<input id="admin_realname" name="userBase.userRealName" />
						<span class="font03">个人真实姓名或公司注册名称</span>
					</td>
				</tr>
				<tr id="user_name_tr">
					<td align="right"><span class="star">*</span>账号</td>
					<td>
						<input id="admin_id" name="userBase.userName" />
						<span class="font03">4-20位字母、数字、下划线，不能以下划线开头或结尾</span>
					</td>
				</tr>
				<tr>
					<td align="right"><span class="star">*</span>email</td>
					<td>
						<input id="admin_email" name="userBase.email" />
						<span class="font03">常用邮箱地址</span>
					</td>
				</tr>
				<tr>
					<td align="right"><span class="star">*</span>手机</td>
					<td>
						<input id="admin_phone" name="userBase.phoneNo" />
						<span class="font03">常用手机号码</span>
					</td>
				</tr>
				<tr>
					<td align="right"><span class="star">*</span>密码</td>
					<td>
						<input onpaste="return false" type="password" id="admin_password" name="userBase.password" />
						<span class="font03">6-16位数字、字母、特殊字符组成，字母区分大小写</span>
					</td>
				</tr>
				<tr>
					<td width="200"  align="right"><span class="star">*</span>确认密码</td>
					<td>
						<input onpaste="return false" type="password" id="admin_password1" name="determinepassword" />
						<span class="font03">再次填写密码</span>
					</td>
				</tr>
				<tr>
					<td width="200" align="right">备注信息</td>
					<td>
						<textarea  class="textarea-two" id="admin_remarks" name="userBase.remarks" rows="3" cols="70"></textarea>
						<span class="font03">限200个字符</span>
					</td>
				</tr>
			</table>
			<input id="hidden_invitation_code" type="hidden" name="invitationCode"/>
		</form>
	</div>
	<div class="formbutton">
		<input type="button" class="btn-active w100 mt10" id="add_admin_submit"
		name="add_admin_submit" value="新增" />
		<input type="button" class="btn-active w100 mt10" id="add_admin_return"
		name="addAdminReturn" value="返回" />
	</div>
</div>
<script type="text/javascript" src="js/admin/admin_add.js"></script>
