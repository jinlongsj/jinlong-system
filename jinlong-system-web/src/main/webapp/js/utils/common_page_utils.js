/***************************************************************************************************/

/**
 * 页面跳转公共处理模块 
 */
window.PageCommon = (function($, module) {

	var urlArray = new Array();
	var codeMap_global = new CollectUtil.Map();

	/**
	 * 页面重定向到指定url 
	 */
	function redirect(url) {
		top.location = url + window.location.hash;
	}

	/**
	 * 将hash字符串封装成数组
	 */
	function packageHashStrToArray() {
		var hash = window.location.hash;
		if (hash && hash != '') {
			return hash.substring(1).split("|");
		}
		return new Array();
	}
	
	/**
	 * 从hash数组中获得hash值
	 */
	function getHashFromArray(hashArray) {
		var hashStr = "";
		for (var i = 0; i < hashArray.length; i++) {
			if (i == 0) {
				hashStr += hashArray[0];
			} else {
				hashStr += ("|" + hashArray[i]);
			}
		}
		return hashStr;
	}
	
	/**
	 * 将hash值压入数组中
	 */
	function addHash(url) {
		var hashArray = packageHashStrToArray();
		hashArray.push(url);
		window.location.hash = getHashFromArray(hashArray);
	}

	/**
	 * 将二级页面hash值从数组中弹出
	 */
	function popHash() {
		var hashArray = packageHashStrToArray();
		hashArray.pop();
		return hashArray;
	}
	
	/**
	 * 从二级页面返回到一级页面
	 */
	function swichToC1() {
		window.location.hash = getHashFromArray(popHash());
	}
	
	/**
	 *  
	 */
	function popHashReplace(url) {
		var hashArray = packageHashStrToArray();
		hashArray.pop();
		hashArray.push(url);
		window.location.hash = getHashFromArray(hashArray);
	}

	/**
	 * 回退并替换
	 */
	function swichToCReplace(url) {
		popHashReplace(url);
	}
	
	/**
	 * 页面加载后进行数据权限控制 
	 */
	function authPageHandle() {
		$(".functionCode").each(function() {
			var functionCode = $(this).val();
			CommonUtils.logInfo("--" + functionCode);
			if ("undefined" != typeof functionCode && functionCode != '') {
				var fcodeArray = new CollectUtil.List(functionCode.split(','));
				$(this).parent().find(".auth").each(function() {
					if (fcodeArray.constains($(this).attr('auth'))) {
						CommonUtils.logInfo("##---show" + $(this).attr('auth'));
						$(this).show();
					} else {
						CommonUtils.logInfo("##---remove" + $(this).attr('auth'));
						$(this).remove();
					}
				});
				$(this).parent().find(".auth").removeClass("auth");
			}
		});
	}
	
	/**
	 * 页面加载后处理函数
	 */
	function loadHandle(response, status, xhr) {
		if (status == 'success') {
			authPageHandle();
		} else {
			top.location = _baseUrl+"/http_error/http_error_500.jsp";
			CommonUtils.loadError(xhr.status, jQuery.parseJSON(response));
		}
	}
	
	/**
	 * 通过页面的URL将页面加载到对应的DIV 
	 */
	function loadToDivByUrl(divId, url, level) {
		$("#"+divId).empty().load(_baseUrl + url, {}, function(response, status, xhr) {
			loadHandle(response, status, xhr);
		});
	}
	
	/**
	 *  
	 */
	function loadPageCommon(url, level) {
		if (!level) {
			level = urlArray.length;
		}
		loadToDivByUrl('data_area' + level, url, level);
	}
	
	/**
	 *  
	 */
	function hashMonitor() {
		var params = packageHashStrToArray();
		var len = 0;
		if (params.length >= urlArray.length) {
			len = params.length;
		} else {
			len = urlArray.length;
		}
		var loaded = false;
		for (var i = 0; i < len; i++) {
			if (params[i] != urlArray[i] && params[i]) {

				urlArray[i] = params[i];
				loadPageCommon(params[i], i + 1);
				if (i == (params.length - 1)) {
					loaded = true;
				}

			} else if (params[i] != urlArray[i] && !params[i]) {
				urlArray.splice(i, 1);
			}
		}
		if (!loaded && params.length > 0) {
			loadPageCommon(params[params.length - 1]);
		}
		swichToLevel(params.length);
	}
	
	/**
	 * 通过主菜单ID获得其对应页面的URL 
	 */
	function loadMenuId(id) {
		urlArray = new Array();
		$("#main-menus li").removeClass("selected");
		$("#"+id).addClass("selected");
		return $("#"+id).attr("url");
	}

	/**
	 * 通过主菜单ID加载对应的页面
	 */
	function loadPageById(id, level, menuName) {
		window.location.hash = loadMenuId(id) || "";
		//document.title="Test+"+menuName;
	}
	
	/**
	 *  
	 */
	function loadLastHash() {
		var hash = window.location.hash;
		if (hash && hash != '') {
			hashMonitor();
		} else {
			loadPageById('MENU_DT', null, "我的桌面");
		}
	}

	/**
	 *  
	 */
	function loadList(list) {
		window.location.hash = getHashFromArray(list);
	}

	/**
	 * 返回true已经存在url，false表示不存在url
	 */ 
	function spliceUrls(url) {
		var urlArray = packageHashStrToArray();
		var a = -1;
		for (var i = 0; i < urlArray.length; i++) {
			if (url == urlArray[i]) {
				a = i;
				break;
			}
		}
		if (a != -1) {
			var dsize = urlArray.length - (a + 1);
			if (dsize > 0) {
				urlArray.splice(a + 1, dsize);
			}
		} else {
			urlArray.push(url);
		}
		return getHashFromArray(urlArray);
	}
	
	/**
	 * 通过url加载页面 
	 */
	function loadPageByUrl(url, level) {
		window.location.hash = spliceUrls(url);
	}

	
	/**
	 *  
	 */
	function swichToLevel(level) {
		$("#data_top >div").addClass("disable");
		$("#data_area" + level).removeClass("disable");
	}
	
	/**
	 * 审核信息显示
	 */
	function modelForReviewDetail(data) {

		var $opinion = $("#find_review_data_btn");
		var $parent = $opinion.parent().parent();
		var $opinionList = $("#review_data");
		var $disable = $parent.find(".disable");
		
		if (data != "" && data.length > 0) {
			$("#review_data").show();
			var strHtml = '';
			var htmltat='<div class="opinion-blockbar"> ' +  	
			'<div class="opinion-block1" style="text-align:center; width:130px;">审核类型</div>'+
			'<div class="opinion-block1" style="text-align:center; width:130px;">审核人员</div>'+
			'<div class="opinion-block3" style="text-align:center; width:147px;">审核时间</div>'+
			'<div class="opinion-block1" style="text-align:center; width:130px;">审核结果</div>'+
			'<div class="opinion-block1" style="text-align:center; width:130px;">驳回原因</div>'+
			'<div class="opinion-block2" style="text-align:center; width:290px; text-align:center;">审核意见</div></div>';
			
			strHtml += htmltat;
			var htmlstr1='<div class="opinion-table"> <table width="100%" border="0" cellspacing="0" cellpadding="0">';
			strHtml += htmlstr1;
			for (var i = 0; i < data.length; i++) {
				//判断审核对象（是客户还是项目经理）
//				var usertype = "客户审核";
//				var reviewType = data[i]['reviewType'];
//				if (reviewType == 1) {
//					usertype = "项目经理审核"
//				}
				//格式化时间
				var formatdate= data[i]['reviewTime'].replace("T"," ");
				var htmlstr ='<tr class="opinion-blockbar"><td style="text-align:center; width:130px;">'+data[i]['reviewTypeName']+'</td>'+
				'<td style="text-align:center; width:130px;">'+data[i]['userName']+'</td>'+
				'<td style="text-align:center; width:147px;">'+formatdate+'</td>'+
				'<td style="text-align:center; width:130px;">'+data[i]['reviewName']+'</td>'+
				'<td style="text-align:center; width:130px;">'+data[i]['dismissReasonName']+'</td>'+
				'<pre><td style="width:300px; white-space:pre-wrap;">'+data[i]['content']+'</td></pre></tr>';
				strHtml += htmlstr;
			}
			htmlstr2 = '</table></div>'; 
			strHtml += htmlstr2
			$("#review_data").empty().append(strHtml);
			if ($disable.length == 0) {
				$opinionList.addClass("disable");
				$opinion.empty().html("展开意见列表");
				$opinionList.attr("style", "");
			} else {
				$opinionList.removeClass("disable");
				$opinion.empty().html("收起意见列表");
			}
		} else if ($opinionList.html().length == 0) {
			$opinionList.removeClass("disable");
			$opinionList.attr("style", "");
			$opinionList.empty().html("暂无审核信息");
			$opinionList.css("text-align", "center");
			$opinion.empty().html("收起意见列表");
		} else {
			$opinionList.addClass("disable");
			$opinionList.empty();
			$opinionList.attr("style", "");
			$opinionList.css("text-align", "");
			$opinion.empty().html("展开意见列表");
		}
	}

	/**
	 * 返回时取消复选框钩选,避免影响第1层页面
	 */
	function cancelCheckboxSelect(){
		var inputCheckedObj = $("input[type=checkbox]:checked");
		var checkCount = inputCheckedObj.length;
		for(var i=0; i<checkCount; i++){
			inputCheckedObj[i].checked=false;
		}
	}
	
	/**
	 * 同步主菜单样式
	 */
	function synchronousMainMenuStyle(menuId){
		$("#main-menus .sel").removeClass("sel");
		$("#"+menuId).addClass("sel");
	}
	
	/**
	 * 多级同步主菜单样式
	 */
	function synchronousMultiMainMenuStyle(menuId){
		$("#"+menuId).parent().parent().parent().find("li").removeClass("sel");
		$("#"+menuId).parent().parent().addClass("sel");
	}
	
	//是否包含特殊符号true表示参数含有特殊符号
	function validateStr(str){
		//特殊符号规则定义可以自己添加其他特殊符号
		var containSpecial = RegExp(/[(\ )(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\-)(\+)(\=)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\/)(\<)(\>)(\?)(\)]+/);      
		if(containSpecial.test(str)){
			return true;
		}else{
			return false;
		}
	}
	
	// 之修改url.hash
	module.redirect = redirect;
	// 监控前进后退
	module.hashMonitor = hashMonitor;
	module.swichToLevel = swichToLevel;
	module.swichToC1 = swichToC1;
	module.loadHandle = loadHandle;
	module.authPageHandle = authPageHandle;
	module.loadToDivByUrl = loadToDivByUrl;
	module.loadPageByUrl = loadPageByUrl;
	module.loadPageById = loadPageById;
	module.loadLastHash = loadLastHash;
	module.loadList = loadList;
	module.swichToCReplace = swichToCReplace;
	module.modelForReviewDetail = modelForReviewDetail;
	module.cancelCheckboxSelect = cancelCheckboxSelect;
	module.synchronousMainMenuStyle = synchronousMainMenuStyle;
	module.synchronousMultiMainMenuStyle = synchronousMultiMainMenuStyle;
	module.validateStr = validateStr;

	return module;
})($, window.PageCommon || {});