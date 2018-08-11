<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>



				<!-- webuploader文件上传CSS -->
				<link rel="stylesheet" type="text/css" href="<%=path%>/css/3rd_party/webuploader.css" />
	    		<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css"/>
                <div class="part3" style="display: none">
	                <!-- 驾校注册页面提交的表单 -->
	                <form id="register_school_form" name="school_register_form" method="post">
                    	<div class="item col-xs-12">
                        	驾校分类
<%--                         	<input type="radio" checked="checked" class="cla" name="dd" value="male1" style="margin: 10px"/><span style="font-size: 15px">总校</span> --%>
<%--                         	<input type="radio" class="class" name="dd" value="male" style="margin: 10px"/><span style="font-size: 15px">分校</span> --%>
                    	</div>
	                    <div class="item col-xs-12">
	                        <input type="text" id="schoolName" name="school.schoolName" placeholder="驾校名称" class="txt03 f-r3" style="margin-bottom: 20px"/>
		                    <div class="focus">驾校名称填写请保持在1-50个字符以内，其中1个汉字等于2个字符</div>
	                    </div>
	                    <div class="col-xs-12">
	                        <input type="text" id="schoolAlias" name="school.schoolAlias" placeholder="驾校别名" class="txt03 f-r3 dipe" style="margin-bottom: 20px"/>
	                        <div class="focus">驾校别名填写请保持在1-50个字符以内，其中1个汉字等于2个字符</div>
	                    </div>
	                    <div class="col-xs-12">
		                	<!-- 省 -->
		                    <select id="province" style="width:100px;"></select>
		                    <!-- 市 -->
		                    <select id="city" style="width:100px;"></select>
		                    <!-- 区县 -->
		                    <select id="region" name="school.zoneId" style="width:100px;"></select>
		                    <div class="focus">省市区县必选</div>
                    		<div class="item col-xs-12">
		                    	<input type="text" id="address" name="school.address" placeholder="报名地址" style="margin-bottom: 20px;width: 500px;border: 1px solid #cccccc;height: 35px"/>
	                        	<div class="focus">报名地址填写请保持在1-50个字符以内，其中1个汉字等于2个字符</div>
                    		</div>
                        </div>
                        <div class="col-xs-12" >
                       		<ul id="warp">
	                            <li style="position: relative">
	                                <p style="font-size: 15px;line-height: 30px">营业执照扫描件上传</p>
	                                <input type="hidden" id="schoolLicense" name="school.schoolLicense"class="active" />
	                                <img id="schoolLicenseImage" width="200" height="100" />
		                        	<div id="uploader" class="wu-example">
										<!-- 上传控件：用来存放文件信息 -->
										<div id="thelist" class="uploader-list"></div>
										<div class="btns">
											<div id="picker">选择图片</div>
											<!-- <button id="ctlBtn" class="btn btn-default">开始上传</button> -->
										</div>
									</div>
									<div class="focus"></div>
	                            </li>
	                            <li>
	                            	<input type="text" id="schoolNumber" name="school.schoolNumber" placeholder="营业执照注册号" class="txt03 f-r3"/>
		                    		<div class="focus">营业执照注册号填写请保持在1-50个字符以内，只能填写数字和英文字母</div>
	                            </li>
                            	<li>
                            		<input type="text" id="organizationName" name="school.organizationName" placeholder="机构名称" class="txt03 f-r3 required"/>
                            		<div class="focus">机构名称填写请保持在1-50个字符以内，只能填写数字和英文字母</div>
                            	</li>
	                            <li style="position: relative">
	                                <p style="font-size: 15px;line-height: 30px">道路运输经营许可证扫描件上传</p>
	                                <input type="hidden" id="transportCertificate" name="school.transportCertificate" class="active"/>
	                                <img id="transportCertificateImage" width="200" height="100" />
		                        	<div id="uploader2" class="wu-example">
										<!-- 上传控件：用来存放文件信息 -->
										<div id="thelist2" class="uploader-list"></div>
										<div class="btns">
											<div id="picker2">选择图片</div>
											<!-- <button id="ctlBtn" class="btn btn-default">开始上传</button> -->
										</div>
									</div>
									<div class="focus"></div>
	                            </li>
	                            <li>
	                            	<input type="text" id="transportNumber" name="school.transportNumber" placeholder="道路运输经营许可证编号" class="txt03 f-r3"/>
		                    		<div class="focus">道路运输经营许可证编号填写请保持在1-50个字符以内，只能填写数字和英文字母</div>
	                            </li>
	                            <li style="position: relative">
	                                <p style="font-size: 15px;line-height: 30px">认证公函扫描件上传 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" style="color: #ccc;font-size: 14px">公函模板下载</a> </p>
	                                <input type="hidden" id="certifiedLetter" name="school.certifiedLetter" class="active"/>
	                                <img id="certifiedLetterImage" width="200" height="100" />
		                        	<div id="uploader3" class="wu-example">
										<!-- 上传控件：用来存放文件信息 -->
										<div id="thelist3" class="uploader-list"></div>
										<div class="btns">
											<div id="picker3">选择图片</div>
											<!-- <button id="ctlBtn" class="btn btn-default">开始上传</button> -->
										</div>
									</div>
									<div class="focus"></div>
	                            </li>
	                        </ul>
                        </div>
	                    <div class="item col-xs-12">
	                        <span class="intelligent-label f-fl">&nbsp;</span>
	                        <div class="f-fl item-ifo">
	                            <a href="javascript:;" class="btn btn-blue f-r3" id="btn_part3" style="margin-top: 15px">下一步</a>
	                        </div>
	                    </div>
				        <!-- 遮罩层div -->
						<div id="overlay">
							<div class="overlayimage">
								<img src="<%=path%>/images/load1.gif" width="31px" height="31px"/>
								<div class="overlaytext">请等待,文件正在上传中...</div>
								<div class="cancleButton"><input type="button" id="cancleFileUpload"  value="取消"/></div>
							</div>
						</div>
						<div class="m-sPopBg" style="z-index:998;"></div>
						<div class="m-sPopCon regcon">
						    <div class="m-sPopTitle"><strong>服务协议条款</strong><b id="sPopClose" class="m-sPopClose" onClick="closeClause()">×</b></div>
						    <div class="apply_up_content">
						    	<pre class="f-r0">
								<strong>同意以下服务条款，提交注册信息</strong>
						        </pre>
						    </div>
						    <center><a class="btn btn-blue btn-lg f-size12 b-b0 b-l0 b-t0 b-r0 f-pl50 f-pr50 f-r3" href="javascript:closeClause();">已阅读并同意此条款</a></center>
						</div>
                    </form>	
                </div>
                <!-- webuploader文件上传组件 -->
				<script type="text/javascript" charset="utf-8" src="<%=path%>/js/3rd_party/webuploader.js"></script>
				<!-- 工具类JS -->
				<script type="text/javascript" charset="utf-8" src="<%=path%>/js/utils/common_handle_button.js"></script>
				<script type="text/javascript" charset="utf-8" src="<%=path%>/js/utils/common_zone.js"></script>
				<!-- 驾校基础信息注册页面JS -->
				<script type="text/javascript" src="<%=path%>/js/register/register_school.js"></script>