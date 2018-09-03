package com.system.excel.service.user;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFPrintSetup;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.util.HtmlUtils;

import com.jinlong.common.excel.controller.CommonExcelController;
import com.jinlong.common.excel.model.singletion.FileContentError;
import com.jinlong.system.model.enums.user.UserProcessState;
import com.jinlong.system.model.enums.user.UserState;
import com.jinlong.system.model.vo.user.UserVO;
import com.system.excel.model.po.Testcase;

/**
 * 用户模块控制器
 * @author xjxaio
 */
public class UserExcelController extends CommonExcelController {
	
	// 日志记录器
	private static final Log logger = LogFactory.getLog(UserExcelController.class);
	
	// 用户ID
	private static final int USER_ID = 1;
	
	// 角色ID
	private static final int ROLE_ID = 2;
	
	// 所属角色用户的扩展表ID
	private static final int AFFILIATED_ID = 3;
	
	// 用户注册时间
	private static final int REGISTER_TIME = 4;
	
	// 用户名称
	private static final int USER_NAME = 5;
	
	// 用户密码
	private static final int PASSWORD = 6;
	
	// 用户手机号码
	private static final int MOBILE_PHONE = 7;
	
	// 用户电子邮箱
	private static final int EMAIL = 8;
	
	// 用户状态
//	private static final int STATE = 9;
	
	// 用户真实姓名
	private static final int REAL_NAME = 10;
	
	// 用户昵称
	private static final int NICK_NAME = 11;
	
	// 性别
	private static final int GENDER = 12;
	
	// 年龄
	private static final int AGE = 13;
	
	// 身份证号码
	private static final int ID_NUMBER = 14;
	
	// 座机号码
	private static final int TELEPHONE = 15;
	
	// 用户所在地ID
	private static final int ZONE_ID = 16;
	
	// 用户地址
	private static final int ADDRESS = 17;
	
	// 用户邮编号码
	private static final int POST_CODE = 18;
	
	// 用户个人主页网址
	private static final int HOME_PAGE = 19;
	
	// 用户QQ
	private static final int QQ_NUMBER = 20;
	
	// 用户淘宝账户
	private static final int ALI_PAY = 21;
	
	// 用户头像图片ID
	private static final int IMAGE = 22;
	
	// 用户详情描述信息
	private static final int DESCRIPTION = 23;
	
	// 用户流程状态
//	private static final int PROCCESS_STATE = 24;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static final Map<Integer, String> HEADER_MAP = new HashMap();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static final Map<Integer, String> TESTCASE_RESULT_MAP = new HashMap();

	static {
		HEADER_MAP.put(Integer.valueOf(USER_ID), "用户ID");
		HEADER_MAP.put(Integer.valueOf(ROLE_ID), "角色ID");
		HEADER_MAP.put(Integer.valueOf(AFFILIATED_ID), "所属角色用户的扩展表ID");
		HEADER_MAP.put(Integer.valueOf(REGISTER_TIME), "用户注册时间");
		HEADER_MAP.put(Integer.valueOf(USER_NAME), "用户名称");
		HEADER_MAP.put(Integer.valueOf(PASSWORD), "用户密码");
		HEADER_MAP.put(Integer.valueOf(MOBILE_PHONE), "用户手机号码");
		HEADER_MAP.put(Integer.valueOf(EMAIL), "用户电子邮箱");
//		HEADER_MAP.put(Integer.valueOf(STATE), "用户状态");
		HEADER_MAP.put(Integer.valueOf(REAL_NAME), "用户真实姓名");
		HEADER_MAP.put(Integer.valueOf(NICK_NAME), "用户昵称");
		HEADER_MAP.put(Integer.valueOf(GENDER), "性别");
		HEADER_MAP.put(Integer.valueOf(AGE), "年龄");
		HEADER_MAP.put(Integer.valueOf(ID_NUMBER), "身份证号码");
		HEADER_MAP.put(Integer.valueOf(TELEPHONE), "座机号码");
		HEADER_MAP.put(Integer.valueOf(ZONE_ID), "用户所在地ID");
		HEADER_MAP.put(Integer.valueOf(ADDRESS), "用户地址");
		HEADER_MAP.put(Integer.valueOf(POST_CODE), "用户邮编号码");
		HEADER_MAP.put(Integer.valueOf(HOME_PAGE), "用户个人主页网址");
		HEADER_MAP.put(Integer.valueOf(QQ_NUMBER), "用户QQ");
		HEADER_MAP.put(Integer.valueOf(ALI_PAY), "用户淘宝账户");
		HEADER_MAP.put(Integer.valueOf(IMAGE), "用户头像图片ID");
		HEADER_MAP.put(Integer.valueOf(DESCRIPTION), "用户详情信息描述");
//		HEADER_MAP.put(Integer.valueOf(PROCCESS_STATE), "用户流程状态");
	}

	/**
	 * 导入数据
	 * @param parseDatas
	 * @param contentErrors
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public static List<UserVO> getUserList(
			List<ArrayList<Object>> parseDatas,
			List<FileContentError> contentErrors) {
		// 用户集合
		List<UserVO> userList = new ArrayList<UserVO>();
		try {
			for (int i = 0; i < parseDatas.size(); i++) {
				ArrayList list = (ArrayList) parseDatas.get(i);
				UserVO user = new UserVO();
				for (int j = 0; j < list.size(); j++) {
					Object value = list.get(j);
					boolean flag = true;
					for (FileContentError contentError : contentErrors) {
						if ((contentError.getRow().intValue() == i)
								&& (contentError.getColumn().intValue() == j + 1)) {
							flag = false;
							break;
						}
					}
					if (flag == true) {
						int index = j + 1;
						user = print(Integer.valueOf(index),
								user, value);
					}
				}
				userList.add(user);
			}
		} catch (Exception e) {
			logger.error("importParseTestcase falied! " + e);
			e.printStackTrace();
		}
		return userList;
	}

	/**
	 * 导入一条用户数据
	 * @param i
	 * @param user
	 * @param value
	 * @return
	 */
	public static UserVO print(Integer i, UserVO user,
			Object value) {
		try {
			if (i.intValue() == 1) {
				user.setRoleId((Integer) value);
			}
			if (i.intValue() == 2) {
				user.setAffiliatedId((Integer) value);
			}
			if (i.intValue() == 3) {
				user.setRegisterTime((Date)value);
			}
			if (i.intValue() == 4) {
				user.setUserName((String) value);
			}
			if (i.intValue() == 5) {
				user.setPassword((String) value);
			}
			if (i.intValue() == 6) {
				user.setMobilePhone((String) value);
			}
			if (i.intValue() == 7) {
				user.setEmail((String) value);
			}
			if (i.intValue() == 8) {
				user.setState(UserState.notActive.getValue());
			}
			if (i.intValue() == 9) {
				user.setRealName((String) value);
			}
			if (i.intValue() == 10) {
				user.setNickName((String) value);
			}
			if (i.intValue() == 11) {
				user.setGender((String) value);
			}
			if (i.intValue() == 12) {
				user.setAge((Integer) value);
			}
			if (i.intValue() == 13) {
				user.setIdNumber((String) value);
			}
			if (i.intValue() == 14) {
				user.setTelephone((String) value);
			}
			if (i.intValue() == 15) {
				user.setZoneId((Integer) value);
			}
			if (i.intValue() == 16) {
				user.setAddress((String) value);
			}
			if (i.intValue() == 17) {
				user.setPostCode((String) value);
			}
			if (i.intValue() == 18) {
				user.setHomePage((String) value);
			}
			if (i.intValue() == 19) {
				user.setQqNumber((String) value);
			}
			if (i.intValue() == 20) {
				user.setAliPay((String) value);
			}
			if (i.intValue() == 21) {
				user.setImage((Integer) value);
			}
			if (i.intValue() == 22) {
				user.setDescription((String) value);
			}
			if (i.intValue() == 23) {
				user.setProcessState(UserProcessState.addUser.getValue());
			}
		} catch (Exception e) {
			logger.error("printTerstcase falied! " + e);
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 导出Excel数据
	 * @param testcaseList
	 * @param path
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void exportExcelData(List<Testcase> testcaseList, String path) {
		List excel = new ArrayList();

		String[] error = new String[1];

		ArrayList sheet = new ArrayList();
		String sheetHead = "";
		try {
			for (int i = 0; i < testcaseList.size(); i++) {
				Testcase testcase = (Testcase) testcaseList.get(i);
				// 导出Excel表头
				if (i == 0) {
					String[] head = new String[16];
					head[0] = ((String) HEADER_MAP.get(Integer.valueOf(1)));
					head[1] = ((String) HEADER_MAP.get(Integer.valueOf(2)));
					head[2] = ((String) HEADER_MAP.get(Integer.valueOf(3)));
					head[3] = ((String) HEADER_MAP.get(Integer.valueOf(4)));
					head[4] = ((String) HEADER_MAP.get(Integer.valueOf(5)));
					head[5] = ((String) HEADER_MAP.get(Integer.valueOf(6)));
					head[6] = ((String) HEADER_MAP.get(Integer.valueOf(7)));
					head[7] = ((String) HEADER_MAP.get(Integer.valueOf(8)));
					head[9] = ((String) HEADER_MAP.get(Integer.valueOf(10)));
					head[8] = ((String) HEADER_MAP.get(Integer.valueOf(9)));
					head[10] = ((String) HEADER_MAP.get(Integer.valueOf(11)));
					head[11] = ((String) HEADER_MAP.get(Integer.valueOf(12)));
					head[12] = ((String) HEADER_MAP.get(Integer.valueOf(13)));
					head[13] = ((String) HEADER_MAP.get(Integer.valueOf(14)));
					head[14] = ((String) HEADER_MAP.get(Integer.valueOf(15)));
					head[15] = ((String) HEADER_MAP.get(Integer.valueOf(16)));
					sheet.add(head);
				}
				String result = "";
				if (testcase.getPassed().intValue() == 1) {
					result = (String) TESTCASE_RESULT_MAP.get(Integer
							.valueOf(1));
				}
				if (testcase.getPassed().intValue() == 2) {
					result = (String) TESTCASE_RESULT_MAP.get(Integer
							.valueOf(2));
				}
				if (testcase.getPassed().intValue() == 3) {
					result = (String) TESTCASE_RESULT_MAP.get(Integer
							.valueOf(3));
				}
				if (testcase.getPassed().intValue() == 4) {
					result = (String) TESTCASE_RESULT_MAP.get(Integer
							.valueOf(4));
				}
				if (testcase.getPassed().intValue() == 5) {
					result = (String) TESTCASE_RESULT_MAP.get(Integer
							.valueOf(5));
				}

				String[] columnArray = new String[16];
				columnArray[0] = testcase.getProjectCode();
				columnArray[1] = testcase.getProjectName();
				columnArray[2] = testcase.getCode();
				columnArray[3] = testcase.getTestcaseName();
				columnArray[4] = testcase.getTypeName();
				columnArray[5] = testcase.getLevelName();
				columnArray[6] = testcase.getModule();
				columnArray[7] = testcase.getDescription();
				columnArray[9] = testcase.getPrecondition();
				columnArray[8] = testcase.getTestPoint();
				columnArray[10] = testcase.getTestStep();
				columnArray[11] = result;
				columnArray[12] = testcase.getTestProcess();
				columnArray[13] = testcase.getExpectedResult();
				columnArray[14] = testcase.getUserName();
				columnArray[15] = testcase.getStateName();
				sheet.add(columnArray);
			}
		} catch (Exception e) {
			logger.error("exportExcelDate falied!" + e.getMessage());
			error[0] = "用例导出失败！";
			sheet.add(error);
			e.printStackTrace();
		} finally {
			excel.add(sheet);
			exportExcel(sheetHead, excel, path, 16, "测试用例");
		}
	}

	public static void exportExcelData(List<Testcase> testcaseList,
			String[] attributeArray, String path) {
	}

	/**
	 * 导出用例Excel数据，每一条用例数据的属性
	 * @param testcase
	 * @param attribute
	 * @return
	 */
	public static String exportAttribute(Testcase testcase, Integer attribute) {
		String column = "";
		try {
			if (attribute.intValue() == 1) {
				column = testcase.getProjectCode();
			}
			if (attribute.intValue() == 2) {
				column = testcase.getProjectName();
			}
			if (attribute.intValue() == 3) {
				column = testcase.getCode();
			}
			if (attribute.intValue() == 4) {
				column = testcase.getTestcaseName();
			}
			if (attribute.intValue() == 5) {
				column = testcase.getTypeName();
			}
			if (attribute.intValue() == 6) {
				column = testcase.getLevelName();
			}
			if (attribute.intValue() == 7) {
				column = testcase.getModule();
			}
			if (attribute.intValue() == 8) {
				column = testcase.getDescription();
			}
			if (attribute.intValue() == 9) {
				column = testcase.getTestPoint();
			}
			if (attribute.intValue() == 10) {
				column = testcase.getPrecondition();
			}
			if (attribute.intValue() == 11) {
				column = testcase.getTestStep();
			}

			if (attribute.intValue() == 12) {
				if (testcase.getPassed().intValue() == 1) {
					column = (String) TESTCASE_RESULT_MAP.get(Integer
							.valueOf(1));
				}
				if (testcase.getPassed().intValue() == 2) {
					column = (String) TESTCASE_RESULT_MAP.get(Integer
							.valueOf(2));
				}
				if (testcase.getPassed().intValue() == 3) {
					column = (String) TESTCASE_RESULT_MAP.get(Integer
							.valueOf(3));
				}
				if (testcase.getPassed().intValue() == 4) {
					column = (String) TESTCASE_RESULT_MAP.get(Integer
							.valueOf(4));
				}
				if (testcase.getPassed().intValue() == 5) {
					column = (String) TESTCASE_RESULT_MAP.get(Integer
							.valueOf(5));
				}
			}
			if (attribute.intValue() == 13) {
				column = testcase.getTestProcess();
			}
			if (attribute.intValue() == 14) {
				column = testcase.getExpectedResult();
			}
			if (attribute.intValue() == 15) {
				column = testcase.getUserName();
			}
			if (attribute.intValue() == 16)
				column = testcase.getStateName();
		} catch (Exception e) {
			logger.error("exportAttribute falied!" + e.getMessage());
		}
		return column;
	}

	/**
	 * 导出生成Excel文件
	 * @param testcaseList
	 * @param path
	 */
	@SuppressWarnings("resource")
	public static void exportExcel(List<Testcase> testcaseList, String path) {
		try {
			FileOutputStream output = new FileOutputStream(new File(path));
			long start = System.currentTimeMillis();

			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFCellStyle headStyle = wb.createCellStyle();
			CreationHelper createHelper = wb.getCreationHelper();

			headStyle.setFillForegroundColor((short) 15);
			headStyle.setFillPattern((short) 9);

			headStyle.setBorderBottom((short) 1);
			headStyle.setBorderLeft((short) 1);
			headStyle.setBorderTop((short) 1);
			headStyle.setBorderRight((short) 1);

			headStyle.setAlignment((short) 2);
			headStyle.setWrapText(true);

			XSSFFont headFont = wb.createFont();
			headFont.setFontName("宋体");
			headFont.setBoldweight((short) 700);
			headFont.setFontHeightInPoints((short) 16);
			headStyle.setFont(headFont);

			headStyle.setWrapText(true);
			XSSFCellStyle cellStyle = wb.createCellStyle();

			cellStyle.setBorderBottom((short) 1);
			cellStyle.setBorderLeft((short) 1);
			cellStyle.setBorderTop((short) 1);
			cellStyle.setBorderRight((short) 1);

			cellStyle.setAlignment((short) 1);

			XSSFFont font = wb.createFont();
			font.setFontName("宋体");
			font.setFontHeightInPoints((short) 14);
			cellStyle.setFont(font);

			cellStyle.setWrapText(true);

			XSSFSheet sheet = wb.createSheet("导出测试用例");
			XSSFPrintSetup printSetup = sheet.getPrintSetup();
			printSetup.setLandscape(true);
			printSetup.setLandscape(true);
			sheet.setFitToPage(true);
			sheet.setHorizontallyCenter(true);

			XSSFRow headerRow = sheet.createRow(0);
			headerRow.setHeightInPoints(30.0F);

			XSSFCell headerCell = headerRow.createCell(0);
			headerCell.setCellValue("项目编号");
			headerCell.setCellStyle(headStyle);

			headerCell = headerRow.createCell(1);
			headerCell.setCellValue("项目名称");
			headerCell.setCellStyle(headStyle);

			headerCell = headerRow.createCell(2);
			headerCell.setCellValue("用例编号");
			headerCell.setCellStyle(headStyle);

			headerCell = headerRow.createCell(3);
			headerCell.setCellValue("用例标题");
			headerCell.setCellStyle(headStyle);

			headerCell = headerRow.createCell(4);
			headerCell.setCellValue("用例类型");
			headerCell.setCellStyle(headStyle);

			headerCell = headerRow.createCell(5);
			headerCell.setCellValue("用例等级");
			headerCell.setCellStyle(headStyle);

			headerCell = headerRow.createCell(6);
			headerCell.setCellValue("所属模块");
			headerCell.setCellStyle(headStyle);

			headerCell = headerRow.createCell(7);
			headerCell.setCellValue("用例描述");
			headerCell.setCellStyle(headStyle);

			headerCell = headerRow.createCell(8);
			headerCell.setCellValue("观察点");
			headerCell.setCellStyle(headStyle);

			headerCell = headerRow.createCell(9);
			headerCell.setCellValue("预置条件");
			headerCell.setCellStyle(headStyle);

			headerCell = headerRow.createCell(10);
			headerCell.setCellValue("测试步骤");
			headerCell.setCellStyle(headStyle);

			headerCell = headerRow.createCell(11);
			headerCell.setCellValue("执行结果");
			headerCell.setCellStyle(headStyle);

			headerCell = headerRow.createCell(12);
			headerCell.setCellValue("过程描述");
			headerCell.setCellStyle(headStyle);

			headerCell = headerRow.createCell(13);
			headerCell.setCellValue("预期结果");
			headerCell.setCellStyle(headStyle);

			headerCell = headerRow.createCell(14);
			headerCell.setCellValue("执行人");
			headerCell.setCellStyle(headStyle);

			headerCell = headerRow.createCell(15);
			headerCell.setCellValue("当前状态");
			headerCell.setCellStyle(headStyle);

			headerCell = headerRow.createCell(16);
			headerCell.setCellValue("提交时间");
			headerCell.setCellStyle(headStyle);

			headerCell = headerRow.createCell(17);
			headerCell.setCellValue("附件信息");
			headerCell.setCellStyle(headStyle);

			for (int i = 0; i < testcaseList.size(); i++) {
				Testcase testcase = (Testcase) testcaseList.get(i);

				XSSFRow cellRow = sheet.createRow(i + 1);
				XSSFCell rowCell = cellRow.createCell(0);
				rowCell.setCellValue(testcase.getProjectCode());
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(1);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(testcase
						.getProjectName()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(2);
				rowCell.setCellValue(testcase.getCode());
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(3);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(testcase
						.getTestcaseName()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(4);
				rowCell.setCellValue(testcase.getTypeName());
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(5);
				rowCell.setCellValue(testcase.getLevelName());
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(6);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(testcase
						.getModule()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(7);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(testcase
						.getDescription()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(8);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(testcase
						.getTestPoint()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(9);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(testcase
						.getPrecondition()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(10);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(testcase
						.getTestStep()));
				rowCell.setCellStyle(cellStyle);

				String execResult = "";
				if (testcase.getPassed() == null) {
					execResult = "未执行";
				}
				if (testcase.getPassed().intValue() == 0) {
					execResult = "未执行";
				}
				if (testcase.getPassed().intValue() == 1) {
					execResult = "通过";
				}
				if (testcase.getPassed().intValue() == 2) {
					execResult = "失效";
				}
				if (testcase.getPassed().intValue() == 3) {
					execResult = "阻塞";
				}
				if (testcase.getPassed().intValue() == 4) {
					execResult = "返回";
				}
				if (testcase.getPassed().intValue() == 5) {
					execResult = "未通过";
				}
				rowCell = cellRow.createCell(11);
				rowCell.setCellValue(execResult);
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(12);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(testcase
						.getTestProcess()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(13);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(testcase
						.getExpectedResult()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(14);
				rowCell.setCellValue(testcase.getUserName());
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(15);
				rowCell.setCellValue(testcase.getStateName());
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(16);
				rowCell.setCellValue(testcase.getSubmitTime() == null ? ""
						: new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
								.format(testcase.getSubmitTime()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(17);
				if ((testcase.getFileName() == null)
						|| ("".equals(testcase.getFileName()))) {
					rowCell.setCellValue("无");
					rowCell.setCellStyle(cellStyle);
				} else {
					rowCell.setCellValue(testcase.getInitName());

					Hyperlink link = rowCell.getHyperlink();
					if (link == null) {
						HyperlinkType arg0 = HyperlinkType.DOCUMENT;
						link = createHelper.createHyperlink(arg0);
//						link = createHelper.createHyperlink(4);

						link.setAddress("light_tower_files/testcaseFile/"
								+ testcase.getFileName());
						rowCell.setHyperlink(link);
					}

					XSSFCellStyle linkCellStyle = wb.createCellStyle();

					linkCellStyle.setBorderBottom((short) 1);
					linkCellStyle.setBorderLeft((short) 1);
					linkCellStyle.setBorderTop((short) 1);
					linkCellStyle.setBorderRight((short) 1);

					linkCellStyle.setAlignment((short) 1);

					XSSFFont linkFont = wb.createFont();
					linkFont.setFontName("宋体");
					linkFont.setFontHeightInPoints((short) 14);

					linkCellStyle.setWrapText(true);
					linkFont.setColor((short) 12);
					linkFont.setUnderline((byte) 1);
					linkCellStyle.setFont(linkFont);
					rowCell.setCellStyle(linkCellStyle);
				}
			}
			wb.write(output);
			output.close();
			long end = System.currentTimeMillis();
			System.out.println("用例excel组织用时....................."
					+ (end - start) + "毫秒");
		} catch (Exception e) {
			logger.error("Export Excel falied!" + e.getMessage());
			e.printStackTrace();
		}
	}
}