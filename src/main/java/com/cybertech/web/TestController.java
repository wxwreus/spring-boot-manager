package com.cybertech.web;

import com.cybertech.common.annotation.LoginRequired;
import com.cybertech.entity.UserInfo;
import com.cybertech.entity.Vehicle;
import com.cybertech.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * ${DESCRIPTION}
 * @author wuxw
 * @date 2018/11/11. 下午6:46
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	TestService testServiceImpl;

	@RequestMapping("/testOneToMany")
	@ResponseBody
	public Object testOneToMany(){
		List<Vehicle> list = testServiceImpl.testOneToMany();
		return list;
	}


	@RequestMapping("/testListRemove")
	@ResponseBody
	public Object testListRemove(){

		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		Vehicle v = new Vehicle();
		vehicleList.add(v);
		Iterator<Vehicle> it = vehicleList.iterator();
		while (it.hasNext()){

//			Vehicle v = it.next();
			it.remove();
		}
		return vehicleList;
	}
	@RequestMapping("/login")
	public String testThymeleaf(){

//		Set<String> set = new SortedSet<String>();
		System.out.println("====login====");
		return "login";
	}


	@RequestMapping("/loadUserInfo")
	@ResponseBody
	@LoginRequired
	public Object loadUserInfo(){

		System.out.println("kkk");
		List<UserInfo> list = testServiceImpl.loadUserInfo();
		return list;
	}
}
