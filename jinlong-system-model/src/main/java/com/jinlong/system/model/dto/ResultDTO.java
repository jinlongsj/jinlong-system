package com.jinlong.system.model.dto;

import java.io.Serializable;

import com.jinlong.system.model.po.page.JqPage;

import lombok.Data;

/**
 * @description 视图层Action返给给各个客户端的数据结果集
 * @author Administrator
 */
@Data
public class ResultDTO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5315138356838689712L;
	
	/**
	 * 返回成功或者失败的执行结果（true表示成功，false便是失败）
	 */
	private boolean flag;
	
	/**
	 * 返回成功或者失败的提示信息
	 */
	private String msg;
	
	/**
	 * 返回的结果对象
	 */
	private Object obj;
	
	/**
	 * 返回的分页对象
	 */
	private JqPage pageInfo;
	
	/**
	 * @description：设置数据
	 * @param flag
	 * @param msg
	 */
	public void setValue(boolean flag, String msg) {
		this.flag = flag;
		this.msg = msg;
	}
	
	/**
	 * @description：设置数据
	 * @param flag
	 * @param msg
	 * @param obj
	 */
	public void setValue(boolean flag, String msg, Object obj) {
		this.flag = flag;
		this.msg = msg;
		this.obj = obj;
	}
	
	/**
	 * @description：设置数据
	 * @param flag
	 * @param msg
	 * @param obj
	 * @param data
	 */
	public void setValue(boolean flag, String msg, Object obj, JqPage pageInfo) {
		this.flag = flag;
		this.msg = msg;
		this.obj = obj;
		this.pageInfo = pageInfo;
	}
	
	/**
	 * @description：设置执行成功的数据
	 * @param msg
	 */
	public void setSuccess(String msg){
		this.flag = true;
		this.msg = msg + "成功！";
	}
	
	/**
	 * @description：设置执行成功的数据
	 * @param msg
	 * @param obj
	 */
	public void setSuccess(String msg, Object obj) {
		this.flag = true;
		this.msg = msg + "成功！";
		this.obj = obj;
	}
	
	/**
	 * @description：设置执行成功的数据
	 * @param msg
	 * @param obj
	 * @param pageInfo
	 */
	public void setSuccess(String msg, Object obj, JqPage pageInfo) {
		this.flag = true;
		this.msg = msg + "成功！";
		this.obj = obj;
		this.pageInfo = pageInfo;
	}
	
	/**
	 * @description：设置查询结果为空的数据
	 * @param msg
	 */
	public void setResultNull(String msg) {
		this.flag = true;
		this.msg = msg + "成功，查询结果为空！";
	}
	
	/**
	 * @description：设置查询结果为空的数据
	 * @param msg
	 * @param obj
	 */
	public void setResultNull(String msg, Object obj) {
		this.flag = true;
		this.msg = msg + "成功，查询结果为空！";
		this.obj = obj;
	}
	
	/**
	 * @description：设置查询结果为空的数据
	 * @param msg
	 * @param obj
	 * @param pageInfo
	 */
	public void setResultNull(String msg, Object obj, JqPage pageInfo) {
		this.flag = true;
		this.msg = msg + "成功，查询结果为空！";
		this.obj = obj;
		this.pageInfo = pageInfo;
	}
	
	/**
	 * @description：设置执行错误失败的数据
	 * @param msg
	 */
	public void setError(String msg){
		this.flag = false;
		this.msg = "失败！原因是：" + msg;
	}
	
	/**
	 * @description：设置执行错误失败的数据
	 * @param msg
	 * @param obj
	 */
	public void setError(String msg, Object obj) {
		this.flag = false;
		this.msg = "失败！原因是：" + msg;
		this.obj = obj;
	}
	
	/**
	 * @description：设置执行错误失败的数据
	 * @param msg
	 * @param obj
	 * @param pageInfo
	 */
	public void setError(String msg, Object obj, JqPage pageInfo) {
		this.flag = false;
		this.msg = "失败！原因是：" + msg;
		this.obj = obj;
		this.pageInfo = pageInfo;
	}
	
	/**
	 * @description：设置执行参数为空失败的数据
	 * @param msg
	 */
	public void setParameterNull(String msg){
		this.flag = false;
		this.msg = "失败，参数为空！原因是：" + msg;
	}
	
	/**
	 * @description：设置执行错误失败的数据
	 * @param msg
	 * @param obj
	 */
	public void setParameterNull(String msg, Object obj) {
		this.flag = false;
		this.msg = "失败，参数为空！原因是：" + msg;
		this.obj = obj;
	}
	
	/**
	 * @description：设置执行错误失败的数据
	 * @param msg
	 * @param obj
	 * @param pageInfo
	 */
	public void setParameterNull(String msg, Object obj, JqPage pageInfo) {
		this.flag = false;
		this.msg = "失败，参数为空！原因是：" + msg;
		this.obj = obj;
		this.pageInfo = pageInfo;
	}
	
	/**
	 * @description：设置执行异常失败的数据
	 * @param msg
	 */
	public void setException(String msg){
		this.flag = false;
		this.msg = "失败！原因是：" + msg;
	}
	
	/**
	 * @description：设置执行异常失败的数据
	 * @param constantMsg
	 * @param msg
	 */
	public void setException(String constantMsg, String msg) {
		this.flag = false;
		this.msg = constantMsg + "失败！原因是：" + msg;
	}
	
}