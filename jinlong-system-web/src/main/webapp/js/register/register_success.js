/**
 * 用户注册页面
 */
window.RegisterSuccess = (function($, module) {
	
	/**
	 * 用户注册页面初始化方法
	 */
	function init() {
        $(".class").change(function() {
            $(".dipe").show()
        });
        $(".cla").change(function() {
            $(".dipe").hide()
        });
	}
	
	/**
	 * 用户注册信息
	 */
	function register() {
		
	}
	
	/**
	 * 注册接口
	 */
	module.init = init;
	module.register = register;
	
	return module;
	
})($, window.RegisterSuccess || {});

/**
 * 事件调用
 */
$(function() {
	
	/**
	 * 页面初始化
	 */
	RegisterSuccess.init();
	
})