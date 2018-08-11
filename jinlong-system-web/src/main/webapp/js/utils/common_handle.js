

/**
 * 定义公共的用来处理按钮被多次点击
 */
window.CommonHandlePreventMoreClickButton = (function($, module, commonHandleButton) {
	var buttonValue;
	var i=3;

	/**
	 * 设置按钮的值
	 */
	/*function setButtonValue(elementId){
		buttonValue = $("#"+elementId).attr("value");
	}*/
	
	/**
	 * 获取按钮的值
	 */
	/*function getButtonValue(){
		return buttonValue;
	}*/
	
	/**
	 * 处理按钮多次点击
	 */
	function handlePreventMoreClick(evt,elementId){
		//setButtonValue(elementId);
		commonHandleButton.deactiveButton(elementId);
		periodicalExecuter(evt,elementId);
	}
	
	/**
	 * 定期执行
	 */
	function periodicalExecuter(evt, elementId){
		if(3 == i){
			callBack.obj = evt;
			callBack.loop = 2;
			var sh = setInterval(function(elementId){
				i=i-1;
				callBack(elementId, sh);
			},1000);
		}else{
			setTimeout(function(){
				callBack.obj = evt;
				callBack.loop = 2;
				var sh = setInterval(function(elementId){
					i=i-1;
					callBack(elementId, sh);
				},1000);
			}, 2000);
		}
	}
	
	/**
	 * 回调
	 */
	function callBack(elementId, sh){
		//方案1:按钮体现时间提示
		/*with (arguments.callee) {
			CommonUtils.logInfo("loop="+loop);
			obj.value = "(" + loop + ")秒后再试!";
			loop = loop-1;
			if (loop == -1) {
				commonHandleButton.activeButton(elementId);
				obj.value = getButtonValue();
				clearInterval(sh);
				return;
			}
		}*/
		
		//方案2:按钮置灰
		with (arguments.callee) {
			CommonUtils.logInfo("loop="+loop);
			//只需执行一次,便可以更改按钮状态
			do{
				$(obj).css({
					"background-color":"#999",
					"cursor":"text"
				});
			}while(-1 > 0);
			
			loop = loop-1;
			
			if (0 == loop) {
				$(obj).css({
					"background-color":"#1abd9b",
					"cursor":"pointer"
				});
				$(obj).removeAttr("disabled");
				//关掉当前的定时器
				clearInterval(sh);
				i=3;
				return;
			}	
		}
	}
	
	module.handlePreventMoreClick = handlePreventMoreClick;
	
	return module;
})($, window.CommonHandlePreventMoreClickButton || {}, window.CommonHandleButton)

/**
 * 定义公共的用来处理文本框的启用和禁用状态
 */
window.CommonHandleText = (function($, module) {
	/**
	 * 启用文本框
	 */
	function activeText(elementId) {
		$("#" + elementId + "").attr("disabled", false);
	}

	/**
	 * 禁用文本框
	 */
	function deactiveText(elementId) {
		$("#" + elementId + "").attr("disabled", true);
	}

	module.activeText = activeText;
	module.deactiveText = deactiveText;

	return module;
})($, window.CommonHandleText || {})

window.LoginHandle = (function($, module) {
	/**
	 * 用户退出接口
	 */
	function exit() {
		$.ajax({
			url : _baseUrl + "/loginExit/toExit.action",
			type : "post",
			dataType : "json"
		}).done(function(data){
			top.location = userUrl;
		}).fail(function(){
			jAlertError("登录超时！", "用户退出");
			top.location = userUrl;
		});
	}

	module.exit = exit;
	return module;
})($, window.LoginHandle || {})
/**
 * 页面初始化
 */
$(function() {

	// 用户退出
	$("#setupicon").on("click", function(){
		jConfirm("   您确定是否退出当前系统?", "用户退出", function(r) {
			if(!r){return;}
			LoginHandle.exit();
		});
	});

	// 消息管理
	$("#message").on("click", function(){
		PageCommon.loadPageByUrl("/jsp/message_manage/mesage.jsp",2);
	});

	
	// 消息查看
	$("#message_see").on("click",function(){
		PageCommon.loadPageByUrl("/jsp/message_manage/message_see.jsp",2);
	});
	
	/*$.datepicker.setDefaults({
		dateFormat : 'yy-mm-dd'
	});*/

	ValidatorUtil.init();

	$(window).bind("hashchange", PageCommon.hashMonitor);

	PageCommon.loadLastHash();

});

// 日期插件绑定
window.CommonDateTimePickerBind = (function($, module) {
	
	// 项目开始日期
	function bindDateTimePickerStart(elementId) {
		$("#" + elementId).datetimepicker({
			timepicker : false,
			scrollMonth : false,
			scrollTime : false,
			scrollInput : false,
			minDate: 0
		});
	}
	
	// 结束日期
	function bindDateTimePicker(elementId) {
		$("#" + elementId).datetimepicker({
			timepicker : false,
			scrollMonth : false,
			scrollTime : false,
			scrollInput : false
		});
	}
	
	// 项目开始日期---->结束日期
	function bindStartToEndDateTimePicker(startElementID,endElementID){
		$("#" + startElementID).datetimepicker({
			timepicker : false,
			scrollTime : false,
			scrollInput : false,		
			onSelectDate:function(dateTime){ 
				$("#" + endElementID).datetimepicker({			         
					controlType:'select',			         
					minDate:$("#" + startElementID).val(),			         
					onSelect:function(dt){			             
						$("#" + endElementID).datetimepicker("setDate",dt);			         
						}			     
				});			
				}		
		});
		$("#" + endElementID).datetimepicker({		
			timepicker : false,
			scrollTime : false,
			scrollInput : false,		
			onSelectDate:function(dateTime){
				$("#" + startElementID).datetimepicker({			         
					controlType:'select',			         
					maxDate:$("#" + endElementID).val(),			         
					onSelect:function(dt){			             
						$("#" + startElementID).datetimepicker("setDate",dt);			         
						}			     
				});			
				}		
		});
	}

	module.bindDateTimePicker = bindDateTimePicker;
	module.bindDateTimePickerStart = bindDateTimePickerStart;
	module.bindStartToEndDateTimePicker = bindStartToEndDateTimePicker;

	return module;

})($, window.CommonDateTimePickerBind || {});
