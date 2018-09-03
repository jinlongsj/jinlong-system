package com.jinlong.system.common.utils.json;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.jinlong.common.exception.LogicException;
import com.jinlong.common.exception.LogicExceptionMessage;

/**
 * @description：JSON工具类
 * @author Administrator
 */
public class JsonXMLUtils {
	
	private static final String PACKAGE = "com.jinlong.ssm.common.utils.json";
	
    /**
     * @param obj
     * @return
     * @throws LogicException
     */
    public static String obj2json(Object obj) throws LogicException {
        try {
			return JSON.toJSONString(obj);
		} catch (Exception e) {
			throw LogicExceptionMessage.returnLogicException(PACKAGE, 
					"obj2json", "obj2json error!", e);
		}
    }

    /**
     * @param jsonStr
     * @param clazz
     * @return
     * @throws LogicException
     */
    public static <T> T json2obj(String jsonStr, Class<T> clazz) throws LogicException {
        try {
			return JSON.parseObject(jsonStr, clazz);
		} catch (Exception e) {
			throw LogicExceptionMessage.returnLogicException(PACKAGE, 
					"json2obj", "json2obj error!", e);
		}
    }

    /**
     * @param jsonStr
     * @return
     * @throws LogicException
     */
    @SuppressWarnings("unchecked")
	public static <T> Map<String, Object> json2map(String jsonStr) throws LogicException {
    	try {
			return JSON.parseObject(jsonStr, Map.class);
		} catch (Exception e) {
			throw LogicExceptionMessage.returnLogicException(PACKAGE, 
					"json2map", "json2map error!", e);
		}
    }
  
    /**
     * @param map
     * @param clazz
     * @return
     * @throws LogicException
     */
    public static <T> T map2obj(Map<?, ?> map, Class<T> clazz) throws LogicException {
        try {
			return JSON.parseObject(JSON.toJSONString(map), clazz);
		} catch (Exception e) {
			throw LogicExceptionMessage.returnLogicException(PACKAGE, 
					"map2obj", "map2obj error!", e);
		}
    }
}
