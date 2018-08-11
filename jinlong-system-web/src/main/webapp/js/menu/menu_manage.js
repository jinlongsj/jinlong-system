/**
 * 菜单信息管理
 */
window.MenuManage = (function($, module) {
	
	/**
	 * 标题常量
	 */
	// 删除信息的标题
	var title = "删除菜单";
	
	/**
	 * 绑定菜单类别下拉框
	 */
	function showMenuType() {
		url = "common/showMenuType";
		errorMsg = "查询菜单类别信息错误！";
		CommonDirectory.showSelectOptionData(url, "typeId", null, null, errorMsg);
	}
	
	/**
	 * 绑定菜单级别下拉框
	 */
	function showMenuLeval() {
		url = "common/showMenuLeval";
		errorMsg = "查询菜单类别信息错误！";
		CommonDirectory.showSelectOptionData(url, "levalId", null, null, errorMsg);
	}

	/**
	 * 绑定菜单状态下拉框
	 */
	function showMenuState() {
		url = "common/showMenuState";
		errorMsg = "查询菜单状态信息错误！";
		CommonDirectory.showSelectOptionData(url, "state", null, null, errorMsg);
	}

	/**
	 * 绑定菜单流程状态下拉框
	 */
	function showMenuProcessState() {
		url = "common/showMenuProcessState";
		errorMsg = "查询角色流程状态信息错误！";
		CommonDirectory.showSelectOptionData(url, "processState", null, null, errorMsg);
	}
	 
	/**
	 * @description：菜单信息列表初始化
	 */
	function showGrid() {
		$("#menu_list").jqGrid({
			url : "menu/manage",
			mtype : "post",
	        treeGrid: true,  
	        treeGridModel: "adjacency",   // treeGrid模式，跟json元数据有关  
	        ExpandColumn : "menuName",    // 一般设置第一行
	        ExpandColClick : true,        // 是否可以点击
			datatype : "json",
			sortable : false,
		    sortname: "menuId",      
	        sortorder: "desc",
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
                return JSON.stringify({"menu" : $("#menu_form").serializeJSON(), "pageInfo" : postData});
            },  
			colNames : ["ID", "菜单名称", "菜单类别", "菜单级别", "菜单地址", "菜单状态", "菜单审核状态", "编辑", "审核", "流程记录", "删除"],
			colModel : 
			[ {
				name : "menuId",
				index : "menuId",
				width : 0,
				hidden : true,
				align : "center",
				hidden : true
			}, {
			    name : "menuName",
			    index : "menuName",
			    width : 250,
			    align : "center"
			}, {
			    name : "typeName",
			    index : "typeName",
			    width : 150,
			    align : "center"
			}, {
				name : "levelName",
			    index : "levelName",
			    width : 130,
			    align : "center"
			}, {
				name : "menuUrl",
			    index : "menuUrl",
			    width : 300,
			    align : "center"
			}, {
			    name : "stateName",
			    index : "stateName",
			    width : 124,
			    align : "center"
			}, {
			    name : "processStateName",
			    index : "processStateName",
			    width : 124,
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
			rowNum :  "-1",
			rowList : [200],
//			pager : "false",
			pager : '#menu_list_pager',
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
		        var ids = $("#menu_list").getDataIDs();
		        // 循环信息，加入编辑连接、删除连接
                $.each(ids, function(i, n) {
                	var menuId = $("#menu_list").getCell(n, "menuId");
			        // 分页列表上面的编辑修改连接
			        var update = "<a href=\"javascript:MenuManage.update('" + menuId + "');\" >修改</a>";
			        // 给表格加上编辑修改的连接
	            	$("#menu_list").jqGrid('setRowData', n, {"update" : update});
	            	// 分页列表上面的审核链接
	            	var examine = "<a href=\"javascript:MenuManage.examine('" + menuId + "');\" >审核</a>";
	            	// 给表格加上审核的链接
	            	$("#menu_list").jqGrid('setRowData', n, {"examine" : examine});
                	// 菜单审核流程链接
                	var process = "<a href=\"javascript:MenuManage.process('" + menuId + "');\">流程记录</a>"
					// 给表格加上菜单流程状态的连接
			        $("#menu_list").jqGrid('setRowData', n, {"process" : process});
			        // 分页表格上面的删除连接
			        var del = "<a href=\"javascript:MenuManage.del('" + menuId + "')\" >删除</a>";
					// 给表格加上编辑修改的连接
			        $("#menu_list").jqGrid('setRowData', n, {"delete" : del});
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
				menudata : "",
				repeatitems : false
			},
	        treeReader : {    
	            parent_id_field: "parent", 	// 父级rowid        		 
	            // 设置树形显示时4个关键字段对应的返回数据字段
	            level_field: "levelId",      // 属性层级
	            loaded_field: "loaded", 	 // 表示是否加载完成，设置为True表示加载完成，不需要在加载
	            leaf_field: "isLeaf",      	 // 是否为最子集的也自己点
	            expanded_field: "expanded"   // 是否加载完毕
	        }
		});
	}
	
	/**
	 * 初始化以页面控件
	 */
	function init() {
		// 绑定菜单类别下拉框
		showMenuType();
		// 绑定菜单级别下拉框
		showMenuLeval();
		// 绑定菜单状态下拉框
		showMenuState();
		// 绑定菜单流程状态下拉框
		showMenuProcessState();
		// 菜单信息列表初始化
		showGrid();
	}
	
	/**
	 * 进入新增菜单信息的页面
	 */
	function add() {
		$("#main").empty().load("jsp/menu/menu_add.jsp?parentId=0");
	}
	
	/**
	 * 查询菜单信息
	 */
	function find() {
		/**
		 * 将form表单搜索的数据和分页的数据封装到一起传入后台
		 */
		var postData = $("#menu_list").jqGrid("getGridParam", "postData");
		$("#menu_list").jqGrid('setGridParam', {
			datatype : 'json',
			postData : postData, // 发送数据
			page : 1
		}).trigger("reloadGrid");
	}
	
	/**
	 * 批量删除菜单信息的操作
	 */
	function batchDelete(menuId) {
		// 获取选中行的行id
		var rowIds = $("#menu_list").jqGrid("getGridParam", "selarrrow");
		var menuIds = [];
		$.each(rowIds, function(i, rowId) {
			var userId = $("#menu_list").getCell(rowId , "menuId");
			menuIds[i] = menuId;
		});
		jConfirm("确认删除当前的菜单信息吗？", "删除菜单", function(r) {
			// 是否确认删除当前的车辆信息
			if (r) {
				$.ajax({
					url : "menu/delete",
					type : "POST",
					async : false,
					contentType: "application/json;charset=UTF-8",
					dataType : "JSON",
					data : JSON.stringify(menuIds)
				}).done(function(data) {
					if (null != data) {
						if (data.flag) {
							jAlert(data.msg, title);
							// 刷新分页表格，调用分页列表
							MenuManage.init();
						} else {
							jAlert(data.msg, title);
						}
					} else {
						jAlert("菜单信息删除失败！", title);
					}
				}).fail(function() {
					jAlert("菜单信息删除失败！", title);
				});
			}
		});
	}
	
	/**
	 * 管理此菜单下面的菜单信息
	 */
	function manage(menuId) {
		$("#main").empty().load("jsp/user/user_manage.jsp?menuId=" + menuId);
	}
	
	/**
	 * 进入修改菜单信息的页面
	 */
	function update(menuId) {
		$("#main").empty().load("jsp/menu/menu_update.jsp?menuId=" + menuId);
	}
	
	/**
	 * 进入审核菜单信息的页面
	 */
	function examine(menuId) {
		$("#main").empty().load("jsp/menu/menu_examine.jsp?menuId=" + menuId);
	}
	
	/**
	 * 进入菜单流程记录页面
	 */
	function process(menuId) {
		$("#main").empty().load("jsp/menu/menu_process.jsp?menuId=" + menuId);
	}
	
	/**
	 * 删除菜单信息的操作
	 */
	function del(menuId) {
		jConfirm("确认删除当前的菜单信息吗？", "删除菜单", function(r) {
			// 是否确认删除当前的车辆信息
			if (r) {
				$.ajax({
					url : "menu/delete",
					type : "POST",
					async : false,
					contentType: "application/json;charset=UTF-8",
					dataType : "JSON",
					data : menuId
				}).done(function(data) {
					if (null != data) {
						if (data.flag) {
							jAlert(data.msg, title);
							// 刷新分页表格，调用分页列表
							MenuManage.init();
						} else {
							jAlert(data.msg, title);
						}
					} else {
						jAlert("菜单信息删除失败！", title);
					}
				}).fail(function() {
					jAlert("菜单信息删除失败！", title);
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
	
})($, window.MenuManage || {});


/**
 * 页面调用
 */
$(function() {
	
	/**
	 * 菜单管理列表信息初始化
	 */
	MenuManage.init();
	
	/**
	 * 进入新增菜单信息的页面
	 */
	$("#add").on("click", function() {
		MenuManage.add();
	});
	
	/**
	 * 批量删除菜单信息
	 */
	$("#batchDelete").on("click", function() {
		MenuManage.batchDelete();
	})
	
	/**
	 * 查询菜单信息
	 */
	$("#find").on("click", function() {
		MenuManage.find();
	});
	
});