/**
 * 用户信息审核
 */
window.UserExamine = (function($, module) {
	
	/**
	 * 全局参数
	 */
	var title = "审核用户信息";
	// 审核用户信息表单校验对象
	var exaimeUserFormValidate;
	
	/**
	 * 文本编辑器
	 */
	var editor;
	
	/**
	 * 导入文本编辑器
	 */
	function showTextArea() {
		editor = new baidu.editor.ui.Editor({
			initialFrameHeight : 100,
			initialFrameWidth : 510,
			minFrameHeight : 100
		});
		editor.render("description");
	}
	
	/**
	 * @description：进入修改页面查询修改的用户信息
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
				// 用户基础信息
				// 用户名称
				$("#userName").val(data.obj.userName);
				// 展示角色下拉文本框
				$("#roleName").val(data.obj.roleName);
				// 手机号
				$("#mobilePhone").val(data.obj.mobilePhone);
				// 电子邮箱
				$("#email").val(data.obj.email);
				// 绑定用户状态下拉框
				$("#state").val(data.obj.stateName);
				// 用户详细信息
				// 真实姓名
				$("#realName").val(data.obj.realName);
				// 用户昵称
				$("#nickName").val(data.obj.nickName);
				// 性别
				$("input:radio[name='gender'][value='" + data.obj.gender + "']").prop("checked", "checked");
				// 年龄
				$("#age").val(data.obj.age);
				// 身份证号码
				$("#idNumber").val(data.obj.idNumber);
				// 座机号码
				$("#telephone").val(data.obj.telephone);
				// 初始化省、自治区、直辖市下拉文本框的信息
				$("#province").val(data.obj.province);
				// 初始化市
				$("#city").val(data.obj.city);
				// 初始化区县
				$("#region").val(data.obj.region);
				// 用户地址
				$("#address").val(data.obj.address);
				// 邮编号码
				$("#postCode").val(data.obj.postCode);
				// 个人主页
				$("#homePage").val(data.obj.homePage);
				// 用户QQ
				$("#qqNumber").val(data.obj.qqNumber);
				// 用户支付宝
				$("#aliPay").val(data.obj.aliPay);
				// 用户详情
				$("#user_description").val(data.obj.description);
			} else if (null != data) {
				jAlert(data.msg, title);
			} else {
				jAlert("用户信息查询失败", title);
			}
		}).fail(function() {
			jAlert("用户信息查询失败", title);
		});
	}
	
	/**
	 * 添加用户信息验证初始化
	 */
	function initValidate() {
		// valiate验证方法
		exaimeUserFormValidate = $("#examine_form").validate({
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
				"roleId" : {
					required : true,
					range:[1,30]
				},
				"description" : {
					required : true,
					range:[1,4]
				}
			},
			messages: {
				"roleId" : {
					required : "用户角色必选！",
					range : "用户角色必选！"
				},
				"description" : {
					required : "用户状态必选！",
					range : "用户状态必选！"
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
		// 导入文本编辑器
		showTextArea();
		// 进入修改页面查询修改的用户信息
		show();
		// 初始化validationEngine验证框架
		initValidate();
	}
	
	/**
	 * @description：修改用户信息
	 */
	function examine() {
		if ($("#examine_form").valid()) {
			$.ajax({
				url : "user/examine",
				type : "POST",
				async : false,
				contentType: "application/json;charset=UTF-8",
				dataType : "JSON",
				data : JSON.stringify($("#examine_form").serializeJSON())
			}).done(function(data) {
				if (null != data && data.flag) {
					jAlert(data.msg, title, function() {
						$("#main").empty().load("jsp/user/user_manage.jsp");
					});
				} else if (!data.flag) {
					jAlert(data.msg, title);
				} else {
					jAlert("用户信息修改失败！", title);
				}
	 		}).fail(function() {
				jAlert("用户信息修改失败！", title);
			});
		} else {
			exaimeUserFormValidate.form();
		}
	}
	
	/**
	 * 接口方法注册
	 */
	module.init = init;
	module.show = show;
	module.examine = examine;
	
	/**
	 * 返回接口方法
	 */
	return module;
	
})($, window.UserExamine || {});



$(function() {
	
	/**
	 * @description：初始化页面数据
	 */
	UserExamine.init();
	
	/**
	 * @description：修改用户信息
	 */
	$("#examine").on("click", function() {
		UserExamine.examine();
	});
	
});