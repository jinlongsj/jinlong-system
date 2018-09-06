/**
 * FileName: 	 ZoneInfo.java
 * @Description: 地区信息实体类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月6日 下午4:22:54 
 **/

package com.jinlong.system.model.po.zone;

import java.io.Serializable;

import lombok.Data;

/**
 * 地区信息实体类
 * @author:	肖学进
 * @date: 2018年6月6日 下午4:22:54 
 */
@Data
public class ZoneInfoPO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 672528973918793293L;
	
	/**
	 * 地区ID
	 */
	private int zoneId;
	
	/**
	 * 地区父类ID
	 */
	private int parentId;
	
	/**
	 * 地区名称
	 */
	private String zoneName;
	
	/**
	 * 地区详情
	 */
	private String description;

}
