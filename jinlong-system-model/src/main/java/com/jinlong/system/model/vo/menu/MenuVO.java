/**
 * FileName: 	 MenuVO.java
 * @Description: 菜单VO视图类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年7月2日 上午11:31:08 
 **/
package com.jinlong.system.model.vo.menu;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 菜单VO视图类
 * @author:	肖学进
 * @date: 2018年7月2日 上午11:31:08
 */
@Data
public class MenuVO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1054578659923800142L;
	
	/**
	 * ID
	 */
	private Integer id;
	
	/**
	 * 父级ID
	 */
	private Integer parent;
	
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
	private Integer levelId;
    
	/**
	 * 此菜单是否为叶子节点
	 */
	private Boolean isLeaf;
	
    /**
     * 表示是否加载完成，设置为True表示加载完成，不需要在加载
     * 注意：1、一般设置此值为True，这样在点击树节点就不会再次调用后台数据，加载数据，避免数据重复
     */
    private Boolean loaded;
    
    /**
     * 表示此节点是否展开
     */
    private Boolean expanded;
	
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
	
	/**
	 * 菜单流程状态
	 */
	private int processState;
	
	/**
	 * 扩展字段
	 */
	
	/**
	 * 菜单类别名称
	 */
	private String typeName;
	
	/**
	 * 菜单级别名称
	 */
	private String levelName;
	
	/**
	 * 菜单状态名称
	 */
	private String stateName;
	
	/**
	 * 菜单流程状态名称
	 */
	private String processStateName;
	
	/**
	 * 子菜单集合
	 */
	private List<MenuVO> son = null;
	
	/**
	 * 子菜单ID的集合
	 */
	private List<Integer> menuIds;
	
	/**
	 * 子菜单分配给角色的条数
	 */
	private Integer size;
	
	/**
	 * 角色菜单ID
	 */
	private Integer roleMenuId;
	
	/**
	 * 角色ID
	 */
	private Integer roleId;

}
