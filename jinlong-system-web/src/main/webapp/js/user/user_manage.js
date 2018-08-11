/**
 * 用户信息管理
 */
window.UserManage = (function($, module) {
	
	/**
	 * @description：标题常量
	 */
	// SpringBoot通过tokern和header进行过滤和拦截的公共认证JS类
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	// 删除信息的标题
	var title = "删除用户";
	
	/**
	 * @description：展示角色下拉文本框
	 */
	function showRoleList() {
		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
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
	 * 绑定用户流程状态下拉框
	 */
	function showUserProcessState() {
		url = "common/showUserProcessState";
		errorMsg = "查询用户流程状态信息错误！";
		CommonDirectory.showSelectOptionData(url, "processState", null, null, errorMsg);
	}
	 
	/**
	 * @description：用户信息分页列表初始化
	 */
	function showGrid() {
		$("#user_list").jqGrid({
			url : "user/manage",
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
            	// 用户信息分页列表查询条件
                return JSON.stringify({"user" : $("#user_form").serializeJSON(), "pageInfo" : postData});  
            },  
			colNames : ["ID", "用户名称", "用户角色", "手机号", "电子邮箱", "状态ID", "用户状态", "真实姓名", 
			            "用户昵称", "性别", "年龄", "身份证号码", "座机号码", "地区", "用户邮编", "流程状态ID",
			            "流程状态", "编辑", "重置密码", "审核", "流程记录", "删除"],
			colModel : 
			[ {
				name : "userId",
				index : "userId",
				width : 0,
				align : "center",
				hidden : true
			}, {
				name : "userName",
				index : "userName",
				width : 90,
				align : "center",
			}, {
			    name : "roleName",
			    index : "roleName",
			    width : 90,
			    align : "center"
			}, {
			    name : "mobilePhone",
			    index : "mobilePhone",
			    width : 120,
			    align : "center"
			}, {
				name : "email",
			    index : "email",
			    width : 150,
			    align : "center"
			}, {
				name : "state",
				index : "state",
				width : 0,
				align : "center",
				hidden : true
			}, {
				name : "stateName",
			    index : "stateName",
			    width : 70,
			    align : "center"
			}, {
			    name : "realName",
			    index : "realName",
			    width : 100,
			    align : "center"
			}, {
			    name : "nickName",
			    index : "nickName",
			    width : 100,
			    align : "center"
			}, {
			    name : "genderName",
			    index : "genderName",
			    width : 60,
			    align : "center"
			}, {
			    name : "age",
			    index : "age",
			    width : 60,
			    align : "center"
			}, {
				name : "idNumber",
				index : "idNumber",
				width : 180,
				align : "center"
			}, {
				name : "telephone",
				index : "telephone",
				width : 140,
				align : "center"
			}, {
				name : "region",
				index : "region",
				width : 60,
				align : "center"
			}, {
				name : "postCode",
				index : "postCode",
				width : 80,
				align : "center"
			}, {
				name : "processState",
				index : "processState",
				width : 0,
				align : "center",
				hidden : true
			}, {
				name : "processStateName",
			    index : "processStateName",
			    width : 150,
			    align : "center"
			}, {
			    name : "update",
			    index : "update",
			    width : 80,
			    align : "center"
			}, {
			    name : "password",
			    index : "password",
			    width : 80,
			    align : "center"
			}, {
			    name : "examine",
			    index : "examine",
			    width : 80,
			    align : "center"
			}, {
				name : "process",
			    index : "process",
			    width : 80,
			    align : "center"
			}, {
			    name : "delete",
			    index : "delete",
			    width : 80,
			    align : "center"
			} ],
			rowNum : 10,
			rowList : [10, 20, 30],
			pager : '#user_list_pager',
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
		    loadComplete : function(data) {
		    	// 获得一页的ID集合
		        var ids = $("#user_list").getDataIDs();
		        // 循环信息，加入编辑连接、删除连接
                $.each(ids, function(i, n) {
                	// 用户ID
                	var userId = $("#user_list").getCell(n, "userId");
                	// 用户状态
                	var state = $("#user_list").getCell(n, "state");
                	// 用户流程状态
                	var processState = $("#user_list").getCell(n, "processState");
                	// 用户流程状态为1、2、3、4时，可以编辑用户信息、修改用户密码
                	if (state in {1 : 1, 2 : 2} && processState in {1 : 1, 3 : 3, 4 : 4, 7 : 7, 10 : 10}) {
    			        // 分页列表上面的编辑修改连接
    			        var update = "<a href=\"javascript:UserManage.update('" + userId + "');\" >编辑</a>";
    			        // 给表格加上编辑修改的连接
    	            	$("#user_list").jqGrid('setRowData', n, {"update" : update});
    			        // 分页列表上面的用户密码编辑修改连接
    			        var password = "<a href=\"javascript:UserManage.password('" + userId + "');\" >重置密码</a>";
    			        // 给表格加上编辑修改的连接
    	            	$("#user_list").jqGrid('setRowData', n, {"password" : password});
                	} else {
    			        // 给表格加上编辑修改的连接
    	            	$("#user_list").jqGrid('setRowData', n, {"update" : ""});
    			        // 给表格加上编辑修改的连接
    	            	$("#user_list").jqGrid('setRowData', n, {"password" : ""});
                	}
                	// 用户流程状态为2、5、8时，可以审核用户信息
                	if (state in {3 : 3, 4 : 4} || processState in {2 : 2, 5 : 5,	6 : 6, 8 : 8, 9 : 9}) {
    	            	// 分页列表上面的审核链接
    	            	var examine = "<a href=\"javascript:UserManage.examine('" + userId + "');\" >审核</a>";
    	            	// 给表格加上审核的链接
    	            	$("#user_list").jqGrid('setRowData', n, {"examine" : examine});
                	} else {
    	            	// 给表格加上审核的链接
    	            	$("#user_list").jqGrid('setRowData', n, {"examine" : ""});
                	}
                	// 用户审核流程链接
                	var process = "<a href=\"javascript:UserManage.process('" + userId + "');\">流程记录</a>"
					// 给表格加上用户流程状态的连接
			        $("#user_list").jqGrid('setRowData', n, {"process" : process});
                	// 用户流程状态为1、2、3、4时，可以删除用户信息
                	if (state in {1 : 1, 2 : 2} && processState in {1 : 1, 3 : 3, 4 : 4, 7 : 7, 10 : 10}) {
    			        // 分页表格上面的删除连接
    			        var del = "<a href=\"javascript:UserManage.del('" + userId + "');\" >删除</a>";
    					// 给表格加上编辑修改的连接
    			        $("#user_list").jqGrid('setRowData', n, {"delete" : del});
                	} else {
    					// 给表格加上编辑修改的连接
    			        $("#user_list").jqGrid('setRowData', n, {"delete" : ""});
                	}
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
				userdata : "",
				repeatitems : false
			}
		});
	}
	
	function init() {
		// 展示角色下拉文本框
		showRoleList();
		// 绑定用户状态下拉框
		showUserState();
		// 绑定用户状态下拉框
		showUserProcessState();
		// 初始化省、自治区、直辖市下拉文本框的信息
		CommonZone.showProvinceList($("#province"), $("#city"), $("#region"), null);
		// 用户信息列表初始化
		showGrid();
	}
	
	/**
	 * 进入新增用户信息的页面
	 */
	function add() {
		$("#main").empty().load("jsp/user/user_add.jsp");
	}
	
	/**
	 * 批量删除用户信息的操作
	 */
	function batchDelete() {
		// 获取选中行的行id
		var rowIds = $("#user_list").jqGrid("getGridParam", "selarrrow");
		var userIds = [];
		$.each(rowIds, function(i, rowId) {
			var userId = $("#user_list").getCell(rowId , "userId");
			userIds[i] = userId;
		});
		jConfirm("确认批量删除当前的用户信息吗？", "批量删除用户", function(r) {
			// 是否确认删除当前的车辆信息
			if (r) {
				$(document).ajaxSend(function(e, xhr, options) {
					xhr.setRequestHeader(header, token);
				});
				$.ajax({
					url : "user/batchDelete",
					type : "POST",
					async : true,
					contentType: "application/json;charset=UTF-8",
					dataType : "JSON",
					data : JSON.stringify(userIds)
				}).done(function(data) {
					if (null != data) {
						if (data.flag) {
							jAlert(data.msg, title);
							// 刷新分页表格，调用分页列表
							$("#user_list").jqGrid().trigger("reloadGrid");
						} else {
							jAlert(data.msg, title);
						}
					} else {
						jAlert("用户信息删除失败！", title);
					}
				}).fail(function() {
					jAlert("用户信息删除失败！", title);
				});
			}
		});
	}
	
	/**
	 * 查询用户信息
	 */
	function find() {
		/**
		 * 将form表单搜索的数据和分页的数据封装到一起传入后台
		 */
		var postData = $("#user_list").jqGrid("getGridParam", "postData");
		$("#user_list").jqGrid('setGridParam', {
			datatype : 'json',
			postData : postData, // 发送数据
			page : 1
		}).trigger("reloadGrid");
	}
	
	/**
	 * 进入修改用户信息的页面
	 */
	function update(userId) {
		$("#main").empty().load("jsp/user/user_update.jsp?userId=" + userId);
	}
	
	/**
	 * 进入修改用户密码信息的页面
	 */
	function password(userId) {
		$("#main").empty().load("jsp/user/user_password.jsp?userId=" + userId);
	}
	
	/**
	 * 进入审核用户信息的页面
	 */
	function examine(userId) {
		$("#main").empty().load("jsp/user/user_examine.jsp?userId=" + userId);
	}
	
	/**
	 * 进入用户流程记录页面
	 */
	function process(userId) {
		$("#main").empty().load("jsp/user/user_process.jsp?userId=" + userId);
	}
	
	/**
	 * 删除用户信息的操作
	 */
	function del(userId) {
		jConfirm("确认删除当前的用户信息吗？", "删除用户", function(r) {
			$(document).ajaxSend(function(e, xhr, options) {
				xhr.setRequestHeader(header, token);
			});
			// 是否确认删除当前的车辆信息
			if (r) {
				$.ajax({
					url : "user/delete",
					type : "POST",
					async : true,
					contentType: "application/json;charset=UTF-8",
					dataType : "JSON",
					data : userId
				}).done(function(data) {
					if (null != data) {
						if (data.flag) {
							jAlert(data.msg, title);
							// 刷新分页表格，调用分页列表
							$("#user_list").jqGrid().trigger("reloadGrid");
						} else {
							jAlert(data.msg, title);
						}
					} else {
						jAlert("用户信息删除失败！", title);
					}
				}).fail(function() {
					jAlert("用户信息删除失败！", title);
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
	module.update = update;
	module.password = password;
	module.examine = examine;
	module.process = process;
	module.del = del;
	
	/**
	 * 返回结果集
	 */
	return module;
	
})($, window.UserManage || {});


/**
 * 页面调用
 */
$(function() {
	
	/**
	 * 用户管理列表信息初始化
	 */
	UserManage.init();
	
	/**
	 * 进入新增用户信息的页面
	 */
	$("#add").on("click", function() {
		UserManage.add();
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
	
	/**
	 * 批量删除用户信息
	 */
	$("#batchDelete").on("click", function() {
		UserManage.batchDelete();
	});
	
	/**
	 * 查询用户信息
	 */
	$("#find").on("click", function() {
		UserManage.find();
	});
	
});