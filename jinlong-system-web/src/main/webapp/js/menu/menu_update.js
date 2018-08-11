/**
 * 添加菜单
 */
window.MenuUpdate = (function($, module) {
	
	/**
	 * 标题信息
	 */
	var title = "修改菜单信息";
	
	/**
	 * @description：初始化validationEngine验证框架
	 */
	function initValidate() {
		// validate验证方法
		updateMenuFormValidate = $("#update_form").validate({
            debug: true, //调试模式取消submit的默认提交功能   
            errorClass: "v_error validate", //默认为错误的样式类为：error   
            focusInvalid: true, //当为false时，验证无效时，没有焦点响应  
            onkeyup: true,   
            submitHandler: function(form){   //表单提交句柄,为一回调函数，带一个参数：form   
            	jAlert("添加菜单", "添加菜单");   
                form.submit();   //提交表单   
            },
			rules: {
				"typeId" : {
					required : true,
					range:[1,6]
				},
				"menuName" : {
					required : true, 
					rangelength : [1, 50],
					// 验证菜单名称是否存在
					remote : {
						url : "menu/checkAdd",
						type : "POST",
						async : false,
						contentType: "application/json;charset=UTF-8",
						dataType : "JSON",
						data : {
							userName : function() {
								return $("#menuName").val()
							}
						}
					}
				},
				"menuUrl" : {
					required : true, 
					rangelength : [1, 50],
				},
				"description" : {
					required : true,
					rangelength : [10, 500]
				},
				"state" : {
					required : true,
					range:[1,6]
				}
			},
			messages: {
				"MenuName" : {
					required : "菜单名称不能为空！",
					rangelength : jQuery.validator.format("菜单名称位数必须在{0}到{1}字符之间！"),
					remote : jQuery.validator.format("此菜单已经错在！")
				},
				"typeId" : {
					required : "菜单类型必选！",
					range : "菜单类型必选！"
				},
				"description" : {
					required : "菜单详情不能为空！",
					rangelength : jQuery.validator.format("菜单详情的长度必须大于等于10个字符，小于500个字符！")
				},
				"state" : {
					required : "菜单状态必选！",
					range : "菜单状态必选！"
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
	 * @description：展示页面信息
	 */
	function show() {
		$.ajax({
			url : "menu/show",
			type : "POST",
			async : true,
			contentType : "application/json;charset=UTF-8",
			data : $("#MenuId").val(),
			dataType : "JSON"
		}).done(function(data) {
			if (null != data && data.flag) {
				// 菜单名称
				$("#MenuName").val(data.obj.MenuName);
				// 绑定菜单类别下拉框（只有显示下拉文本框的时候应用）
				showMenuType(data.obj.typeId);
				// 菜单详情
				editor.setContent(data.obj.description);
				// 绑定菜单状态下拉框（只有显示下拉文本框的时候应用）
				showMenuState(data.obj.state);
			} else if (null != data && !data.flag) {
				jAlert(data.msg, title);
			} else {
				jAlert("菜单信息查询失败！", title);
			}
		}).fail(function() {
			jAlert("菜单信息查询失败！", title);
		});
	}
	
	/**
	 * 绑定菜单类别下拉框
	 */
	function showMenuType(typeId) {
		url = "common/showMenuType";
		errorMsg = "查询菜单类别信息错误！";
		CommonDirectory.showSelectOptionData(url, "typeId", null, typeId, errorMsg);
	}

	/**
	 * 绑定菜单状态下拉框
	 */
	function showMenuState(state) {
		url = "common/showMenuState";
		errorMsg = "查询菜单状态信息错误！";
		CommonDirectory.showSelectOptionData(url, "state", null, state, errorMsg);
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
	 * 页面初始化
	 */
	function init() {
		// 初始化validationEngine验证框架
		initValidate();
		// 导入文本编辑器
		showTextArea();
		// 展示页面信息
		show();
	}
	
	/**
	 * 添加菜单信息
	 */
	function update() {
		if ($("#update_form").valid()) {
			$.ajax({
				url : "menu/update",
				type : "POST",
				async : false,
				dataType : "JSON",
				data : JSON.stringify({"menu" : $("#update_form").serializeJSON(), "menuIds" : $("#menuIds").val()})
			}).done(function(data) {
				if (null != data && data.flag) {
					jAlert(data.msg, title, function() {
						$("#main").empty().load("jsp/menu/Menu_manage.jsp");
					});
				} else if (null != data && !data.flag) {
					jAlert(data.msg, title);
				} else {
					jAlert("菜单信息添加失败！", data.flag);
				}
			}).fail(function() {
				jAlert("菜单信息添加失败", data.flag);
			});
		} else {
			updateMenuFormValidate.form();
		}
	}
	
	/**
	 * 接口注册
	 */
	module.init = init;
	module.show = show;
	module.showMenuType = showMenuType;
	module.showMenuState = showMenuState;
	module.update = update;
	
	/**
	 * 返回接口对象
	 */
	return module;
	
})($, window.MenuUpdate || {});



/**
 * 事件调用
 */
$(function(){
	
	/**
	 * 初始添加菜单的页面
	 */
	MenuUpdate.init();
	
	/**
	 * 添加菜单信息
	 */
	$("#update").on("click", function() {
		MenuUpdate.update();
	});
	
});