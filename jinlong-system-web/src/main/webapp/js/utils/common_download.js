/**
 * 文件下载插件
 * 
 * @param url
 *            提交到后台Action的路径
 * @param data
 *            参数数据,参数传入的格式为(fileInfo.fileId=文件ID或者{"fileInfo.fileId":"文件ID"})
 * @method get或者post提交
 */
jQuery.fileDownload = function(url, data, method) {
	// 获取url和data
	if (url && data) {
		// data是string或者array/object
		data = typeof data == "string" ? data : jQuery.param(data);
		// 把参数组装成 form的 input
		var inputs = "";
		jQuery.each(data.split("&"), function() {
			var pair = this.split("=");
			inputs += "<input type='hidden' name='" + pair[0] + "' value='" + pair[1] + "' />";
		});
		// request发送请求
		jQuery("<form action='" + url + "' method='" + (method || "post") + "'>'" + inputs + "'</form>").appendTo('body').submit().remove();
	}
};