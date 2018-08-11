/**
 * 角色信息管理
 */
window.RoleManage = (function($, module) {
	
	/**
	 * 标题常量
	 */
	// 删除信息的标题
	var title = "删除角色";
	
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
	 * 绑定角色流程状态下拉框
	 */
	function showRoleProcessState() {
		url = "common/showRoleProcessState";
		errorMsg = "查询角色流程状态信息错误！";
		CommonDirectory.showSelectOptionData(url, "processState", null, null, errorMsg);
	}
	 
	/**
	 * @description：角色信息列表初始化
	 */
	function showGrid() {
		$("#role_list").jqGrid({
			url : "role/manage",
			mtype : "post",
			datatype : "json",
			sortable : false,
			height : "auto",
			forceFit : true,
			width : "1000",
			toolbar: [false,"top"],
			shrinkToFit : false,
			autoScroll: true, 
            autowidth : false,
			pagination: false,
            ajaxGridOptions: {contentType: "application/json; charset=utf-8"},  
            serializeGridData: function (postData) {
                return JSON.stringify({"role" : $("#role_form").serializeJSON(), "pageInfo" : postData});
            },  
			colNames : ["ID", "角色类别", "角色编码", "角色名称", "角色状态", "角色流程状态", "管理下面的用户信息", "编辑", "审核", "流程记录", "删除"],
			colModel : 
			[ {
				name : "roleId",
				index : "roleId",
				width : 0,
				hidden : true,
				align : "center",
				hidden : true
			}, {
			    name : "typeName",
			    index : "typeName",
			    width : 150,
			    align : "center"
			}, {
			    name : "roleCode",
			    index : "roleCode",
			    width : 150,
			    align : "center"
			}, {
			    name : "roleName",
			    index : "roleName",
			    width : 150,
			    align : "center"
			}, {
			    name : "stateName",
			    index : "stateName",
			    width : 130,
			    align : "center"
			}, {
			    name : "processStateName",
			    index : "processStateName",
			    width : 200,
			    align : "center"
			}, {
				name : "manage",
			    index : "manage",
			    width : 180,
			    align : "center"
			}, {
			    name : "update",
			    index : "update",
			    width : 90,
			    align : "center"
			}, {
			    name : "examine",
			    index : "examine",
			    width : 90,
			    align : "center"
			}, {
				name : "process",
			    index : "process",
			    width : 100,
			    align : "center"
			}, {
			    name : "delete",
			    index : "delete",
			    width : 90,
			    align : "center"
			} ],
			rowNum : 10,
			rowList : [10, 20, 30],
			pager : '#role_list_pager',
			recordpos : 'right',
			viewrecords : true,
			multiselect : true,
			pgbuttons : true,
			pginput : true,
			gridComplete : function() {
			},
			onSelectAll : function(rowid, status) {
			},
			onSelectRow : function(rowid, status) {
			},
			// 分页列表，加载后完成的犯法
		    loadComplete : function(data){
		    	// 获得一页的ID集合
		        var ids = $("#role_list").getDataIDs();
		        // 循环信息，加入编辑连接、删除连接
                $.each(ids, function(i, n) {
                	var roleId = $("#role_list").getCell(n, "roleId");
			        // 分页列表上面的编辑修改连接
			        var manage = "<a href=\"javascript:RoleManage.manage('" + roleId + "');\" >管理下面的用户信息</a>";
			        // 给表格加上编辑修改的连接
	            	$("#role_list").jqGrid('setRowData', n, {"manage" : manage});
			        // 分页列表上面的编辑修改连接
			        var update = "<a href=\"javascript:RoleManage.update('" + roleId + "');\" >修改</a>";
			        // 给表格加上编辑修改的连接
	            	$("#role_list").jqGrid('setRowData', n, {"update" : update});
	            	// 分页列表上面的审核链接
	            	var examine = "<a href=\"javascript:RoleManage.examine('" + roleId + "');\" >审核</a>";
	            	// 给表格加上审核的链接
	            	$("#role_list").jqGrid('setRowData', n, {"examine" : examine});
                	// 角色审核流程链接
                	var process = "<a href=\"javascript:RoleManage.process('" + roleId + "');\">流程记录</a>"
					// 给表格加上角色流程状态的连接
			        $("#role_list").jqGrid('setRowData', n, {"process" : process});
			        // 分页表格上面的删除连接
			        var del = "<a href=\"javascript:RoleManage.del('" + roleId + "')\" >删除</a>";
					// 给表格加上编辑修改的连接
			        $("#role_list").jqGrid('setRowData', n, {"delete" : del});
                });
			},
			prmNames : {
				search : "search",
				page : "page",
				rows : "rows",
				sidx : "sidx",
				sord : "sord",
				nd : "nd"
			},
			jsonReader : {
				root : "obj",
				page : "pageInfo.page",
				records : "pageInfo.record",
				total : "pageInfo.totalPage",
				sidx : "pageInfo.sidx",
				sord : "pageInfo.sord",
				roledata : "",
				repeatitems : false
			}
		});
	}
	
	/**
	 * 初始化以页面控件
	 */
	function init() {
		// 绑定角色类别下拉框
		showRoleType();
		// 绑定角色状态下拉框
		showRoleState();
		// 绑定角色流程状态下拉框
		showRoleProcessState();
		// 角色信息列表初始化
		showGrid();
	}
	
	/**
	 * 进入新增角色信息的页面
	 */
	function add() {
		$("#main").empty().load("jsp/role/role_add.jsp");
	}
	
	/**
	 * 查询角色信息
	 */
	function find() {
		/**
		 * 将form表单搜索的数据和分页的数据封装到一起传入后台
		 */
		var postData = $("#role_list").jqGrid("getGridParam", "postData");
		$("#role_list").jqGrid('setGridParam', {
			datatype : 'json',
			postData : postData, // 发送数据
			page : 1
		}).trigger("reloadGrid");
	}
	
	/**
	 * 批量删除角色信息的操作
	 */
	function batchDelete(roleId) {
		// 获取选中行的行id
		var rowIds = $("#role_list").jqGrid("getGridParam", "selarrrow");
		var roleIds = [];
		$.each(rowIds, function(i, rowId) {
			var userId = $("#role_list").getCell(rowId , "roleId");
			roleIds[i] = roleId;
		});
		jConfirm("确认删除当前的角色信息吗？", "删除角色", function(r) {
			// 是否确认删除当前的车辆信息
			if (r) {
				$.ajax({
					url : "role/delete",
					type : "POST",
					async : false,
					contentType: "application/json;charset=UTF-8",
					dataType : "JSON",
					data : JSON.stringify(roleIds)
				}).done(function(data) {
					if (null != data) {
						if (data.flag) {
							jAlert(data.msg, title);
							// 刷新分页表格，调用分页列表
							RoleManage.init();
						} else {
							jAlert(data.msg, title);
						}
					} else {
						jAlert("角色信息删除失败！", title);
					}
				}).fail(function() {
					jAlert("角色信息删除失败！", title);
				});
			}
		});
	}
	
	/**
	 * 管理此角色下面的角色信息
	 */
	function manage(roleId) {
		$("#main").empty().load("jsp/user/user_manage.jsp?roleId=" + roleId);
	}
	
	/**
	 * 进入修改角色信息的页面
	 */
	function update(roleId) {
		$("#main").empty().load("jsp/role/role_update.jsp?roleId=" + roleId);
	}
	
	/**
	 * 进入审核角色信息的页面
	 */
	function examine(roleId) {
		$("#main").empty().load("jsp/role/role_examine.jsp?roleId=" + roleId);
	}
	
	/**
	 * 进入角色流程记录页面
	 */
	function process(roleId) {
		$("#main").empty().load("jsp/role/role_process.jsp?roleId=" + roleId);
	}
	
	/**
	 * 删除角色信息的操作
	 */
	function del(roleId) {
		jConfirm("确认删除当前的角色信息吗？", "删除角色", function(r) {
			// 是否确认删除当前的车辆信息
			if (r) {
				$.ajax({
					url : "role/delete",
					type : "POST",
					async : false,
					contentType: "application/json;charset=UTF-8",
					dataType : "JSON",
					data : roleId
				}).done(function(data) {
					if (null != data) {
						if (data.flag) {
							jAlert(data.msg, title);
							// 刷新分页表格，调用分页列表
							RoleManage.init();
						} else {
							jAlert(data.msg, title);
						}
					} else {
						jAlert("角色信息删除失败！", title);
					}
				}).fail(function() {
					jAlert("角色信息删除失败！", title);
				});
			}
		});
	}
	
	/**
	 * 接口注册
	 */
	module.init = init;
	module.add = add;
	module.batchDelete = batchDelete;
	module.find = find;
	module.manage = manage;
	module.update = update;
	module.examine = examine;
	module.process = process;
	module.del = del;
	
	/**
	 * 返回结果集
	 */
	return module;
	
})($, window.RoleManage || {});


/**
 * 页面调用
 */
$(function() {
	
	/**
	 * 角色管理列表信息初始化
	 */
	RoleManage.init();
	
	/**
	 * 进入新增角色信息的页面
	 */
	$("#add").on("click", function() {
		RoleManage.add();
	});
	
	/**
	 * 批量删除角色信息
	 */
	$("#batchDelete").on("click", function() {
		RoleManage.batchDelete();
	})
	
	/**
	 * 查询角色信息
	 */
	$("#find").on("click", function() {
		RoleManage.find();
	});
	
});