package com.jinlong.system.common.utils.exception;

import lombok.Getter;
import lombok.Setter;


/**
 * 异常实体类
 * @author 肖学进
 */
@Getter
@Setter
public class LogicException extends Exception {
	
    /**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 发生异常的包和类名称
     */
    private String exceptionPackage = "";
    
    /**
     * 发生异常的方法名称
     */
    private String exceptionMethod = "";
    
    /**
     * 发生异常的信息
     */
    private String exceptionMessage = "";

	/**
	 * @description 构造方法
	 * @param exceptionPackage
	 * @param exceptionMethod
	 * @param exceptionMessage
	 */
	public LogicException(String exceptionPackage, String exceptionMethod,
			String exceptionMessage) {
		super();
		this.exceptionPackage = exceptionPackage;
		this.exceptionMethod = exceptionMethod;
		this.exceptionMessage = exceptionMessage;
	}
	
	public String getMessage() {
		return "异常包和类：" + this.exceptionPackage + "，异常方法：" + this.exceptionMethod + "，异常信息：" + this.exceptionMessage;
	}
    
}
