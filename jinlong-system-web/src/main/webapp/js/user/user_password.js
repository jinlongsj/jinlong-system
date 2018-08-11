/**
 * 用户信息修改
 */
window.UserPassword = (function($, module) {
	
	/**
	 * 全局参数
	 */
	var title = "重置用户密码";
	// 修改用户基础信息表单校验对象
	var updateUserFormValidate;
	
	/**
	 * 文本编辑器
	 */
	var editor;
	
	/**
	 * @description：进入修改用户密码页面查询修改的用户名称
	 */
	function show() {
		$.ajax({
			url : "user/show",
			type : "POST",
			async : false,
			contentType: "application/json;charset=UTF-8",
			dataType : "JSON",
			data : $("#userId").val()
		}).done(function(data) {
			if (null != data && data.flag) {
				// 用户名称
				$("#userName").val(data.obj.userName);
			} else if (null != data) {
				jAlert(data.msg, title);
			} else {
				jAlert("用户名称查询是失败", title);
			}
		}).fail(function() {
			jAlert("用户名称查询失败", title);
		});
	}
	
	/**
	 * 添加用户信息验证初始化
	 */
	function initValidate() {
		// valiate验证方法
		updateUserBaseValidate = $("#update_form").validate({
            debug: true, //调试模式取消submit的默认提交功能   
            errorClass: "v_error validate", //默认为错误的样式类为：error   
            focusInvalid: true, //当为false时，验证无效时，没有焦点响应  
            onkeyup: true,   
            submitHandler: function(form){
            	//表单提交句柄,为一回调函数，带一个参数：form  
            	jAlert("修改用户", "修改用户");
                form.submit();   //提交表单   
            },
			rules: {
				"pwd" : {
					required : true,
					rangelength : [6, 50],
					confirmPwdCheck : true
				},
				"password" : {
					required : true,
					rangelength : [6, 50],
					confirmPwdCheck : true
				}
			},
			messages: {
				"pwd" : {
					required : "密码不能为空！",
					rangelength : jQuery.validator.format("密码位数必须大于等于6个字符，小于50个字符！"),
					confirmPwdCheck : "与确认密码输入的不一致！"
				},
				"password" : {
					required : "确认密码不能为空！",
					rangelength : jQuery.validator.format("确认密码位数必须大于等于6个字符，小于50个字符！"),
					confirmPwdCheck : "两次输入的密码不一致！"
				}
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
	 * @description：初始化数据
	 */
	function init() {
		// 进入修改页面查询修改的用户信息
		show();
		// 初始化validationEngine验证框架
		initValidate();
	}
	
	/**
	 * @description：修改用户信息
	 */
	function update() {
		if ($("#update_form").valid()) {
			$.ajax({
				url : "user/update",
				type : "POST",
				async : false,
				contentType: "application/json;charset=UTF-8",
				dataType : "JSON",
				data : JSON.stringify({"userBase" : $("#update_form").serializeJSON()})
			}).done(function(data) {
				if (null != data && data.flag) {
					jAlert(data.msg, title, function() {
						$("#main").empty().load("jsp/user/user_manage.jsp");
					});
				} else if (!data.flag) {
					jAlert(data.msg, title);
				} else {
					jAlert("用户密码重置失败！", title);
				}
	 		}).fail(function() {
				jAlert("用户密码重置失败！", title);
			});
		} else {
			updateUserFormValidate.form();
		}
	}
	
	/**
	 * 接口方法注册
	 */
	module.init = init;
	module.update = update;
	
	/**
	 * 返回接口方法
	 */
	return module;
	
})($, window.UserPassword || {});



$(function() {
	
	/**
	 * @description：初始化页面数据
	 */
	UserPassword.init();
	
	/**
	 * @description：修改用户密码信息
	 */
	$("#update").on("click", function() {
		UserPassword.update();
	});
	
});