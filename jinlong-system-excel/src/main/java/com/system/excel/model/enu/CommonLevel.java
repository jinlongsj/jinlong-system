package com.system.excel.model.enu;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 模拟一个级别字典表的常量类
 * @author xiaoxj
 */
public class CommonLevel {

	public static final Integer FATAL = Integer.valueOf(1);

	public static final Integer CRITICAL = Integer.valueOf(2);

	public static final Integer MINER = Integer.valueOf(3);

	public static final Integer SUGGESTION = Integer.valueOf(4);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static final Map<String, Integer> LEVEL_MAP = new HashMap();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static final Map<Integer, String> LEVEL_VALUE_MAP = new HashMap();

	static {
		LEVEL_MAP.put("低", FATAL);
		LEVEL_MAP.put("中", CRITICAL);
		LEVEL_MAP.put("高", MINER);
		LEVEL_VALUE_MAP.put(FATAL, "低");
		LEVEL_VALUE_MAP.put(CRITICAL, "中");
		LEVEL_VALUE_MAP.put(MINER, "高");
	}
}
