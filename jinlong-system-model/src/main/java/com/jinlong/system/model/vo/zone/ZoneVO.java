package com.jinlong.system.model.vo.zone;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 地区信息表VO试图类
 * @author 肖学进
 */
@Data
public class ZoneVO implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2267100786402047216L;
	
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
	
	/**
	 * 子地区集合
	 */
	private List<ZoneVO> son;
	
	/**
	 * 子地址的长度
	 */
	private Integer size;
	
}