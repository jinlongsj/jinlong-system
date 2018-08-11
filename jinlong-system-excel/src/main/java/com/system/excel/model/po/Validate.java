package com.system.excel.model.po;

import lombok.Data;

/**
 * 每一行的校验结果细腻些
 * @author asus
 */
@Data
public class Validate {
	
	/**
	 * 校验信息ID
	 */
	private Integer validateId;
	
	/**
	 * 校验信息行号
	 */
	private Integer row;
	
	/**
	 * 校验信息详情
	 */
	private String description;
}
