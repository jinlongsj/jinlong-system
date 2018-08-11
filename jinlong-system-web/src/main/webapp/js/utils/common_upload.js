/**
 * 用户信息完善POP弹出层
 */
window.CommonUpload = (function($, module) {
	
	function init() {
		//同步主菜单按钮样式
		PageCommon.synchronousMainMenuStyle("personal_center");
		
		//弹出框事件初始化
		initPopBox();
	}
	
	function loadUserExtension(){
		$("#signup-modal").modal("show");
	}
	
	function loadPicture(){
	    $list = $('#thelist'),
	    $btn = $('#ctlBtn'),
	    state = 'pending',
	    uploader;
	    //添加上传时的参数
		//var projectId = $("#project_id").val();
		//初始化uploader对象
		var uploader = WebUploader.create({
			auto:true,
	        // 文件接收服务端。
			server: _baseUrl + '/fileInfo/uploadFileInfo.action',
		    // 选择文件的按钮。可选。
		    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
			pick: {
		    	id:'#picker',
		    	multiple :false
		    },
		    fileSingleSizeLimit:5242880, //设定文件大小限制5m
		    fileNumLimit:1,
		    accept:{
		       extensions: 'jpg,bmp,gif,png',
		    }
		});
		uploader.option('formData',{"fileInfo.projectId":"","fileInfo.fileFlag":"3"});
		
		// 当有文件添加进来的时候
		uploader.on( 'fileQueued', function( file ) {
		    $list.append( '<div id="' + file.id + '" class="item">' +
		        '<h4 class="info">' + file.name + '</h4>' +
		        '<p class="state">等待上传...</p></div>');
		    $(".validMsg").html("");
		});
		//文件上传前开始触发
		uploader.on("startUpload",function(){
			//显示遮罩层
			CommonUpload.showOverlay();		
		});
		// 文件上传过程中创建进度条实时显示。
		uploader.on( 'uploadProgress', function( file, percentage ) {
			progressNum = uploader.getStats().progressNum;
		    var $li = $( '#'+file.id ),
		        $percent = $li.find('.progress .progress-bar');
		    // 避免重复创建
		    if ( !$percent.length ) {
		        $percent = $('<div class="progress progress-striped active">' +
		          '<div class="progress-bar" role="progressbar" style="width: 0%">' +
		          '</div>' +
		        '</div>').appendTo( $li ).find('.progress-bar');
		    }
		    $li.find('p.state').text('上传中');
		    $percent.css( 'width', percentage * 100 + '%' );
		});
		
		//文件上传成功后触发
		uploader.on( 'uploadSuccess', function( file,response) {
		    $( '#'+file.id ).find('p.state').text('已上传');
		    if( response == "null" || response == "" || 
		    		response == null || response == '"null"'){
		    	jAlertError("网络异常，稍后重试!","提示");
		    	hideOverlay();
		    }else if(JSON.stringify(response).indexOf(",") > 0 ){
	       	 	var pos = response.indexOf(",");
	       	 	var fileName = response.substring(0,pos);
	       	 	var fileId = response.substring(pos+1,response.length);
	       	 	var getFileId = $("#hidden_picture_file_id").attr("value");
	       	 	if (getFileId != ""){
	       	 		getFileId += ","+fileId;
	       	 	} else {
	       	 		getFileId += fileId;
	       	 	}
	       	 	$("#hidden_picture_file_id").attr("value",getFileId);
		       	/*
		       	 var getFileName = $("#file_name").attr("value");
		    	 if(getFileName != ""){
		    		 getFileName+=","+fileName;
		       	 }else{
		       		getFileName+=fileName;
		       	 }
		       	 $("#file_name").attr("value",getFileName);
		       	 
		       	var getInitName = $("#init_name").attr("value");
		        if(getFileName != ""){
		        	getInitName+=","+file.name;
		      	 }else{
		      		getInitName+=file.name;
		      	 }
		         $("#init_name").attr("value",getFileName);
		       	 
			     $('#'+file.id ).find('p.state').append("<a href='javascript:void(0);' data='"+fileId+"' class='delete'></a><br/>");
			     $("#"+file.id).find("h4").css({"float":"left","margin":"0","padding-right":"20px"});
			     if(file.name.length>20){
			    	 $("#"+file.id).find("h4").text(file.name.substr(0,20)+"...");
			     }*/
		    }else{
		    	jAlertError("网络异常，请刷新界面重新上传!","提示");
		    	hideOverlay();
		    }
		});
		//所有文件上传结束时触发
		uploader.on("uploadFinished",function(){
			CommonUpload.hideOverlay();
		});
		//上传出错时触发
		uploader.on( 'uploadError', function( file ) {
		    $('#'+file.id ).find('p.state').text('上传出错');
		    $('#'+file.id ).find('p.state').append("<a href='javascript:void(0);' data='"+file.id+"' class='errdelete'></a><br/>");
		});
		//不管成功或者失败，文件上传完成时触发
		uploader.on( 'uploadComplete', function( file ) {
		    $( '#'+file.id ).find('.progress').fadeOut();
		    // 隐藏上传按钮
		    $("#picker").css("display", "none");
		    // 删除按钮
		    $(".state").html("已上传<a href='javascript:void(0);' data='7848' class='delete'></a>");
		    // 个人头像上传之后修改头像、实名认证上传之后修改头像
    		$.ajax({
    			url : _baseUrl + "/testerUserInfo/findNewTesterUserPictureById.action",
    			type : "post",
    			dataType : "json",
    			data : {"fileId": $("#hidden_picture_file_id").val()},
    			async : true
    		}).done(function(data) {
    			if (data.fileInfo.filePath != null) {
					var pictureFilePath = data.fileInfo.filePath;
					//转码
					pictureFilePath = encodeURI(encodeURI(pictureFilePath));
    				$("#head_img1").attr("src", _baseUrl+"/jsp/desktop/picture.jsp?pictureFilePath=" + pictureFilePath);
    				$("#head_img2").attr("src", _baseUrl+"/jsp/desktop/picture.jsp?pictureFilePath=" + pictureFilePath);
    				$("#head_img3").attr("src", _baseUrl+"/jsp/desktop/picture.jsp?pictureFilePath=" + pictureFilePath);
    			}
    		}).fail(function(data) {
    			CommonUtils.logError("init testerUser picture failed!");
    		});
		});
		//验证不通过时触发
		uploader.on('error',function(type){
			if(type == 'F_EXCEED_SIZE'){
				$(".validMsg").html("<span>文件大小不能超过限制5M!</span>");
			}
			if(type == 'Q_TYPE_DENIED'){
				$(".validMsg").html("<span>请上传允许的图片类型:jpg,bmp,gif,png</span>");
			}
		});
		//删除
		$list.find(".delete").live('click',function(){
			var $ele = $(this);
			var fileId = $ele.attr("data");
			var fId = $ele.parent().parent().attr("id");
			jConfirm("确定要删除当前文件吗？", "提示", function(r) {
				if(!r){return;}
				if (uploader.getFile(fId)) {
					uploader.removeFile(uploader.getFile(fId),true); //从queue中移除
				}
			    // 显示上传按钮
			    $("#picker").css("display", "block");
			    // 修改头像图片路径
				$("#head_img1").attr("src", _baseUrl+"/css/images/touxiang.png");
				$("#head_img2").attr("src", _baseUrl+"/css/images/touxiang.png");
				$("#head_img3").attr("src", _baseUrl+"/css/images/touxiang.png");
				$.ajax({
					url : _baseUrl + "/deskTop/deleteUserPictureFile.action",
					type : "post",
					dataType : "json",
					data : {"fileInfo.fileId":fileId}
				}).done(function(data){
					$ele.parent().parent().remove();
					$("#hidden_picture_file_id").val("");
					TesterUserPicture.initTesterUserPicture();//调用放处理：删除刚上传的头像文件有回显已经上传的头像图片
				}).fail(function(){
					jAlertError("删除失败!","提示");
				});
			});
		});
		//已取消 或 上传出错后 增加删除事件
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
			    	CommonUpload.hideOverlay();
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
		});
		//-------webupload上传文件end-------------
		$("#picture-modal").modal("show");
	}
	
	function loadForget(){
		$("#forgetform").modal("show");
	}
	
	function loadActivation(){
		$("#activation-modal").modal("show");
	}
	
	function loadSetPassword(){
		$("#setpassword-modal").modal("show");
	}
	
	/* 显示遮罩层 */
	function showOverlay() {
	    $("#overlay").height('100%');
	    $("#overlay").width('100%');
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
	
	
	module.init = init;
	module.showOverlay = showOverlay;
	module.hideOverlay = hideOverlay;
	module.pageHeight = pageHeight;
	module.pageWidth = pageWidth;
	module.loadUserExtension = loadUserExtension;
	module.loadPicture = loadPicture;
	module.loadForget = loadForget;
	module.loadActivation = loadActivation;
	module.loadSetPassword = loadSetPassword;
	
	return module;
	
}($, window.CommonUpload || {}));

/**
 * 页面初始化
 */
$(function() {
	
	CommonUpload.init();
	
});