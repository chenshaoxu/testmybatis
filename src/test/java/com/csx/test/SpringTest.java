package com.csx.test;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csx.mybatis.dao.UserMapper;

public class SpringTest {
	public final static Logger logger = LoggerFactory.getLogger(SpringTest.class);

	@Before
	public void init() {
		logger.info("haha before");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		UserMapper usermapper = ac.getBean(UserMapper.class);
		logger.info("countAll:" + usermapper.countAll());

	}
	@Test
	public void test(){
		System.out.println(121);
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		UserMapper usermapper = ac.getBean(UserMapper.class);
		logger.info("1");
		logger.info("2");
		logger.info("countAll:" + usermapper.countAll());
	}

	@Test
	public void testTask() {
		System.out.println("xml load");
		@SuppressWarnings("resource")

		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		// UserMapper usermapper = ac.getBean(UserMapper.class);
		logger.info("xml load ok");
		// logger.info("2");
		// logger.info("countAll:" + usermapper.countAll());
	}

	@RequestMapping(value = "/{id}/show", method = RequestMethod.POST)
	public void test3() {

	}

}
