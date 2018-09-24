/**
 * FileName: 	 UserBasePOServiceImplTest.java
 * @Description: TODO
 * 
 * All rights Reserved, Designed By ZTE-ITS
 * Copyright:	Copyright(C) 2010-2011
 * Company   	ZTE-ITS WuXi LTD.
 * @author:		肖学进
 * @version		V1.0 
 * Createdate: 	2017年11月26日 下午12:32:20 
 **/

package com.jinlong.system.user.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jinlong.common.exception.LogicException;
import com.jinlong.common.page.PageProperty;
import com.jinlong.system.model.po.user.UserBasePO;
import com.jinlong.system.service.user.IUserBaseService;
import com.jinlong.system.service.user.impl.UserBaseServiceImpl;

/**
 * 用户基础信息Service接口测试类
 */
public class UserBaseServiceImplTest {
	
	private IUserBaseService iubs;

	/**
	 * Junit测试类初始化
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-context.xml");
		iubs = (UserBaseServiceImpl)ac.getBean("userBaseService");
	}

	/**
	 * @Description:测试“新增一条用户基础信息”
	 */
	@Ignore
	@Test
	public void testAddUserBasePO() {
//		fail("Not yet implemented");
		UserBasePO ub = new UserBasePO();
		ub.setRoleId(1);
		ub.setAffiliatedId(1);
		ub.setRegisterTime(new Date());
		ub.setUserName("admin");
		ub.setPassword("111111");
		ub.setMobilePhone("13888889999");
		ub.setEmail("admin@126.com");
		ub.setState(1);
		try {
			iubs.add(ub);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description:测试“批量新增一条用户基础信息”
	 */
	@Ignore
	@Test
	public void testBathAddUserBasePO() {
//		fail("Not yet implemented");
	}

	/**
	 * @Description:测试“删除一条用户基础信息”
	 */
	@Ignore
	@Test
	public void testDeleteUserBasePOById() {
//		fail("Not yet implemented");
		try {
			iubs.deleteById(2);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description:测试“批量删除一批用户基础信息”
	 */
	@Ignore
	@Test
	public void testBathDeleteUser() {
//		fail("Not yet implemented");
		List<Integer> userIdList = new ArrayList<Integer>();
		userIdList.add(13);
		userIdList.add(14);
		userIdList.add(16);
		try {
			iubs.bathDeleteUser(userIdList);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description:测试“编辑修改一条用户基础信息”
	 */
	@Ignore
	@Test
	public void testUpdateUserBasePO() {
//		fail("Not yet implemented");
		UserBasePO ub = new UserBasePO();
		ub.setUserId(3);
		ub.setRoleId(3);
		ub.setAffiliatedId(10);
		ub.setRegisterTime(new Date());
		ub.setUserName("肖学进");
		ub.setPassword("123456");
		ub.setMobilePhone("13991114657");
		ub.setEmail("beboyous@126.com");
		try {
			iubs.update(ub);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description:测试“通过用户ID查询这一条用户基础信息”
	 */
	@Ignore
	@Test
	public void testFindUserBasePOById() {
//		fail("Not yet implemented");
		try {
			UserBasePO ub = iubs.find(15);
			System.out.println("############################################");
			System.out.println("userId = " + ub.getUserId());
			System.out.println("roleId = " + ub.getRoleId());
			System.out.println("affiliatedId = " + ub.getAffiliatedId());
			System.out.println("registerTime = " + ub.getRegisterTime());
			System.out.println("userName = " + ub.getUsername());
			System.out.println("password = " + ub.getPassword());
			System.out.println("mobilePhonew = " + ub.getMobilePhone());
			System.out.println("email = " + ub.getEmail());
			System.out.println("state = " + ub.getState());
			System.out.println("############################################");
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description:测试“查询所有的用户基础信息”
	 */
	@Ignore
	@Test
	public void testFindAllUserBasePO() {
		try {
			List<UserBasePO> ubList = iubs.findAll();
			for (UserBasePO ub : ubList) {
				System.out.println("############################################");
				System.out.println("userId = " + ub.getUserId());
				System.out.println("roleId = " + ub.getRoleId());
				System.out.println("affiliatedId = " + ub.getAffiliatedId());
				System.out.println("registerTime = " + ub.getRegisterTime());
				System.out.println("userName = " + ub.getUsername());
				System.out.println("password = " + ub.getPassword());
				System.out.println("mobilePhonew = " + ub.getMobilePhone());
				System.out.println("email = " + ub.getEmail());
				System.out.println("state = " + ub.getState());
				System.out.println("############################################");
			}
		} catch (LogicException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * @Description:测试“查询所有的用户基础信息”
	 */
	@Ignore
	@Test
	public void testFindListUserBasePO() {
		try {
			UserBasePO ueb = new UserBasePO();
			ueb.setUserName("肖学进");
			List<UserBasePO> ubList = iubs.findList(ueb);
			for (UserBasePO ub : ubList) {
				System.out.println("############################################");
				System.out.println("userId = " + ub.getUserId());
				System.out.println("roleId = " + ub.getRoleId());
				System.out.println("affiliatedId = " + ub.getAffiliatedId());
				System.out.println("registerTime = " + ub.getRegisterTime());
				System.out.println("userName = " + ub.getUsername());
				System.out.println("password = " + ub.getPassword());
				System.out.println("mobilePhonew = " + ub.getMobilePhone());
				System.out.println("email = " + ub.getEmail());
				System.out.println("state = " + ub.getState());
				System.out.println("############################################");
			}
		} catch (LogicException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * @Description:测试“通过用户ID查询这一条用户基础信息”
	 */
	@Ignore
	@Test
	public void testFindNew() {
//		fail("Not yet implemented");
		try {
			UserBasePO ub = iubs.findNew();
			System.out.println("############################################");
			System.out.println("userId = " + ub.getUserId());
			System.out.println("roleId = " + ub.getRoleId());
			System.out.println("affiliatedId = " + ub.getAffiliatedId());
			System.out.println("registerTime = " + ub.getRegisterTime());
			System.out.println("userName = " + ub.getUsername());
			System.out.println("password = " + ub.getPassword());
			System.out.println("mobilePhonew = " + ub.getMobilePhone());
			System.out.println("email = " + ub.getEmail());
			System.out.println("state = " + ub.getState());
			System.out.println("############################################");
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description:测试“查询所有的用户基础信息”
	 */
	@Ignore
	@Test
	public void testFindNewList() {
		try {
			List<UserBasePO> ubList = iubs.findNewList(3);
			for (UserBasePO ub : ubList) {
				System.out.println("############################################");
				System.out.println("userId = " + ub.getUserId());
				System.out.println("roleId = " + ub.getRoleId());
				System.out.println("affiliatedId = " + ub.getAffiliatedId());
				System.out.println("registerTime = " + ub.getRegisterTime());
				System.out.println("userName = " + ub.getUsername());
				System.out.println("password = " + ub.getPassword());
				System.out.println("mobilePhonew = " + ub.getMobilePhone());
				System.out.println("email = " + ub.getEmail());
				System.out.println("state = " + ub.getState());
				System.out.println("############################################");
			}
		} catch (LogicException e) {
			e.printStackTrace();
		} 
	}

	@Ignore
	@Test
	public void testCount() {
		try {
			int count = iubs.findCount(new HashMap<String, Object>());
			System.out.println("########################################");
			System.out.println("count = " + count);
			System.out.println("########################################");
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testFindPageList() {
		try {
			PageProperty pp = new PageProperty();
			pp.setNpage(1);
			pp.setNpagesize(5);
			List<UserBasePO> ubList = iubs.findPageList(pp).getRecords();
			for (UserBasePO ub : ubList) {
				System.out.println("############################################");
				System.out.println("userId = " + ub.getUserId());
				System.out.println("roleId = " + ub.getRoleId());
				System.out.println("affiliatedId = " + ub.getAffiliatedId());
				System.out.println("registerTime = " + ub.getRegisterTime());
				System.out.println("userName = " + ub.getUsername());
				System.out.println("password = " + ub.getPassword());
				System.out.println("mobilePhonew = " + ub.getMobilePhone());
				System.out.println("email = " + ub.getEmail());
				System.out.println("state = " + ub.getState());
				System.out.println("############################################");
			}
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	public void testSetRegisterTimeAndPassword() {
		fail("Not yet implemented");
	}

}
