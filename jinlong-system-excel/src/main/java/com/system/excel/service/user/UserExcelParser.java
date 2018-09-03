package com.system.excel.service.user;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jinlong.common.excel.constant.ParseFileContentError;
import com.jinlong.common.excel.constant.ParseFileError;
import com.jinlong.common.excel.model.po.FileParseResult;
import com.jinlong.common.excel.model.singletion.FileContentError;
import com.jinlong.common.excel.parser.CommonExcelParser;

/**
 * 测试用例模块解析器
 * @author xjxiao
 */
public class UserExcelParser extends CommonExcelParser {
	
	private static final Log logger = LogFactory.getLog(UserExcelParser.class);

	public UserExcelParser(String _fileName, UserExcelValidate _validate) {
		super(_fileName, _validate);
	}

	/**
	 * 解析测试用例Excel文件
	 */
	@SuppressWarnings("resource")
	public FileParseResult parse(List<String> list, int colomnSize) {
		FileParseResult parseResult = new FileParseResult();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(
					new File(this.fileName)));

			XSSFSheet sheet = workbook.getSheetAt(0);

			parseResult = parseHeader(sheet, parseResult, list, colomnSize);
			if (parseResult.getErrorFile() == ParseFileError.ERROR_HEADER)
				return parseResult;
		} catch (Exception e) {
			logger.error("parse falied! " + e);
			e.printStackTrace();
		}
		return parseResult;
	}

	/**
	 * 解析测试用例Excel文件表头
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected FileParseResult parseHeader(XSSFSheet sheet,
			FileParseResult parseResult, List<String> list, int colomnSize) {
		try {
			setMaxRow(Integer.valueOf(sheet.getPhysicalNumberOfRows()));
			parseResult.setRow(getMaxRow());

			XSSFRow row = sheet.getRow(0);
			int c = row.getPhysicalNumberOfCells();

			setMaxColumn(Integer.valueOf(c));
			parseResult.setColumn(getMaxColumn());

			if (c != UserExcelValidate.HEADER_MAP.size()) {
				parseResult.setErrorFile(ParseFileError.ERROR_HEADER);
			}

			List contentErrors = new ArrayList();
			
			// 解析sheet页
			parseResult = parseSheet(sheet, parseResult, list, colomnSize);

			ArrayList head = parseResult.getHead();

			for (int i = 0; i < head.size(); i++) {
				FileContentError contentError = new FileContentError();
				String value = (String) head.get(i);

				String fieldName = (String) UserExcelValidate.HEADER_MAP
						.get(Integer.valueOf(i + 1));
				if (!value.equals(fieldName)) {
					contentError.setRow(Integer.valueOf(1));
					contentError.setColumn(Integer.valueOf(i + 1));
					contentError.setField(value);
					contentError
							.setErrorType(ParseFileContentError.HEADER_ERROR);

					contentErrors.add(contentError);
				}
			}

			contentErrors.addAll(parseResult.getContentErrors());

			parseResult.setContentErrors(contentErrors);
			List datas = new ArrayList();
			datas.addAll(parseResult.getDatas());

			parseResult.setDatas(datas);
		} catch (Exception e) {
			logger.error("parseHeader falied! " + e);
			e.printStackTrace();
		}
		return parseResult;
	}
}