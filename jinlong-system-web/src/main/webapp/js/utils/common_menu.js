/**
 * 主页面框架初始化
 */
(function() {
	// 初始化菜单
	$("#main-menus").on("click", "li[url]", function(event) {
		var id = $(this).attr("id");
		if(id == "MENU_PJ"){ //判断是否为项目管理
			$(this).parent().parent().parent().find("li").removeClass("sel");
			$(this).parent().parent().addClass("sel");
		}else if(id == "MENU_OD"){ //判断是否为订单管理
			$(this).parent().parent().parent().find("li").removeClass("sel");
			$(this).parent().parent().addClass("sel");
		}else if(id == "MENU_DM"){ //判断是否为需求管理
			$(this).parent().parent().parent().find("li").removeClass("sel");
			$(this).parent().parent().addClass("sel");
		}else{
			$(this).parent().find("li").removeClass("sel");
			$(this).addClass("sel");
		}
		if (id) {
			PageCommon.loadPageById(id, null, $("#"+id+">a").html());
		}
	});
	//$("#MENU_DT").find("a").addClass("sel");
	
	// 初始化页脚连接
	/*$("#footer-link").on("click", "li[url]", function(event) {
		var id = $(this).attr("id");
		if (id) {
			PageCommon.loadPageById(id, null, null);
		}
	});*/
	
	/**
	 * 初始化页脚问题反馈
	 */
	if($("#user_role_id").val() == "6"){
		$("#footer_right_link").removeClass("disable");
	}else {
		$("#footer_right_link").addClass("disable");
	}

	// 解决IE浏览器console未定义
	window.console = window.console
			|| (function() {
				var names = [
				             "log", "debug", "info", "warn", 
				             "error", "assert", "exception", "dir", 
				             "dirxml", "group", "groupEnd", "time",
				             "timeEnd", "count", "trace", "profile", 
				             "profileEnd"
				            ];
				window.console = {};
				for (var i = 0; i < names.length; ++i) {
					window.console[names[i]] = function() {
					}
				}
				return window.console;
			})();
})();
