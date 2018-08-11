package com.jinlong.system.common.utils.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jinlong.system.common.utils.exception.LogicException;
import com.jinlong.system.common.utils.exception.LogicExceptionMessage;



/**
 * @description 分页集合组建
 * @author Administrator
 *
 * @param <T>
 */
public class PageList<T> implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6893820108903012818L;

	/**
	 * 本业务层实现类所在的包的位置和类名称
	 */
	private static final String PACKAGE = "com.jinlongshiji.common.utils.page.PageList";
	
	/**
	 * 日志记录器
	 */
	private Log logger = LogFactory.getLog(this.getClass());

	private int page = 1;
	
	private int totalRecords;
	
	private int totalPages;
	
	private int pageSize = 20;
	
	private int numbersPerBlock = 10;
	
	private List<T> records = new ArrayList<T>();
	
	private PageProperty pageProperty;

	
	private String sidx = "";
	private String sord = "";
	private String nd = "";
	private String search = "";
	
	public PageList() {

	}

	/**
	 * @param pp
	 * @param allCount
	 * @param list
	 * @throws Exception
	 */
	public PageList(PageProperty pp, int allCount, List<T> list) throws LogicException {	
		try {
			if(pp.getNpage()>0){
				this.page = pp.getNpage();
			}
			if(pp.getNpagesize()>0){
				this.pageSize = pp.getNpagesize();
			}
			this.totalRecords = allCount;
			if (totalRecords % pageSize > 0) {
				this.totalPages = totalRecords / pageSize + 1;
			} else {
				this.totalPages = totalRecords / pageSize;
			}
			this.setRecords(list);
		} catch (Exception e) {
			logger.debug("************************* new PageList ERROR *****************************************");
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "new PageList(PageProperty pp, int allCount, List<T> list)", 
					"new PageList(PageProperty pp, int allCount, List<T> list) ERROR! ", e);
		}
	}
	
	/**
	 * @param page
	 * @param pageSize
	 * @param allCount
	 * @param list
	 * @throws Exception
	 */
	public PageList(int page,int pageSize, int allCount, List<T> list) throws LogicException {
		try {
			if(page>0){
				this.page = page;
			}
			if(pageSize>0){
				this.pageSize = pageSize;
			}
			this.totalRecords = allCount;
			if (totalRecords % pageSize > 0) {
				this.totalPages = totalRecords / pageSize + 1;
			} else {
				this.totalPages = totalRecords / pageSize;
			}
			this.setRecords(list);
		} catch (Exception e) {
			logger.debug("************************* new PageList(int page,int pageSize, int allCount, List<T> list) ERROR *****************************************");
			e.printStackTrace();
			throw LogicExceptionMessage.returnLogicException(PACKAGE, "new PageList(int page,int pageSize, int allCount, List<T> list)", 
					"new PageList(int page,int pageSize, int allCount, List<T> list) ERROR! ", e);
		}
	}


	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) throws LogicException {
		if (page < 1)
			page = 1;
		this.page = page;
	}

	public int getPageNumber() {
		int pageNumber = 0;
		if (totalRecords % pageSize == 0)
			pageNumber = totalRecords / pageSize;
		else
			pageNumber = 1 + totalRecords / pageSize;

		return pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	/**
	 * first row count of current page, start from 1
	 * 
	 * @return
	 */
	public int getFirstRow() {
		return (page - 1) * pageSize + 1;
	}

	/**
	 * last row count of current page
	 * 
	 * @return
	 */
	public int getLastRow() {
		return page == getPageNumber() ? getTotalRecords() : page * pageSize;
	}

	public int getPreviousPage() {
		return page > 1 ? page - 1 : page;
	}

	public int getNextPage() {
		return page < getPageNumber() ? page + 1 : page;
	}

	public int getBlocks() {
		if (this.getPageNumber() % this.numbersPerBlock == 0) {
			return this.getPageNumber() / this.numbersPerBlock;
		} else {
			return 1 + this.getPageNumber() / this.numbersPerBlock;
		}
	}

	public int getBlock() {
		if (this.getPage() % this.numbersPerBlock == 0) {
			return this.getPage() / this.numbersPerBlock;
		} else {
			return 1 + this.getPage() / this.numbersPerBlock;
		}
	}

	public int getNumbersPerBlock() {
		return numbersPerBlock;
	}

	public void setNumbersPerBlock(int numberPerBlock) {
		this.numbersPerBlock = numberPerBlock;
	}

	public int getPageOfPrevBlock() {
		if (this.getBlock() > 1) {
			return (this.getBlock() - 1) * this.getNumbersPerBlock();
		} else {
			return 1;
		}
	}

	public int getPageOfNextBlock() {
		if (this.getBlock() < this.getBlocks()) {
			return this.getBlock() * this.getNumbersPerBlock() + 1;
		} else {
			return this.getTotalRecords();
		}
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public PageProperty getPageProperty() {
		return pageProperty;
	}

	public void setPageProperty(PageProperty pageProperty) {
		this.pageProperty = pageProperty;
	}
	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}
