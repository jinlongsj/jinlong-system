/**
 * 用户登陆JS
 */
window.Login = (function($, module) {
	
	var loginFormValidate;
	
	/**
	 * 用户登陆验证初始化
	 */
	function init() {
		loginFormValidate = $("#loginForm").validate({
            debug: true, //调试模式取消submit的默认提交功能   
            errorClass: "validate", //默认为错误的样式类为：error   
            focusInvalid: true, //当为false时，验证无效时，没有焦点响应  
            onkeyup: false,   
			rules: {
				"userName" : {
					required : true, 
					rangelength : [1, 50],
					// 验证用户名是否存在
					remote : {                                          
						type : "POST",
						url : "loginExit/checkUserName.action",
						data:{
							userName : function() {
//								alert($("#userName").val());
								return $("#userName").val();
							}
						}
					}
				},
				"password" : {
					required : true,
					minlength : 6
				},
				"checkCode" : {
					required:true,
					remote:{
						type : "POST",
						url : "loginExit/checkCheckCode.action",             
						data : {
							checkCode : function() {
						        return $("#checkCode").val();
						    }
						} 
					} 
				}
			},
			messages: {
				"userName" : {
					required : "用户名不能为空！",
					rangelength : jQuery.validator.format("用户名必须在{1}到{50}个字符之间！"),
					remote : jQuery.validator.format("此用户不存在！")
				},
				"password" : {
					required : "密码不能为空！",
					minlength : jQuery.validator.format("密码位数必须大于等于6个字符！")
				},
				"checkCode" : {
					required : "请输入验证码",
					remote : jQuery.validator.format("验证码错误")
				}
			},
			// 更改验证提示信息的位置
			/*errorPlacement : function(error, element) {
				element.parent().find(".validate").empty().append(error);
			},*/
			// 失去焦点进行验证
			onfocusout: function(element) {
		        $(element).valid();
		    },   
            /*submitHandler: function(form) {
            	//提交表单 
                if (form.submit()) {   
        			$.ajax({
        				url : loginExit/login.action,
        				type : "POST",
        				async : true,
        				dataType : "JSON"
        			}).done(function(data) {
        				// 驾校用户登录成功
        				if (data.flag) {
        					jAlert(data.status, "用户登陆", function() {
        						window.location.href= "home.jsp";
        					});
        				} else {
        					// 驾校用户登录失败
        					jAlert(data.status, "用户登陆");
        				}
        			}).fail(function(data) {
        				// 驾校用户登录失败
        				jAlert("登陆失败!", "用户登陆");
        			});
                }
            }*/
		});
	}
	
	/**
	 * 用户登陆
	 */
	function login() {
		if($("#loginForm").valid()) {
			$.ajax({
				url : "loginExit/login",
				type : "POST",
				async : true,
				dataType : "JSON",
				data : JSON.stringify($("#loginForm").serializeJSON()),
			}).done(function(data) {
				// 驾校用户登录成功
				if (data.flag) {
					window.location.href= "/Chujia_school/home.jsp";
				} else {
					// 驾校用户登录失败
					$("#validate\\.info").html(data.status);
				}
			}).fail(function(data) {
				// 驾校用户登录失败
				$("#validate\\.info").html("登陆失败!");
			});
		} else {
			loginFormValidate.form();
		}
	}
	
	/**
	 * 注册接口
	 */
	module.init = init;
	module.login = login;
	
	/**
	 * 返回接口对象
	 */
	return module;	
	
})($, window.Login || {});



/**
 * 事件绑定
 */
$(function() {
	
	/**
	 * 方法初始化
	 */
	Login.init();
	
	/**
	 * 登录验证
	 */
	/*$("#login").on("click", function() {
		Login.login();
	});*/
	
});