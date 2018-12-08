package com.cybertech.service.impl;

import com.cybertech.entity.UserInfo;
import com.cybertech.entity.Vehicle;
import com.cybertech.mapper.TestMapper;
import com.cybertech.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wuxw
 * @date 2018/11/12. 下午6:45
 */
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestMapper testMapper;

	@Override
	public List<Vehicle> testOneToMany() {

		List<Vehicle> vehicleList = null;
		try{
			vehicleList = testMapper.testOneToMany();
		}catch(Exception e){
			e.printStackTrace();
		}
		return vehicleList;
	}

	@Override
	public List<UserInfo> loadUserInfo() {

		List<UserInfo> userInfoList = null;
		try{
			userInfoList = testMapper.loadUserInfo();
		}catch(Exception e){
			e.printStackTrace();
		}
		return userInfoList;
	}
}
