package com.system.excel.validate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.system.excel.constant.ParseFileContentError;
import com.system.excel.model.po.FileParseResult;
import com.system.excel.model.singletion.FileContentError;

/**
 * 公共Excel校验器
 * @author asus
 */
public class CommonExcelValidate {

	/**
	 * 日志记录器
	 */
	private static final Log logger = LogFactory.getLog(CommonExcelValidate.class);
	
	/**
	 * Excel导入的解析结果
	 */
	protected FileParseResult parseResult;
	
	/**
	 * 日期格式字符串
	 */
	private String dateString;

	/**
	 * 校验
	 * @param _parseResult
	 * @param list
	 * @param obj
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FileParseResult validate(FileParseResult _parseResult,
			List<String> list, Object obj) {
		this.parseResult = _parseResult;

		List lineErrors = null;
		int r = 0;
		try {
			lineErrors = new ArrayList();
			for (ArrayList line : this.parseResult.getDatas()) {
				lineErrors = validateLine(lineErrors, line, r, list, obj);
				r++;
			}

			this.parseResult.setContentErrors(lineErrors);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.parseResult;
	}
	
	/**
	 * 校验
	 * @param _parseResult
	 * @param list
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FileParseResult validate(FileParseResult _parseResult,
			List<String> list) {
		this.parseResult = _parseResult;

		List lineErrors = null;
		int r = 0;
		try {
			lineErrors = new ArrayList();
			for (ArrayList line : this.parseResult.getDatas()) {
				lineErrors = validateLine(lineErrors, line, r, list);
				r++;
			}

			this.parseResult.setContentErrors(lineErrors);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.parseResult;
	}

	protected List<FileContentError> validateLine(
			List<FileContentError> lineErrors, List<Object> line, int r,
			List<String> list) {
		return null;
	}

	protected List<FileContentError> validateLine(
			List<FileContentError> lineErrors, List<Object> line, int r,
			List<String> list, List<String> localList) {
		return null;
	}

	protected List<FileContentError> validateLine(
			List<FileContentError> lineErrors, List<Object> line, int r,
			List<String> list, Object obj) {
		return null;
	}

	protected List<FileContentError> validateLine(
			List<FileContentError> lineErrors, List<Object> line, int r,
			List<String> list, List<String> localList, Object obj) {
		return null;
	}

	/**
	 * 校验此行是否存在
	 * @param field
	 * @param row
	 * @param column
	 * @param list
	 */
	protected void validateLineExists(String field, Integer row,
			Integer column, List<String> list) {
		try {
			if ((field != null) && (!field.equals("")))
				for (String code : list)
					if (field.equals(code)) {
						this.parseResult.getContentErrors().add(
								new FileContentError(row, column, field,
										ParseFileContentError.LINE_EXISTS));

						this.parseResult.setErrorCellNumber(Integer
								.valueOf(this.parseResult.getErrorCellNumber()
										.intValue() + 1));
						break;
					}
		} catch (Exception e) {
			logger.error("validateRepart falied");
			e.printStackTrace();
		}
	}

	/**
	 * 校验行重复
	 * @param field
	 * @param row
	 * @param column
	 * @param list
	 */
	protected void validateLineRepart(String field, Integer row,
			Integer column, List<String> list) {
		try {
			if ((field != null) && (!field.equals("")))
				for (int index = 0; index < list.size(); index++) {
					String code = (String) list.get(index);
					if ((!field.equals(code)) || (row.intValue() != index + 1))
						continue;
					this.parseResult.getContentErrors().add(
							new FileContentError(row, column, field,
									ParseFileContentError.LINE_REPORT));

					this.parseResult.setErrorCellNumber(Integer
							.valueOf(this.parseResult.getErrorCellNumber()
									.intValue() + 1));
					break;
				}
		} catch (Exception e) {
			logger.error("validateRepart falied");
			e.printStackTrace();
		}
	}

	/**
	 * 校验单元格是否为空
	 * @param field
	 * @param row
	 * @param column
	 */
	protected void validateEmpty(String field, Integer row, Integer column) {
		try {
			field = field.trim();
			if ((field == null) || (field.equals(""))) {
				this.parseResult.getContentErrors().add(
						new FileContentError(row, column, "",
								ParseFileContentError.FIELD_EMPTY));

				this.parseResult.setErrorCellNumber(Integer
						.valueOf(this.parseResult.getErrorCellNumber()
								.intValue() + 1));
			}
		} catch (Exception e) {
			logger.error("validateEmpty falied");
			e.printStackTrace();
		}
	}

	/**
	 * 校验单元格长度
	 * @param field
	 * @param row
	 * @param column
	 * @param standard
	 */
	protected void validateLength(String field, Integer row, Integer column,
			Integer standard) {
		try {
			if (field.length() > standard.intValue()) {
				this.parseResult.getContentErrors().add(
						new FileContentError(row, column, field,
								ParseFileContentError.FIELD_EXCEEDS_LENGTH));

				this.parseResult.setErrorCellNumber(Integer
						.valueOf(this.parseResult.getErrorCellNumber()
								.intValue() + 1));
			}
		} catch (Exception e) {
			logger.error("validateLength falied");
			e.printStackTrace();
		}
	}

	/**
	 * 校验党员个格式
	 * @param field
	 * @param row
	 * @param column
	 */
	protected void validateFormat(String field, Integer row, Integer column) {
		try {
			if ((field.indexOf("<") >= 0) || (field.indexOf(">") >= 0)) {
				this.parseResult.getContentErrors().add(
						new FileContentError(row, column, field,
								ParseFileContentError.FIELD_FORMAT_ERROR));

				this.parseResult.setErrorCellNumber(Integer
						.valueOf(this.parseResult.getErrorCellNumber()
								.intValue() + 1));
			}
		} catch (Exception e) {
			logger.error("validateFormat falied");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 校验日期格式
	 * @param field
	 * @param row
	 * @param column
	 */
	protected void validateDateFormat(String field, Integer row, Integer column) {
		try {
			if ((field != null) && (!field.equals(""))
					&& (!checkDateFormat(field))) {
				this.parseResult.getContentErrors().add(
						new FileContentError(row, column, field,
								ParseFileContentError.DATE_FORMAT_ERROR));

				this.parseResult.setErrorCellNumber(Integer
						.valueOf(this.parseResult.getErrorCellNumber()
								.intValue() + 1));
			}
		} catch (Exception e) {
			logger.error("validateDateFormat falied");
			e.printStackTrace();
		}
	}

	/**
	 * 检查日期格式
	 * @param dateString
	 * @return
	 */
	protected boolean checkDateFormat(String dateString) {
		try {
			new Date(Integer.parseInt(dateString));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 检查日期
	 * @param dateObj
	 * @return
	 */
	protected boolean checkDate(Object dateObj) {
		try {
			this.dateString = ((String) dateObj);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 校验两个日期时间是否冲突
	 * @param field1
	 * @param field2
	 * @param row
	 * @param column
	 */
	protected void validateStatrAndEndTime(Date field1, Date field2,
			Integer row, Integer column) {
		try {
			if (field1.getTime() >= field2.getTime()) {
				this.parseResult.getContentErrors().add(
						new FileContentError(row, column,
								field1.getTime() + "",
								ParseFileContentError.START_END_DATE_ERROR));

				this.parseResult.setErrorCellNumber(Integer
						.valueOf(this.parseResult.getErrorCellNumber()
								.intValue() + 1));
			}
		} catch (Exception e) {
			logger.error("validateDateFormat falied");
			e.printStackTrace();
		}
	}

	/**
	 * 校验日期时间是否在一个时间段之内
	 * @param date
	 * @param startDate
	 * @param endDate
	 * @param row
	 * @param column
	 */
	protected void validateDateRange(Date date, Date startDate, Date endDate,
			Integer row, Integer column) {
		if ((date.getTime() < startDate.getTime())
				|| (date.getTime() > endDate.getTime())) {
			this.parseResult.getContentErrors().add(
					new FileContentError(row, column, date.getTime() + "",
							ParseFileContentError.DATE_RANGE_ERROR));

			this.parseResult
					.setErrorCellNumber(Integer.valueOf(this.parseResult
							.getErrorCellNumber().intValue() + 1));
		}
	}

	public FileParseResult getParseResult() {
		return this.parseResult;
	}

	public void setParseResult(FileParseResult parseResult) {
		this.parseResult = parseResult;
	}

	public String getDateString() {
		return this.dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
}
