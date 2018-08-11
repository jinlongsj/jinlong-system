/**
 * 1.定义项目管理模块化 2.项目管理初始化
 */
window.PjtPftList = (function($, module) {
	
	
	//保存审核意见
	function bindSaveReviw(objThis) {
		if($("#bind_review_form").valid()){
			$.ajax({
				url : _baseUrl + "/testerUserBasicManage/addCommonReview.action",
				type : "post",
				dataType : "json",
				data : $("#bind_review_form").serialize()
			}).done(function(data){
				jAlert("审核完成!","审核");
				$("#signup-modal").modal("hide");
				PageCommon.swichToC1();
			}).fail(function(){
				jAlertError("审核失败!","审核");
			});
			//处理保存按钮,防止按钮被多次点击
			CommonHandlePreventMoreClickButton.handlePreventMoreClick(objThis, "saveReviewbtn");
		}else{
			bindReviewFormValidate.form();
		}
	}
	
	//验证审核form表单
	function validateInit(){
		//自定义邀请码验证变量
		var isChecked = ValidatorUtil.getMethodInfo('isChecked');
		$.validator.addMethod(isChecked.code, isChecked.method, isChecked.msg);
		
		bindReviewFormValidate = $("#bind_review_form").validate({
			rules: {
				"commonReviewModel.reviewResult":{
					isChecked: true
				},
				"commonReviewModel.content": {
					required: true,
					maxlength: 200
				}
			},
			messages: {
				"commonReviewModel.reviewResult":{
					isChecked: "请选择审核结果"
				},
				"commonReviewModel.content":{
					required: "审核意见不能为空",
					maxlength: "审核意见长度最多为200个字符"
				}
			},
			errorPlacement: function(error, $elementObj){
				$elementObj.parent().find(".font03").empty().append(error);
			}
		});
	}
	
	/**
	 * 查询实名认证审核信息
	 */
	function findCommonReviewDetail(event){
		event.preventDefault();
		$.ajax({
			type: "post",
			url : _baseUrl + "/commonreviewData/findCommonReviewDetail.action",
			dataType : "json",
			data : {
				"commonReviewModel.modelType":$("#hidden_model_type").val(), 
				"commonReviewModel.modelId":$("#hidden_bind_id").val()
			}
		}).done(function(data){
			if(null != data){
				PageCommon.modelForReviewDetail(data.datas);
			}
		}).fail(function(){
			jAlertError("查找审核信息失败!","提示");
		});
	}
	
	//查询实名认证是否已经审核
	function findRealNameIsReview(){
		var userId = $("#hidden_bind_id").val();
		$.ajax({
			url : _baseUrl + "/testerUserBasicManage/findRealNameIsReview.action",
			type : "post",
			dataType : "json",
			data : {"userBaseVO.userId" : userId}
		}).done(function(data){
			var flag = data.flag;
			if(flag == 2){
				$("#real_name_review").html('<td align="center" colspan="2">实名认证审核：<span class="nav-title-right"><a data-toggle="modal" href="#signup-modal">已认证</a></span></td>')
				$("#bind_review_form").addClass("disable");
				$("#saveReviewbtn").addClass("disable");
				$("#loadUserExtension").val("返    回");
				$("#loadUserExtension").css({
					"background-color":"#0aa0b8",
					"color":"#fff",
					"margin-right":"60px"
				});
			}else if(flag == 1){
				$("#real_name_review").html('<td align="center" colspan="2">实名认证审核：<span class="nav-title-right"><a data-toggle="modal" href="#signup-modal">审核</a></span></td>');
				$("#bind_review_form").removeClass("disable");
				$("#saveReviewbtn").removeClass("disable");
				$("#loadUserExtension").val("取    消");
				$("#loadUserExtension").css({
					"background-color":"#ddd",
					"color":"#333",
					"margin-right":"0px"
				});
			}
		});
	}
	
	/**
	 * 初始化测试用户头像
	 */
	function initTesterUserPicture() {
		$.ajax({
			url : _baseUrl + "/testerUserBasicManage/findTesterUserPicture.action",
			type : "post",
			dataType : "json",
			data : {"userBaseVO.userId" : $("#hidden_bind_id").val()}
		}).done(function(data) {
			if (data.filePath != null) {
				$("#head_img1").attr("src", _baseUrl+"/jsp/admin/picture.jsp?pictureFilePath=" +data.filePath);
			}
			if (data.description != null){
				$("#name_realname").html(data.description);
			}
			if (data.initName != null){
				$("#number_realname").html(data.initName);
			}
		}).fail(function(data) {
			CommonUtils.logError("init testerUser picture failed!");
		});
	}
	
	function loadUserExtension(){
		$("#signup-modal").modal("hide");
	}
	

	/**
	 * 模块初始化方法
	 */
	function init() {
		validateInit();
		findRealNameIsReview();
		initTesterUserPicture();
		// 加载项目信息列表
//		loadPjtPftGrid();
	}

	module.init = init;
	module.bindSaveReviw = bindSaveReviw;
	module.findCommonReviewDetail = findCommonReviewDetail;
	module.loadUserExtension = loadUserExtension;

	return module;

})($, window.PjtPftList || {});

/**
 * 页面初始化
 */
(function() {
	// 模块初始化
	PjtPftList.init();
	$("#signup-modal").modal("hide");
	
	//返回按钮
	$("#detail_admin_return").on("click", function() {
		PageCommon.swichToC1();
    });
	
	//关闭审核框
	$("#loadUserExtension").on("click", function() {
		PjtPftList.loadUserExtension();
	});
	
	//保存审核信息
	$("#saveReviewbtn").on("click", function(){
		PjtPftList.bindSaveReviw(this);
	});
	
	
	//查看审核信息
	$("#find_review_data_btn").on("click", function(event) {
		PjtPftList.findCommonReviewDetail(event);
	});
	
})();