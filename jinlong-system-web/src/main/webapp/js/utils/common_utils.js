/***************************************************************************************************/

/**
 * 公共工具类模块 
 */
window.CommonUtils = (function($, module) {

	/**
	 * ajax请求异常处理 
	 */
	function ajaxError(response, status, errorThrown) {
		/*var eInfo = jQuery.parseJSON(response.responseText);
		alert("异常编码:" + eInfo.code + "异常类型:" + eInfo.type + "异常信息:" + eInfo.msg);*/
		jAlert("程序出现异常!", "提示");
	}

	/**
	 * 记录信息日志工具
	 */
	function logInfo(infoMsg) {
		if (console && console.log) {
			console.log(infoMsg);
		}
	}

	/**
	 * 加载错误处理 
	 */
	function loadError(status, response) {
		if (status == 401) {
			alert(response.msg);
			top.location = userUrl;
		} else if (status == 403) {
			alert(response.msg);
		}else if(status == 404){
			top.location = _baseUrl+"/http_error/http_error_404.jsp";
		}else if(status == 500){
			top.location = _baseUrl+"/http_error/http_error_500.jsp";
		}
	}

	/**
	 * 记录错误日志工具
	 */
	function logError(errMsg) {
		if (console && console.log) {
			console.log(errMsg);
		}
	}
	
	//扩展Date的format方法   
    Date.prototype.format = function (format) {  
        var o = {  
            "M+": this.getMonth() + 1,  
            "d+": this.getDate(),  
            "h+": this.getHours(),  
            "m+": this.getMinutes(),  
            "s+": this.getSeconds(),  
            "q+": Math.floor((this.getMonth() + 3) / 3),  
            "S": this.getMilliseconds()  
        }  
        if (/(y+)/.test(format)) {  
            format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
        }  
        for (var k in o) {  
            if (new RegExp("(" + k + ")").test(format)) {  
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));  
            }  
        }  
        return format;  
    }
    
    /**   
    *转换日期对象为日期字符串   
    * @param date 日期对象   
    * @param isFull 是否为完整的日期数据,   
    *               为true时, 格式如"2000-03-05 01:05:04"   
    *               为false时, 格式如 "2000-03-05"   
    * @return 符合要求的日期字符串   
    */    
    function getSmpFormatDate(date, isFull) {  
        var pattern = "";  
        if (isFull == true || isFull == undefined) {  
            pattern = "yyyy-MM-dd hh:mm:ss";  
        } else {  
            pattern = "yyyy-MM-dd";  
        }  
        return getFormatDate(date, pattern);  
    }  
    /**   
    *转换当前日期对象为日期字符串   
    * @param date 日期对象   
    * @param isFull 是否为完整的日期数据,   
    *               为true时, 格式如"2000-03-05 01:05:04"   
    *               为false时, 格式如 "2000-03-05"   
    * @return 符合要求的日期字符串   
    */    
  
    function getSmpFormatNowDate(isFull) {  
        return getSmpFormatDate(new Date(), isFull);  
    }  
    /**   
    *转换long值为日期字符串   
    * @param l long值   
    * @param isFull 是否为完整的日期数据,   
    *               为true时, 格式如"2000-03-05 01:05:04"   
    *               为false时, 格式如 "2000-03-05"   
    * @return 符合要求的日期字符串   
    */    
  
    function getSmpFormatDateByLong(l, isFull) {  
        return getSmpFormatDate(new Date(l), isFull);  
    }  
    /**   
    *转换long值为日期字符串   
    * @param l long值   
    * @param pattern 格式字符串,例如：yyyy-MM-dd hh:mm:ss   
    * @return 符合要求的日期字符串   
    */    
  
    function getFormatDateByLong(l, pattern) {  
        return getFormatDate(new Date(l), pattern);  
    }  
    /**   
    *转换日期对象为日期字符串   
    * @param l long值   
    * @param pattern 格式字符串,例如：yyyy-MM-dd hh:mm:ss   
    * @return 符合要求的日期字符串   
    */    
    function getFormatDate(date, pattern) {  
        if (date == undefined) {  
            date = new Date();  
        }  
        if (pattern == undefined) {  
            pattern = "yyyy-MM-dd hh:mm:ss";  
        }  
        return date.format(pattern);  
    }  
    
    /**
     * @description 获得URL参数信息
     * @param name 参数的KEY
     */
    function getQueryString(name) { 
    	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    	var r = window.location.search.substr(1).match(reg);
    	alert(r);
    	var href = window.location.href;
    	alert(href);
    	if (r != null) {
    		alert(unescape(r[2]));
    		return unescape(r[2]); 
    	}
    	return null; 
    } 
    
    /**
     * 注册接口
     */
	module.logInfo = logInfo;
	module.logError = logError;
	module.loadError = loadError;
	module.ajaxError = ajaxError;
	module.getSmpFormatDate = getSmpFormatDate;
	module.getSmpFormatNowDate = getSmpFormatNowDate;
	module.getSmpFormatDateByLong = getSmpFormatDateByLong;
	module.getFormatDateByLong = getFormatDateByLong;
	module.getFormatDate = getFormatDate;
	module.getQueryString = getQueryString;
	
	/**
	 * 返回接口
	 */
	return module;
	
})($, window.CommonUtils || {});