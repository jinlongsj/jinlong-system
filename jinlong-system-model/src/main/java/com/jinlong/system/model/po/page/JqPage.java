package com.jinlong.system.model.po.page;

import java.io.Serializable;

import lombok.Data;

/**
 * @description 后台分页组件
 * @author 肖学进
 */
@Data
public class JqPage implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6173251100210456198L;
	private Integer rows = Integer.valueOf(10);
	private Integer page = Integer.valueOf(1);
	private Integer totalPage = Integer.valueOf(0);
	private Integer record = Integer.valueOf(0);
	private String sord = "";
	private String nd = "";
	private String sidx = "";
	private String search = "";
	private Object data;

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof JqPage))
			return false;
		JqPage other = (JqPage) o;
		if (!other.canEqual(this))
			return false;
		Object this$rows = getRows();
		Object other$rows = other.getRows();
		if (this$rows == null ? other$rows != null : !this$rows
				.equals(other$rows)) {
			return false;
		}
		Object this$page = getPage();
		Object other$page = other.getPage();
		if (this$page == null ? other$page != null : !this$page
				.equals(other$page)) {
			return false;
		}
		Object this$totalPage = getTotalPage();
		Object other$totalPage = other.getTotalPage();
		if (this$totalPage == null ? other$totalPage != null : !this$totalPage
				.equals(other$totalPage)) {
			return false;
		}
		Object this$record = getRecord();
		Object other$record = other.getRecord();
		if (this$record == null ? other$record != null : !this$record
				.equals(other$record)) {
			return false;
		}
		Object this$sord = getSord();
		Object other$sord = other.getSord();
		if (this$sord == null ? other$sord != null : !this$sord
				.equals(other$sord)) {
			return false;
		}
		Object this$nd = getNd();
		Object other$nd = other.getNd();
		if (this$nd == null ? other$nd != null : !this$nd.equals(other$nd)) {
			return false;
		}
		Object this$sidx = getSidx();
		Object other$sidx = other.getSidx();
		if (this$sidx == null ? other$sidx != null : !this$sidx
				.equals(other$sidx)) {
			return false;
		}
		Object this$search = getSearch();
		Object other$search = other.getSearch();
		return this$search == null ? other$search == null : this$search
				.equals(other$search);
	}

	protected boolean canEqual(Object other) {
		return other instanceof JqPage;
	}

	@SuppressWarnings("unused")
	public int hashCode() {
		int PRIME = 59;
		int result = 1;
		Object $rows = getRows();
		result = result * 59 + ($rows == null ? 0 : $rows.hashCode());
		Object $page = getPage();
		result = result * 59 + ($page == null ? 0 : $page.hashCode());
		Object $totalPage = getTotalPage();
		result = result * 59 + ($totalPage == null ? 0 : $totalPage.hashCode());
		Object $record = getRecord();
		result = result * 59 + ($record == null ? 0 : $record.hashCode());
		Object $sord = getSord();
		result = result * 59 + ($sord == null ? 0 : $sord.hashCode());
		Object $nd = getNd();
		result = result * 59 + ($nd == null ? 0 : $nd.hashCode());
		Object $sidx = getSidx();
		result = result * 59 + ($sidx == null ? 0 : $sidx.hashCode());
		Object $search = getSearch();
		result = result * 59 + ($search == null ? 0 : $search.hashCode());
		return result;
	}

	public String toString() {
		return "JqPage(rows=" + getRows() + ", page=" + getPage()
				+ ", totalPage=" + getTotalPage() + ", record=" + getRecord()
				+ ", sord=" + getSord() + ", nd=" + getNd() + ", sidx="
				+ getSidx() + ", search=" + getSearch() + ")";
	}

}
