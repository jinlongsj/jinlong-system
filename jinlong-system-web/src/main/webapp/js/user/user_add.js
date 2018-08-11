/**
 * 添加用户信息
 */
window.UserAdd = (function($, module) {
	
	/**
	 * 全局参数
	 */
	// 文本框标题
	var title = "添加用户信息";
	// 添加用户基础信息表单校验对象
	var addUserBaseFormValidate;
	// 添加用户详细信息表单校验对象
	var addUserInfoFormValidate;
	
	/**
	 * 文本编辑器
	 */
	var editor;
	
	/**
	 * @description：展示角色下拉文本框
	 */
	function showRoleList() {
		$.ajax({
			url : "user/showRoleList",
			type : "POST",
			async : false,
			contentType: "application/json;charset=UTF-8",
			dataType : "JSON"
		}).done(function(data) {
			if (data.flag && data.obj != null) {
				var auxArr = [];
				auxArr[0] ='<option value="0">请选择</option>';
				if(data.obj.length > 0){
					$.each(data.obj, function(index, key) {
						auxArr[index+1] = "<option value='" + key.roleId + "'>" + key.roleName + "</option>";
					});
				}
				$("#roleId").html(auxArr.join(''));
			} else {
				jAlert(data.msg, "角色列表");
			}
		}).fail(function() {
			jAlert("角色列表查询失败！", "角色列表");
		});
	}

	/**
	 * 绑定用户状态下拉框
	 */
	function showUserState() {
		url = "common/showUserState";
		errorMsg = "查询用户状态信息错误！";
		CommonDirectory.showSelectOptionData(url, "state", null, null, errorMsg);
	}
	
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
	 * 添加用户信息验证初始化
	 */
	function initValidate() {
		// 引入自定义确认密码验证
		var confirmPwdCheck = ValidatorUtil.getMethodInfo("confirmPwdCheck");
		$.validator.addMethod(confirmPwdCheck.code, confirmPwdCheck.method, confirmPwdCheck.msg);
		// 引入自定义校验手机格式验证方法
		var phoneNoFormatCheck = ValidatorUtil.getMethodInfo("phoneNoFormatCheck");
		$.validator.addMethod(phoneNoFormatCheck.code, phoneNoFormatCheck.method, phoneNoFormatCheck.msg);
		// 引入自定义电子邮箱格式验证
		var emailFormatCheck = ValidatorUtil.getMethodInfo("emailFormatCheck");
		$.validator.addMethod(emailFormatCheck.code, emailFormatCheck.method, emailFormatCheck.msg);
		// valiate验证方法
		addUserBaseFormValidate = $("#add_base_form").validate({
            debug: true, //调试模式取消submit的默认提交功能   
            errorClass: "v_error validate", //默认为错误的样式类为：error   
            focusInvalid: true, //当为false时，验证无效时，没有焦点响应  
            onkeyup: true, 
            submitHandler: function(form) {
            	// 表单提交句柄,为一回调函数，带一个参数：form
            	jAlert("添加用户", "添加用户");
                form.submit();   //提交表单   
            },
			rules: {
				"userName" : {
					required : true,
					rangelength : [1, 50],
					// 验证用户名称是否存在
					remote : {
						url : "user/checkAdd",
						type : "POST",
						async : false,
						dataType : "JSON",
						data : {
							userName : function() {
								return $("#userName").val();
							}
						}
					}
				},
				"roleId" : {
					required : true,
					range:[1,30]
				},
				"pwd" : {
					required : true,
					rangelength : [6, 50],
					confirmPwdCheck : true
				},
				"password" : {
					required : true,
					rangelength : [6, 50],
					confirmPwdCheck : true
				},
				"mobilePhone" : {
                    required : true,
                    digits : true,
					rangelength : [11, 11],
                    phoneNoFormatCheck : true,
					// 验证用户手机号码是否存在
					remote : {
						url : "user/checkAddMobilePhone",                                       
						type : "POST",
						async : false,
						dataType : "JSON",
						data:{
							mobilePhone : function() {
								return $("#mobilePhone").val();
							}
						}
					}
                },
				"email" : {
                    required : true,
					rangelength : [5, 100],
					emailFormatCheck : true,
					// 验证用户电子邮箱是否存在
					remote : {
						url : "user/checkAddEmail",                              
						type : "POST",
						async : false,
						dataType : "JSON",
						data:{
							email : function() {
								return $("#email").val();
							}
						}
					}
                },
				"state" : {
					required : true,
					range:[1,4]
				}
			},
			messages: {
				"userName" : {
					required : "用户名称不能为空！",
					rangelength : jQuery.validator.format("用户位数必须在{0}到{1}字符之间！"),
					remote : jQuery.validator.format("此用户已被注册！")
				},
				"roleId" : {
					required : "用户角色必选！",
					range : "用户角色必选！"
				},
				"pwd" : {
					required : "密码不能为空！",
					rangelength : jQuery.validator.format("密码位数必须大于等于6个字符，小于50个字符！"),
					confirmPwdCheck : "与确认密码输入的不一致！"
				},
				"password" : {
					required : "确认密码不能为空！",
					rangelength : jQuery.validator.format("确认密码位数必须大于等于6个字符，小于50个字符！"),
					confirmPwdCheck : "两次输入的密码不一致！"
				},
				"mobilePhone" : {
                    required : "手机号码必填！",
                    digits : "手机号码长度格式不正确！",
					rangelength : jQuery.validator.format("手机号码位数不对！"),
                    phoneNoFormatCheck : "手机号码格式错误！",
					remote : jQuery.validator.format("此手机号码已被注册！")
                },
				"email" : {
                    required : "电子邮箱必填！",
					rangelength : "电子邮箱位数不对！",
					emailFormatCheck : "电子邮箱码格式错误！",
					remote : jQuery.validator.format("此电子邮箱地址已被注册！")
                },
				"state" : {
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
		// valiate验证方法
		addUserInfoFormValidate = $("#add_info_form").validate({
            debug: true, //调试模式取消submit的默认提交功能   
            errorClass: "v_error validate", //默认为错误的样式类为：error   
            focusInvalid: true, //当为false时，验证无效时，没有焦点响应  
            onkeyup: true,   
            submitHandler: function(form){   //表单提交句柄,为一回调函数，带一个参数：form   
                alert("提交表单");   
                form.submit();   //提交表单   
            },
			rules: {
				"realName" : {
					required : true, 
					rangelength : [1, 50]
				},
				"nickName" : {
					required : true,
					rangelength : [1, 50]
				},
				"gender" : {
					required : true
				},
				"age" : {
                    required : true,
                    number : true,
					rangelength : [1, 3]
                },
				"idNumber" : {
                    required : true,
					rangelength : [17, 19]
                },
				"telephone" : {
                    required : true,
					rangelength : [11, 13]
                },
                "province" : {
                	required : true
                },
                "city" : {
                	required : true
                },
                "region" : {
                	required : true
                },
                "address" : {
					required : true, 
					rangelength : [1, 500]
                },
                "postCode" : {
					required : true, 
					number	: true,
					rangelength : [6, 6]
                },
                "homePage" : {
					required : true, 
					rangelength : [6, 500]
                },
                "qqNumber" : {
                	required : true,
                	number : true,
                	rangelength : [5, 13]
                },
                "aliPay" : {
                	required : true,
                	rangelength : [6, 50]
                },
                "description" : {
                	required : true,
                	rangelength : [6, 50]
                }
			},
			messages: {
				"realName" : {
					required : "真实姓名不能为空！",
					rangelength : jQuery.validator.format("真实姓名位数必须在{1}到{50}字符之间！")
				},
				"nickName" : {
					required : "用户昵称不能为空！",
					rangelength : jQuery.validator.format("用户昵称位数必须大于等于1个字符，小于50个字符！")
				},
				"gender" : {
					required : "用户性别必选！"
				},
				"age" : {
                    required : "用户年龄必填！",
                    number : "请填写数字！",
					rangelength : jQuery.validator.format("用户年龄过长！")
                },
				"idNumber" : {
                    required : "身份证号码必填！",
					rangelength : jQuery.validator.format("身份证号码请填写17到19个字符！")
                },
				"telephone" : {
                    required : "用户手机号码必填！",
					rangelength : jQuery.validator.format("用户座机号填写11到13个字符之间，区号和电话之间用-隔开！")
                },
                "province" : {
                	required : "用户所在地省区必选！"
                },
                "city" : {
                	required : "用户所在地市必选！"
                },
                "region" : {
                	required : "用户所在地县区必选！"
                },
                "address" : {
					required : "用户地址必填",
					rangelength : jQuery.validator.format("用户地址长度过长！")
                },
                "postCode" : {
					required : "邮编号码必填",
					number	: "邮编号码格式错误",
					rangelength : jQuery.validator.format("邮编号码长度必须填写6位！")
                },
                "homePage" : {
					required : "用户个人主页必填", 
					rangelength : jQuery.validator.format("用户个人主页请保持在6到500个字符之间！")
                },
                "qqNumber" : {
					required : "用户QQ必填", 
                	number : "用户QQ请填写数字",
                	rangelength : jQuery.validator.format("用户QQ请保持在5到13个数字之间！")
                },
                "aliPay" : {
                	required : "支付宝账号必填",
                	rangelength : jQuery.validator.format("支付宝账号长度不对！")
                },
                "description" : {
                	required : "用户详情不能为空！",
                	rangelength : jQuery.validator.format("用户支付宝请保持在1到10000个字符之间！")
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
		// 展示角色下拉文本框
		showRoleList();
		// 绑定用户状态下拉框
		showUserState();
		// 初始化省、自治区、直辖市下拉文本框的信息
		CommonZone.showProvinceList($("#province"), $("#city"), $("#region"), null);
		// 导入文本编辑器
		showTextArea();
		// 初始化validationEngine验证框架
		initValidate();
	}
	
	/**
	 * @description：新增用户信息
	 */
	function add() {
		if ($("#add_base_form").valid() && $("#add_info_form").valid()) {
			$.ajax({
				url : "user/add",
				type : "POST",
				async : false,
				contentType: "application/json;charset=UTF-8",
				dataType : "JSON",
				data : JSON.stringify({"userBase" : $("#add_base_form").serializeJSON(),
					"userInfo" : $("#add_info_form").serializeJSON()})
			}).done(function(data) {
				if (null != data && data.flag) {
					jAlert(data.msg, title, function() {
						$("#main").empty().load("jsp/user/user_manage.jsp");
					});
				} else if (null != data && !data.flag) {
					jAlert(data.msg, title);
				} else {
					jAlert("用户信息新增失败！", title);
				}
			}).fail(function() {
				jAlert("用户信息新增失败！", title);
			});
		} else {
			addUserBaseFormValidate.form();
			addUserInfoFormValidate.form();
		}
	}
	
	/**
	 * 接口方法注册
	 */
	module.init = init;
	module.showRoleList = showRoleList;
	module.add = add;
	
	/**
	 * 返回接口方法
	 */
	return module;
	
})($, window.UserAdd || {});



$(function() {
	
	/**
	 * @description：初始化页面数据
	 */
	UserAdd.init();
	
	/**
	 * @description：新增用户信息
	 */
	$("#add").on("click", function() {
		UserAdd.add();
	});
	
	/**
	 * @description：省、自治区、直辖市与下面的城市下拉文本框联动
	 */
	$("#province").on("change", function() {
		CommonZone.showCityList($("#province").val(), $("#city"), $("#region"), null);
	});
	
	/**
	 * @description：城市与下面的区县下拉文本框联动
	 */
	$("#city").on("change", function() {
		CommonZone.showRegionList($("#city").val(), $("#region"), null);
	});
	
});