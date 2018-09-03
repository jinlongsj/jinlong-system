package com.jinlong.system.model.form.user;

import java.io.Serializable;

import com.jinlong.common.model.po.page.JqPage;
import com.jinlong.system.model.vo.user.UserVO;

import lombok.Data;

/**
 * 用户VO视图Form类
 * @author asus
 */
@Data
public class UserVOForm implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5499880515646649549L;
	
	/**
	 * 提交到后台的用户VO视图类数据
	 */
	private UserVO user;
	
	/**
	 * 分页配置
	 */
	private JqPage pageInfo;

}
