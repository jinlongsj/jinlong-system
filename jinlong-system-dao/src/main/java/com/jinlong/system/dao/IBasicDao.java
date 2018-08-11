package com.jinlong.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 基础持久化层公共基础DAO接口
 * @author Administrator
 * @param <T>
 */
public interface IBasicDao<T> {
	
	/*
	 * 操作事物，曾、删、改、查的接口
	 */
	/**
     * @Description:新增数据对象
     * @author Administrator
     * @param obj 实体对象
     * @return
     * @throws Exception
     */
    public int insert(T obj) throws Exception;
    
    /**
     * @Description:批量新增数据对象
     * @author Administrator
     * @param obj
     * @return
     * @throws Exception
     */
    public int batchInsert(List<T> list) throws Exception;
    
    /**
     * @Description:删除数据对象
     * @author Administrator
     * @param obj 实体对象
     * @return　受影响的行数
     * @throws Exception
     */
    public int delete(T obj) throws Exception;
    
    /**
     * @Description:通过ID删除数据对象
     * @author Administrator
     * @param id
     * @return
     * @throws Exception
     */
    public int deleteById(@Param(value = "id") int id) throws Exception;
    
    /**
     * @Description:批量删除数据对象
     * @param list
     * @return
     * @throws Exception
     */
    public int batchDelete(Integer[] list) throws Exception;
    
    /**
     * @Description:单条修改数据对象
     * @author Administrator
     * @param obj 实体对象
     * @return 受影响的行数
     * @throws Exception
     */
    public int update(T obj) throws Exception;
    
    /**
     * @Description 批量修改单挑数据
     * @param list
     * @return
     * @throws Exception
     */
    public int batchUpdate(List<T> list) throws Exception;
	
    /*
     * 不操作事务，查询 操作的接口
     */
	/**
     * @Description:得到数据对象
     * @author Administrator
     * @param id 实体对象ID
     * @return 查询出单个对象
     * @throws Exception
     */
    public T select(@Param(value = "id") int id) throws Exception;
    
    /**
     * @Description:得到数据对象列表
     * @author Administrator
     * @return 查询出对象List集合
     * @throws Exception
     */
    public List<T> selectAll() throws Exception;
    
    /**
     * @Description:得到数据对象列表
     * @author Administrator
     * @param obj 实体对象
     * @return 查询出对象List集合
     * @throws Exception
     */
    public List<T> selectList(T obj) throws Exception;
    
	/**
     * @Description:查找最新的一个对象
	 * @return
	 * @throws Exception
	 */
	public T selectNew() throws Exception;
	
	/**
     * @Description:查找最新的count条对象
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public List<T> selectNewList(@Param(value = "count") int count) throws Exception;
    
    /*
     * 分页操作
     */
    /**
     * @Description:得到数据数量按分页条数?
     * @author Administrator
     * @param param 传入的Map参数pp PageProperty对象
     * @return 数据条数
     * @throws Exception
     */
    public int getCount(Map<String, Object> param) throws Exception;
    
    /**
     * @Description:得到数据对象列表按分页条数，当pp.getNpageSize=0时返回所有
     * @author Administrator
     * @param param 传入的Map参数pp PageProperty对象
     * @return 查询出分页对象List集合
     * @throws Exception
     */
    public List<T> getSplitList(Map<String, Object> param) throws Exception;
}
