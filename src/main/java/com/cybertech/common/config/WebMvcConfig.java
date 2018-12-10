package com.cybertech.common.config;

import com.cybertech.common.filter.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ${DESCRIPTION}
 *
 * @author wuxw
 * @date 2018/12/6. 10:00 AM
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public LoginInterceptor getSecurityInterceptor() {
		return new LoginInterceptor();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		super.addResourceHandlers(registry);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
		// 排除配置
		addInterceptor.excludePathPatterns("/error");
		addInterceptor.excludePathPatterns("/login**");
		// 拦截配置
		addInterceptor.addPathPatterns("/**");
	}
}
