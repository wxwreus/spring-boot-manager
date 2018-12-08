package com.cybertech.service;

import com.cybertech.entity.UserInfo;
import com.cybertech.entity.Vehicle;

import java.util.List;

/**
 * ${DESCRIPTION}
 * @author wuxw
 * @date 2018/11/11. 下午6:45
 */
public interface TestService {

	List<Vehicle> testOneToMany();


	List<UserInfo> loadUserInfo();
}
