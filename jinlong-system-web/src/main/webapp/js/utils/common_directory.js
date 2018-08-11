/**
 * 公共信息字典表信息显示JS
 */
window.CommonDirectory = (function($, module) {

	/**
	 * @description 	动态给下拉框绑定数据
	 * @param url 		路径->后台Action
	 * @param element	绑定下拉框的id
	 * @param params	提交到Action的参数
	 * @param fromData	绑定下拉框的数据来源
	 * @param fillName	Option中显示的数据
	 * @param fillValue	Option中value的数据
	 * @param errorMsg	错误信息
	 */
	function showSelectOptions(url, elementId, params, fromData, fillName, fillValue, selectValue, errorMsg) {
		$.ajax({
			url : url,
			type : "post",
			dataType : "json",
			data : params
		}).done(function(data) {
			if (dat.obj[fromData] != null) {
				$.each(data[fromData], function(i, n) {
					$("#" + elementId + "").get(0).options.add(new Option(n[fillName], n[fillValue]));
				});
			}
		}).fail(function() {
			CommonUtils.logError(errorMsg);
		}).done(function() {
			if ((selectValue != null) && (selectValue != "") && (selectValue != undefined)) {
				$("#" + elementId + " option[value=" + selectValue + "]").attr("selected", "selected");
			}
		});
	}

	/**
	 * @description			动态给下拉框绑定数据
	 * @param url       	路径->后台Action
	 * @param elementId 	绑定下拉框的id
	 * @param params     	提交到Action的参数
	 * @param selectValue 	选中的选项value
	 * @param errorMsg		错误信息
	 */
	function showSelectOptionData(url, elementId, params, selectValue, errorMsg) {
		$.ajax({
			url : url,
			type : "post",
			dataType : "json",
			data : {"params" : params}
		}).done(function(data) {
			if (data.obj != null) {
				/**
				 * 方法一: 兼容性好 
				 */
				var auxArr = [];
				auxArr[0] ='<option value="0">请选择</option>';
				if(data.obj.length > 0){
					$.each(data.obj, function(index, key) {
						auxArr[index+1] = "<option value='" + key["value"] + "'>" + key["name"]+ "</option>";
					});
				}
				$("#"+elementId).html(auxArr.join(''));
				/*
				 	方法二: 兼容性不太好
					$("#" + elementId + "").empty();
					$("#" + elementId + "").get(0).options.add(new Option("请选择", 0));
					$.each(data.dataList, function(i, n) {
						$("#" + elementId + "").get(0).options.add(new Option(n.name, n.value));
					});
				*/
			}
		}).fail(function() {
			CommonUtils.logError(errorMsg);
		}).done(function() {
			if ((selectValue != null) && (selectValue != "") && (selectValue != undefined)) {
				$("#" + elementId + " option[value=" + selectValue + "]").attr("selected", "selected");
			}
		});
	}

	// 默认请选择为-1
	function showSelectOptionDataDefault(url, elementId, params, selectValue, errorMsg) {
		$.ajax({
			url : url,
			type : "post",
			dataType : "json",
			data : {"params":params}
		}).done(function(data) {
			if (data.obj != null) {
				$("#" + elementId + "").empty();
				$("#" + elementId + "").get(0).options.add(new Option("请选择", -1));
				$.each(data.obj, function(i, n) {
					$("#" + elementId + "").get(0).options.add(new Option(n.name, n.value));
				});
			}
		}).fail(function() {
			CommonUtils.logError(errorMsg);
		}).done(function() {
			if ((selectValue != null) && (selectValue != "") && (selectValue != undefined)) {
				$("#" + elementId + " option[value=" + selectValue + "]").attr("selected", "selected");
			}
		});
	}
	
	/**
	 * @description 		动态给下拉框绑定数据
	 * @param data			后台查询结果数据集合
	 * @param elementId		绑定下拉框的id
	 * @param params		提交到Action的参数（no use）
	 * @param selectValue	选中的选项value
	 * @param errorMsg		错误信息
	 */
	function showSelectOptionDataList(data, elementId, params, selectValue, errorMsg) {
		if (data != undefined) {
			$("#" + elementId + "").empty();
			$("#" + elementId + "").get(0).options.add(new Option("请选择", 0));
			$.each(data.obj, function(i, n) {
				$("#" + elementId + "").get(0).options.add(new Option(n.name, n.value));
			});
		} else {
			CommonUtils.logError(errorMsg);
		}
		if ((selectValue != null) && (selectValue != "") && (selectValue != undefined)) {
			$("#" + elementId + " option[value=" + selectValue + "]").attr("selected", "selected");
		}
	}
	
	/**
	 * @description 单选框集合
	 * @param url
	 * @param dom	   给DOM对象里面append子节点，DOM是$("#id")，直接把$("#id")传进来即可
	 * @param id
	 * @param name
	 * @param value
	 * @param errorMsg
	 * @param title    错误时，弹出框的title标题
	 */
	function showRadioList(url, dom, id, name, value, errorMsg, title) {
		$.ajax({
			url : url,
			type : "POST",
			async : true,
			dataType : "JSON"
		}).done(function(data) {
			if (null != data && true == data.flag && null != data.obj) {
				$.each(data.obj, function(i, category) {
					$("#" + dom).append("<input type='radio' id='" + id + i + "' name='" + name + "' " +
						"value='" + category.value +"' style='display: inline-block; width: 15px;height: 15px;' />" 
						+ category.name);
					if (value != null && value == category.value) {
						$("#" + id + i).attr("checked", true);
					}
				});
			} else {
				jAlert(title, errorMsg);
			}
		}).fail(function(data) {
			jAlert(title, errorMsg);
		});
	}
	
	/**
	 * @description 		复选框集合
	 * @param url
	 * @param dom       	给DOM对象里面append子节点，DOM是$("#id")，直接把$("#id")传进来即可
	 * @param parentId
	 * @param parentValue
	 * @param id
	 * @param name
	 * @param value
	 * @param checkMessage  提示信息
	 * @param errorMsg
	 * @param title    		错误时，弹出框的title标题
	 */
	function showCheckboxList(url, dom, id, value, disabled, errorMsg, title) {
		$.ajax({
			url : url,
			type : "POST",
			async : true,
			dataType : "JSON"
		}).done(function (data) {
			if (null != data && true == data.flag && null != data.obj) {
				$.each(data.obj ,function(i, c) {
					// 插入数据库ID
					$("#" + dom).append("<input id='" + id + i + "'  " +
						"type='checkbox' value='" + c.value + "' />" + c.name);
					// 多选框置灰
					if (disabled == true) {
						$("#" + id + i).attr("disabled", true);
					}
				});
				if (null != title && "" != title) {
					// 提示信息
					$("#" + dom).append(title);
				}
			} else {
				jAlert(title, errorMsg);
			}
		}).fail(function () {
			jAlert(title, errorMsg);
		});
	}
	
	/**
	 * @description 		复选框集合
	 * @param url
	 * @param dom       	给DOM对象里面append子节点，DOM是$("#id")，直接把$("#id")传进来即可
	 * @param parentId
	 * @param parentValue
	 * @param id
	 * @param name
	 * @param value
	 * @param checkMessage  提示信息
	 * @param errorMsg
	 * @param title    		错误时，弹出框的title标题
	 */
	function showUpdateCheckboxList(url, dom, id, value, parentId, parentValue, disabled, errorMsg, title) {
		$.ajax({
			url : url,
			type : "POST",
			async : true,
			dataType : "JSON"
		}).done(function (data) {
			if (null != data && true == data.flag && null != data.obj) {
				$.each(data.obj ,function(i, c) {
					// 插入数据库ID
					$("#" + dom).append("<input id='" + id + i + "' ' " +
						"type='checkbox' value='" + c.value + "' />" + c.name);
				});
				// 隐藏的其他ID的文本框
				if (null != parentId && "" != parentId && 0 < parentValue) {
					$("#" + dom).append("<input id='" + parentId + i + "'  " +
							"type='hidden' value='" + parentValue + "' />");
				}
				if (null != title && "" != title) {
					// 提示信息
					$("#" + dom).append(title);
				}
			} else {
				jAlert(title, errorMsg);
			}
		}).fail(function () {
			jAlert(title, errorMsg);
		});
	}
	
	/**
	 * @description 		复选框集合
	 * @param url
	 * @param dom       	给DOM对象里面append子节点，DOM是$("#id")，直接把$("#id")传进来即可
	 * @param parentId
	 * @param parentValue
	 * @param id
	 * @param name
	 * @param value
	 * @param checkMessage  提示信息
	 * @param errorMsg
	 * @param title    		错误时，弹出框的title标题
	 */
	function showAllCheckboxList(url, dom, parentId, parentValue, id, name, value, checkMessage, errorMsg, title) {
		$.ajax({
			url : url,
			type : "POST",
			async : true,
			dataType : "JSON"
		}).done(function (data) {
			if (null != data && true == data.flag && null != data.obj) {
				$.each(data.obj ,function(i, c) {
					// 插入数据库ID
					$("#" + dom).append("<input id='" + parentId + i + "' name='" + name + "[" + i + "]." + parentId + "' " +
							"type='hidden' value='" + parentValue + "' />" + c.name);
					// 插入数据库ID
					$("#" + dom).append("<input id='" + id + i + "' name='" + name + "[" + i + "]." + id + "' " +
						"type='checkbox' value='" + c.value + "' />" + c.name);
				});
				if (null != checkMessage && "" != checkMessage) {
					// 提示信息
					$("#" + dom).append(checkMessage);
				}
			} else {
				jAlert(title, errorMsg);
			}
		}).fail(function () {
			jAlert(title, errorMsg);
		});
	}
	
	/**
	 * 注册接口
	 */
	module.showSelectOptions = showSelectOptions;
	module.showSelectOptionData = showSelectOptionData;
	module.showSelectOptionDataDefault = showSelectOptionDataDefault;
	module.showSelectOptionDataList = showSelectOptionDataList;
	module.showRadioList = showRadioList;
	module.showCheckboxList = showCheckboxList;
	module.showUpdateCheckboxList = showUpdateCheckboxList;
	module.showAllCheckboxList = showAllCheckboxList;
	
	/**
	 * 返回接口
	 */
	return module;
	
})($, window.CommonDirectory || {});