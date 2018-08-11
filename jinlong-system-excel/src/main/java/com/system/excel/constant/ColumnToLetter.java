package com.system.excel.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @description Excel表头信息
 * @author xiaoxj
 */
public class ColumnToLetter {
	
	public static final Integer LETTER_A = Integer.valueOf(1);
	public static final Integer LETTER_B = Integer.valueOf(2);
	public static final Integer LETTER_C = Integer.valueOf(3);
	public static final Integer LETTER_D = Integer.valueOf(4);
	public static final Integer LETTER_E = Integer.valueOf(5);
	public static final Integer LETTER_F = Integer.valueOf(6);
	public static final Integer LETTER_G = Integer.valueOf(7);
	public static final Integer LETTER_H = Integer.valueOf(8);
	public static final Integer LETTER_I = Integer.valueOf(9);
	public static final Integer LETTER_J = Integer.valueOf(10);
	public static final Integer LETTER_K = Integer.valueOf(11);
	public static final Integer LETTER_L = Integer.valueOf(12);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static final Map<Integer, String> LETTER_MAP = new HashMap();

	static {
		LETTER_MAP.put(LETTER_A, "A");
		LETTER_MAP.put(LETTER_B, "B");
		LETTER_MAP.put(LETTER_C, "C");
		LETTER_MAP.put(LETTER_D, "D");
		LETTER_MAP.put(LETTER_E, "E");
		LETTER_MAP.put(LETTER_F, "F");
		LETTER_MAP.put(LETTER_G, "G");
		LETTER_MAP.put(LETTER_H, "H");
		LETTER_MAP.put(LETTER_I, "I");
		LETTER_MAP.put(LETTER_J, "J");
		LETTER_MAP.put(LETTER_K, "K");
		LETTER_MAP.put(LETTER_L, "L");
	}
}