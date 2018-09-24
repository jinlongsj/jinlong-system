package com.jinlong.system.user.test;

import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jinlong.common.exception.LogicException;
import com.jinlong.common.page.PageProperty;
import com.jinlong.system.model.po.user.UserInfoPO;
import com.jinlong.system.service.user.IUserInfoService;
import com.jinlong.system.service.user.impl.UserInfoServiceImpl;

public class UserInfoServiceImplTest {
	
	IUserInfoService iuis; 

	@SuppressWarnings("resource")
	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-context.xml");
		iuis = (UserInfoServiceImpl)ac.getBean("userInfoService");
	}

	@Ignore
	@Test
	public void testAddUserInfo() {
//		fail("Not yet implemented");
		UserInfoPO ui = new UserInfoPO();
		ui.setUserId(7);
		ui.setRealName("肖学进");
		ui.setNickName("beboyous");
		ui.setGender(1);
		ui.setAge(33);
		ui.setTelephone("029-88492313");
		ui.setZoneId(1);
		ui.setAddress("友谊西路127号西北工业大学南村4-4-0101");
		ui.setPostCode("710072");
		ui.setHomePage("wwww.beboyous.com");
		ui.setQqNumber("363204584");
		ui.setAliPay("beboyous@126.com");
		ui.setImage(3);
		ui.setDescription("肖学进是一西安中软国际科技服务有限公堤的一位高级软件工程师!哈哈,他世界上就是一个酷逼的码农!!!");
		try {
			iuis.add(ui);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testDeleteUserInfo() {
//		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testDeleteById() {
//		fail("Not yet implemented");
		try {
			iuis.deleteById(2);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void testUpdateUserInfo() {
//		fail("Not yet implemented");
		UserInfoPO ui = new UserInfoPO();
		ui.setUserId(4);
		ui.setRealName("刘兔");
		ui.setNickName("xxj");
		ui.setGender(2);
		ui.setAge(29);
		ui.setTelephone("029-89797989");
		ui.setZoneId(1);
		ui.setAddress("西高新108号");
		ui.setPostCode("710065");
		ui.setHomePage("wwww.beboyous.com");
		ui.setQqNumber("89798797");
		ui.setAliPay("xxj@163.com");
		ui.setImage(3);
		ui.setDescription("刘兔是一个玉兔!");
		try {
			iuis.update(ui);
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void testFindInt() {
//		fail("Not yet implemented");
		try {
			UserInfoPO ui = iuis.find(3);
			System.out.println("#############################");
			System.out.println(ui.getUserId());
			System.out.println(ui.getRealName());
			System.out.println(ui.getNickName());
			System.out.println(ui.getGender());
			System.out.println(ui.getAge());
			System.out.println(ui.getIdNumber());
			System.out.println(ui.getTelephone());
			System.out.println(ui.getZoneId());
			System.out.println(ui.getAddress());
			System.out.println(ui.getPostCode());
			System.out.println(ui.getHomePage());
			System.out.println(ui.getQqNumber());
			System.out.println(ui.getAliPay());
			System.out.println(ui.getImage());
			System.out.println(ui.getDescription());
			System.out.println("#############################");
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void testFindAll() {
//		fail("Not yet implemented");
		try {
			List<UserInfoPO> uiList = iuis.findAll();
			for (UserInfoPO ui : uiList) {
				System.out.println("#############################");
				System.out.println(ui.getUserId());
				System.out.println(ui.getRealName());
				System.out.println(ui.getNickName());
				System.out.println(ui.getGender());
				System.out.println(ui.getAge());
				System.out.println(ui.getIdNumber());
				System.out.println(ui.getTelephone());
				System.out.println(ui.getZoneId());
				System.out.println(ui.getAddress());
				System.out.println(ui.getPostCode());
				System.out.println(ui.getHomePage());
				System.out.println(ui.getQqNumber());
				System.out.println(ui.getAliPay());
				System.out.println(ui.getImage());
				System.out.println(ui.getDescription());
				System.out.println("#############################");
			}
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void testFindListUserInfo() {
//		fail("Not yet implemented");
		try {
			UserInfoPO usi = new UserInfoPO();
			usi.setRealName("刘兔");
			List<UserInfoPO> uiList = iuis.findList(usi);
			for (UserInfoPO ui : uiList) {
				System.out.println("#############################");
				System.out.println(ui.getUserId());
				System.out.println(ui.getRealName());
				System.out.println(ui.getNickName());
				System.out.println(ui.getGender());
				System.out.println(ui.getAge());
				System.out.println(ui.getIdNumber());
				System.out.println(ui.getTelephone());
				System.out.println(ui.getZoneId());
				System.out.println(ui.getAddress());
				System.out.println(ui.getPostCode());
				System.out.println(ui.getHomePage());
				System.out.println(ui.getQqNumber());
				System.out.println(ui.getAliPay());
				System.out.println(ui.getImage());
				System.out.println(ui.getDescription());
				System.out.println("#############################");
			}
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void testFindNew() {
//		fail("Not yet implemented");
		try {
			UserInfoPO ui = iuis.findNew();
			System.out.println("#############################");
			System.out.println(ui.getUserId());
			System.out.println(ui.getRealName());
			System.out.println(ui.getNickName());
			System.out.println(ui.getGender());
			System.out.println(ui.getAge());
			System.out.println(ui.getIdNumber());
			System.out.println(ui.getTelephone());
			System.out.println(ui.getZoneId());
			System.out.println(ui.getAddress());
			System.out.println(ui.getPostCode());
			System.out.println(ui.getHomePage());
			System.out.println(ui.getQqNumber());
			System.out.println(ui.getAliPay());
			System.out.println(ui.getImage());
			System.out.println(ui.getDescription());
			System.out.println("#############################");
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void testFindNewListInt() {
//		fail("Not yet implemented");
		try {
			List<UserInfoPO> uiList = iuis.findNewList(3);
			for (UserInfoPO ui : uiList) {
				System.out.println("#############################");
				System.out.println(ui.getUserId());
				System.out.println(ui.getRealName());
				System.out.println(ui.getNickName());
				System.out.println(ui.getGender());
				System.out.println(ui.getAge());
				System.out.println(ui.getIdNumber());
				System.out.println(ui.getTelephone());
				System.out.println(ui.getZoneId());
				System.out.println(ui.getAddress());
				System.out.println(ui.getPostCode());
				System.out.println(ui.getHomePage());
				System.out.println(ui.getQqNumber());
				System.out.println(ui.getAliPay());
				System.out.println(ui.getImage());
				System.out.println(ui.getDescription());
				System.out.println("#############################");
			}
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void testFindCount() {
//		fail("Not yet implemented");
		try {
			int count = iuis.findCount(new HashMap<String, Object>());
			System.out.println("###################################");
			System.out.println("count = " + count);
			System.out.println("###################################");
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void testFindPageListPageProperty() {
//		fail("Not yet implemented");
		PageProperty pp = new PageProperty();
		pp.setNpage(1);
		pp.setNpagesize(5);
		try {
			List<UserInfoPO> uiList = iuis.findPageList(pp).getRecords();
			for (UserInfoPO ui : uiList) {
				System.out.println("#############################");
				System.out.println(ui.getUserId());
				System.out.println(ui.getRealName());
				System.out.println(ui.getNickName());
				System.out.println(ui.getGender());
				System.out.println(ui.getAge());
				System.out.println(ui.getIdNumber());
				System.out.println(ui.getTelephone());
				System.out.println(ui.getZoneId());
				System.out.println(ui.getAddress());
				System.out.println(ui.getPostCode());
				System.out.println(ui.getHomePage());
				System.out.println(ui.getQqNumber());
				System.out.println(ui.getAliPay());
				System.out.println(ui.getImage());
				System.out.println(ui.getDescription());
				System.out.println("#############################");
			}
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

}
