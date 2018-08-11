/**
 * 定义公共的用来处理按钮的启用和禁用状态
 */
window.CommonHandleButton = (function($, module) {
		
	/**
	 * 定义按钮CSS
	 */
	var activeClass;
	var disactiveClass;
	
	/**
	 * 按钮状态改变
	 */
	function judgeBtnId(elementId){
		if("confirm_upload" == elementId){
			activeClass = "upfile";
			disactiveClass = "upfile1";
		}else if("batch_review" == elementId || "batch_cust_review" == elementId){
			activeClass = "nav-img9";
			disactiveClass = "nav-img8";
		}else if(
					"batch_delete" == elementId 
					|| 
					"member_remove" == elementId 
					|| 
					"import_testcase" == elementId 
					|| 
					"export_validate" == elementId
				){
			activeClass = "nav-img7";
			disactiveClass = "nav-img4";
		}else if("remove_task" == elementId || "member_prepare" == elementId){
			activeClass = "";
			disactiveClass = "nav-img6";
		}
	}
	
	/**
	 * 启用按钮
	 */
	function activeButton(elementId) {
		judgeBtnId(elementId);
		$("#" + elementId + "").addClass(activeClass);
		$("#" + elementId + "").removeClass(disactiveClass);
		$("#" + elementId + "").css("cursor", "pointer");
		$("#" + elementId + "").attr("disabled", false);
	}

	/**
	 * 禁用按钮
	 */
	function deactiveButton(elementId) {
		judgeBtnId(elementId);
		$("#" + elementId + "").css("cursor", "text");
		$("#" + elementId + "").removeClass(activeClass);
		$("#" + elementId + "").addClass(disactiveClass);
		$("#" + elementId + "").attr("disabled", true);
	}
	
	/**
	 * 接口定义
	 */
	module.judgeBtnId = judgeBtnId;
	module.activeButton = activeButton;
	module.deactiveButton = deactiveButton;
	
	/**
	 * 返回接口
	 */
	return module;
	
})($, window.CommonHandleButton || {});