/**
 * FileName: 	 LoginExitController.java
 * @Description: 登陆退出Controller
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月14日 下午4:56:34 
 **/

package com.jinlong.system.web.controller.longinexit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jinlong.system.common.utils.validatecode.RandomValidateCodeUtil;

/**
 * 登陆退出Controller
 * @author:	肖学进
 * @date: 2018年6月14日 下午4:56:34
 */
@Controller
@RequestMapping("/loginExit")
public class LoginExitController {
	
	/**
	 * 日志记录器
	 */
	private static final Logger logger = LoggerFactory.getLogger(LoginExitController.class);
	
	/**
	 * 登陆页面
	 * @return
	 */
	@RequestMapping("/userLogin")
	public String userLogin() {
		return "/login";
	}
	
	/**
	 * @description 获得验证码
	 * @return
	 */
	@RequestMapping(value = "/code")
	public void code(HttpServletRequest request, HttpServletResponse response) {
	    try {
	        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
	        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
	        response.setHeader("Cache-Control", "no-cache");
	        response.setDateHeader("Expire", 0);
	        RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
	        randomValidateCode.getRandcode(request, response);//输出验证码图片方法
	    } catch (Exception e) {
	        logger.error("获取验证码失败>>>>   ", e);
	    }
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResultDTO login(@RequestBody UserBase user) {
		return null;
	}*/
	

}
