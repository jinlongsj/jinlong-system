package com.jinlong.system.user.test;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jinlong.common.exception.LogicException;
import com.jinlong.system.model.po.user.UserExaminePO;
import com.jinlong.system.service.user.IUserExamineService;
import com.jinlong.system.service.user.impl.UserExamineServiceImpl;

public class UserExamineServiceImplTest {
	
	private IUserExamineService userExamineService;

	@SuppressWarnings("resource")
	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-context.xml");
		userExamineService = (UserExamineServiceImpl)ac.getBean("userExamineService");
	}

	@Ignore
	@Test
	public void testAddUserExamine() {
//		fail("Not yet implemented");
		UserExaminePO ue = new UserExaminePO();
		ue.setUserId(1);
		ue.setExamineTime(new Date());
		ue.setPass(1);
		ue.setDescription("通过审批");
		ue.setState(1);
		try {
			userExamineService.add(ue);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testDeleteById() {
//		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testDeleteUserExamine() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testUpdateUserExamine() {
//		fail("Not yet implemented");
		UserExaminePO ue = new UserExaminePO();
		ue.setUserId(1);
		ue.setExamineTime(new Date());
		ue.setPass(2);
		ue.setDescription("由于你没有详细描述用户的信息，所以我这块不允许通过审核！");
		ue.setState(2);
		try {
			userExamineService.update(ue);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testFindCount() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testFindInt() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testFindListUserExamine() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testFindNew() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testFindNewListInt() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testFindPageListPageProperty() {
		fail("Not yet implemented");
	}

}
