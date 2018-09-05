package com.jinlong.system.excel.service.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jinlong.common.excel.constant.ParseFileContentError;
import com.jinlong.common.excel.constant.ParseFileError;
import com.jinlong.common.excel.model.po.FileParseResult;
import com.jinlong.common.excel.model.singletion.FileContentError;
import com.jinlong.common.excel.validate.CommonExcelValidate;

/**
 * @description 测试用例模块Excel校验器
 * @author xiaoxj
 */
public class UserExcelValidate extends CommonExcelValidate {
	
	private static final Log logger = LogFactory.getLog(UserExcelValidate.class);
	public static final int TESTCASE_NAME = 1;
	public static final int TESTCASE_LEVEL = 2;
	public static final int TESTCASE_TYPE = 3;
	public static final int TESTCASE_DESCRIPTION = 4;
	public static final int TESTCASE_POINTENT = 5;
	public static final int TESTCASE_PRECONDITION = 6;
	public static final int TESTCASE_STEP = 7;
	public static final int TESTCASE_EXPECTED_RESULT = 8;
	public static final int TESTCASE_END_TIME = 9;
	public static final int TESTCASE_MODULE = 10;
	@SuppressWarnings("unused")
	private static final int TESTCASE_NAME_LENGTH = 50;
	@SuppressWarnings("unused")
	private static final int TESTCASE_LEVEL_LENGTH = 10;
	@SuppressWarnings("unused")
	private static final int TESTCASE_TYPE_LENGTH = 10;
	@SuppressWarnings("unused")
	private static final int TESTCASE_MODULE_LENGTH = 20;
	@SuppressWarnings("unused")
	private static final int TESTCASE_DESCRIPTION_LENGTH = 200;
	@SuppressWarnings("unused")
	private static final int TESTCASE_POINTENT_LENGTH = 200;
	@SuppressWarnings("unused")
	private static final int TESTCASE_PRECONDITIO_LENGTH = 200;
	@SuppressWarnings("unused")
	private static final int TESTCASE_STEP_LENGTH = 500;
	@SuppressWarnings("unused")
	private static final int TESTCASE_EXPECTED_RESULT_LENGTH = 200;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static final Map<Integer, String> HEADER_MAP = new HashMap();

	static {
		HEADER_MAP.put(Integer.valueOf(1), "用例标题");
		HEADER_MAP.put(Integer.valueOf(2), "用例级别");
		HEADER_MAP.put(Integer.valueOf(3), "用例类型");
		HEADER_MAP.put(Integer.valueOf(4), "用例描述");
		HEADER_MAP.put(Integer.valueOf(5), "测试观察点");
		HEADER_MAP.put(Integer.valueOf(6), "预置条件");
		HEADER_MAP.put(Integer.valueOf(7), "测试步骤");
		HEADER_MAP.put(Integer.valueOf(8), "预期结果");
		HEADER_MAP.put(Integer.valueOf(9), "结束时间");
		HEADER_MAP.put(Integer.valueOf(10), "所属模块");
	}

	/**
	 * 校验解析的数据
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FileParseResult validate(FileParseResult _parseResult,
			List<String> list, Object obj) {
		this.parseResult = _parseResult;

		List lineErrors = null;
		int r = 0;
		try {
			lineErrors = new ArrayList();

			this.parseResult.setHead((ArrayList) getParseResult().getDatas()
					.get(0));
			getParseResult().getDatas().remove(0);
			List localList = new ArrayList();
			for (ArrayList line : getParseResult().getDatas()) {
				localList.add((String) line.get(0));
			}
			for (ArrayList line : this.parseResult.getDatas()) {
				lineErrors = validateLine(lineErrors, line, r, list, localList,
						obj);
				r++;
			}

			if (lineErrors.size() != 0)
				this.parseResult.setErrorFile(ParseFileError.ERROR_FOMAT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.parseResult;
	}

	/* 
	 * 校验一行，返回的校验信息
	 * (non-Javadoc)
	 * @see com.jinlong.ssm.common.utils.excel.validate.FileValidate#validateLine(java.util.List, java.util.List, int, java.util.List, java.util.List, java.lang.Object)
	 */
	public List<FileContentError> validateLine(
			List<FileContentError> lineErrors, List<Object> line, int rowNum,
			List<String> list, List<String> localList, Object obj) {
		try {
			// 校验单元格A
			String field = (String) line.get(0);
			validateEmpty(field, Integer.valueOf(rowNum), Integer.valueOf(1));
			validateLength(field, Integer.valueOf(rowNum), Integer.valueOf(1),
					Integer.valueOf(50));
			validateFormat(field, Integer.valueOf(rowNum), Integer.valueOf(1));
			// 校验单元格B
			field = (String) line.get(1);
			validateEmpty(field, Integer.valueOf(rowNum), Integer.valueOf(2));
			validateLength(field, Integer.valueOf(rowNum), Integer.valueOf(2),
					Integer.valueOf(10));
			validateFileFormatByCommonLevel(field, Integer.valueOf(rowNum),
					Integer.valueOf(2));
			// 校验单元格C
			field = (String) line.get(2);
			validateEmpty(field, Integer.valueOf(rowNum), Integer.valueOf(3));
			validateLength(field, Integer.valueOf(rowNum), Integer.valueOf(3),
					Integer.valueOf(10));
			validateFileFormatByCommonType(field, Integer.valueOf(rowNum),
					Integer.valueOf(3));
			// 校验单元格D
			field = (String) line.get(3);
			validateEmpty(field, Integer.valueOf(rowNum), Integer.valueOf(4));
			validateLength(field, Integer.valueOf(rowNum), Integer.valueOf(4),
					Integer.valueOf(200));
			validateFormat(field, Integer.valueOf(rowNum), Integer.valueOf(4));
			// 校验单元格E
			field = (String) line.get(4);
			validateEmpty(field, Integer.valueOf(rowNum), Integer.valueOf(5));
			validateLength(field, Integer.valueOf(rowNum), Integer.valueOf(5),
					Integer.valueOf(200));
			validateFormat(field, Integer.valueOf(rowNum), Integer.valueOf(5));
			// 校验单元格F
			field = (String) line.get(5);
			validateEmpty(field, Integer.valueOf(rowNum), Integer.valueOf(6));
			validateLength(field, Integer.valueOf(rowNum), Integer.valueOf(6),
					Integer.valueOf(200));
			validateFormat(field, Integer.valueOf(rowNum), Integer.valueOf(6));
			// 校验单元格G
			field = (String) line.get(6);
			validateEmpty(field, Integer.valueOf(rowNum), Integer.valueOf(7));
			validateLength(field, Integer.valueOf(rowNum), Integer.valueOf(7),
					Integer.valueOf(500));
			validateFormat(field, Integer.valueOf(rowNum), Integer.valueOf(7));
			// 校验单元格H
			field = (String) line.get(7);
			validateEmpty(field, Integer.valueOf(rowNum), Integer.valueOf(8));
			validateLength(field, Integer.valueOf(rowNum), Integer.valueOf(8),
					Integer.valueOf(200));
			validateFormat(field, Integer.valueOf(rowNum), Integer.valueOf(8));
			// 校验单元格I
			if (checkDate(line.get(8))) {
				field = (String) line.get(8);

				validateDateFormat(field, Integer.valueOf(rowNum),
						Integer.valueOf(9));
			}
			field = (String) line.get(9);
			validateEmpty(field, Integer.valueOf(rowNum), Integer.valueOf(10));
			validateLength(field, Integer.valueOf(rowNum), Integer.valueOf(10),
					Integer.valueOf(20));
			validateFormat(field, Integer.valueOf(rowNum), Integer.valueOf(10));
		} catch (NumberFormatException e) {
			logger.error("validateLine falied! " + e);
		}
		return lineErrors;
	}

	/**
	 * 校验枚举
	 * @param field
	 * @param row
	 * @param column
	 */
	protected void validateFileFormatByCommonLevel(String field, Integer row,
			Integer column) {
		try {
			if ((!field.equals(""))) {
				this.parseResult.getContentErrors().add(
						new FileContentError(row, column, field,
								ParseFileContentError.FIELD_FORMAT_ERROR));

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
	 * 校验枚举
	 * @param field
	 * @param row
	 * @param column
	 */
	protected void validateFileFormatByCommonType(String field, Integer row,
			Integer column) {
		try {
			if ((!field.equals(""))) {
				this.parseResult.getContentErrors().add(
						new FileContentError(row, column, field,
								ParseFileContentError.FIELD_FORMAT_ERROR));

				this.parseResult.setErrorCellNumber(Integer
						.valueOf(this.parseResult.getErrorCellNumber()
								.intValue() + 1));
			}
		} catch (Exception e) {
			logger.error("validateDateFormat falied");
			e.printStackTrace();
		}
	}
}
