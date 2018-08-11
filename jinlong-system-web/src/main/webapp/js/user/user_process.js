/**
 * 用户流程信息管理
 */
window.UserProcess = (function($, module) {

	/**
	 * 绑定用户状态下拉框
	 */
	function showUserState() {
		url = "common/showProccessState";
		errorMsg = "查询用户状态信息错误！";
		CommonDirectory.showSelectOptionData(url, "state", null, null, errorMsg);
	}
	 
	/**
	 * 用户流程信息分页列表初始化
	 */
	function showGrid() {
		$("#user_process").jqGrid({
			url : "userProcess/manage",
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
                return JSON.stringify({"userProcessVO" : $("#user_process_form").serializeJSON(), "pageInfo" : postData});  
            },  
			colNames : ["ID", "用户名称", "流程节点时间", "审核人名称", "是否通过审核", "用户流程状态"],
			colModel : 
			[ {
				name : "processId",
				index : "processId",
				width : 0,
				align : "center",
				hidden : true
			}, {
				name : "userName",
				index : "userName",
				width : 200,
				align : "center",
			}, {
			    name : "processTime",
			    index : "processTime",
			    width : 200,
			    align : "center"
			}, {
			    name : "examineUserName",
			    index : "examineUserName",
			    width : 200,
			    align : "center"
			}, {
				name : "passName",
			    index : "passName",
			    width : 100,
			    align : "center"
			}, {
				name : "stateName",
				index : "stateName",
				width : 270,
				align : "center"
			} ],
			rowNum : 10,
			rowList : [10, 20, 30],
			pager : '#user_process_pager',
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
		// 绑定用户状态下拉框
		showUserState();
		// 用户信息列表初始化
		showGrid();
	}
	
	/**
	 * 查询用户流程信息
	 */
	function find() {
		/**
		 * 将form表单搜索的数据和分页的数据封装到一起传入后台
		 */
		var postData = $("#user_process").jqGrid("getGridParam", "postData");
		$("#user_process").jqGrid('setGridParam', {
			datatype : 'json',
			postData : postData, // 发送数据
			page : 1
		}).trigger("reloadGrid");
	}
	
	/**
	 * 接口注册
	 */
	module.init = init;
	module.find = find;
	
	/**
	 * 返回结果集
	 */
	return module;
	
})($, window.UserProcess || {});


/**
 * 页面调用
 */
$(function() {
	
	/**
	 * 用户流程信息分页列表初始化
	 */
	UserProcess.init();
	
	/**
	 * 查询用户流程信息
	 */
	$("#find").on("click", function() {
		UserProcess.find();
	});
	
});