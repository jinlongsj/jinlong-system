<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd“>
<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <meta name="_csrf" content="${_csrf.token}"/>
		<meta name="_csrf_header" content="${_csrf.headerName}"/>
	    <title>金龙智能工业物联网云平台-系统管理平台</title>
	    <!-- jQuery UI的CSS样式 -->
	    <link rel="stylesheet" type="text/css" href="<%=path%>/css/lib/jquery-ui.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/lib/jquery-ui-1.9.2.custom.min.css" />
		<!-- jQGrid表格插件CSS样式 -->
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/lib/ui.jqgrid.css" />
    	<!-- 日起选择插件样式 -->
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/lib/jquery.datetimepicker.css" />
		<!-- 时分秒选择插件样式 -->
    	<link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css" />
    	<link rel="stylesheet" type="text/css" href="<%=path%>/css/lib/jquery-ui-timepicker-addon.css" />
		<!-- webuploader文件上传CSS -->
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/lib/webuploader.css" />
		<!-- rating评价信息五角星级别插件CSS -->
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/lib/jquery.rating.css"  />
		<!-- zTree树结构插件样式 -->
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/lib/jquery.zTreeStyle.css" />
		<!-- bootstramp样式 -->
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap.min.css" />
		<!-- jBootstrapPage的分页样式 -->
    	<link rel="stylesheet" type="text/css" href="<%=path%>/css/lib/jBootsrapPage.css" />
    	<!-- 后台主页面公共样式 -->
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/lib/global.css" />
		<!-- 在线编辑器插件CSS -->
	    <link rel="stylesheet" type="text/css" href="<%=path%>/js/lib/ueditor/themes/default/css/ueditor.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/pages.css" />
	    <link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css" />
	    <link rel="stylesheet" type="text/css" href="<%=path%>/css/xiugaixinxi.css" />
	    <link rel="stylesheet" type="text/css" href="<%=path%>/css/jiaxiaoxinxi.css" />
		<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jquery/jquery-1.9.1.js"></script>
		<script type="text/javascript" charset="utf-8" src="<%=path%>/js/utils/common_security.js"></script>
		<script type="text/javascript" charset="utf-8" src="<%=path%>/js/main/menu_list.js"></script>
	</head>
	<body>
		<div class="head">
		    <div class="head_top">
		        <div class="logo">
		            <img src="<%=path%>/images/jinlong.jpg"  style="margin-left: 25px"/>
		            <span style="color: #d3d9e9">金龙智能工业物联网云平台-系统管理平台</span>
		            <ul class="ul">
		                <li class="eml"><a href=""></a></li>
		                <li>
		                    <p><img src="<%=path%>/images/jinlong.jpg" width="40px" height="45px" style="border-radius: 30px"/></p>
		                </li>
		                <li><button type="button" class="btn btn-default btn-xs" style="margin-top: 10px">退出</button></li>
		            </ul>
		        </div>
		    </div>
		</div>
		<div class="content">
		    <%-- 此处理是头部区  --%>
		    <div class="con_le">
		        <div id="firstpane" class="menu_list">
		        </div>
		    </div>
		    <!-- 各个模块信息的主页面 -->
		    <div id="main" class="con_ri"></div>
		</div>
	</body>
	<!-- jQuery UI库 -->
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jquery/jquery-1.9.1.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jquery/jquery.alerts.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jquery/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jquery/grid.locale-cn.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jquery/jquery.form.js"></script>
	<!-- JSON序列化对象类库 -->
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jquery/jquery.serializejson.js"></script>
	<!-- jqGrid 表格插件 -->
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jquery/jquery.jqGrid.min.js"></script>
	<!-- webuploader文件上传组件 -->
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/webuploader-0.1.5/webuploader.js"></script>
	<!-- 引入日期控件的脚本地址 -->
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/DatePicker/WdatePicker.js"></script>
	<!-- 时分秒控件依赖库 -->
    <script type="text/javascript" charset="utf-8" src="http://code.jquery.com/ui/1.9.1/jquery-ui.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jquery-ui/jquery-ui-timepicker-addon.js"></script>
	<!-- validate 验证插件 -->
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jquery/jquery.validate.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jquery-ui/jquery-ui-timepicker-zh-CN.js" ></script>
	<!-- 评论插件 -->
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jquery/jquery.metadata.js"></script>
	<!-- rating评论信息五角星级别插件 -->
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jquery/jquery.rating.pack.js"></script>
	<!-- ztree树形插件 -->
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jquery/jquery.ztree-2.6.min.js" ></script>
<%-- 	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/zTree_v3/js/jquery.ztree.all.min.js" ></script> --%>
	<!-- bootstrap库 -->
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/bootstrap-3.3.0/js/bootstrap.min.js"></script>
	<!-- jBootstrapPage的分页组件 -->
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/jBootstrapPage-master/jBootstrapPage.js"></script>
	<!-- 常用的JS工具类 -->
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/utils/util.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/utils/collection_utils.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/utils/common_utils.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/utils/common_page.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/utils/common_handle.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/utils/common_zone.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/utils/common_directory.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/utils/validator_util.js"></script>
	<!-- ueitor文本编辑器 -->
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/ueditor/ueditor.all.js"> </script>
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/lib/ueditor/lang/zh-cn/zh-cn.js"></script>
</html>