/**
 * FileName: 	 UserCacheManager.java
 * @Description: 用户信息缓存管理器
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年7月11日 下午3:41:42 
 **/

package com.jinlong.system.cache.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.Validate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jinlong.system.model.vo.user.UserVO;

/**
 * 用户信息缓存管理器
 * @author:	肖学进
 * @date: 2018年7月11日 下午3:41:42
 */
public class UserCacheManager {

	private static final Log logger = LogFactory.getLog(UserCacheManager.class);

	private static UserCacheManager _instance = new UserCacheManager();

	private Integer token = Integer.valueOf(0);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Map<Integer, List<UserVO>> userData = new HashMap();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Map<Integer, List<Validate>> userValidteData = new HashMap();

	public static UserCacheManager getInstance() {
		return _instance;
	}

	private UserCacheManager() {
	    this.token = Integer.valueOf(0);
	}

	@SuppressWarnings("unused")
	public synchronized Integer getFileId() {
		Integer localInteger1 = this.token;
		Integer localInteger2 = this.token = Integer.valueOf(this.token.intValue() + 1);
		return this.token;
	}

	public synchronized void putUserVO(Integer token, List<UserVO> testcaseList) {
		try {
			this.userData.put(token, testcaseList);
		} catch (Exception e) {
			logger.error("putUserVO falied");
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public synchronized List<UserVO> getUserVO(Integer token) {
		return (List) this.userData.get(token);
	}

	public synchronized void clearUserVO(Integer token) {
		try {
			this.userData.remove(token);
		} catch (Exception e) {
			logger.error("clearUserVO falied");
			e.printStackTrace();
		}
	}

	public synchronized void putUserVOVailate(Integer token, List<Validate> validateList) {
		try {
			this.userValidteData.put(token, validateList);
		} catch (Exception e) {
			logger.error("putUserVOVailate falied");
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public synchronized List<Validate> getUserVOVailate(Integer token) {
		return (List) this.userValidteData.get(token);
	}

	public synchronized void clearUserVOVailate(Integer token) {
		try {
			this.userData.remove(token);
		} catch (Exception e) {
			logger.error("clearUserVOVailate falied");
			e.printStackTrace();
		}
	}

}
