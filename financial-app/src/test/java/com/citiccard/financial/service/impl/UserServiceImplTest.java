package com.citiccard.financial.service.impl;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.citiccard.financial.common.BaseTestConfig;
import com.citiccard.financial.model.UserInfo;
import com.citiccard.financial.service.IUserService;

public class UserServiceImplTest extends BaseTestConfig {
	
	private static final Logger logger = Logger.getLogger(UserServiceImplTest.class);

	@Autowired
	IUserService userService;
	
	@Test
	public void testGetUserByUseName() {
		UserInfo userInfo = userService.getUserByUseName("admin");
		assertNotNull(userInfo);
		logger.info(userInfo.toString());
	}
}
