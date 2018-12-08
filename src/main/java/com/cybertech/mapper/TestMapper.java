package com.cybertech.mapper;

import com.cybertech.entity.UserInfo;
import com.cybertech.entity.Vehicle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wuxw
 * @date 2018/11/11. 下午6:44
 */
@Mapper
public interface TestMapper {

	List<Vehicle> testOneToMany();

	List<UserInfo> loadUserInfo();
}
