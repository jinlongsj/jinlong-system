window.ValidatorUtil = (function($, module) {
	var methodMap = new CollectUtil.Map();
	
	/**
	 * 定义规则方法
	 */
	function rulesDefine(){
		//是否是浮点数
		addMethodInfo("isFloat", function(value, element) {
			var urlFormat = /^-?\d+(\.\d+)?$/g;
			return urlFormat.test(value);
		}, "请填金额");

		//是否13位浮点数
		addMethodInfo("is13Float", function(value, element) {
			var urlFormat = /^-?\d{1,13}(\.\d+)?$/g;
			return urlFormat.test(value);
		}, "超出范围");

		//是否选择
		addMethodInfo("isSelected", function(value, element) {
			return value != 0;
		}, "");
		
		//是否选择
		addMethodInfo("isChecked", function(value, element) {
			result = "";
			result = $("input[type='radio'][name='commonReviewModel.reviewResult']:checked").val();
            if (result == "" || result==null) {
                return false;
            }else{
            	return true;
            }
		}, "");
		
		//是否是字母数字组合,字母不区分大小写,且由字母开头
		addMethodInfo("isAlphanumericCaseInsensitive", function(value, element){
			var alphanumericFormatSingle = /^[a-z0-9]$/gi;  
			var alphanumericFormatMulti = /^[a-z0-9][a-z0-9-]{0,18}[a-z0-9]$/gi;  
			
			if(value.length == 1){
				return alphanumericFormatSingle.test(value);
			}else if(value.length > 1 && value.length <= 20){
				return alphanumericFormatMulti.test(value);
			}
		}, "只能输入1~20位字母,数字,中划线组合,不能以中划线开头或结尾");
		
		//开始日期和结束日期验证
		addMethodInfo("startAndEndDateCheck", function(value, element) {
			var stVal = $("#start_time").val();
			var etVal = $("#end_time").val();
			var stValPjt = $("#start_time_pjt_info").val();
			var etValPjt = $("#end_time_pjt_info").val();
			
			if(stVal != undefined && etVal != undefined){
				if(stValPjt != undefined && etValPjt != undefined){
					return ((stValPjt.length == 10) && (etValPjt.length == 10)) && (etValPjt >= stValPjt);
				}else {
					return ((stVal.length == 10) && (etVal.length == 10)) && (etVal >= stVal);
				}
			}
			
		}, "开始时间和结束时间不能为空且结束时间必须晚于开始时间");
		
		// 验证账号格式
		addMethodInfo("accountFormatCheck", function(value, element){
			var accountRule = /^(?!_)(?!.*?_$)[\u4e00-\u9fa5\w]{4,20}$/;
			return accountRule.test(value);
		}, "账号格式错误");
		
		// 验证邮箱格式
		addMethodInfo("emailFormatCheck", function(value, element){
			var emailRule = /^[0-9a-z][0-9a-z\-\_\.]+@([0-9a-z][0-9a-z\-]*\.)+[a-z]{2,}$/i;
			return emailRule.test(value);
		}, "邮箱格式错误");
		
		// 密码格式验证
		addMethodInfo("pwdFormatCheck", function(value, element){
			var pwdRule = /^(?:(?!\s).){6,}$/;
			return pwdRule.test(value);
		}, "密码格式错误");
		
		// 确认密码验证
		addMethodInfo("confirmPwdCheck", function(value, element) {
			var password = $("#password").val();
			var rePassword = $("#rePassword").val();
			if (password != "" && rePassword !="") {
				return password == rePassword;
			} else {
				return true;
			}
		}, "两次输入的密码不一致！");
		
		// 验证11位手机号格式
		addMethodInfo("phoneNoFormatCheck", function(value, element){
			var phoneNoRule = /^1[34578]\d{9}$/;
			return phoneNoRule.test(value);
		}, "请输入有效的手机号码");
		
		// 验证验证码的格式
		addMethodInfo("captchaFormatCheck", function(value, element){
			var captchaRule = /^[0-9]{6}$/g;
			return captchaRule.test(value);
		}, "验证码必须为6位数字字符");
		
		// 验证<>特殊字符
		addMethodInfo("checkFormat", function(value, element) {
			return !(value.indexOf("<") >= 0 || value.indexOf(">") >= 0);
		}, "不能含有<或>特殊字符");
		
	}
	

	function init() {
		//验证规则定义
		rulesDefine();
	}

	function addMethodInfo(code, method, msg) {
		var info = new Object();
		info.code = code;
		info.method = method;
		info.msg = msg;

		methodMap.put(code, info);
	}

	function getMethodInfo(code) {

		return methodMap.get(code);
	}

	module.getMethodInfo = getMethodInfo;
	module.init = init;

	return module;
})($, window.ValidatorUtil || {});