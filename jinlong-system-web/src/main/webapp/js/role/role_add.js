/**
 * 添加角色
 */
window.RoleAdd = (function($, module) {
	
	/**
	 * 标题信息
	 */
	var title = "添加角色信息";

	/**
	 * @description：初始化validationEngine验证框架
	 */
	function initValidate() {
		// validate验证方法
		addRoleFormValidate = $("#add_form").validate({
            debug : true, //调试模式取消submit的默认提交功能   
            errorClass : "validate", //默认为错误的样式类为：error   
            focusInvalid : true, //当为false时，验证无效时，没有焦点响应  
            onkeyup : true,   
            submitHandler : function(form) {
            	// 表单提交句柄,为一回调函数，带一个参数：form   
            	jAlert("添加角色", "添加角色");   
                form.submit();   //提交表单   
            },
			rules: {
				"typeId" : {
					required : true,
					range : [1,6]
				},
				"roleCode" : {
					required : true, 
					rangelength : [1, 50],
					// 验证角色名称是否存在
					remote : {
						url : "role/checkCodeAdd",
						type : "POST",
						async : false,
						contentType: "application/json;charset=UTF-8",
						dataType : "JSON",
						data : {
							userName : function() {
								return $("#roleCode").val()
							}
						}
					}
				},
				"roleName" : {
					required : true, 
					rangelength : [1, 50],
					// 验证角色名称是否存在
					remote : {
						url : "role/checkAdd",
						type : "POST",
						async : false,
						contentType: "application/json;charset=UTF-8",
						dataType : "JSON",
						data : {
							userName : function() {
								return $("#roleName").val()
							}
						}
					}
				},
				"description" : {
					required : true,
					rangelength : [10, 500]
				},
				"state" : {
					required : true,
					range :[1,6]
				}
			},
			messages: {
				"roleName" : {
					required : "角色名称不能为空！",
					rangelength : jQuery.validator.format("角色名称位数必须在{0}到{1}字符之间！"),
					remote : jQuery.validator.format("此角色已经存在！")
				},
				"typeId" : {
					required : "角色类型必选！",
					range : "角色类型必选！"
				},
				"description" : {
					required : "角色详情不能为空！",
					rangelength : jQuery.validator.format("角色详情的长度必须大于等于10个字符，小于500个字符！")
				},
				"state" : {
					required : "角色状态必选！",
					range : "角色状态必选！"
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
	 * 绑定角色类别下拉框
	 */
	function showRoleType() {
		url = "common/showRoleType";
		errorMsg = "查询角色类别信息错误！";
		CommonDirectory.showSelectOptionData(url, "typeId", null, null, errorMsg);
	}

	/**
	 * 绑定角色状态下拉框
	 */
	function showRoleState() {
		url = "common/showRoleState";
		errorMsg = "查询角色状态信息错误！";
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
	
	// 树对象
	var zTree;
	
	/**
	 * 菜单树结构
	 */
	function showMenuList() {
		// 树的数据对象
		var zTreeNodes = [];
		// 设置树的参数 
		var setting = {
			isSimpleData : true,              // 数据是否采用简单 Array 格式，默认false  
			treeNodeKey : "id",               // 在isSimpleData格式下，当前节点id属性  
			treeNodeParentKey : "pId",        // 在isSimpleData格式下，当前节点的父节点id属性  
			showLine : true,                  // 是否显示节点间的连线  
			checkable: true,				  //节点是否含有checkbox
			callback:{
				 click: getMenuTreeNode,//节点点击和checkbox状态发生改变都会调用回调函数
				 change : getMenuTreeNode
			}
		};
		$.ajax({
			url : "role/showMenuList",
			type : "POST",
			async : false,
			contentType : "application/json;charset=UTF-8",
			dataType : "JSON"
		}).done(function(data) {
			if (null != data && data.flag && null != data.obj) {
				$.each(data.obj, function(i, menu) {
					zTreeNodes.push({"id" : menu.menuId, "pId" : menu.parentId, "name" : menu.menuName});
				});
				zTree = $("#menuTree").zTree(setting, zTreeNodes);
			} else if (null != data && !data.flag) {
				$(".menuTree").html("暂无数据，请选择角色类型");
				jAlert(data.msg, title);
			} else {
				$(".menuTree").html("暂无数据，请选择角色类型");
				jAlert("绑定菜单信息查询失败！", title);
			}
		}).fail(function() {
			jAlert("绑定菜单信息查询失败！", title);
		});
	}

	// 获得勾选权限菜单
	function getMenuTreeNode() {
		// 获取已选中的节点
		var selectedMenu = zTree.getCheckedNodes();
		// 选中的权限ID，以"，"拼接，如"1111,2222,3333"
		var menuIds = [];
		if (selectedMenu != null) {
			var index = 0;
			$.each(selectedMenu, function(i, menu) {
				if (menu.pId == null) {
					menuIds.push(menu.id);
					index ++;
				}
			});
		}
		//进行赋值
		$("#menuIds").val(menuIds);
	}
	
	/**
	 * 页面初始化
	 */
	function init() {
		// 初始化validationEngine验证框架
		initValidate()
		// 绑定角色类别下拉框（只有显示下拉文本框的时候应用）
		showRoleType();
		// 绑定角色状态下拉框（只有显示下拉文本框的时候应用）
		showRoleState();
		// 导入文本编辑器
		showTextArea();
		// 菜单树结构
		showMenuList();
	}
	
	/**
	 * 添加角色信息
	 */
	function add() {
		if ($("#add_form").valid()) {
			$.ajax({
				url : "role/add",
				type : "POST",
				async : false,
				contentType : "application/json;charset=UTF-8",
				dataType : "JSON",
				data : JSON.stringify({"role" : $("#add_form").serializeJSON(), "menuIds" : $("#menuIds").val().split(",")})
			}).done(function(data) {
				if (null != data && data.flag) {
					jAlert(data.msg, title, function() {
						$("#main").empty().load("jsp/role/role_manage.jsp");
					});
				} else if (null != data && !data.flag) {
					jAlert(data.msg, title);
				} else {
					jAlert("角色信息添加失败！", data.flag);
				}
			}).fail(function() {
				jAlert("角色信息添加失败", data.flag);
			});
		} else {
			addRoleFormValidate.form();
		}
	}
	
	/**
	 * 接口注册
	 */
	module.init = init;
	module.showRoleType = showRoleType;
	module.showRoleState = showRoleState;
	module.add = add;
	
	/**
	 * 返回接口对象
	 */
	return module;
	
})($, window.RoleAdd || {});



/**
 * 事件调用
 */
$(function() {
	
	/**
	 * 初始添加角色的页面
	 */
	RoleAdd.init();
	
	/**
	 * 添加角色信息
	 */
	$("#add").on("click", function() {
		RoleAdd.add();
	});
	
});