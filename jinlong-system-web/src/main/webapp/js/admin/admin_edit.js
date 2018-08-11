/**
 * Admin_jqgrid初始化
 */
/**
 * 1.定义人员管理新增模块化
 * 2.人员管理新增初始化
 */
window.AdminAddManage = (function($, module) {
	
	//验证新增用例form表单
	function validateInit(){
		//自定义校验下拉框是否选中方法
		var isSelected = ValidatorUtil.getMethodInfo('isSelected');
		$.validator.addMethod(isSelected.code, isSelected.method, isSelected.msg);
		
		//验证邮箱格式
		var emailFormatCheck = ValidatorUtil.getMethodInfo('emailFormatCheck');
		$.validator.addMethod(emailFormatCheck.code, emailFormatCheck.method, emailFormatCheck.msg);
		
		//验证密码格式
		var pwdFormatCheck = ValidatorUtil.getMethodInfo('pwdFormatCheck');
		$.validator.addMethod(pwdFormatCheck.code, pwdFormatCheck.method, pwdFormatCheck.msg);
		
		//用户账户唯一性校验
		$.validator.addMethod("checkEmal", function(value, element) {
			var exists;
			var userId = $("#hidden_user_id").val();
			//检查用户账号是否唯一
			$.ajax({
				url :  _baseUrl + "/sysusermanageOperate/checkUserMsgExists.action",
				type : "post",
				dataType : "json",
				data : {"userBase.email" : value, "flag" : 2, "userBase.id" : userId},
			    async: false
			}).done(function(data){
				exists = data.flag;
			}).fail(function(){
				CommonUtils.logError("check email fail!");
			});
			return exists == 0; 
		}, "此邮箱已经存在");
		
		//用户手机号码唯一性校验
		$.validator.addMethod("checkPhoneNo", function(value, element) {
			var exists;
			var userId = $("#hidden_user_id").val();
			//检查用户手机号码是否唯一
			$.ajax({
				url :  _baseUrl + "/sysusermanageOperate/checkUserMsgExists.action",
				type : "post",
				dataType : "json",
				data : {"userBase.phoneNo" : value, "flag" : 3, "userBase.id" : userId},
			    async: false
			}).done(function(data){
				exists = data.flag;
			}).fail(function(){
				CommonUtils.logError("check phoneNo fail!");
			});
			return exists == 0; 
		}, "此号码已经存在");
		
		UserAddFormValidate = $("#user_edit_form").validate({
			rules: {
				"userBase.roleId":{
					isSelected: true
				},
				"userBase.usersState":{
					isSelected: true
				},
				"userBase.userRealName":{
					required: false,
					maxlength: 20
				},
				"userBase.phoneNo":{
					required: true,
					digits:true,
					rangelength:[11,11],
					maxlength: 11,
					checkPhoneNo: true
				},
				"userBase.email": {
					required: true,
					email: true,
					maxlength: 50,
					emailFormatCheck: true,
					checkEmal: true
				},
				"userBase.password":{
					required: false,
					rangelength: [6,16],
					pwdFormatCheck : false
				},
				"determinepassword":{
					required: false,
					equalTo: "#admin_password"
				},
				"userBase.remarks":{
					required: false,
					maxlength: 200
				}
			},
			messages: {
				"userBase.roleId":{
					isSelected: "请选择一个账号类型"
				},
				"userBase.usersState":{
					isSelected: "请选择一个账号状态"
				},
				"userBase.userRealName":{
					maxlength: "姓名长度不能超过20个字符"
				},
				"userBase.phoneNo":{
					required: "手机号码不能为空",
					digits: "手机号码只能输入整数",
					rangelength:"手机号码长度为11个字符",
					maxlength: "手机号码长度为11个字符",
					checkPhoneNo: "此号码已经存在"
				},
				"userBase.email":{
					required: "邮箱不能为空",
					email: "请输入正确的email地址",
					maxlength: "邮箱长度最多为50个字符",
					emailFormatCheck: "邮箱格式不正确",
					checkEmal: "此邮箱已存在"
				},
				"userBase.password": {
					required: "密码不能为空",
					rangelength:"密码长度为6-16个字符",
					maxlength: "密码长度为6-16个字符",
					pwdFormatCheck: "密码不能包含空格"
				},
				"determinepassword":{
					required: "确认密码不能为空",
					equalTo: "两次输入密码不一致"
				},
				"userBase.remarks":{
					maxlength: "备注信息长度最多为200个字符"
				}
			},
			errorPlacement : function(error, element) {
				element.parent().find(".font03").empty().append(error);
			},
			success: function(label){
				var promptInfo;
				var elmtId = label[0].id;
				var $spanElmt = $(label).parent().parent().find(".font03"); 
				if("admin_realname-error" == elmtId){
					promptInfo = "";
				}else if("admin_phoneNo-error" == elmtId){
					promptInfo = "";
				}else if("admin_password-error" == elmtId){
					promptInfo = "";
				}else if("admin_password1-error" == elmtId){
					promptInfo = "";
				}else if("admin_remarks-error" == elmtId){
					promptInfo = "";
				}
				$spanElmt.empty().html(promptInfo); 
			}
		});
	}
	
	//问题单编辑状态下查找已经选中的各个下拉框的值进行回显
	function findTicketSelected(){
		var roleId;
		var statusId;
		var userId = $("#hidden_user_id").val();
		$.ajax({
			url : _baseUrl + "/sysusermanageOperate/findUserRoleIdAndUserState.action",
			type : "post",
			dataType : "json",
			data : {"userBase.id" : userId}
		}).done(function(data){
			roleId = data.userBaseVO.roleId;
			statusId = data.userBaseVO.usersState;
			bindSelectedEvent(roleId,statusId);
			if(roleId == 3){
				$("#admin_email").attr("disabled","disabled");
			}
		}).fail(function(){
			CommonUtils.logError("人员管理查询已经选中项失败!");
		});
	}
	
	//邀请码验证
	function invitationCodeValid(){
		//邀请码输入框对象
		var $invitationCode = $("#invitation_code");
		var invitationCodeLen = $invitationCode.val().length;
		$invitationCode.rules("remove");
		if(invitationCodeLen >= 1){
			$invitationCode.rules("add", { isAlphanumericCaseInsensitive: true, messages: { isAlphanumericCaseInsensitive: function(){
				$("#invitation_code").siblings("span").empty();
				return "只能输入1~20位字母,数字,中划线组合,不能以中划线开头或结尾";
			}} });
		}
	}
	
	//编辑人员信息
	function editUserEvent(){
		var adminPwd = $("#admin_password").val();
		var validatorPassword = true;
		if(null !=adminPwd && "" != adminPwd){
			var validatorPassword = customPasswordValidator(adminPwd);
		}
		if($("#user_edit_form").valid()){
			if(validatorPassword){
				$.ajax({
					url : _baseUrl + "/sysusermanageOperate/editUserBasic.action",
					type : "post",
					dataType : "json",
					data : $("#user_edit_form").serialize()
				}).done(function(data){
					jAlert("编辑成功!","用户编辑");
					PageCommon.swichToC1();
					$("#admin_jqgrid_data").jqGrid().trigger("reloadGrid");
				}).fail(function(){
					jAlertError("编辑失败!","用户编辑");
				});
			}
		}else{
			UserAddFormValidate.form();
		}
	}
	
	/**
	 * 绑定下拉框选中项回显事件
	 */
	function bindSelectedEvent(roleId,statusId){
		try {
			//账号类型
			var url = _baseUrl + "/commonData/findUserRoleName.action";
			var errorMsg = "get roleName is error!";
			CommonAjaxHandle.bindSelectOptionData(url,"role_id_add",null,roleId,errorMsg);
			
			//账号状态
			var url = _baseUrl + "/commonData/findUserStatusName.action";
			var errorMsg = "get userstatus is error!";
			CommonAjaxHandle.bindSelectOptionData(url,"user_type",null,statusId,errorMsg);
		} catch (error) {
			
		}
	}
	
	// 改变密码样式
	function changePasswordCss() {
		$("#admin_password").siblings("span").empty();
		$("#admin_password").siblings("span").removeClass("font03");
		$("#admin_password").siblings("span").addClass("validator_message");
	}
	
	// 手动验证密码
	function customPasswordValidator(value) {
		if (value == "") {
			changePasswordCss();
			$("#admin_password").siblings("span").html("密码不能为空！");
			return false;
		} else {
			var space = /\s/g;
			if (space.test(value)) {
				changePasswordCss();
				$("#admin_password").siblings("span").html("密码不能包含空格！");
				return false;
			} else {
				if (value.length < 6) {
					changePasswordCss();
					$("#admin_password").siblings("span").html("密码由6-16位数字、字符、字母组成，字母区分大小写！");
					return false;
				} else if (value.length > 16) {
					changePasswordCss();
					$("#admin_password").siblings("span").html("密码由6-16位数字、字符、字母组成，字母区分大小写！");
					return false;
				} else {
					$("#admin_password").siblings("span").empty();
					$("#admin_password").next().empty().append("<img src='css/images/regright.png'/>");
					return true;
				}
			}
		}
	}
	
	//修改密码隐藏于显示
	function editPasswordEvent(event){
		event.preventDefault();
		var $opinion = $("#paswd_edit_btn");
		var disable = $(".dispaswd").hasClass("disable");
		var $disable1 = $(".dispaswd");
		var $inputval = $("input[id=admin_password]");
		var $inputval1 = $("input[id=admin_password1]");
		if (!disable) {
			$disable1.addClass("disable");
			$opinion.empty().html("显示修改密码框");
			$inputval.val("");
			$inputval1.val("");
		} else {
			$disable1.removeClass("disable");
			$("input[id=admin_password]").eq(0).next("span").attr("class","font03");
			$("input[id=admin_password]").eq(0).next("span").html("6-16位数字、字母、特殊字符组成，字母区分大小写");
			$("input[id=admin_password1]").eq(0).next("span").html("再次填写密码");
			$opinion.empty().html("隐藏修改密码框");
		}
	}
	
	
	
	
	//问题单管理初始化
	function init(){
		validateInit();
		findTicketSelected();
	}
	
	module.init = init;
	module.editUserEvent = editUserEvent;
	module.findTicketSelected = findTicketSelected;
	module.invitationCodeValid = invitationCodeValid;
	module.customPasswordValidator = customPasswordValidator;
	module.editPasswordEvent = editPasswordEvent;
	
	return module;
})($, window.AdminAddManage || {});

/**
 * 页面初始化
 */
(function() {
	AdminAddManage.init();
	
	//邀请码输入框绑定事件
//	$("#invitation_code").on({
//		"blur": AdminAddManage.invitationCodeValid,
//		"keyup": AdminAddManage.invitationCodeValid
//	});
	
	//返回按钮
	$("#edit_admin_return").on("click", function() {
		PageCommon.swichToC1();
    });
	
	$("#update_admin_return").on("click", function(){
		AdminAddManage.editUserEvent();
	})
	
	//手机号码绑定keyup事件
	$("#admin_phoneNo").on("keyup",function(){
		this.value = this.value.replace(/\D/g,'');
	});
	
	// 绑定密码keyup事件
	$("#admin_password").on("keyup", function() {
		AdminAddManage.customPasswordValidator(this.value);
	});
	
	//修改密码隐藏于显示
	$("#paswd_edit_btn").on("click", function(event) {
		AdminAddManage.editPasswordEvent(event);
	});
	
})();