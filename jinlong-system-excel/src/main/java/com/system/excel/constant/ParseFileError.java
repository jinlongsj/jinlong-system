package com.system.excel.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 解析文件结果信息常亮类
 * @author xiaoxj
 */
public class ParseFileError {
	
	/**
	 * 成功
	 */
	public static final Integer ERROR_SUCCESS = Integer.valueOf(0);

	/**
	 * 格式错误
	 */
	public static final Integer ERROR_FOMAT = Integer.valueOf(1);

	/**
	 * 字段为空
	 */
	public static final Integer ERROR_EMPTY = Integer.valueOf(2);

	/**
	 * 文件表头错误
	 */
	public static final Integer ERROR_HEADER = Integer.valueOf(3);

	/**
	 * 文件结果常量类Map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static final Map<Integer, String> ERROR_MAP = new HashMap();

	static {
		ERROR_MAP.put(ERROR_FOMAT, "格式错误");
		ERROR_MAP.put(ERROR_EMPTY, "字段为空");
		ERROR_MAP.put(ERROR_HEADER, "文件表头错误");
	}
}
