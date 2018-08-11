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
		
		//自定义邀请码验证变量
		var isSelected = ValidatorUtil.getMethodInfo('isSelected');
		var isAlphanumericCaseInsensitive = ValidatorUtil.getMethodInfo('isAlphanumericCaseInsensitive');
		var accountFormatCheck = ValidatorUtil.getMethodInfo('accountFormatCheck');
		var emailFormatCheck = ValidatorUtil.getMethodInfo('emailFormatCheck');
		var pwdFormatCheck = ValidatorUtil.getMethodInfo('pwdFormatCheck');
		
		//邀请码验证添加自定义规则
		$.validator.addMethod(isSelected.code, isSelected.method, isSelected.msg);
		$.validator.addMethod(isAlphanumericCaseInsensitive.code, isAlphanumericCaseInsensitive.method, isAlphanumericCaseInsensitive.msg);
		$.validator.addMethod(accountFormatCheck.code, accountFormatCheck.method, accountFormatCheck.msg);
		$.validator.addMethod(emailFormatCheck.code, emailFormatCheck.method, emailFormatCheck.msg);
		$.validator.addMethod(pwdFormatCheck.code, pwdFormatCheck.method, pwdFormatCheck.msg);
		
		//判断账号类型是不是企业，若是企业类型隐藏账号框,否则显示
		$.validator.addMethod("checkRoleType",function(value,element) {
			if(value == 3){
				$("#user_name_tr").hide();
			}else{
				$("#user_name_tr").show();
			}
			return value != -1;
		}); 
		
		//用户账户唯一性校验
		$.validator.addMethod("checkUserName", function(value, element) {
			var exists;
			//检查用户账号是否唯一
			$.ajax({
				url :  _baseUrl + "/sysusermanageOperate/checkUserIdExists.action",
				type : "post",
				dataType : "json",
				data : {"userBase.userName" : value, "flag" : 1},
			    async: false
			}).done(function(data){
				exists = data.flag;
			}).fail(function(){
				CommonUtils.logError("check userName fail!");
			});
			return exists == 0; 
		}, "此账号已经存在");
		
		//用户邮箱唯一性校验
		///^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/
		$.validator.addMethod("checkEmal", function(value, element) {
			var exists;
			//检查用户邮箱是否唯一
			$.ajax({
				url :  _baseUrl + "/sysusermanageOperate/checkUserIdExists.action",
				type : "post",
				dataType : "json",
				data : {"userBase.email" : value, "flag" : 2},
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
			//检查用户手机号码是否唯一
			$.ajax({
				url :  _baseUrl + "/sysusermanageOperate/checkUserIdExists.action",
				type : "post",
				dataType : "json",
				data : {"userBase.phoneNo" : value, "flag" : 3},
			    async: false
			}).done(function(data){
				exists = data.flag;
			}).fail(function(){
				CommonUtils.logError("check phoneNo fail!");
			});
			return exists == 0; 
		}, "此号码已经存在");
		
		
		UserAddFormValidate = $("#user_add_form").validate({
			rules: {
				"userBase.roleId":{
					isSelected: true,
					checkRoleType:true
				},
				"userBase.usersState":{
					isSelected: true
				},
				"userBase.userRealName":{
					required: false,
					maxlength: 20
				},
				"userBase.userName":{
					required: true,
					maxlength: 20,
					checkUserName: true,
					accountFormatCheck: true
				},
				"userBase.email": {
					required: true,
					email: true,
					maxlength: 50,
					emailFormatCheck: true,
					checkEmal: true
				},
				"userBase.phoneNo":{
					required: true,
					digits:true,
					rangelength:[11,11],
					maxlength: 11,
					checkPhoneNo:true
				},
				"userBase.password":{
					required: true,
					rangelength: [6,16],
					pwdFormatCheck : true
				},
				"determinepassword":{
					required: true,
					equalTo: "#admin_password"
				},
				"userBase.remarks":{
					required: false,
					maxlength: 200
				}
			},
			messages: {
				"userBase.roleId":{
					isSelected: "请选择一个账号类型",
					checkRoleType:"企业账号"
				},
				"userBase.usersState":{
					isSelected: "请选择一个账号状态"
				},
				"userBase.userRealName":{
					maxlength: "姓名长度不能超过20个字符"
				},
				"userBase.userName":{
					required: "账号不能为空",
					maxlength: "账号长度最多为20个字符",
					checkUserName: "此账号已存在!",
					accountFormatCheck: "只能输入4-20个字母、数字、下划线,首尾字符不能为下划线"
				},
				"userBase.email":{
					required: "邮箱不能为空",
					email: "请输入正确的email地址",
					maxlength: "邮箱长度最多为50个字符",
					emailFormatCheck: "邮箱格式不正确",
					checkEmal: "此邮箱已存在"
				},
				"userBase.phoneNo":{
					required: "手机号码不能为空",
					digits: "手机号码只能输入整数",
					rangelength:"手机号码长度为11个字符",
					maxlength: "手机号码长度为11个字符",
					checkPhoneNo: "此号码已经存在"
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
				var elmtId = element[0].id;
				if("admin_email" == elmtId){
					element.parent().parent().find(".font03").empty().append(error);
				}else {
					element.parent().find(".font03").empty().append(error);
				}
			},
			success: function(label){
				var promptInfo;
				var elmtId = label[0].id;
				var $spanElmt = $(label).parent().parent().find(".font03"); 
				if("invitation_code-error" == elmtId){
					promptInfo = "";
				}else if("admin_realname-error" == elmtId){
					promptInfo = "";
				}else if("admin_id-error" == elmtId){
					promptInfo = "";
				}else if("admin_email-error" == elmtId){
					promptInfo = "";
				}else if("admin_phone-error" == elmtId){
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
	
	//新增人员信息
	function addUserEvent(objThis){
		//邀请码赋值给隐藏域
		$("#hidden_invitation_code").val($("#invitation_code").val());
		var validatorPassword = customPasswordValidator($("#admin_password").val());
		if($("#user_add_form").valid()){
			if(validatorPassword){
				$.ajax({
					url : _baseUrl + "/sysusermanageOperate/addUserBasic.action",
					type : "post",
					dataType : "json",
					data : $("#user_add_form").serialize()
				}).done(function(data){
					jAlert("保存成功!","新增");
					PageCommon.swichToC1();
					$("#admin_jqgrid_data").jqGrid().trigger("reloadGrid");
				}).fail(function(){
					jAlertError("保存失败!","新增");
				});
				//处理保存按钮,防止按钮被多次点击
				CommonHandlePreventMoreClickButton.handlePreventMoreClick(objThis, "add_admin_submit");
			}
		}else{
			UserAddFormValidate.form();
		}
	}
	
	//绑定人员类型下拉选择框
	function bindroleIdSelect(){
		var url = _baseUrl + "/commonData/findUserRoleName.action";
		var errorMsg = "get roleName is error!";
		CommonAjaxHandle.bindSelectOptionData(url,"role_type",null,null,errorMsg);
	}
	
	//绑定人员账号状态下拉选择框
	function bindUserStatusSelect(){
		var url = _baseUrl + "/commonData/findUserStatusName.action";
		var errorMsg = "get userstatus is error!";
		CommonAjaxHandle.bindSelectOptionData(url,"user_type",null,null,errorMsg);
	}
	
	//邮箱提示
	function emailPrompt(){
		$("#admin_email").mailAutoComplete({
			boxClass: "out_box", //外部box样式
			listClass: "list_box", //默认的列表样式
			focusClass: "focus_box", //列表选样式中
			markCalss: "mark_box", //高亮样式
			autoClass: false,
			textHint: true //提示文字自动隐藏
		});
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
	
	//问题单管理初始化
	function init(){
		validateInit();
		bindroleIdSelect();
		bindUserStatusSelect();
		emailPrompt();//邮箱提示
		
	}
	
	module.init = init;
	module.invitationCodeValid = invitationCodeValid;
	module.addUserEvent = addUserEvent;
	module.customPasswordValidator = customPasswordValidator;
	
	return module;
})($, window.AdminAddManage || {});

/**
 * 页面初始化
 */
(function() {
	AdminAddManage.init();
	
	//邀请码输入框绑定事件
	$("#invitation_code").on({
		"blur": AdminAddManage.invitationCodeValid,
		"keyup": AdminAddManage.invitationCodeValid
	});
	
	//返回按钮
	$("#add_admin_return").on("click", function() { 
		PageCommon.swichToC1();
    });
	
	//人员新增按钮事件绑定
	$("#add_admin_submit").on("click", function(){
		AdminAddManage.addUserEvent(this);
	})
	
	//手机号码绑定keyup事件
	$("#admin_phone").on("keyup",function(){
		this.value = this.value.replace(/\D/g,'');
	});
	
	// 绑定密码keyup事件
	$("#admin_password").on("keyup", function() {
		AdminAddManage.customPasswordValidator(this.value);
	});
	
})();