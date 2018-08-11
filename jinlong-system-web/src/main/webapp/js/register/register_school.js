/**
 * 用户注册页面
 */
window.RegisterSchool = (function($, module) {
	
	var registerFormValidate;
	
	/**
	 * 用户登陆验证初始化
	 */
	function initValidate() {
		registerFormValidate = $("#register_school_form").validate({
            debug: true, //调试模式取消submit的默认提交功能   
            errorClass: "v_error validate", //默认为错误的样式类为：error   
            focusInvalid: true, //当为false时，验证无效时，没有焦点响应  
            onkeyup: true,   
            submitHandler: function(form) {   //表单提交句柄,为一回调函数，带一个参数：form   
                alert("提交表单");   
                form.submit();   //提交表单   
            },
			rules: {
				"school.parentId" : {
                    required : true
                },
				"school.schoolName" : {
                    required : true,
					rangelength : [1, 50]
                },
                "school.address" : {
                    required : true,
					rangelength : [1, 500]
                },
                "school.zone" : {
                    required : true
                },
				"school.schoolLicense" : {
					required : true, 
					digits : true,
					rangelength : [1, 50],
					min : 1
				},
				"school.organizationName" : {
                    required : true,
					rangelength : [1, 50]
				},
				"school.schoolNumber" : {
					required : true,
					rangelength : [6, 50]
				},
				"school.transportCertificate" : {
					required : true, 
					digits : true,
					rangelength : [1, 50],
					min : 1
				},
				"school.transportNumber" : {
					required : true,
					rangelength : [6, 50]
				},
				"school.certifiedLetter" : {
					required : true, 
					digits : true,
					rangelength : [1, 50],
					min : 1
				}
			},
			messages: {
				"school.parentId" : {
                    required : "总校名称必填！",
                },
				"school.schoolName" : {
                    required : "驾校名称必填！",
    				rangelength : jQuery.validator.format("驾校名称必填必须在{1}到{50}字符之间！")
                },
                "school.address" : {
                    required : "驾校地址",
					rangelength : jQuery.validator.format("驾校地址必填必须在{1}到{500}字符之间！")
                },
                "school.zone" : {
                    required : "省市区县必选"
                },
				"school.schoolLicense" : {
					required : "请上传营业执照扫描件上传！",
					digits : "请上传营业执照扫描件上传！",
					rangelength : jQuery.validator.format("请上传营业执照扫描件上传！"),
					min : "请上传营业执照扫描件上传！"
				},
				"school.organizationName" : {
                    required : "机构名称不能为空",
    				rangelength : jQuery.validator.format("机构名称必填必须在{1}到{50}字符之间！")
				},
				"school.schoolNumber" : {
					required : "请输入营业执照注册号！",
					rangelength : jQuery.validator.format("营业执照注册号必须大于等于6个字符，小于50个字符！")
				},
				"school.transportCertificate" : {
					required : "请上传道路运输经营许可证扫描件！",
					digits : "请上传营业执照扫描件上传！",
					rangelength : jQuery.validator.format("请上传道路运输经营许可证扫描件！"),
					min : "请上传营业执照扫描件上传！"
				},
				"school.transportNumber" : {
					required : "请输入道路运输经营许可证号！",
					rangelength : jQuery.validator.format("道路运输经营许可证号必须大于等于6个字符，小于50个字符！")
				},
				"school.certifiedLetter" : {
					required : "请上传认证公函扫描件！",
					digits : "请上传营业执照扫描件上传！",
					rangelength : jQuery.validator.format("请上传认证公函扫描件！"),
					min : "请上传营业执照扫描件上传！"
				}
			},
			// 更改验证提示信息的位置
			errorPlacement : function(error, element) {
				element.parent().find(".focus").empty().append(error);
			},
			// 失去焦点进行验证
			onfocusout: function(element) {
		        $(element).valid();
		    }
		});
	}
	
	/**
	 * 用户注册页面初始化方法
	 */
	function init() {
		// 初始化省、自治区、直辖市下拉文本框的信息
		CommonZone.showProvinceList($("#province"), $("#city"), $("#region"), null);
		// 用户登陆验证初始化
		initValidate();
        $(".class").change(function() {
            $(".dipe").show()
        });
        $(".cla").change(function() {
            $(".dipe").hide()
        });
	}
	
	/**
	 * 加载地区省市县的信息：通过省级地区ID，查询展示下面的城市信息集合
	 */
	function showCityList() {
		CommonZone.showCityList($("#province").val(), $("#city"), $("#region"), null);
	}
	
	/**
	 * 加载地区省市县的信息：通过城市地区ID，查询展示下面的区县信息集合
	 */
	function showRegionList() {
		CommonZone.showRegionList($("#city").val(), $("#region"), null);
	}
	
	/**
	 * 用户注册信息
	 */
	function register() {
		// 注册页面1的确定按钮的样式控制
		if ($("#register_school_form").valid()) {
			$.ajax({
				url : "userRegister/registerSchool.action",
				type : "POST",
				data : $("#register_school_form").serialize(),
				dataType : "JSON"
			}).done(function(data) {
				if (data.flag) {
					jAlert("注册成功", "驾校注册",function() {
						// 加载执照和认知上传的页面
						RegisterSchool.submitRegisterSuccess();
					});
				} else {
					jAlert(data.status, "驾校注册");
				}
			}).fail(function(response, textStatus, errorThrown) {
				jAlert("注册失败", "驾校注册");
			});
		} else {
			registerFormValidate.form();
		}
	}
	
	/**
	 * 提交注册信息
	 */
	function submitRegisterSuccess() {
   		$(".part3").hide();
        $(".part4").show();
        $(".step li").eq(2).addClass("on");
	}
	
	/**
	 * 注册接口
	 */
	module.init = init;
	module.showCityList = showCityList;
	module.showRegionList = showRegionList;
	module.register = register;
	module.submitRegisterSuccess = submitRegisterSuccess;
	
	return module;
	
})($, window.RegisterSchool || {});

/**
 * 事件调用
 */
$(function() {
	
	/**
	 * 页面初始化
	 */
	RegisterSchool.init();
	
	/**
	 * 省、自治区、直辖市与下面的城市下拉文本框联动
	 */
	$("#province").on("change", function() {
		RegisterSchool.showCityList();
	});
	
	/**
	 * 城市与下面的区县下拉文本框联动
	 */
	$("#city").on("change", function() {
		RegisterSchool.showRegionList();
	});
	
	// 第二页的确定按钮
    $("#btn_part3").click(function() {
    	RegisterSchool.register();
   	});
    
	/* 显示遮罩层 */
	function showOverlay() {
	    $("#overlay").height(pageHeight());
	    $("#overlay").width(pageWidth());
	    // fadeTo第一个参数为速度，第二个为透明度
	    // 多重方式控制透明度，保证兼容性，但也带来修改麻烦的问题
	    $("#overlay").fadeTo(200, 0.5);
	}

	/* 隐藏覆盖层 */
	function hideOverlay() {
	    $("#overlay").fadeOut(200);
	}

	/* 当前页面高度 */
	function pageHeight() {
	    return document.body.scrollHeight;
	}

	/* 当前页面宽度 */
	function pageWidth() {
	    return document.body.scrollWidth;
	}
	
	// 添加上传时的参数
//	var schoolId = $("#schoolId").val();
	//-----webupload第一个上传文件开始-------
    $list = $('#thelist'),
    $btn = $('#ctlBtn'),
    state = 'pending',
    uploader;
	// 初始化uploader对象
	uploader = WebUploader.create({
		auto: true,
        // 文件接收服务端。
        server: "fileInfo/uploadFileInfo.action",
	    // 选择文件的按钮。可选。
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: {
	    	id: '#picker',
	    	multiple :false
	    },
	    fileSingleSizeLimit:5242880, //设定文件大小限制5m
	    fileNumLimit:1,//设置文件上传的最大个数
	    accept:{
	    	 extensions: 'jpg,bmp,gif,png',
	    }
	});
	
//	uploader.option('formData', {"fileInfo.fileFlag" : "3"});
	
	uploader.option('formData', {"fileInfo.schoolId" : 1, "fileInfo.fileFlag" : "3"});
	
	// 当有文件添加进来的时候
	uploader.on('fileQueued', function(file) {
	    $list.append( '<div id="' + file.id + '" class="item">' +
	        '<h4 class="info">' + file.name + '</h4>' +
	        '<p class="state">等待上传...</p></div>');
	    $(".validMsg").html("");
	});
	
	// 文件上传前开始触发
	uploader.on("startUpload",function(file){
		//显示遮罩层
		showOverlay();
	});
	
	// 文件上传过程中创建进度条实时显示。
	uploader.on('uploadProgress', function(file, percentage) {
		progressNum = uploader.getStats().progressNum;
	    var $li = $( '#'+file.id ),
	        $percent = $li.find('.progress .progress-bar');
	    // 避免重复创建
	    if (!$percent.length) {
	        $percent = $('<div class="progress progress-striped active">' +
	          '<div class="progress-bar" role="progressbar" style="width: 0%">' +
	          '</div>' +
	        '</div>').appendTo( $li ).find('.progress-bar');
	    }
	    $li.find('p.state').text('上传中');
	    $percent.css( 'width', percentage * 100 + '%' );
	});
	
	// 文件上传成功后触发
	uploader.on( 'uploadSuccess', function( file,response) {
	    $("#" + file.id ).find('p.state').text('已上传');
	    console.log(JSON.stringify(response));
	    console.log("response-type:"+typeof(response)+",JSON:"+JSON.stringify(response));
	    if (response == "null" || response == "" || 
	    		response == null || response == '"null"'){
	    	jAlertError("网络异常，稍后重试!","提示");
	    	hideOverlay();
	    } else if (JSON.stringify(response).indexOf(",") > 0) {
	    	console.log(response);
	    	var pos = response.indexOf(",");
			var fileName = response.substring(1, pos);
			var fileId = response.substring(pos + 1, response.length);
			// 上传后的图片ID
			$("#schoolLicense").val(fileId);
			$('#'+file.id ).find('p.state').append("<a href='javascript:void(0);' data='"+fileId+"' class='delete'></a><br/>");
		    $("#"+file.id).find("h4").css({"float":"left","margin":"0","padding-right":"20px"});
		    if(file.name.length>20){
		    	 $("#"+file.id).find("h4").text(file.name.substr(0,20)+"...");
		    }
		    //激活确定保存按钮
		    CommonHandleButton.activeButton("save_real_name");
		    CommonHandleButton.deactiveButton("realname_file_confirm_upload");
	    }else{
	    	jAlertError("网络异常，请刷新界面重新上传!","提示");
	    	hideOverlay();
	    }
	});
	
	// 所有文件上传结束时触发
	uploader.on("uploadFinished",function(){
		hideOverlay();
	});
	
	// 上传出错时触发
	uploader.on( 'uploadError', function( file ) {
	    $('#'+file.id ).find('p.state').text('上传出错');
	    $('#'+file.id ).find('p.state').append("<a href='javascript:void(0);' data='"+file.id+"' class='errdelete'></a><br/>");
	});
	
	// 不管成功或者失败，文件上传完成时触发
	uploader.on( 'uploadComplete', function( file ) {
		// 隐藏上传按钮
//		$("#picker").css("display", "none");
	    $( '#'+file.id ).find('.progress').fadeOut();
	    // 个人头像上传之后修改头像、实名认证上传之后修改头像
		$.ajax({
			url : "fileInfo/show.action",
			type : "post",
			dataType : "json",
			data : {"fileInfo.fileId":  $("#schoolLicense").val()},
			async : true
		}).done(function(data) {
			if (data.filePath != null) {
				var pictureFilePath = data.filePath;
				//转码
				pictureFilePath = encodeURI(encodeURI(pictureFilePath));
				$("#schoolLicenseImage").attr("src", "jsp/main/picture.jsp?pictureFilePath=" + pictureFilePath);
				$("#schoolLicenseImage").css("display", "block");
			}
		}).fail(function(data) {
			CommonUtils.logError("init testerUser picture failed!");
		});
	});
	
	// 验证不通过时触发
	uploader.on('error',function(type){
		if(type == 'F_EXCEED_SIZE'){
			$(".validMsg").html("<span>文件大小不能超过限制5M!</span>");
		}
		if(type == 'Q_TYPE_DENIED'){
			$(".validMsg").html("<span>请上传允许的图片类型:jpg,bmp,gif,png</span>");
		}
	});
	
	// 删除
	$list.find(".delete").live('click',function(){
		var $ele = $(this);
		var fileId = $ele.attr("data");
		var fId = $ele.parent().parent().attr("id");
		jConfirm("确定要删除当前文件吗？", "提示", function(r) {
			if(!r){return;}
			uploader.removeFile(uploader.getFile(fId),true); //从queue中移除
			$.ajax({
				url : "deskTop/deleteUserPictureFile.action",
				type : "post",
				dataType : "json",
				data : {"fileInfo.fileId" : fileId}
			}).done(function(data){
				$ele.parent().parent().remove();
				$("#hidden_init_file_name").val("");
			    $("#hidden_file_name").val("");
			    $("#hidden_file_id").val(0);
			    $("#show").empty();
			    $("#show_file_upload").show();
				$("#hidden_picture_file_id").val(0);
				$("#img").val(0);
				$("#realname_show").empty();
				$("#realname_file_upload").show();
				// 显示上传按钮
				$("#picker").css("display", "block");
				$("#image").attr("src", "css/images/touxiang.png");
			}).fail(function(){
				CommonUtils.logError("delete file failed!");
			});
		});
	});
	
	// 已取消 或 上传出错后 增加删除事件
	$list.find(".errdelete").live('click',function(){
		var $ele = $(this);
		jConfirm("确定要删除当前文件吗？", "提示", function(r){
			if(!r){return;}
			var fileId = $ele.attr("data");
			//上传出错 或 取消了的文件删除 只在页面上做移除 
			$ele.parent().parent().remove();
		});
	});
	
	//取消上传附件
	$("#cancleFileUpload").click(function(){
		jConfirm("确定要取消正在上传的文件吗？", "提示", function(r){
			if(!r){return;}
			var fileArray = uploader.getFiles();
		    for(var i = 0; i < fileArray.length; i++){
		    	var file = fileArray[i];
		    	if('complete' == file.getStatus()){
		    		continue;
		    	}
		    	uploader.cancelFile(file);
		    	//页面中移除已取消的文件
		    	if('complete' != file.getStatus()){
		    		$("#"+file.id).remove();
		    	}
		    	hideOverlay();
		    }
		});
	});
	
	//相应所有事件
	uploader.on( 'all', function( type ) {
	    if ( type === 'startUpload' ) {
	        state = 'uploading';
	    } else if ( type === 'stopUpload' ) {
	        state = 'paused';
	    } else if ( type === 'uploadFinished' ) {
	        state = 'done';
	    }
	
	    if ( state === 'uploading' ) {
	        $btn.text('暂停上传');
	    } else {
	        $btn.text('开始上传');
	    }
	});
	
	// 切换到手动上传
	$btn.on( 'click', function() {
	    if ( state != 'uploading' ) {
	        uploader.stop();
	    } else {
	        uploader.upload();
	    }
	});
	
	//-----webupload第二个上传文件开始-------
    $list2 = $('#thelist2'),
    $btn2 = $('#ctlBtn'),
    state2 = 'pending',
	uploader2;
	// 初始化uploader对象
	uploader2 = WebUploader.create({
		auto: true,
        // 文件接收服务端。
        server: "fileInfo/uploadFileInfo.action",
	    // 选择文件的按钮。可选。
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: {
	    	id: '#picker2',
	    	multiple :false
	    },
	    fileSingleSizeLimit:5242880, //设定文件大小限制5m
	    fileNumLimit:1,//设置文件上传的最大个数
	    accept:{
	    	 extensions: 'jpg,bmp,gif,png',
	    }
	});
	
//	uploader2.option('formData', {"fileInfo.fileFlag" : "3"});
	
	uploader2.option('formData', {"fileInfo.schoolId" : 1, "fileInfo.fileFlag" : "3"});
	
	// 当有文件添加进来的时候
	uploader2.on('fileQueued', function(file) {
		$list2.append( '<div id="' + file.id + '" class="item">' +
	        '<h4 class="info">' + file.name + '</h4>' +
	        '<p class="state">等待上传...</p></div>');
	    $(".validMsg").html("");
	});
	
	// 文件上传前开始触发
	uploader2.on("startUpload",function(file){
		//显示遮罩层
		showOverlay();
	});
	
	// 文件上传过程中创建进度条实时显示。
	uploader2.on('uploadProgress', function(file, percentage) {
		progressNum = uploader2.getStats().progressNum;
	    var $li = $( '#'+file.id ),
	        $percent = $li.find('.progress .progress-bar');
	    // 避免重复创建
	    if (!$percent.length) {
	        $percent = $('<div class="progress progress-striped active">' +
	          '<div class="progress-bar" role="progressbar" style="width: 0%">' +
	          '</div>' +
	        '</div>').appendTo( $li ).find('.progress-bar');
	    }
	    $li.find('p.state').text('上传中');
	    $percent.css( 'width', percentage * 100 + '%' );
	});
	
	// 文件上传成功后触发
	uploader2.on( 'uploadSuccess', function( file,response) {
	    $("#" + file.id ).find('p.state').text('已上传');
	    console.log(JSON.stringify(response));
	    console.log("response-type:"+typeof(response)+",JSON:"+JSON.stringify(response));
	    if (response == "null" || response == "" || 
	    		response == null || response == '"null"'){
	    	jAlertError("网络异常，稍后重试!","提示");
	    	hideOverlay();
	    } else if (JSON.stringify(response).indexOf(",") > 0) {
	    	console.log(response);
	    	var pos = response.indexOf(",");
			var fileName = response.substring(1, pos);
			var fileId = response.substring(pos + 1, response.length);
			// 上传后的图片ID
			$("#transportCertificate").val(fileId);
			$('#'+file.id ).find('p.state').append("<a href='javascript:void(0);' data='"+fileId+"' class='delete'></a><br/>");
		    $("#"+file.id).find("h4").css({"float":"left","margin":"0","padding-right":"20px"});
		    if(file.name.length>20){
		    	 $("#"+file.id).find("h4").text(file.name.substr(0,20)+"...");
		    }
		    //激活确定保存按钮
		    CommonHandleButton.activeButton("save_real_name");
		    CommonHandleButton.deactiveButton("realname_file_confirm_upload");
	    }else{
	    	jAlertError("网络异常，请刷新界面重新上传!","提示");
	    	hideOverlay();
	    }
	});
	
	// 所有文件上传结束时触发
	uploader2.on("uploadFinished",function(){
		hideOverlay();
	});
	
	// 上传出错时触发
	uploader2.on( 'uploadError', function( file ) {
	    $('#'+file.id ).find('p.state').text('上传出错');
	    $('#'+file.id ).find('p.state').append("<a href='javascript:void(0);' data='"+file.id+"' class='errdelete'></a><br/>");
	});
	
	// 不管成功或者失败，文件上传完成时触发
	uploader2.on( 'uploadComplete', function( file ) {
		// 隐藏上传按钮
//		$("#picker").css("display", "none");
	    $( '#'+file.id ).find('.progress').fadeOut();
	    // 个人头像上传之后修改头像、实名认证上传之后修改头像
		$.ajax({
			url : "fileInfo/show.action",
			type : "post",
			dataType : "json",
			data : {"fileInfo.fileId":  $("#transportCertificate").val()},
			async : true
		}).done(function(data) {
			if (data.filePath != null) {
				var pictureFilePath = data.filePath;
				//转码
				pictureFilePath = encodeURI(encodeURI(pictureFilePath));
				$("#transportCertificateImage").attr("src", "jsp/main/picture.jsp?pictureFilePath=" + pictureFilePath);
				$("#transportCertificateImage").css("display", "block");
			}
		}).fail(function(data) {
			CommonUtils.logError("init testerUser picture failed!");
		});
	});
	
	// 验证不通过时触发
	uploader2.on('error',function(type){
		if(type == 'F_EXCEED_SIZE'){
			$(".validMsg").html("<span>文件大小不能超过限制5M!</span>");
		}
		if(type == 'Q_TYPE_DENIED'){
			$(".validMsg").html("<span>请上传允许的图片类型:jpg,bmp,gif,png</span>");
		}
	});
	
	// 删除
	$list2.find(".delete").live('click',function(){
		var $ele = $(this);
		var fileId = $ele.attr("data");
		var fId = $ele.parent().parent().attr("id");
		jConfirm("确定要删除当前文件吗？", "提示", function(r) {
			if(!r){return;}
			uploader2.removeFile(uploader2.getFile(fId),true); //从queue中移除
			$.ajax({
				url : "deskTop/deleteUserPictureFile.action",
				type : "post",
				dataType : "json",
				data : {"fileInfo.fileId" : fileId}
			}).done(function(data){
				$ele.parent().parent().remove();
				$("#hidden_init_file_name").val("");
			    $("#hidden_file_name").val("");
			    $("#hidden_file_id").val(0);
			    $("#show").empty();
			    $("#show_file_upload").show();
				$("#hidden_picture_file_id").val(0);
				$("#img").val(0);
				$("#realname_show").empty();
				$("#realname_file_upload").show();
				// 显示上传按钮
				$("#picker").css("display", "block");
				$("#image").attr("src", "css/images/touxiang.png");
			}).fail(function(){
				CommonUtils.logError("delete file failed!");
			});
		});
	});
	
	// 已取消 或 上传出错后 增加删除事件
	$list2.find(".errdelete").live('click',function(){
		var $ele = $(this);
		jConfirm("确定要删除当前文件吗？", "提示", function(r){
			if(!r){return;}
			var fileId = $ele.attr("data");
			//上传出错 或 取消了的文件删除 只在页面上做移除 
			$ele.parent().parent().remove();
		});
	});
	
	//取消上传附件
	$("#cancleFileUpload").click(function(){
		jConfirm("确定要取消正在上传的文件吗？", "提示", function(r){
			if(!r){return;}
			var fileArray = uploader2.getFiles();
		    for(var i = 0; i < fileArray.length; i++){
		    	var file = fileArray[i];
		    	if('complete' == file.getStatus()){
		    		continue;
		    	}
		    	uploader2.cancelFile(file);
		    	//页面中移除已取消的文件
		    	if('complete' != file.getStatus()){
		    		$("#"+file.id).remove();
		    	}
		    	hideOverlay();
		    }
		});
	});
	
	//相应所有事件
	uploader2.on( 'all', function( type ) {
	    if ( type === 'startUpload' ) {
	        state = 'uploading';
	    } else if ( type === 'stopUpload' ) {
	        state = 'paused';
	    } else if ( type === 'uploadFinished' ) {
	        state = 'done';
	    }
	
	    if ( state === 'uploading' ) {
	        $btn2.text('暂停上传');
	    } else {
	        $btn2.text('开始上传');
	    }
	});
	
	// 切换到手动上传
	$btn2.on( 'click', function() {
	    if ( state != 'uploading' ) {
	        uploader2.stop();
	    } else {
	        uploader2.upload();
	    }
	});
	
	//-----webupload第3个上传文件开始-------
    $list3 = $('#thelist3'),
    $btn3 = $('#ctlBtn'),
    state3 = 'pending',
	uploader3;
	// 初始化uploader对象
	uploader3 = WebUploader.create({
		auto: true,
        // 文件接收服务端。
        server: "fileInfo/uploadFileInfo.action",
	    // 选择文件的按钮。可选。
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: {
	    	id: '#picker3',
	    	multiple :false
	    },
	    fileSingleSizeLimit:5242880, //设定文件大小限制5m
	    fileNumLimit:1,//设置文件上传的最大个数
	    accept:{
	    	 extensions: 'jpg,bmp,gif,png',
	    }
	});
	
//	uploader3.option('formData', {"fileInfo.fileFlag" : "3"});
	
	uploader3.option('formData', {"fileInfo.schoolId" : 1, "fileInfo.fileFlag" : "3"});
	
	// 当有文件添加进来的时候
	uploader3.on('fileQueued', function(file) {
		$list3.append( '<div id="' + file.id + '" class="item">' +
	        '<h4 class="info">' + file.name + '</h4>' +
	        '<p class="state">等待上传...</p></div>');
	    $(".validMsg").html("");
	});
	
	// 文件上传前开始触发
	uploader3.on("startUpload",function(file){
		//显示遮罩层
		showOverlay();
	});
	
	// 文件上传过程中创建进度条实时显示。
	uploader3.on('uploadProgress', function(file, percentage) {
		progressNum = uploader3.getStats().progressNum;
	    var $li = $( '#'+file.id ),
	        $percent = $li.find('.progress .progress-bar');
	    // 避免重复创建
	    if (!$percent.length) {
	        $percent = $('<div class="progress progress-striped active">' +
	          '<div class="progress-bar" role="progressbar" style="width: 0%">' +
	          '</div>' +
	        '</div>').appendTo( $li ).find('.progress-bar');
	    }
	    $li.find('p.state').text('上传中');
	    $percent.css( 'width', percentage * 100 + '%' );
	});
	
	// 文件上传成功后触发
	uploader3.on( 'uploadSuccess', function( file,response) {
	    $("#" + file.id ).find('p.state').text('已上传');
	    console.log(JSON.stringify(response));
	    console.log("response-type:"+typeof(response)+",JSON:"+JSON.stringify(response));
	    if (response == "null" || response == "" || 
	    		response == null || response == '"null"'){
	    	jAlertError("网络异常，稍后重试!","提示");
	    	hideOverlay();
	    } else if (JSON.stringify(response).indexOf(",") > 0) {
	    	console.log(response);
	    	var pos = response.indexOf(",");
			var fileName = response.substring(1, pos);
			var fileId = response.substring(pos + 1, response.length);
			// 上传后的图片ID
			$("#certifiedLetter").val(fileId);
			$('#'+file.id ).find('p.state').append("<a href='javascript:void(0);' data='"+fileId+"' class='delete'></a><br/>");
		    $("#"+file.id).find("h4").css({"float":"left","margin":"0","padding-right":"20px"});
		    if(file.name.length>20){
		    	 $("#"+file.id).find("h4").text(file.name.substr(0,20)+"...");
		    }
		    //激活确定保存按钮
		    CommonHandleButton.activeButton("save_real_name");
		    CommonHandleButton.deactiveButton("realname_file_confirm_upload");
	    }else{
	    	jAlertError("网络异常，请刷新界面重新上传!","提示");
	    	hideOverlay();
	    }
	});
	
	// 所有文件上传结束时触发
	uploader3.on("uploadFinished",function(){
		hideOverlay();
	});
	
	// 上传出错时触发
	uploader3.on( 'uploadError', function( file ) {
	    $('#'+file.id ).find('p.state').text('上传出错');
	    $('#'+file.id ).find('p.state').append("<a href='javascript:void(0);' data='"+file.id+"' class='errdelete'></a><br/>");
	});
	
	// 不管成功或者失败，文件上传完成时触发
	uploader3.on( 'uploadComplete', function( file ) {
		// 隐藏上传按钮
//		$("#picker").css("display", "none");
	    $( '#'+file.id ).find('.progress').fadeOut();
	    // 个人头像上传之后修改头像、实名认证上传之后修改头像
		$.ajax({
			url : "fileInfo/show.action",
			type : "post",
			dataType : "json",
			data : {"fileInfo.fileId":  $("#certifiedLetter").val()},
			async : true
		}).done(function(data) {
			if (data.filePath != null) {
				var pictureFilePath = data.filePath;
				//转码
				pictureFilePath = encodeURI(encodeURI(pictureFilePath));
				$("#certifiedLetterImage").attr("src", "jsp/main/picture.jsp?pictureFilePath=" + pictureFilePath);
				$("#certifiedLetterImage").css("display", "block");
			}
		}).fail(function(data) {
			CommonUtils.logError("init testerUser picture failed!");
		});
	});
	
	// 验证不通过时触发
	uploader3.on('error',function(type){
		if(type == 'F_EXCEED_SIZE'){
			$(".validMsg").html("<span>文件大小不能超过限制5M!</span>");
		}
		if(type == 'Q_TYPE_DENIED'){
			$(".validMsg").html("<span>请上传允许的图片类型:jpg,bmp,gif,png</span>");
		}
	});
	
	// 删除
	$list3.find(".delete").live('click',function(){
		var $ele = $(this);
		var fileId = $ele.attr("data");
		var fId = $ele.parent().parent().attr("id");
		jConfirm("确定要删除当前文件吗？", "提示", function(r) {
			if(!r){return;}
			uploader3.removeFile(uploader3.getFile(fId),true); //从queue中移除
			$.ajax({
				url : "deskTop/deleteUserPictureFile.action",
				type : "post",
				dataType : "json",
				data : {"fileInfo.fileId" : fileId}
			}).done(function(data){
				$ele.parent().parent().remove();
				$("#hidden_init_file_name").val("");
			    $("#hidden_file_name").val("");
			    $("#hidden_file_id").val(0);
			    $("#show").empty();
			    $("#show_file_upload").show();
				$("#hidden_picture_file_id").val(0);
				$("#img").val(0);
				$("#realname_show").empty();
				$("#realname_file_upload").show();
				// 显示上传按钮
				$("#picker").css("display", "block");
				$("#image").attr("src", "css/images/touxiang.png");
			}).fail(function(){
				CommonUtils.logError("delete file failed!");
			});
		});
	});
	
	// 已取消 或 上传出错后 增加删除事件
	$list3.find(".errdelete").live('click',function(){
		var $ele = $(this);
		jConfirm("确定要删除当前文件吗？", "提示", function(r){
			if(!r){return;}
			var fileId = $ele.attr("data");
			//上传出错 或 取消了的文件删除 只在页面上做移除 
			$ele.parent().parent().remove();
		});
	});
	
	//取消上传附件
	$("#cancleFileUpload").click(function(){
		jConfirm("确定要取消正在上传的文件吗？", "提示", function(r){
			if(!r){return;}
			var fileArray = uploader3.getFiles();
		    for(var i = 0; i < fileArray.length; i++){
		    	var file = fileArray[i];
		    	if('complete' == file.getStatus()){
		    		continue;
		    	}
		    	uploader3.cancelFile(file);
		    	//页面中移除已取消的文件
		    	if('complete' != file.getStatus()){
		    		$("#"+file.id).remove();
		    	}
		    	hideOverlay();
		    }
		});
	});
	
	//相应所有事件
	uploader3.on( 'all', function( type ) {
	    if ( type === 'startUpload' ) {
	        state = 'uploading';
	    } else if ( type === 'stopUpload' ) {
	        state = 'paused';
	    } else if ( type === 'uploadFinished' ) {
	        state = 'done';
	    }
	
	    if ( state === 'uploading' ) {
	        $btn3.text('暂停上传');
	    } else {
	        $btn3.text('开始上传');
	    }
	});
	
	// 切换到手动上传
	$btn3.on( 'click', function() {
	    if ( state != 'uploading' ) {
	        uploader3.stop();
	    } else {
	        uploader3.upload();
	    }
	});
	
})