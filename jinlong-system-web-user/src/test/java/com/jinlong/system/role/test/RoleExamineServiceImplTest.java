/**
 * FileName: 	 RoleExamineServiceImplTest.java
 * @Description: 角色审核信息Service层测试类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月7日 上午9:54:34 
 **/

package com.jinlong.system.role.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jinlong.common.exception.LogicException;
import com.jinlong.system.model.po.role.RoleExaminePO;
import com.jinlong.system.service.role.IRoleExamineService;
import com.jinlong.system.service.role.impl.RoleExamineServiceImpl;

/**
 * 角色审核信息Service层测试类
 * @author:	肖学进
 * @date: 2018年6月7日 上午9:54:34
 */
public class RoleExamineServiceImplTest {
	
	private IRoleExamineService ires = null;

	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("resource")
	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-context.xml");
		ires = (RoleExamineServiceImpl) ac.getBean("roleExamineService");
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineServiceImpl#add(com.jinlong.ssm.common.model.po.RoleExamine)}.
	 */
	@Ignore
	@Test
	public void testAddRoleExamine() {
//		fail("Not yet implemented");
		RoleExaminePO re = new RoleExaminePO();
		re.setRoleId(5);
		re.setExamineUserId(38);
		re.setExamineTime(new Date());
		re.setPass(1);
		re.setDescription("此角色信息审核通过");
		re.setState(1);
		try {
			ires.add(re);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineServiceImpl#delete(com.jinlong.ssm.common.model.po.RoleExamine)}.
	 */
	@Ignore
	@Test
	public void testDeleteRoleExamine() {
//		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineServiceImpl#deleteById(int)}.
	 */
	@Ignore
	@Test
	public void testDeleteById() {
//		fail("Not yet implemented");
		try {
			int index = ires.deleteById(2);
			System.out.println("**************************");
			System.out.println("index = " + index);
			System.out.println("**************************");
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineServiceImpl#update(com.jinlong.ssm.common.model.po.RoleExamine)}.
	 */
	@Ignore
	@Test
	public void testUpdateRoleExamine() {
//		fail("Not yet implemented");
		RoleExaminePO re = new RoleExaminePO();
		re.setRoleId(3);
		re.setExamineUserId(5);
		re.setExamineTime(new Date());
		re.setPass(2);
		re.setDescription("此角色信息审核不通过");
		re.setState(2);
		try {
			ires.update(re);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineServiceImpl#find(int)}.
	 */
	@Ignore
	@Test
	public void testFindInt() {
//		fail("Not yet implemented");
		try {
			RoleExaminePO re = ires.find(1);
			System.out.println("**********************************************");
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
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineServiceImpl#findAll()}.
	 */
	@Ignore
	@Test
	public void testFindAll() {
//		fail("Not yet implemented");
		try {
			List<RoleExaminePO> reList = ires.findAll();
			for (RoleExaminePO re : reList) {
				System.out.println("**********************************************");
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
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineServiceImpl#findList(com.jinlong.ssm.common.model.po.RoleExamine)}.
	 */
	@Ignore
	@Test
	public void testFindListRoleExamine() {
//		fail("Not yet implemented");
		RoleExaminePO r = new RoleExaminePO();
		r.setExamineUserId(38);
		try {
			List<RoleExaminePO> reList = ires.findList(r);
			for (RoleExaminePO re : reList) {
				System.out.println("**********************************************");
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
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineServiceImpl#findNew()}.
	 */
	@Ignore
	@Test
	public void testFindNew() {
//		fail("Not yet implemented");
		try {
			RoleExaminePO re = ires.findNew();
			System.out.println("**********************************************");
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
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineServiceImpl#findNewList(int)}.
	 */
	@Ignore
	@Test
	public void testFindNewListInt() {
//		fail("Not yet implemented");
		try {
			List<RoleExaminePO> reList = ires.findNewList(3);
			for (RoleExaminePO re : reList) {
				System.out.println("**********************************************");
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
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineServiceImpl#findCount(java.util.Map)}.
	 */
//	@Ignore
	@Test
	public void testFindCount() {
//		fail("Not yet implemented");
		try {
			int count = ires.findCount(new HashMap<String, Object>());
			System.out.println("***********************************");
			System.out.println("count = " + count);
			System.out.println("***********************************");
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleExamineServiceImpl#findPageList(com.jinlong.ssm.common.utils.page.PageProperty)}.
	 */
	@Ignore
	@Test
	public void testFindPageListPageProperty() {
//		fail("Not yet implemented");
	}

}
