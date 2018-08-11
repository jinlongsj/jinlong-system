package com.jinlong.system.service;

import java.util.List;
import java.util.Map;

import com.jinlong.system.common.utils.exception.LogicException;
import com.jinlong.system.common.utils.page.PageList;
import com.jinlong.system.common.utils.page.PageProperty;
import com.jinlong.system.model.po.page.JqPage;

/**
 * 基础VO视图类基础业务层SERVICE接口
 * @author 肖学进
 * @param <VO>
 */
public interface IBaseVOService<PO, VO> {
	
	/*
	 * 操作事物，曾、删、改、查的接口
	 */
	/**
     * 创建数据对象
     * @author Administrator
     * @param obj 实体对象
     * @return 所影响的行数
     * @throws LogicException
     */
    public int add(PO obj) throws LogicException;
    
    /**
     * 删除单条数据对象
     * @author Administrator
     * @param obj 实体对象
     * @return 所影响的行数
     * @throws LogicException
     */
    public int delete(PO obj) throws LogicException;
    
    /**
     * 删除单条数据对象
     * @author Administrator
     * @param obj 实体对象
     * @return 所影响的行数
     * @throws LogicException
     */
    public int deleteById(int id) throws LogicException;
    
    /**
     * 修改单条据对象
     * @author Administrator
     * @param obj 实体对象
     * @return 所影响的行数
     * @throws LogicException
     */
    public int update(PO obj) throws LogicException;
	
    /*
     * 不操作事务，查询 操作的接口
     */
	/**
     * 得到数据对象
     * @author Administrator
     * @param int 实体对象ID
     * @return 查询出单个对象
     * @throws LogicException
     */
    public VO find(int id) throws LogicException;
    
    /**
     * 得到数据对象列表
     * @author Administrator
     * @return 查询出对象List集合
     * @throws LogicException
     */
    public List<VO> findAll() throws LogicException;
    
    /**
     * 得到数据对象列表
     * @author Administrator
     * @param obj 实体对象
     * @return List<VO> 实体列表
     * @throws LogicException
     */
    public List<VO> findList(VO obj) throws LogicException;
    
	/**
     * 查找最新的一个对象
	 * @return
	 * @throws LogicException
	 */
	public VO findNew() throws LogicException;
	
	/**
     * 查找最新的count条对象
	 * @param count
	 * @return
	 * @throws LogicException
	 */
	public List<VO> findNewList(int count) throws LogicException;
    
    /*
     * 分页操作
     */
    /**
     * 得到数据数量按分页条数
     * @author Administrator
     * @param param 传入的Map参数pp PageProperty对象
     * @return 数据条数
     * @throws LogicException
     */
    public int findCount(Map<String,Object> param) throws LogicException;
    
    /**
     * 得到数据对象列表按分页条数，当pp.getNpageSize=0时返回所有
     * @author Administrator
     * @param param 传入的Map参数pp PageProperty对象
     * @return 查询出分页对象List集合
     * @throws LogicException
     */
    public PageList<VO> findPageList(PageProperty pp) throws LogicException;
	
	/**
	 * JQgrid分页查询
	 * @param roleVO
	 * @param pageInfo
	 * @return
	 * @throws LogicException
	 */
	public List<VO> findJqPageList(VO obj, JqPage pageInfo) throws LogicException;

}
