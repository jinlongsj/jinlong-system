/**
 * 公共的省市区县三级联动表单
 */
window.CommonZone = (function($, module) {
	
	/**
	 * @description 		初始化省、自治区、直辖市下拉文本框的信息
	 * @param province 		省级行政区的文本框对象
	 * @param city     		市级行政区的文本框对象
	 * @param region   		区县行政区的文本框对象
	 * @param provinceValue 省级行政区下拉文本框选择的值，默认可以设置为空
	 * @return
	 */
	function showProvinceList(province, city, region, provinceValue) {
		$.ajax({
			url : "zone/show",
			type : "POST",
			contentType: "application/json;charset=UTF-8",
			async : false,
			dataType : "JSON"
		}).done(function(data) {
			if (null != data.obj && 0 < data.obj.length) {
				// 首先加入请选择提示
				province.append("<option value='0'> 请选择 </option>");
				city.append("<option value='0'> 请选择 </option>");
				region.append("<option value='0'> 请选择 </option>");
				$.each(data.obj, function(i, zone) {
					// 添加新查询出来的三级文本框选项
					province.append("<option value='" + zone.zoneId + "' >" + zone.zoneName + "</option>");
				});
				// 当省市区的值有数据的时候，则给省市区的下拉文本框设置数值
				if (null != provinceValue && 0 < provinceValue) {
					province.val(provinceValue);
				}
			} else {
				jAlert(data.msg, "省、自治区、直辖市列表信息查询");
			}
		}).fail(function() {
			jAlert("省、自治区、直辖市列表信失败！", "省、自治区、直辖市列表信息查询");
		});
	}
	
	/**
	 * @description 	通过省级地区ID，查询展示下面的城市信息集合
	 * @param city      市级行政区的文本框对象
	 * @param region    区县行政区的文本框对象
	 * @param cityValue 市级行政区下拉文本框选择的值，默认可以设置为空
	 * @return
	 */
	function showCityList(provinceValue, city, region, cityValue) {
		if (null != provinceValue && 0 < provinceValue) {
			$.ajax({
				url : "zone/showByParentId",
				type : "POST",
				async : false,
				contentType: "application/json;charset=UTF-8",
				dataType : "JSON",
				data : provinceValue
			}).done(function(data) {
				// 如果之前的二级文本框有选项，则删除
				if (null != city && null != city.children() && 0 < city.children().length) {
					// 置空之前的选择的省、自治区、直辖市下面的城市
					city.empty();
				}
				// 如果之前的三级文本框有选项，则删除
				if (null != region && null != region.childNodes && 0 < region.childNodes.length) {
					// 置空之前的选择的城市下面的区县
					regionList.empty();
				}
				if (null != data.obj && 0 < data.obj.length) {
					// 首先加入请选择提示
					city.append("<option value='0'> 请选择 </option>");
					$.each(data.obj, function(i, zone) {
						// 添加新查询出来的三级文本框选项
						city.append("<option value='" + zone.zoneId + "' >" + zone.zoneName + "</option>");
					});
					// 当城市有数据的时候，则给城市的下拉文本框设置数值
					if (null != cityValue && 0 < cityValue) {
						city.val(cityValue);
					}
				} else {
					jAlert(data.msg, "城市列表信息查询");
				}
			}).fail(function() {
				jAlert("城市列表信息查询失败！", "城市列表信息查询");
			});
		}
	}
	
	/**
	 * @description 		通过城市地区ID，查询展示下面的区县信息集合
	 * @param city      	市级行政区的文本框对象
	 * @param region    	区县行政区的文本框对象
	 * @param regionValue 	区县行政区下拉文本框选择的值，默认可以设置为空
	 * @return
	 */
	function showRegionList(cityValue, region, regionValue) {
		if (null != cityValue && 0 < cityValue) {
			$.ajax({
				url : "zone/showByParentId",
				type : "POST",
				async : false,
				contentType: "application/json;charset=UTF-8",
				dataType : "JSON",
				data : cityValue
			}).done(function(data) {
				// 如果之前的三级文本框有选项，则删除
				if (region != null && region.children() != null 
					&& region.children().length != 0) {
					// 置空之前的选择的城市下面的区县
					region.empty();
				}
				if (null != data.obj && 0 < data.obj.length) {
					// 首先加入请选择提示
					region.append("<option value='0'> 请选择 </option>");
					$.each(data.obj, function(i, zone) {
						// 添加新查询出来的三级文本框选项
						region.append("<option value='" + zone.zoneId + "' >" + zone.zoneName + "</option>");
					});
					// 给区县有数据的时候，则给区县的下拉文本框当中设置数值
					if (null != regionValue && 0 < regionValue) {
						region.val(regionValue);
					}
				} else {
					jAlert(data.msg, "区县列表信息查询");
				}
			}).fail(function() {
				jAlert("区县列表信息查询失败！", "区县列表信息查询");
			});
		}
	}
	
	/**
	 * @description  通过当前的的地区ID，查询他的父ID信息
	 * @param zoneId 地区ID
	 * @return zone
	 */
	function showParentIdByZone(zoneId) {
		if (null != zoneId && 0 < zoneId) {
			var zone;
			$.ajax({
				url : "zone/showParentIdByZone",
				type : "POST",
				async : false,
				contentType: "application/json;charset=UTF-8",
				dataType: "JSON",
				data : JSON.stringify(zoneId)
			}).done(function(data) {
				if (true == data.flag) {
					zone = data.obj;
				} else {
					jAlert(data.msg, "上一级地区查询");
				}
			}).fail(function(data) {
				jAlert(data.msg, "上一级地区查询");
			});
			return zone;
		}
	}
	
	/**
	 * @description  通过当前的的地区ID，查询他的父ID信息
	 * @param zoneId 地区ID
	 * @return
	 */
	function showParentIdByZoneId(zoneId) {
		if (null != zoneId && 0 < zoneId) {
			var zone;
			$.ajax({
				url : "zone/showParentIdByZone",
				type : "POST",
				async : false,
				contentType: "application/json;charset=UTF-8",
				dataType: "JSON",
				data : JSON.stringify(zoneId)
			}).done(function(data) {
				if (true == data.flag) {
					zone = data.obj.zoneId;
				} else {
					jAlert(data.msg, "上一级地区ID查询");
				}
			}).fail(function(data) {
				jAlert(data.msg, "上一级地区ID查询");
			});
			return zone;
		}
	}
	
	/**
	 * 注册接口
	 */
	module.showProvinceList = showProvinceList;
	module.showCityList = showCityList;
	module.showRegionList = showRegionList;
	module.showParentIdByZone = showParentIdByZone;
	module.showParentIdByZoneId = showParentIdByZoneId;
	
	/**
	 * 返回接口对象
	 */
	return module;
	
})($, window.CommonZone || {});