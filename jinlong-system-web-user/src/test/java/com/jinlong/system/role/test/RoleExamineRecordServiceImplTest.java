/**
 * FileName: 	 RoleExamineRecordServiceImplTest.java
 * @Description: 角色审核记录信息Service层测试类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月7日 下午4:40:29 
 **/

package com.jinlong.system.role.test;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jinlong.common.exception.LogicException;
import com.jinlong.system.model.po.role.RoleExamineRecordPO;
import com.jinlong.system.service.role.IRoleExamineRecordService;
import com.jinlong.system.service.role.impl.RoleExamineRecordServiceImpl;

/**
 * 角色审核记录信息Service层测试类
 * @author:	肖学进
 * @date: 2018年6月7日 下午4:40:29
 */
public class RoleExamineRecordServiceImplTest {
	
	private IRoleExamineRecordService irers = null;

	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("resource")
	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-context.xml");
		irers = (RoleExamineRecordServiceImpl) ac.getBean("roleExamineRecordService");
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineRecordServiceImpl#add(com.jinlong.ssm.common.model.po.RoleExamineRecord)}.
	 */
	@Ignore
	@Test
	public void testAddRoleExamineRecord() {
//		fail("Not yet implemented");
		RoleExamineRecordPO re = new RoleExamineRecordPO();
		re.setRoleId(5);
		re.setExamineUserId(38);
		re.setExamineTime(new Date());
		re.setPass(1);
		re.setDescription("此角色信息审核通过");
		re.setState(1);
		try {
			irers.add(re);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineRecordServiceImpl#delete(com.jinlong.ssm.common.model.po.RoleExamineRecord)}.
	 */
	@Ignore
	@Test
	public void testDeleteRoleExamineRecord() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineRecordServiceImpl#deleteById(int)}.
	 */
	@Ignore
	@Test
	public void testDeleteById() {
//		fail("Not yet implemented");
		try {
			int index = irers.deleteById(2);
			System.out.println("**************************");
			System.out.println("index = " + index);
			System.out.println("**************************");
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineRecordServiceImpl#update(com.jinlong.ssm.common.model.po.RoleExamineRecord)}.
	 */
	@Ignore
	@Test
	public void testUpdateRoleExamineRecord() {
//		fail("Not yet implemented");
		RoleExamineRecordPO re = new RoleExamineRecordPO();
		re.setExamineId(3);
		re.setRoleId(2);
		re.setExamineUserId(5);
		re.setExamineTime(new Date());
		re.setPass(2);
		re.setDescription("此角色信息审核不通过");
		re.setState(2);
		try {
			irers.update(re);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineRecordServiceImpl#find(int)}.
	 */
	@Ignore
	@Test
	public void testFindInt() {
//		fail("Not yet implemented");
		try {
			RoleExamineRecordPO re = irers.find(1);
			System.out.println("**********************************************");
			System.out.println("examineId = " + re.getExamineId());
			System.out.println("roleId = " + re.getRoleId());
			System.out.println("examineUserId = " + re.getExamineUserId());
			System.out.println("examineTime = " + re.getExamineTime());
			System.out.println("pass = " + re.getPass());
			System.out.println("description = " + re.getDescription());
			System.out.println("state = " + re.getState());
			System.out.println("**********************************************");
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineRecordServiceImpl#findAll()}.
	 */
	@Ignore
	@Test
	public void testFindAll() {
//		fail("Not yet implemented");
		try {
			List<RoleExamineRecordPO> reList = irers.findAll();
			for (RoleExamineRecordPO re : reList) {
				System.out.println("**********************************************");
				System.out.println("examineId = " + re.getExamineId());
				System.out.println("roleId = " + re.getRoleId());
				System.out.println("examineUserId = " + re.getExamineUserId());
				System.out.println("examineTime = " + re.getExamineTime());
				System.out.println("pass = " + re.getPass());
				System.out.println("description = " + re.getDescription());
				System.out.println("state = " + re.getState());
				System.out.println("**********************************************");
			}
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineRecordServiceImpl#findList(com.jinlong.ssm.common.model.po.RoleExamineRecord)}.
	 */
	@Ignore
	@Test
	public void testFindListRoleExamineRecord() {
//		fail("Not yet implemented");
		RoleExamineRecordPO r = new RoleExamineRecordPO();
		r.setExamineUserId(5);
		try {
			List<RoleExamineRecordPO> reList = irers.findList(r);
			for (RoleExamineRecordPO re : reList) {
				System.out.println("**********************************************");
				System.out.println("examineId = " + re.getExamineId());
				System.out.println("roleId = " + re.getRoleId());
				System.out.println("examineUserId = " + re.getExamineUserId());
				System.out.println("examineTime = " + re.getExamineTime());
				System.out.println("pass = " + re.getPass());
				System.out.println("description = " + re.getDescription());
				System.out.println("state = " + re.getState());
				System.out.println("**********************************************");
			}
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineRecordServiceImpl#findNew()}.
	 */
	@Ignore
	@Test
	public void testFindNew() {
//		fail("Not yet implemented");
		try {
			RoleExamineRecordPO re = irers.findNew();
			System.out.println("**********************************************");
			System.out.println("examineId = " + re.getExamineId());
			System.out.println("roleId = " + re.getRoleId());
			System.out.println("examineUserId = " + re.getExamineUserId());
			System.out.println("examineTime = " + re.getExamineTime());
			System.out.println("pass = " + re.getPass());
			System.out.println("description = " + re.getDescription());
			System.out.println("state = " + re.getState());
			System.out.println("**********************************************");
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineRecordServiceImpl#findNewList(int)}.
	 */
	@Ignore
	@Test
	public void testFindNewListInt() {
//		fail("Not yet implemented");
		try {
			List<RoleExamineRecordPO> reList = irers.findNewList(3);
			for (RoleExamineRecordPO re : reList) {
				System.out.println("**********************************************");
				System.out.println("examineId = " + re.getExamineId());
				System.out.println("roleId = " + re.getRoleId());
				System.out.println("examineUserId = " + re.getExamineUserId());
				System.out.println("examineTime = " + re.getExamineTime());
				System.out.println("pass = " + re.getPass());
				System.out.println("description = " + re.getDescription());
				System.out.println("state = " + re.getState());
				System.out.println("**********************************************");
			}
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineRecordServiceImpl#findCount(java.util.Map)}.
	 */
//	@Ignore
	@Test
	public void testFindCount() {
//		fail("Not yet implemented");
		try {
			int count = irers.findCount(new HashMap<String, Object>());
			System.out.println("***********************************");
			System.out.println("count = " + count);
			System.out.println("***********************************");
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineRecordServiceImpl#findPageList(com.jinlong.ssm.common.utils.page.PageProperty)}.
	 */
	@Ignore
	@Test
	public void testFindPageListPageProperty() {
		fail("Not yet implemented");
	}

}
