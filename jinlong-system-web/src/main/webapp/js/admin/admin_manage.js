/**
 * Admin_jqgrid初始化
 */
/**
 * 1.定义人员管理模块化 2.人员管理初始化
 */
window.AdminManage = (function($, module) {

	// 加载问题单列表
	function loadAdminGrid() {
		$("#admin_jqgrid_data").jqGrid({
			url : _baseUrl + "/sysusermanage/findAllUsersDetail.action",
			datatype : "json",
			mtype : "post",
			forceFit : true,
			height : "100%",
			width : "100%",
			colNames : ['id', '姓名', '账号', 'email', '账号类型', '账号状态','审核状态', '操作'],
			colModel : [{
				name : 'id',
				index : 'id',
				width : 0,
				hidden : true,
				align : "center",
				sortable : false
			}, {
				name : 'userRealName',
				index : 'userRealName',
				width : 88,
				align : "center",
				sortable : false
			}, {
				name : 'userName',
				index : 'userName',
				width : 260,
				align : "center",
				sortable : false
			}, {
				name : 'email',
				index : 'email',
				width : 260,
				align : 'center',
				sortable : false
			}, {
				name : 'roleName',
				index : 'roleName',
				width : 120,
				align : "center",
				sortable : false,
			}, {
				name : 'userStateName',
				index : 'userStateName',
				width : 100,
				align : "center",
				sortable : false
			}, {
				name : 'reviewType',
				index : 'reviewType',
				width : 100,
				align : "center",
				sortable : false,
				formatter : function(cellvalue, options, rowObject){
	            	return cellvalue == 0 ? "未提交" :
	            		cellvalue == 1 ? "审核中" :
	            		cellvalue == 2 ? "已审核" :
	            		cellvalue == 3 ? "未通过" :  "未提交";
	            }
			}, {
				name : 'operate',
				index : 'operate',
				sortable : false,
				align : 'center',
				width : 230,
				sortable : false
			}],

			// caption: "指标文号信息",
			rowList : [15, 30, 45],
			recordpos : 'right',
			viewrecords : true,
			multiselect : true,
			pgbuttons : true,
			pginput : true,
			gridComplete : function() {
				var ids = jQuery("#admin_jqgrid_data").getDataIDs();
				$.each(ids, function(i, n) {
					var userId = $("#admin_jqgrid_data").getCell(n, "id");
					var detail = "<a class='view' href='javascript:AdminManage.showAdminDetail(" + userId + ")'>查看</a>";
					var edit = "<a class='edit' href='javascript:AdminManage.adminEdit(" + userId + ")'>编辑</a>";
					var delet = "<a class='delete' href='javascript:AdminManage.deleteAdmin(" + userId + ")'>删除</a>";

					$("#admin_jqgrid_data").jqGrid('setRowData', n, {
						operate : detail + edit + delet
					});
				});
			},
			prmNames : {
				search : "pageInfo.search",
				page : "pageInfo.page",
				rows : "pageInfo.rows",
				sidx : "pageInfo.sidx",
				sord : "pageInfo.sord",
				nd : "pageInfo.nd"
			},
			jsonReader : {
				id : "Id",
				root : "datas",
				page : "pageInfo.page",
				records : "pageInfo.record",
				total : "pageInfo.totalPage",
				sidx : "pageInfo.sidx",
				sord : "pageInfo.sord",
				userdata : "",
				repeatitems : false
			},
			pager : '#admin_jqgrid_pager'
		});
	}

	// 加载人员新增页面
	function loadAddAdminPage() {
		PageCommon.loadPageByUrl("/jsp/admin/admin_add.jsp", 2);
	}

	// 人员删除（单选）
	function deleteAdmin(userId) {
		jConfirm("确定要删除当前人员吗？", "人员删除", function(r) {
			if (r) {
				$.ajax({
					url : _baseUrl + "/sysusermanageOperate/deleteUserBasic.action",
					type : "post",
					dataType : "json",
					data : {
						"userBase.id" : userId
					}
				}).done(function(data) {
					$("#admin_jqgrid_data").jqGrid().trigger("reloadGrid");
				}).fail(function() {
					jAlertError("删除失败!", "人员删除");
				});
			}
		});
	}

	// 显示单个人员详细信息界面
	function showAdminDetail(userId) {
		PageCommon.loadPageByUrl("/sysusermanageOperate/findUserSingleDetailById.action?userBase.id=" + userId, 2);
	}

	// 编辑人员基本信息
	function adminEdit(userId) {
		PageCommon.loadPageByUrl("/sysusermanageOperate/findUserSingleEditById.action?userBase.id=" + userId, 2);
	}

	// 问题单搜索
	function searchAdmin() {
		/**
		 * 将form表单搜索的数据和分页的数据封装到一起传入后台
		 */
		var postData = $("#admin_jqgrid_data").jqGrid("getGridParam", "postData");
		$.each($("#userBase_search_form").serializeArray(), function(i, n){
			var name = n.name;
			var value = n.value;
			if(value == undefined){
				postData[name] = "";
			}else{
				postData[name] = value;
			}
		});
		
		$("#admin_jqgrid_data").jqGrid('setGridParam', {
			url : _baseUrl + "/sysusermanage/findUserDetailByCondition.action",
			datatype : 'json',
			postData : postData, // 发送数据
			page : 1
		}).trigger("reloadGrid");
	}

	// 绑定人员类型下拉选择框
	function bindroleIdSelect() {
		var url = _baseUrl + "/commonData/findUserRoleName.action";
		var errorMsg = "get roleName is error!";
		CommonAjaxHandle.bindSelectOptionData(url, "role_id", null, null, errorMsg);
	}

	// 问题单管理初始化
	function init() {
		loadAdminGrid();
		bindroleIdSelect();
	}

	module.init = init;
	module.loadAddAdminPage = loadAddAdminPage;
	module.searchAdmin = searchAdmin;
	module.deleteAdmin = deleteAdmin;
	module.showAdminDetail = showAdminDetail;
	module.adminEdit = adminEdit;

	return module;
})($, window.AdminManage || {});

/**
 * 事件绑定
 */
(function() {
	AdminManage.init();
	// 新建问题单
	$("#admin_add_btn").on("click", function() {
		AdminManage.loadAddAdminPage();
	});

	// 绑定搜索功能
	$("#admin_btn").on("click", function() {
		AdminManage.searchAdmin();
	});

})();
