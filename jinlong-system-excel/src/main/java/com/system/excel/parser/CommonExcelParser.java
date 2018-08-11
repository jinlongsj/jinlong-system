package com.system.excel.parser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.system.excel.constant.ParseFileError;
import com.system.excel.model.po.FileParseResult;
import com.system.excel.validate.CommonExcelValidate;

/**
 * @description 公共Excel文件解析器
 * @author xiaoxj
 */
public class CommonExcelParser {
	
	/**
	 * 日志记录器
	 */
	private static final Log logger = LogFactory.getLog(CommonExcelParser.class);

	/**
	 * 文件名称
	 */
	public String fileName = "";

	/**
	 * 最大行
	 */
	private Integer maxRow = Integer.valueOf(0);

	/**
	 * 最大列
	 */
	private Integer maxColumn = Integer.valueOf(0);
	
	/**
	 * 文件校验类
	 */
	private CommonExcelValidate validate;

	public CommonExcelParser(String _fileName, CommonExcelValidate _validate) {
		this.fileName = _fileName;
		this.validate = _validate;
	}

	/**
	 * 
	 * @param list
	 * @param colomnSize
	 * @param obj
	 * @return
	 */
	public FileParseResult parse(List<String> list, int colomnSize, Object obj) {
		return null;
	}

	public FileParseResult parse(List<String> list, int colomnSize) {
		return null;
	}

	/**
	 * 解析Excel头
	 * @param sheet
	 * @param parseResult
	 * @param list
	 * @param colomnSize
	 * @param obj
	 * @return
	 */
	protected FileParseResult parseHeader(XSSFSheet sheet,
			FileParseResult parseResult, List<String> list, int colomnSize,
			Object obj) {
		return null;
	}

	/**
	 * 解析Excel头
	 * @param sheet
	 * @param parseResult
	 * @param list
	 * @param colomnSize
	 * @return
	 */
	protected FileParseResult parseHeader(XSSFSheet sheet,
			FileParseResult parseResult, List<String> list, int colomnSize) {
		return null;
	}

	/**
	 * 解析sheet页
	 * @param sheet
	 * @param parseResult
	 * @param list
	 * @param colomnSize
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FileParseResult parseSheet(XSSFSheet sheet,
			FileParseResult parseResult, List<String> list, int colomnSize) {
		List parseData = new ArrayList();
		try {
			for (int r = 0; r < this.maxRow.intValue(); r++) {
				XSSFRow row = sheet.getRow(r);

				List line = parseRow(row, parseResult, colomnSize);
				parseData.add((ArrayList) line);
			}
		} catch (Exception e) {
			logger.error("parseSheet falied! " + e);
		} finally {
			parseResult.setDatas(parseData);
			parseResult.setErrorFile(ParseFileError.ERROR_SUCCESS);
			parseResult = this.validate.validate(parseResult, list);
		}
		return parseResult;
	}

	/**
	 * 解析行
	 * @param row
	 * @param parseResult
	 * @param colomnSize
	 * @return
	 */
	@SuppressWarnings({"unchecked", "rawtypes" })
	private List<Object> parseRow(XSSFRow row, FileParseResult parseResult,
			int colomnSize) {
		List line = new ArrayList();
		try {
			for (int i = 0; i < colomnSize; i++) {
				Object value = parseCell(row, i);
				line.add(value);
			}
		} catch (Exception e) {
			logger.error("parseRow falied! " + e);
		}
		return line;
	}

	/**
	 * 解析一个单元格
	 * @param row
	 * @param c
	 * @return
	 */
	private Object parseCell(XSSFRow row, int c) {
		String value = "";
		Date inputValue = null;
		try {
			XSSFCell cell = row.getCell((short) c);
			if (null != cell) {
				if (cell.getCellType() == 1) {
					value = cell.getStringCellValue();
				} else if (cell.getCellType() == 0) {
					if (DateUtil.isCellDateFormatted(cell)) {
						cell.getCellStyle().getDataFormat();

						inputValue = cell.getDateCellValue();

						return inputValue;
					}

					value = String.valueOf((int) cell.getNumericCellValue());
				} else if (cell.getCellType() == 4) {
					value = String.valueOf(cell.getStringCellValue());
				} else if (cell.getCellType() == 2) {
					value = String.valueOf(cell.getStringCellValue());
				} else if (cell.getCellType() == 3) {
					value = String.valueOf("");
				} else if (cell.getCellType() == 5) {
					value = String.valueOf(cell.getDateCellValue());
				}
			}
		} catch (Exception e) {
			logger.error("parseCell falied! " + e);
			e.printStackTrace();
		}
		return value;
	}

	public void setMaxRow(Integer maxRow) {
		this.maxRow = maxRow;
	}

	public Integer getMaxRow() {
		return this.maxRow;
	}

	public void setMaxColumn(Integer maxColumn) {
		this.maxColumn = maxColumn;
	}

	public Integer getMaxColumn() {
		return this.maxColumn;
	}
}
