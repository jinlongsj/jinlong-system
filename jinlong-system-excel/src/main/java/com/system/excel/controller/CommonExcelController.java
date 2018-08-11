package com.system.excel.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.system.excel.constant.ColumnToLetter;
import com.system.excel.constant.ParseFileContentError;
import com.system.excel.constant.ParseFileError;
import com.system.excel.model.po.Validate;
import com.system.excel.model.singletion.FileContentError;
import com.system.excel.service.testcase.TestcaseValidate;

/**
 * @description Excel导入导出控制器
 * @author xiaoxj
 */
public class CommonExcelController {
	
	private static final Log logger = LogFactory.getLog(CommonExcelController.class);
	
	/**
	 * 校验行号
	 */
	@SuppressWarnings("unused")
	private static final int VALIDATE_ROW = 1;
	
	/**
	 * 校验信息描述
	 */
	@SuppressWarnings("unused")
	private static final int VALIDATE_DESCRIPTION = 2;
	
	/**
	 * 校验信息Map集合
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static final Map<Integer, String> VALIDATE_HEADER_MAP = new HashMap();
	
	/**
	 * 校验的错误列号
	 */
	@SuppressWarnings("unused")
	private static final int VALIDATE_COLUMN_NUM = 1;
	
	/**
	 * 校验的错误列
	 */
	@SuppressWarnings("unused")
	private static final int VALIDATE_COLUMN = 2;
	
	/**
	 * 校验的错误信息
	 */
	@SuppressWarnings("unused")
	private static final int VALIDATE_MESSAGE = 4;
	
	/**
	 * 校验的错误信息Map集合
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static final Map<Integer, String> VALIDATE_MAP = new HashMap();

	static {
		VALIDATE_HEADER_MAP.put(Integer.valueOf(1), "校验行号");
		VALIDATE_HEADER_MAP.put(Integer.valueOf(2), "校验信息描述");
		VALIDATE_MAP.put(Integer.valueOf(1), "错误列号");
		VALIDATE_MAP.put(Integer.valueOf(2), "错误列");
		VALIDATE_MAP.put(Integer.valueOf(4), "错误信息");
	}

	/**
	 * 通过解析和校验的结果，拼接合并每一行的校验细腻些
	 * @param contentErrors
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Validate> getValidate(
			List<FileContentError> contentErrors) {
		List validateList = new ArrayList();
		try {
			if (contentErrors.size() != 0) {
				Validate validate = new Validate();
				String validateDescription = (String) VALIDATE_MAP.get(Integer
						.valueOf(1))
						+ "：{0}，"
						+ (String) VALIDATE_MAP.get(Integer.valueOf(2))
						+ "：{1}，"
						+ (String) VALIDATE_MAP.get(Integer.valueOf(4))
						+ "：{2}；";

				if (contentErrors.size() != 0) {
					combineFirstValidate(validate, validateDescription,
							(FileContentError) contentErrors.get(0));

					if (contentErrors.size() == 1) {
						validateList.add(validate);
					}
				}
				if (contentErrors.size() > 1)
					for (int i = 1; i < contentErrors.size(); i++) {
						FileContentError lastContentError = (FileContentError) contentErrors
								.get(i - 1);
						FileContentError contentError = (FileContentError) contentErrors
								.get(i);
						if (contentError.getRow() == lastContentError.getRow()) {
							combineValidate(validate, validateDescription,
									contentError);
						} else {
							if ((lastContentError.getRow().intValue() == 1)
									&& (lastContentError.getErrorType() == ParseFileContentError.HEADER_ERROR)) {
								validate.setRow(lastContentError.getRow());
							} else {
								validate.setRow(Integer
										.valueOf(lastContentError.getRow()
												.intValue() + 2));
							}
							validateList.add(validate);

							validate = new Validate();

							combineValidate(validate, validateDescription,
									contentError);
						}

						if (i != contentErrors.size() - 1)
							continue;
						validate.setRow(Integer.valueOf(contentError.getRow()
								.intValue() + 2));
						validateList.add(validate);

						validate = new Validate();

						combineValidate(validate, validateDescription,
								contentError);
					}
			}
		} catch (Exception e) {
			logger.error("getValidate falied! " + e);
			e.printStackTrace();
		}
		return validateList;
	}

	/**
	 * 合并校验总体信息：错误行数、错误烈属、错误单元格数
	 * @param validate
	 * @param validateDescription
	 * @param contentError
	 */
	public static void combineFirstValidate(Validate validate,
			String validateDescription, FileContentError contentError) {
		try {
			if (contentError.getErrorType() == ParseFileContentError.HEADER_ERROR) {
				validate.setRow(contentError.getRow());
			} else {
				validate.setRow(Integer.valueOf(contentError.getRow()
						.intValue() + 2));
			}
			validate.setDescription(MessageFormat.format(
					validateDescription,
					new Object[] {
							ColumnToLetter.LETTER_MAP.get(contentError
									.getColumn()),
							TestcaseValidate.HEADER_MAP.get(contentError
									.getColumn()),
							ParseFileContentError.CONTENT_ERROR_MAP
									.get(contentError.getErrorType()) }));
		} catch (Exception e) {
			logger.error("combineFirstValidate falied! " + e);
		}
	}

	/**
	 * 合并一行的校验信息
	 * @param validate
	 * @param validateDescription
	 * @param contentError
	 */
	public static void combineValidate(Validate validate,
			String validateDescription, FileContentError contentError) {
		try {
			if (contentError.getErrorType() != ParseFileError.ERROR_SUCCESS) {
				if ((validate.getDescription() != null)
						&& (!validate.getDescription().equals(""))) {
					validate.setDescription(validate.getDescription()
							+ MessageFormat.format(
									validateDescription,
									new Object[] {
											ColumnToLetter.LETTER_MAP
													.get(contentError
															.getColumn()),
											TestcaseValidate.HEADER_MAP
													.get(contentError
															.getColumn()),
											ParseFileContentError.CONTENT_ERROR_MAP
													.get(contentError
															.getErrorType()) }));
				} else if ((validate.getDescription() == null)
						|| (!validate.getDescription().equals(""))) {
					validate.setDescription(MessageFormat.format(
							validateDescription,
							new Object[] {
									ColumnToLetter.LETTER_MAP.get(contentError
											.getColumn()),
									TestcaseValidate.HEADER_MAP
											.get(contentError.getColumn()),
									ParseFileContentError.CONTENT_ERROR_MAP
											.get(contentError.getErrorType()) }));
				}
			}

		} catch (Exception e) {
			logger.error("combineValidate falied! " + e);
		}
	}

	/**
	 * 导出校验信息
	 * @param validateList
	 * @param path
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void exportValidate(List<Validate> validateList, String path, String sheetName) {
		List excel = new ArrayList();

		String[] error = new String[1];

		ArrayList sheet = new ArrayList();
		String sheetHead = "";
		try {
			for (int i = 0; i < validateList.size(); i++) {
				Validate validate = (Validate) validateList.get(i);

				String row = "";
				for (int index = 0; index < 2; index++) {
					if (i == 0) {
						String head = (String) VALIDATE_HEADER_MAP.get(Integer
								.valueOf(index + 1));
						sheetHead = sheetHead + head + ",";
					}

					row = row
							+ printValidateAttribute(validate,
									Integer.valueOf(index)) + ",";
				}

				if (i == 0) {
					String[] head = sheetHead.split(",");
					sheet.add(head);
				}

				String[] columnArray = row.split(",");
				sheet.add(columnArray);
			}
		} catch (Exception e) {
			logger.error("exportExcelDate falied!" + e.getMessage());
			error[0] = "用例校验导出失败！";
			sheet.add(error);
			e.printStackTrace();
		} finally {
			excel.add(sheet);
			exportExcel(sheetHead, excel, path, 2, sheetName);
		}
	}

	/**
	 * 解析校验信息
	 * @param validate
	 * @param index
	 * @return
	 */
	public static String printValidateAttribute(Validate validate, Integer index) {
		index = Integer.valueOf(index.intValue() + 1);
		String column = "";
		try {
			if (index.intValue() == 1) {
				column = String.valueOf(validate.getRow());
			}
			if (index.intValue() == 2)
				column = validate.getDescription();
		} catch (Exception e) {
			logger.error("printValidateAttribute");
		}
		return column;
	}

	/**
	 * 导出校验信息
	 * @param sheetHead
	 * @param excel
	 * @param path
	 * @param length
	 */
	@SuppressWarnings({ "rawtypes", "resource" })
	public static void exportExcel(String sheetHead,
			List<ArrayList<String[]>> excel, String path, int length, String sheetName) {
		try {
			String[] sheetnames = sheetHead.split(",");
			FileOutputStream output = new FileOutputStream(new File(path));
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFCellStyle headStyle = wb.createCellStyle();

//			headStyle.setFillForegroundColor(15);
//			headStyle.setFillPattern(9);
//
//			headStyle.setBorderBottom(1);
//			headStyle.setBorderLeft(1);
//			headStyle.setBorderTop(1);
//			headStyle.setBorderRight(1);
//
//			headStyle.setAlignment(2);
			headStyle.setWrapText(true);

			XSSFFont headFont = wb.createFont();
			headFont.setFontName("宋体");
//			headFont.setBoldweight(700);
//			headFont.setFontHeightInPoints(16);
			headStyle.setFont(headFont);

			headStyle.setWrapText(true);
			XSSFCellStyle cellStyle = wb.createCellStyle();

//			cellStyle.setBorderBottom(1);
//			cellStyle.setBorderLeft(1);
//			cellStyle.setBorderTop(1);
//			cellStyle.setBorderRight(1);
//
//			cellStyle.setAlignment(1);

			XSSFFont font = wb.createFont();
			font.setFontName("宋体");
//			font.setFontHeightInPoints(14);
			cellStyle.setFont(font);

			cellStyle.setWrapText(true);
			for (int sn = 0; sn < excel.size(); sn++) {
				XSSFSheet sheet = wb.createSheet(String.valueOf(sn));
				if (sheetnames[sn].equals("")) {
					sheetnames[sn] = "123";
				}

				wb.setSheetName(sn, "导出" + sheetName);
				ArrayList ls2 = (ArrayList) excel.get(sn);

				for (int i = 0; i < ls2.size(); i++) {
					XSSFRow row = sheet.createRow(i);
					String[] s = (String[]) ls2.get(i);

					for (int cols = 0; cols < length; cols++) {
						XSSFCell cell = row.createCell(cols);

						sheet.autoSizeColumn((short) cols);
						if (i == 0) {
							cell.setCellStyle(headStyle);
						} else {
							cell.setCellStyle(cellStyle);
						}

						cell.setCellType(1);
						if (s.length > cols) {
							cell.setCellValue(s[cols]);
						} else {
							cell.setCellValue("");
						}
					}
				}
			}
			wb.write(output);
			output.close();
		} catch (Exception e) {
			logger.error("import Excel falied!" + e.getMessage());
			e.printStackTrace();
		}
	}
	
}
