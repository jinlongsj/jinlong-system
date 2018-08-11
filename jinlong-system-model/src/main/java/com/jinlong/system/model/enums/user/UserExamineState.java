package com.jinlong.system.model.enums.user;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 用户审核状态
 * @author asus
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum UserExamineState implements Serializable {
	
	/**
	 * 通过审核
	 */
	passExamine(1, "通过审核"),
	
	/**
	 * 没有通过审核
	 */
	noPassExamine(2, "没有通过审核");
	
	private Integer value;
	
	private String name;

}
