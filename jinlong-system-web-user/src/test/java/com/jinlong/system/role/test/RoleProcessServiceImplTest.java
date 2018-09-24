/**
 * FileName: 	 RoleProcessServiceImplTest.java
 * @Description: 角色流程信息Service层测试类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月7日 下午5:43:22 
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
import com.jinlong.system.model.po.role.RoleProcessPO;
import com.jinlong.system.model.vo.role.RoleProcessVO;
import com.jinlong.system.service.role.IRoleProcessService;
import com.jinlong.system.service.role.impl.RoleProcessServiceImpl;

/**
 * 角色流程信息Service层测试类
 * @author:	肖学进
 * @date: 2018年6月7日 下午5:43:22
 */
public class RoleProcessServiceImplTest {
	
	private IRoleProcessService irps = null;

	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("resource")
	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-context.xml");
		irps = (RoleProcessServiceImpl)ac.getBean("roleProcessService");
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleProcessServiceImpl#add(com.jinlong.ssm.common.model.po.RoleProcess)}.
	 */
	@Ignore
	@Test
	public void testAddRoleProcess() {
//		fail("Not yet implemented");
		RoleProcessPO rp = new RoleProcessPO();
//		rp.setExamineId(1);
		rp.setRoleId(1);
		rp.setProcessTime(new Date());
		rp.setState(5);
		try {
			irps.add(rp);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleProcessServiceImpl#delete(com.jinlong.ssm.common.model.po.RoleProcess)}.
	 */
	@Ignore
	@Test
	public void testDeleteRoleProcess() {
//		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleProcessServiceImpl#deleteById(int)}.
	 */
	@Ignore
	@Test
	public void testDeleteById() {
//		fail("Not yet implemented");
		try {
			int index = irps.deleteById(2);
			System.out.println("****************************");
			System.out.println("index = " + index);
			System.out.println("****************************");
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleProcessServiceImpl#update(com.jinlong.ssm.common.model.po.RoleProcess)}.
	 */
	@Ignore
	@Test
	public void testUpdateRoleProcess() {
//		fail("Not yet implemented");
		RoleProcessPO rp = new RoleProcessPO();
		rp.setProcessId(3);
		rp.setExamineId(2);
		rp.setProcessTime(new Date());
		rp.setState(4);
		try {
			irps.update(rp);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleProcessServiceImpl#find(int)}.
	 */
	@Ignore
	@Test
	public void testFindInt() {
//		fail("Not yet implemented");
		try {
			RoleProcessVO rp = irps.find(3);
			System.out.println("*********************************************");
			System.out.println("processId = " + rp.getProcessId());
			System.out.println("roleId = " + rp.getRoleId());
			System.out.println("roleName = " + rp.getRoleName());
			System.out.println("processTime = " + rp.getProcessTime());
			System.out.println("examineId = " + rp.getExamineId());
			System.out.println("state = " + rp.getState());
			System.out.println("examineUserId = " + rp.getExamineId());
			System.out.println("examineUserName = " + rp.getExamineUserName());
			System.out.println("passName = " + rp.getPassName());
			System.out.println("description = " + rp.getDescription());
			System.out.println("stateName = " + rp.getStateName());
			System.out.println("**********************************************");
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleProcessServiceImpl#findAll()}.
	 */
	@Ignore
	@Test
	public void testFindAll() {
//		fail("Not yet implemented");
		try {
			List<RoleProcessVO> rpList = irps.findAll();
			for (RoleProcessVO rp : rpList) {
				System.out.println("*********************************************");
				System.out.println("processId = " + rp.getProcessId());
				System.out.println("roleId = " + rp.getRoleId());
				System.out.println("roleName = " + rp.getRoleName());
				System.out.println("processTime = " + rp.getProcessTime());
				System.out.println("examineId = " + rp.getExamineId());
				System.out.println("state = " + rp.getState());
				System.out.println("examineUserId = " + rp.getExamineId());
				System.out.println("examineUserName = " + rp.getExamineUserName());
				System.out.println("passName = " + rp.getPassName());
				System.out.println("description = " + rp.getDescription());
				System.out.println("stateName = " + rp.getStateName());
				System.out.println("**********************************************");
			}
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleProcessServiceImpl#findList(com.jinlong.ssm.common.model.vo.RoleProcessVO)}.
	 */
	@Ignore
	@Test
	public void testFindListRoleProcessVO() {
//		fail("Not yet implemented");
		try {
			RoleProcessVO r = new RoleProcessVO();
			r.setState(3);
			List<RoleProcessVO> rpList = irps.findList(r);
			for (RoleProcessVO rp : rpList) {
				System.out.println("*********************************************");
				System.out.println("processId = " + rp.getProcessId());
				System.out.println("roleId = " + rp.getRoleId());
				System.out.println("roleName = " + rp.getRoleName());
				System.out.println("processTime = " + rp.getProcessTime());
				System.out.println("examineId = " + rp.getExamineId());
				System.out.println("state = " + rp.getState());
				System.out.println("examineUserId = " + rp.getExamineId());
				System.out.println("examineUserName = " + rp.getExamineUserName());
				System.out.println("passName = " + rp.getPassName());
				System.out.println("description = " + rp.getDescription());
				System.out.println("stateName = " + rp.getStateName());
				System.out.println("**********************************************");
			}
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleProcessServiceImpl#findNew()}.
	 */
	@Ignore
	@Test
	public void testFindNew() {
//		fail("Not yet implemented");
		try {
			RoleProcessVO rp = irps.findNew();
			System.out.println("*********************************************");
			System.out.println("processId = " + rp.getProcessId());
			System.out.println("roleId = " + rp.getRoleId());
			System.out.println("roleName = " + rp.getRoleName());
			System.out.println("processTime = " + rp.getProcessTime());
			System.out.println("examineId = " + rp.getExamineId());
			System.out.println("state = " + rp.getState());
			System.out.println("examineUserId = " + rp.getExamineId());
			System.out.println("examineUserName = " + rp.getExamineUserName());
			System.out.println("passName = " + rp.getPassName());
			System.out.println("description = " + rp.getDescription());
			System.out.println("stateName = " + rp.getStateName());
			System.out.println("**********************************************");
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleProcessServiceImpl#findNewList(int)}.
	 */
	@Ignore
	@Test
	public void testFindNewListInt() {
//		fail("Not yet implemented");
		try {
			List<RoleProcessVO> rpList = irps.findNewList(3);
			for (RoleProcessVO rp : rpList) {
				System.out.println("*********************************************");
				System.out.println("processId = " + rp.getProcessId());
				System.out.println("roleId = " + rp.getRoleId());
				System.out.println("roleName = " + rp.getRoleName());
				System.out.println("processTime = " + rp.getProcessTime());
				System.out.println("examineId = " + rp.getExamineId());
				System.out.println("state = " + rp.getState());
				System.out.println("examineUserId = " + rp.getExamineId());
				System.out.println("examineUserName = " + rp.getExamineUserName());
				System.out.println("passName = " + rp.getPassName());
				System.out.println("description = " + rp.getDescription());
				System.out.println("stateName = " + rp.getStateName());
				System.out.println("**********************************************");
			}
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleProcessServiceImpl#findCount(java.util.Map)}.
	 */
//	@Ignore
	@Test
	public void testFindCount() {
//		fail("Not yet implemented");
		try {
			int count = irps.findCount(new HashMap<String, Object>());
			System.out.println("***********************************");
			System.out.println("count = " + count);
			System.out.println("***********************************");
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleProcessServiceImpl#findPageList(com.jinlong.ssm.common.utils.page.PageProperty)}.
	 */
	@Ignore
	@Test
	public void testFindPageListPageProperty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.jinlong.ssm.service.role.impl.RoleProcessServiceImpl#findJqPageList(com.jinlong.ssm.common.model.vo.RoleProcessVO, com.jinlong.ssm.common.utils.page.JqPage)}.
	 */
	@Ignore
	@Test
	public void testFindJqPageListRoleProcessVOJqPage() {
		fail("Not yet implemented");
	}

}
