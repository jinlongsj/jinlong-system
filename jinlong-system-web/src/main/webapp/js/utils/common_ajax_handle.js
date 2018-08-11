/**
 * 定义公共的Ajax
 */
window.CommonAjaxHandle = (function($, module) {
	
	module.bindSelectOptions = bindSelectOptions;
	module.bindSelectOptionData = bindSelectOptionData;
	module.bindSelectOptionDataList = bindSelectOptionDataList;
	module.bindSelectOptionDataDefault = bindSelectOptionDataDefault

	return module;
})($, window.CommonAjaxHandle || {})