package com.jinlong.system.excel.service.user;

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

/**
 * 用户模块控制器
 * @author xjxaio
 */
public class UserExcelController extends CommonExcelController {
	
	// 日志记录器
	private static final Log logger = LogFactory.getLog(UserExcelController.class);
	
	// 用户ID
//	private static final int USER_ID = 1;
	
	// 角色ID
	private static final int ROLE_ID = 1;
	
	// 所属角色用户的扩展表ID
	private static final int AFFILIATED_ID = 2;
	
	// 用户注册时间
	private static final int REGISTER_TIME = 3;
	
	// 用户名称
	private static final int USER_NAME = 4;
	
	// 用户密码
	private static final int PASSWORD = 5;
	
	// 用户手机号码
	private static final int MOBILE_PHONE = 6;
	
	// 用户电子邮箱
	private static final int EMAIL = 7;
	
	// 用户状态
	private static final int STATE = 8;
	
	// 用户真实姓名
	private static final int REAL_NAME = 9;
	
	// 用户昵称
	private static final int NICK_NAME = 10;
	
	// 性别
	private static final int GENDER = 11;
	
	// 年龄
	private static final int AGE = 12;
	
	// 身份证号码
	private static final int ID_NUMBER = 13;
	
	// 座机号码
	private static final int TELEPHONE = 14;
	
	// 用户所在地ID
	private static final int ZONE_ID = 15;
	
	// 用户地址
	private static final int ADDRESS = 16;
	
	// 用户邮编号码
	private static final int POST_CODE = 17;
	
	// 用户个人主页网址
	private static final int HOME_PAGE = 18;
	
	// 用户QQ
	private static final int QQ_NUMBER = 19;
	
	// 用户淘宝账户
	private static final int ALI_PAY = 20;
	
	// 用户头像图片ID
	private static final int IMAGE = 21;
	
	// 用户详情描述信息
	private static final int DESCRIPTION = 22;
	
	// 用户流程状态
	private static final int PROCCESS_STATE = 23;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static final Map<Integer, String> HEADER_MAP = new HashMap();

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	private static final Map<Integer, String> USER_RESULT_MAP = new HashMap();

	static {
//		HEADER_MAP.put(Integer.valueOf(USER_ID), "用户ID");
		HEADER_MAP.put(Integer.valueOf(ROLE_ID), "角色ID");
		HEADER_MAP.put(Integer.valueOf(AFFILIATED_ID), "所属角色用户的扩展表ID");
		HEADER_MAP.put(Integer.valueOf(REGISTER_TIME), "用户注册时间");
		HEADER_MAP.put(Integer.valueOf(USER_NAME), "用户名称");
		HEADER_MAP.put(Integer.valueOf(PASSWORD), "用户密码");
		HEADER_MAP.put(Integer.valueOf(MOBILE_PHONE), "用户手机号码");
		HEADER_MAP.put(Integer.valueOf(EMAIL), "用户电子邮箱");
		HEADER_MAP.put(Integer.valueOf(STATE), "用户状态");
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
		HEADER_MAP.put(Integer.valueOf(PROCCESS_STATE), "用户流程状态");
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
			logger.error("importParseUserVO falied! " + e);
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
	 * @param userList
	 * @param path
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void exportExcelData(List<UserVO> userList, String path) {
		List excel = new ArrayList();

		String[] error = new String[1];

		ArrayList sheet = new ArrayList();
		String sheetHead = "";
		try {
			for (int i = 0; i < userList.size(); i++) {
				UserVO user = (UserVO) userList.get(i);
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
					head[16] = ((String) HEADER_MAP.get(Integer.valueOf(17)));
					head[17] = ((String) HEADER_MAP.get(Integer.valueOf(18)));
					head[18] = ((String) HEADER_MAP.get(Integer.valueOf(19)));
					head[19] = ((String) HEADER_MAP.get(Integer.valueOf(20)));
					head[20] = ((String) HEADER_MAP.get(Integer.valueOf(21)));
					head[21] = ((String) HEADER_MAP.get(Integer.valueOf(22)));
					head[22] = ((String) HEADER_MAP.get(Integer.valueOf(23)));
					sheet.add(head);
				}
				String[] columnArray = new String[16];
				columnArray[0] = user.getRoleId().toString();
				columnArray[1] = user.getAffiliatedId().toString();
				columnArray[2] = new SimpleDateFormat().format( user.getRegisterTime());
				columnArray[3] = user.getUserName();
				columnArray[4] = user.getPassword();
				columnArray[5] = user.getMobilePhone();
				columnArray[6] = user.getEmail();
				columnArray[7] = user.getRealName();
				columnArray[9] = user.getNickName();
				columnArray[8] = user.getGender();
				columnArray[10] = user.getIdNumber();
				columnArray[11] = user.getTelephone();
				columnArray[12] = user.getZoneId().toString();
				columnArray[13] = user.getAddress();
				columnArray[14] = user.getPostCode();
				columnArray[15] = user.getHomePage();
				columnArray[16] = user.getQqNumber();
				columnArray[17] = user.getAliPay();
				columnArray[18] = user.getImage().toString();
				columnArray[19] = user.getDescription();
				columnArray[20] = user.getProcessStateName();
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

	public static void exportExcelData(List<UserVO> userList,
			String[] attributeArray, String path) {
	}

	/**
	 * 导出用例Excel数据，每一条用例数据的属性
	 * @param user
	 * @param attribute
	 * @return
	 */
	public static String exportAttribute(UserVO user, Integer attribute) {
		String column = "";
		try {
			if (attribute.intValue() == 1) {
				column = user.getRoleName();
			}
			if (attribute.intValue() == 2) {
				column = user.getAffiliatedId().toString();
			}
			if (attribute.intValue() == 3) {
				column = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getRegisterTime());
			}
			if (attribute.intValue() == 4) {
				column = user.getUserName();
			}
			if (attribute.intValue() == 5) {
				column = user.getPassword();
			}
			if (attribute.intValue() == 6) {
				column = user.getMobilePhone();
			}
			if (attribute.intValue() == 7) {
				column = user.getEmail();
			}
			if (attribute.intValue() == 8) {
				column = user.getDescription();
			}
			if (attribute.intValue() == 9) {
				column = user.getStateName();
			}
			if (attribute.intValue() == 10) {
				column = user.getRealName();
			}
			if (attribute.intValue() == 11) {
				column = user.getNickName();
			}
			if (attribute.intValue() == 12) {
				column = user.getGender();
			}
			if (attribute.intValue() == 13) {
				column = user.getAge().toString();
			}
			if (attribute.intValue() == 14) {
				column = user.getIdNumber();
			}
			if (attribute.intValue() == 15) {
				column = user.getTelephone();
			}
			if (attribute.intValue() == 16) {
				column = user.getCity();
			}
			if (attribute.intValue() == 17) {
				column = user.getAddress();
			}
			if (attribute.intValue() == 18) {
				column = user.getPostCode();
			}
			if (attribute.intValue() == 19) {
				column = user.getHomePage();
			}
			if (attribute.intValue() == 20) {
				column = user.getQqNumber();
			}
			if (attribute.intValue() == 21) {
				column = user.getAliPay();
			}
			if (attribute.intValue() == 16) {
				column = user.getDescription();
			}
			if (attribute.intValue() == 16) {
				column = user.getProcessStateName();
			}
		} catch (Exception e) {
			logger.error("exportAttribute falied!" + e.getMessage());
		}
		return column;
	}

	/**
	 * 导出生成Excel文件
	 * @param userList
	 * @param path
	 */
	@SuppressWarnings("resource")
	public static void exportExcel(List<UserVO> userList, String path) {
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

			for (int i = 0; i < userList.size(); i++) {
				UserVO user = (UserVO) userList.get(i);

				XSSFRow cellRow = sheet.createRow(i + 1);
				XSSFCell rowCell = cellRow.createCell(0);
				rowCell.setCellValue(user.getRoleName());
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(1);
				rowCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getRegisterTime()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(2);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(user.getUserName()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(3);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(user.getMobilePhone()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(4);
				rowCell.setCellValue(user.getEmail());
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(5);
				rowCell.setCellValue(user.getProcessStateName());
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(6);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(user.getRealName()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(7);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(user.getNickName()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(8);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(user.getGender()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(9);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(user.getAge().toString()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(10);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(user.getIdNumber()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(11);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(user.getTelephone()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(12);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(user.getCity()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(13);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(user.getAddress()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(14);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(user.getPostCode()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(15);
				rowCell.setCellValue(HtmlUtils.htmlUnescape(user.getHomePage()));
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(16);
				rowCell.setCellValue(user.getQqNumber());
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(17);
				rowCell.setCellValue(user.getAliPay());
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(18);
				rowCell.setCellValue(user.getDescription());
				rowCell.setCellStyle(cellStyle);

				rowCell = cellRow.createCell(19);
				rowCell.setCellValue(user.getProcessStateName());
				rowCell.setCellStyle(cellStyle);
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