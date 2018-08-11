/**
 * 用户注册页面
 */
window.RegisterUser = (function($, module) {
	
	// 登录校验对象
	var registerFormValidate;
	
	/**
	 * 用户信息注册验证初始化
	 */
	function initValidate() {
		// 自定义校验手机格式验证方法
		var phoneNoFormatCheck = ValidatorUtil.getMethodInfo('phoneNoFormatCheck');
		$.validator.addMethod(phoneNoFormatCheck.code, phoneNoFormatCheck.method, phoneNoFormatCheck.msg);
		// 确认密码验证
		var confirmPwdCheck = ValidatorUtil.getMethodInfo('confirmPwdCheck');
		$.validator.addMethod(confirmPwdCheck.code, confirmPwdCheck.method, confirmPwdCheck.msg);
		// valiate验证方法
		registerFormValidate = $("#register_user_form").validate({
            debug: true, //调试模式取消submit的默认提交功能   
            errorClass: "v_error validate", //默认为错误的样式类为：error   
            focusInvalid: true, //当为false时，验证无效时，没有焦点响应  
            onkeyup: true,   
            submitHandler: function(form){   //表单提交句柄,为一回调函数，带一个参数：form   
                alert("提交表单");   
                form.submit();   //提交表单   
            },
			rules: {
				"user.userName" : {
					required : true, 
					rangelength : [1, 50],
					// 验证用户名是否存在
					remote : {                                          
						type : "POST",
						url : "userRegister/checkUserName.action",
						data:{
							userName : function() {
								return $("#userName").val();
							}
						} 
					} 
				},
				"user.mobilePhone" : {
                    required : true,
                    digits : true,
					rangelength : [11, 11],
                    phoneNoFormatCheck : true,
					// 验证用户名是否存在
					remote : {                                          
						type : "POST",
						url : "userRegister/checkMobilePhone.action",
						data:{
							mobilePhone : function() {
								return $("#mobilePhone").val();
							}
						} 
					} 
                },
				"password" : {
					required : true,
					rangelength : [6, 50],
					confirmPwdCheck : true
				},
				"user.password" : {
					required : true,
					rangelength : [6, 50],
					confirmPwdCheck : true
				},
				"checkCode" : {
					required : true,
					rangelength : [4, 4],
					remote : {
						type : "POST",
						url : "userRegister/checkCheckCode.action",             
						data : {
							checkCode : function() {
						        return $("#checkCode").val();
						    }
						} 
					} 
				},
				"verifyNo" : {
					required : true,
					rangelength : [4, 4]
				/*,
					remote : {
						type : "POST",
						url : "userRegister/checkVerifyNo.action",             
						data : {
							verifyNo : function() {
						        return $("#verifyNo").val();
						    }
						} 
					}*/
				}
			},
			messages: {
				"user.userName" : {
					required : "用户名不能为空！",
					rangelength : jQuery.validator.format("用户名位数必须在{0}到{1}字符之间！"),
					remote : jQuery.validator.format("此用户已被注册！")
				},
				"user.mobilePhone" : {
                    required : "手机号码必填！",
                    digits : "手机号码长度格式不正确！",
					rangelength : "手机号码位数不对！",
                    phoneNoFormatCheck : "手机号码格式错误！",
					remote : jQuery.validator.format("此手机号码已被注册！")
                },
				"password" : {
					required : "密码不能为空！",
					rangelength : jQuery.validator.format("密码位数必须大于等于6个字符，小于50个字符！"),
					confirmPwdCheck : "与确认密码输入的不一致！"
				},
				"user.password" : {
					required : "确认密码不能为空！",
					rangelength : jQuery.validator.format("确认密码位数必须大于等于6个字符，小于50个字符！"),
					confirmPwdCheck : "两次输入的密码不一致！"
				},
				"checkCode" : {
					required : "请输入验证码！",
					rangelength : jQuery.validator.format("验证码必须填写4个字符！"),
					remote : jQuery.validator.format("验证码错误！")
				},
				"verifyNo" : {
					required : "请输入手机验证码！",
					rangelength : jQuery.validator.format("手机验证码必须填写4个字符！")
//					,
//					remote : jQuery.validator.format("验证码错误！")
				}
			},
			// 更改验证提示信息的位置
			errorPlacement : function(error, element) {
				element.parent().find(".focus").empty().append(error);
			},
			// 失去焦点进行验证
			onfocusout : function(element) {
		        $(element).valid();
		    },
			// 成功回调函数当中加入自定义验证方法
			success : function() {
				
			}
		});
	}
	
	/**
	 * 用户信息注册页面初始化方法
	 */
	function init() {
		// 用户登陆验证初始化
		initValidate();
        $(".class").change(function() {
            $(".dipe").show()
        });
        $(".cla").change(function() {
            $(".dipe").hide()
        });
	}
	
	/**
	 * 发送手机验证码
	 */
	function sentVerifyNo() {
		if (null != $("#mobilePhone").val() && "" != $("#mobilePhone").val()) {
			// 生成短信验证码
			$.ajax({
				url : "userRegister/sentVerifyNo.action",
				typ : "POST",
				async : true,
				dataType : "JSON",
				data : {"mobilePhone" : $("#mobilePhone").val()}
			}).done(function(data) {
				if (data.flag) {
					jAlert(data.status, "发送短信验证码");
				} else {
					jAlert(data.status, "发送短信验证码");
				}
			}).fail(function() {
				jAlert("生成短信验证码失败", "发送短信验证码");
			});
		} else {
			$("#verifyNo\\.info").html("手机号码不能为空");
		}
	}
	
	/**
	 * 用户注册信息
	 */
	function register() {
		// 注册页面1的确定按钮的样式控制
		if ($("#register_user_form").valid()) {
			$.ajax({
				url : "userRegister/register.action",
				type : "POST",
				data : $("#register_user_form").serialize(),
				dataType : "JSON"
			}).done(function(data) {
				if (data.flag) {
					// 加载执照和认知上传的页面
					RegisterUser.submitAuthentication()
				} else {
					jAlert(data.staus, "驾校注册");
				}
			}).fail(function(response, textStatus, errorThrown) {
				jAlert("注册失败", "驾校注册");
			});
		} else {
			registerFormValidate.form();
		}
	}
	
	/**
	 * 注册认证页面的确定按钮的样式控制
	 */
	function submitAuthentication() {
		$(".part1").hide();
		$(".part3").show();
		$(".step li").eq(1).addClass("on");
	}
	
	/**
	 * 注册接口
	 */
	module.init = init;
	module.sentVerifyNo = sentVerifyNo;
	module.register = register;
	module.submitAuthentication = submitAuthentication;
	
	return module;
	
})($, window.RegisterUser || {});

/**
 * 事件调用
 */
$(function() {
	
	/**
	 * 页面初始化
	 */
	RegisterUser.init();
	
	/**
	 * 发送手机验证码
	 */
	$("#verifyYz").on("click", function() {
		RegisterUser.sentVerifyNo();
	});
	
	/**
	 * 第一页的确定按钮
	 */
    $("#register_part1").on("click", function(){
    	RegisterUser.register();
   	});
	
})