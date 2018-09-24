/**
 * FileName: 	 RoleServiceImplTest.java
 * @Description: 角色信息Service业务层测试类
 * 
 * All rights Reserved, Designed By Jinlong
 * Copyright:	Copyright(C) 2018-2019
 * Company   	Jinlong.
 * @author:		肖学进
 * @version		V1.0 
 * CreateDate: 	2018年6月7日 上午9:39:09 
 **/

package com.jinlong.system.role.test;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jinlong.system.service.role.IRoleService;
import com.jinlong.system.service.role.impl.RoleServiceImpl;

/**
 * 角色信息Service业务层测试类
 * @author:	肖学进
 * @date: 2018年6月7日 上午9:41:49
 */
public class RoleServiceImplTest {
	
	@SuppressWarnings("unused")
	private IRoleService rs = null;

	@SuppressWarnings("resource")
	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-context.xml");
		rs = (RoleServiceImpl)ac.getBean("roleBaseService");
	}

	@Ignore
	@Test
	public void testAddRoleInfoListOfInteger() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testDeleteRoleInfo() {
//		fail("Not yet implemented");
	}
	
//	@Ignore
	@Test
	public void testDeleteById() {
//		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testUpdateRoleInfoListOfInteger() {
//		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testFindInt() {
//		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testFindAll() {
//		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testFindListRoleVO() {
//		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testFindNew() {
//		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testFindNewListInt() {
//		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testFindCount() {
//		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testFindPageListPageProperty() {
//		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testFindJqPageListRoleVOJqPage() {
//		fail("Not yet implemented");
	}

}
