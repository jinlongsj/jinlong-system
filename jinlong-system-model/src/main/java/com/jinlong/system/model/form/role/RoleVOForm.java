package com.jinlong.system.model.form.role;

import java.io.Serializable;

import com.jinlong.system.model.po.page.JqPage;
import com.jinlong.system.model.vo.role.RoleVO;

import lombok.Data;

/**
 * 角色视图Form类
 * @author 肖学进
 */
@Data
public class RoleVOForm implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1410690879158812165L;
	
	/**
	 * 提交到后台的用户VO视图类数据
	 */
	private RoleVO role;
	
	/**
	 * 分页配置
	 */
	private JqPage pageInfo;

}
