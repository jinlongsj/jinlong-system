/**
 * SpringBoot通过tokern和header进行过滤和拦截的公共认证JS类
 */
window.CommonSecurity = (function($, module) {
	
	/**
	 * SpringBoot通过tokern和header进行过滤和拦截
	 */
	function ajaxSend() {
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
	}
	
	module.ajaxSend = ajaxSend;
	
	/**
	 * 返回接口
	 */
	return module;
	
})($, window.CommonSecurity || {});