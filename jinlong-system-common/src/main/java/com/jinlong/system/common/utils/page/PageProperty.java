package com.jinlong.system.common.utils.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.Data;

/**
 * @author Administratoe
 */
@Data
public class PageProperty implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6960121950113293333L;
    /**
     * 页码
     */
    private int npage;
	/**
	 * 查询起点
	 */
	private int nfirstindex;
	/**
	 * 查询数量，表示全部
	 */
	private int npagesize;
	/**
	 * 查询条件 where field=?
	 */
	private String searchString;
	/**
	 * 排序条件 order by id desc
	 */
	private String orderString;
	/**
	 * 查询条件参数列表
	 */
	private List<Object> parameterList;
	/**
	 * 参数map
	 */
	private HashMap<String,Object> paramMap;
	
	/**
	 * 构造方法
	 * @param page
	 * @param pagesize
	 * @param searchString
	 * @param orderString
	 */
	public PageProperty(int page, int pagesize,String searchString, String orderString){
		this.npagesize = pagesize;
		this.npage = page;
		this.searchString = searchString;
		this.orderString = orderString;
	}
	
	/**
	 * 构造方法
	 */
	public PageProperty(){
	    this.npage=1;
		this.npagesize = 10;
		this.nfirstindex = 0;
		this.searchString = "";
		this.orderString = "";
	}
	public int getNfirstindex() {
	    	nfirstindex=(npage-1)*npagesize;
		return nfirstindex;
	}
	public void addParamter(Object o){//增加参数
		initParameterList();
		parameterList.add(o);
	}
	public void addParamter(int index,Object o){ //增加参数
		initParameterList();
		parameterList.add(index,o);
	}
	public void clearParamter(){ //增加参数
		initParameterList();
		parameterList.clear();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initParameterList(){//初始化参数列�?
		if(parameterList==null){
			parameterList = new ArrayList();
		}
	}
	public HashMap<String,Object> getParamMap() {
		initParamMap();
		return paramMap;
	}
	public void putParamMap(String name,Object o){ //增加参数
		initParamMap();
		paramMap.put(name,o);
	}
	public void clearParamMap(){ //增加参数
		initParamMap();
		paramMap.clear();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initParamMap(){//初始化参数列�?
		if(paramMap == null){
			paramMap = new HashMap();
		}
	}
	public int getPageStart(){
		return (npage - 1)*npagesize;
	}
	public int getPageEnd(){
		return npage*npagesize;
	}

	public int getNpage() {
		return npage;
	}

	public void setNpage(int npage) {
		this.npage = npage;
	}

	public int getNpagesize() {
		return npagesize;
	}

	public void setNpagesize(int npagesize) {
		this.npagesize = npagesize;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getOrderString() {
		return orderString;
	}

	public void setOrderString(String orderString) {
		this.orderString = orderString;
	}

	public List<Object> getParameterList() {
		return parameterList;
	}

	public void setParameterList(List<Object> parameterList) {
		this.parameterList = parameterList;
	}

	public void setNfirstindex(int nfirstindex) {
		this.nfirstindex = nfirstindex;
	}

	public void setParamMap(HashMap<String, Object> paramMap) {
		this.paramMap = paramMap;
	}
}
