package com.system.excel.model.singletion;

import java.io.Serializable;

import com.system.excel.constant.ParseFileError;

/**
 * @description 文件内容错误信息类
 * @author xiaoxj
 */
public class FileContentError implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8995550377288057844L;
	
	/**
	 * 行数
	 */
	private Integer row = Integer.valueOf(0);

	/**
	 * 列数
	 */
	private Integer column = Integer.valueOf(0);

	/**
	 * 单元格信息
	 */
	private String field = "";

	/**
	 * 错误类型
	 */
	private Integer errorType = ParseFileError.ERROR_SUCCESS;

	public FileContentError() {
	}

	public FileContentError(Integer _row, Integer _column, String _field,
			Integer _errorType) {
		this.row = _row;
		this.column = _column;
		this.field = _field;
		this.errorType = _errorType;
	}

	public Integer getRow() {
		return this.row;
	}

	public Integer getColumn() {
		return this.column;
	}

	public String getField() {
		return this.field;
	}

	public Integer getErrorType() {
		return this.errorType;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public void setColumn(Integer column) {
		this.column = column;
	}

	public void setField(String field) {
		this.field = field;
	}

	public void setErrorType(Integer errorType) {
		this.errorType = errorType;
	}
}