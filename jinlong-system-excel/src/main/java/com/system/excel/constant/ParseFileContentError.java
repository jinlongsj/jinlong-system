package com.system.excel.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 解析文件内容出现的错误信息常亮类
 * @author xiaoxj
 */
public class ParseFileContentError {
	
	/**
	 * 默认无错误
	 */
	public static final Integer ERROR_DEFAUlT = Integer.valueOf(0);

	/**
	 * Excel表头错误
	 */
	public static final Integer HEADER_ERROR = Integer.valueOf(1);

	/**
	 * 字段为空
	 */
	public static final Integer FIELD_EMPTY = Integer.valueOf(2);

	/**
	 * 字段长度超出限制
	 */
	public static final Integer FIELD_EXCEEDS_LENGTH = Integer.valueOf(3);

	/**
	 * 字段格式错误
	 */
	public static final Integer FIELD_FORMAT_ERROR = Integer.valueOf(4);

	/**
	 * 此行在系统已经存在
	 */
	public static final Integer LINE_EXISTS = Integer.valueOf(5);

	/**
	 * 此行在Excel文件当中重复
	 */
	public static final Integer LINE_REPORT = Integer.valueOf(6);

	/**
	 * 日期格式错误
	 */
	public static final Integer DATE_FORMAT_ERROR = Integer.valueOf(7);

	/**
	 * 日期开始时间错误
	 */
	public static final Integer START_END_DATE_ERROR = Integer.valueOf(8);

	/**
	 * 日期结束时间错误
	 */
	public static final Integer DATE_RANGE_ERROR = Integer.valueOf(9);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static final Map<Integer, String> CONTENT_ERROR_MAP = new HashMap();

	static {
		CONTENT_ERROR_MAP.put(ERROR_DEFAUlT, "无错误");
		CONTENT_ERROR_MAP.put(HEADER_ERROR, "表头字段不匹配");
		CONTENT_ERROR_MAP.put(FIELD_EMPTY, "字段为空");
		CONTENT_ERROR_MAP.put(FIELD_EXCEEDS_LENGTH, "字段长度过长");
		CONTENT_ERROR_MAP.put(FIELD_FORMAT_ERROR, "字段包含特出字符格式错误");
		CONTENT_ERROR_MAP.put(LINE_EXISTS, "此行数据在系统当中已存在");
		CONTENT_ERROR_MAP.put(LINE_REPORT, "此行数据与其他行数据重复");
		CONTENT_ERROR_MAP.put(DATE_FORMAT_ERROR, "日期格式错误");
		CONTENT_ERROR_MAP.put(START_END_DATE_ERROR, "开始时间不能等于或者晚于结束时间");
		CONTENT_ERROR_MAP.put(DATE_RANGE_ERROR, "日期时间不在开始和结束时间范围之内");
	}
}
