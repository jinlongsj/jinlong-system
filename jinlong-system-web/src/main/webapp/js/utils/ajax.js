/**
 * 获得Ajax原生对象
 */
function getXMLHttpRequest() {
	var xhr = null;
	if ((typeof XMLHttpRequet) != 'undefined') {
		// 非IE浏览器
		xhr = new XMLHttpRequest();
	} else {
		// IE浏览器
		xhr = new ActiveXObject('Microsoft.XMLHttp');
	}
	return xhr;
}