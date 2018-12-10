package com.cybertech.common.filter;

import com.cybertech.common.annotation.LoginRequired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * ${DESCRIPTION}
 *
 * @author wuxw
 * @date 2018/12/9. 8:29 PM
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);
		if(loginRequired != null){

			System.out.println("注解过滤。。。。。");
			return true;
		}
		return true;

	}
}
