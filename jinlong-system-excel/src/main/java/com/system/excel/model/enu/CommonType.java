package com.system.excel.model.enu;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 公共类型常量类
 * @author xiaoxj
 */
public class CommonType {
	
	public static final int FUNCTION = 1;
	public static final int PERFORMANCE = 2;
	public static final int LOCALIZATION = 3;
	public static final int SECURITY = 4;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static final Map<String, Integer> TYPE_MAP = new HashMap();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static final Map<Integer, String> TYPE_VALUE_MAP = new HashMap();
	
	static {
		TYPE_MAP.put("功能测试", Integer.valueOf(1));
		TYPE_MAP.put("性能测试", Integer.valueOf(2));
		TYPE_MAP.put("定制测试", Integer.valueOf(3));
		TYPE_MAP.put("安全测试", Integer.valueOf(4));
		TYPE_VALUE_MAP.put(Integer.valueOf(1), "功能测试");
		TYPE_VALUE_MAP.put(Integer.valueOf(2), "性能测试");
		TYPE_VALUE_MAP.put(Integer.valueOf(3), "定制测试");
		TYPE_VALUE_MAP.put(Integer.valueOf(4), "安全测试");
	}
}