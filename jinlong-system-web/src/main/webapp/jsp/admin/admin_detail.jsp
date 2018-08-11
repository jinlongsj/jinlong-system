<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="title">
    <div class="titlename">账户查看</div>
</div>
<div class="container">
	<div class="table-view">
    	<table width="100%">
    		<tr>
				<td width="200" align="right">邀请码</td>
				<td><s:property value="userBaseVO.invitationCode" /></td>
			</tr>
          	<tr>
            <td width="200" align="right">姓名/企业名称</td>
           <td colspan="2"><s:property value="userBaseVO.userRealName" /></td>
          </tr>
          <tr>
            <td align="right">账号</td>
            <td id="user_name" colspan="2"><s:property value="userBaseVO.userName"/></td>
          </tr>
          <tr>
            <td align="right">Email</td>
            <td colspan="2"><s:property value="userBaseVO.email"/></td>
          </tr>
          <tr>
			<td align="right">手机</td>
			<td colspan="2"><s:property value="userBaseVO.phoneNo"/></td>
		  </tr>
		  <tr>
			<td align="right">备注信息</td>
			<td colspan="2" style="white-space:pre-wrap;"><s:property value="userBaseVO.remarks"/>
			<!-- word-wrap : break-word;word-break: break-all; overflow:hidden; 数字换行 -->
			</td>
		  </tr>
		  <tr>
			<td align="right">最后一次登录</td>
			<td colspan="2"><s:property value="userBaseVO.usersState"/></td>
		  </tr>
          <tr>
            <td align="right">账号类型</td>
            <td colspan="2">
				<s:property value="userBaseVO.roleName"/>
			</td>
          </tr>
          <tr>
            <td align="right">账号状态</td>
           <td colspan="2">
				<s:property value="userBaseVO.userStateName"/>
			</td>
          </tr>
           <tr id="real_name_review">
            <td align="center" colspan="2">实名认证审核：</td>
          </tr>
        </table>
    </div>
    
    <div class="jfreview">
		<!--可隐藏的审批意见div-->
		<div class="seemore">
			<a id="find_review_data_btn" href="">展开审核意见</a>
		</div>
		<div class="opinion disable" id="review_data"></div>
	</div>
   
    <div class="button">
    	<input id="detail_admin_return"	name="detailTestcaseReturn" type="button" value="返  回" />
	</div>
</div>

 <!--审核实名信息pop开始-->

 </style>
    <div class="modal" id="signup-modal">
        <a class="close" data-dismiss="modal"></a>
        <h1>审核实名信息</h1>
        <div class="pop-tx">
			<table width="100%">
				<tr>
					<td valign="top" width="60%" style="height:240px;">
						<img id="head_img1" height="100%" width="100%" src="${baseUrl}/css/images/touxiang.png" />
					</td>
					<td>
						 <p>姓名：<span  id="name_realname">XXX</span></p>
						 <p>身份证号码：<span  id="number_realname">XXX</span></p>
					</td>
				</tr>
			</table>
           
          
			<form class="customForm" id="bind_review_form" name="bind_review_form">
		    	<div class="nav-form-block1">
		        	<div class="nfb1-name">审核是否通过：</div>
		            <div class="nfb1-con">
						<input id="pass_btn" name="commonReviewModel.reviewResult" type="radio" value="3" class="radio" />
						<span class="ras">通过</span>
						<input id="no_pass_btn" name="commonReviewModel.reviewResult" type="radio" value="1" class="radio" />
						<span class="ras">不通过</span>
						<span class="font03"></span>
		            </div>
		        </div>
	        	<div class="pop-infor-area">
	            	<span class="pop-infor-areabt">审核意见：</span>
	            	<textarea name="commonReviewModel.content" cols="70" rows="3"></textarea>
	            	<p>
	            		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            		<span class="pop-infor-areatips font03">限200字以内</span>
	            	</p>
	            </div>
		        <input type="hidden" id="hidden_review_type" name="commonReviewModel.reviewType" value="4" />
		        <input type="hidden" id="hidden_model_type" name="commonReviewModel.modelType" value="5" />
				<input type="hidden" id="hidden_bind_id" name="commonReviewModel.modelId" value="<s:property value="userBaseVO.id"/>" />
				<input type="hidden" id="hidden_label_id" name="commonReviewModel.modelLabel" value="2" />
	    	</form>
            <div class="pop-tx-button">
            	<input id="saveReviewbtn" type="button" class="save" value="提  交" /><input id="loadUserExtension" type="button" class="cancel" value="取 消" />
            </div>
    	</div>
    </div>
	<!--审核实名信息pop结束-->
	
<script type="text/javascript" src="${baseUrl}/js/admin/admin_detail.js"></script>
