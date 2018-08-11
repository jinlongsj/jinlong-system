/**
 * 加载驾校用户后台的右侧列表菜单
 */
window.MenuList = (function ($, module) {
	
	/**
	 * 迭代循环驾校用户后台主页面的右侧菜单信息
	 */
	function showMenu() {
		$.ajax({
			url : "main/show",
			type : "POST",
			async : false,
			dataType : "JSON"
		}).done(function(data) {
			if (data.flag && 0 < data.obj.length) {
				// 先清空菜单列表
				$("#firstpane").html("");
				// 循环一级菜单信息
				$.each(data.obj, function (i, menu) {
					var menu_body = "<div style=\"display:block\" class=\"menu_body\">";
					// 循环二级菜单信息
					$.each(menu.son, function (i, menuSon) {
						menu_body = menu_body + "<a id=" + menuSon.menuId 
						+ " href=\"javascript:MenuList.load('" + menuSon.menuUrl + "');\">"
						+ menuSon.menuName + "</a>";
					});
					$("#firstpane").html($("#firstpane").html() + "<h3 class=\"menu_head current\">" 
							+ menu.menuName + "</h3>" + menu_body + "</div>");
				});
		        // 设置一级菜单样式
		        $("#firstpane").children("h3:first-child").siblings().removeClass("current");
				// 折叠所有的二级菜单
		        $("#firstpane .menu_body").hide();
				// 打开头一个折叠的一级菜单
		        $("#firstpane .menu_body:eq(0)").show();
			} else {
				jAlert(data.msg, "后台首页菜单");
			}
		}).fail(function() {
			jAlert("后台首页菜单查询错误！", "后台首页菜单");
		});
	}
	
	/**
	 * 页面初始化方法
	 */
	function init() {
		// SpringBoot通过tokern和header进行过滤和拦截的公共认证JS类
		CommonSecurity.ajaxSend();
		// 展示菜单信息
		showMenu();
		// 初始化用户信息管理页面
		$("#main").empty().load("jsp/user/user_manage.jsp");
	}
	
	/**
	 * 加载页面URL
	 */
	function load(url) {
		// 隐藏校验提示框的验证样式
		$(".formError").remove();
		// 加载页面URL
		$("#main").empty().load(url);
	}
	
	module.init = init;
	module.load = load;
	
	/**
	 * 返回接口
	 */
	return module;
	
})($, window.MenuList || {});

/**
 * 页面初始化实现
 */
$(function() {
	
	/**
	 * 调用较小用户后台主页面初始化方法
	 */
	MenuList.init();
	
	/**
	 * 菜单初始化
	 */
    $("#firstpane h3.menu_head").on("click", function(){
        $(this).addClass("current").next("div.menu_body").slideToggle(300).siblings("div.menu_body").slideUp("slow");
        $(this).siblings().removeClass("current");
    });
	
	// 初始化菜单
	/*$("#main-menus").on("click", "li[url]", function(event) {
		var id = $(this).attr("id");
		if (id) {
			PageCommon.loadPageById(id, null, $("#"+id+">a").html());
		}
	});*/
	
});