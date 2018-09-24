package com.jinlong.system.user.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jinlong.common.exception.LogicException;
import com.jinlong.system.model.po.user.UserProcessPO;
import com.jinlong.system.model.vo.user.UserProcessVO;
import com.jinlong.system.service.user.IUserProcessService;
import com.jinlong.system.service.user.impl.UserProcessServiceImpl;

/**
 * @description 用户流程业务层测试类
 * @author asus 
 */
public class UserProcessServiceImplTest {
	
	IUserProcessService iups;

	@SuppressWarnings("resource")
	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-context.xml");
		iups = (UserProcessServiceImpl)ac.getBean("userProcessService");
	}

	@Ignore
	@Test
	public void testAdd() {
//		fail("Not yet implemented");
		UserProcessPO up = new UserProcessPO();
		up.setUserId(1);
		up.setProcessTime(new Date());
		up.setExamineId(1);
		up.setState(3);
		try {
			iups.add(up);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testDelete() {
//		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testDeleteById() {
//		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testUpdate() {
//		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testFindInt() {
//		fail("Not yet implemented");
		try {
			UserProcessVO up = iups.find(1);
			System.out.println("########################################");
			System.out.println("processId = " + up.getProcessId());
			System.out.println("uesrId = " + up.getUserId());
			System.out.println("proccessTime = " + up.getProcessTime());
			System.out.println("examineId = " + up.getExamineId());
			System.out.println("state = " + up.getState());
			System.out.println("pass = " + up.getPass());
			System.out.println("description = " + up.getDescription());
			System.out.println("stateName = " + up.getStateName());
			System.out.println("########################################");
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testFindAll() {
//		fail("Not yet implemented");
		try {
			List<UserProcessVO> upList = iups.findAll();
			for (UserProcessVO up : upList) {
				System.out.println("########################################");
				System.out.println("processId = " + up.getProcessId());
				System.out.println("uesrId = " + up.getUserId());
				System.out.println("proccessTime = " + up.getProcessTime());
				System.out.println("examineId = " + up.getExamineId());
				System.out.println("state = " + up.getState());
				System.out.println("pass = " + up.getPass());
				System.out.println("description = " + up.getDescription());
				System.out.println("stateName = " + up.getStateName());
				System.out.println("########################################");
			}
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testFindListUserProcessVO() {
//		fail("Not yet implemented");
		UserProcessVO u = new UserProcessVO();
		u.setUserId(1);
		try {
			List<UserProcessVO> upList = iups.findList(u);
			for (UserProcessVO up : upList) {
				System.out.println("########################################");
				System.out.println("processId = " + up.getProcessId());
				System.out.println("uesrId = " + up.getUserId());
				System.out.println("proccessTime = " + up.getProcessTime());
				System.out.println("examineId = " + up.getExamineId());
				System.out.println("state = " + up.getState());
				System.out.println("pass = " + up.getPass());
				System.out.println("description = " + up.getDescription());
				System.out.println("stateName = " + up.getStateName());
				System.out.println("########################################");
			}
		} catch (LogicException e) {
			e.printStackTrace();
		}
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

//	@Ignore
	@Test
	public void testFindCount() {
//		fail("Not yet implemented");
		try {
			int count = iups.findCount(new HashMap<String, Object>());
			System.out.println("###################################");
			System.out.println("count = " + count);
			System.out.println("###################################");
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testFindPageListPageProperty() {
//		fail("Not yet implemented");
	}

}
