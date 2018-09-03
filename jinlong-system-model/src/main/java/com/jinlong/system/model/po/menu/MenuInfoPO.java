package com.jinlong.system.model.po.menu;

import java.io.Serializable;

import lombok.Data;

/**
 * 菜单实体类
 * @author 肖学进
 */
@Data
public class MenuInfoPO implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7904587757945169232L;
	
	/**
	 * 菜单ID
	 */
	private Integer menuId;
	
	/**
	 * 菜单类别ID（前台ID、后台ID）
	 */
	private Integer typeId;
	
	/**
	 * 菜单级别
	 */
	private Integer level;
	
	/**
	 * 父菜单ID
	 */
	private Integer parentId;
	
	/**
	 * 菜单编码
	 */
	private String menuCode;
	
	/**
	 * 菜单名称
	 */
	private String menuName;
	
	/**
	 * 菜单地址
	 */
	private String menuUrl;
	
	/**
	 * 菜单图片
	 */
	private String image;
	
	/**
	 * 菜单介绍
	 */
	private String description;
	
	/**
	 * 菜单状态
	 */
	private Integer state;
	
}