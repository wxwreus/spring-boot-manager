package com.cybertech.common.druidconfig;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author wuxw
 * @date 2018/12/8. 6:31 PM
 */


@Configuration
@MapperScan("com.cybertech.mapper")
public class MyBatisConfig {

	@Value("${spring.datasource.url}")
	private String dbUrl;
	@Value("${spring.datasource.username}")
	private String userName;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;

	private static String MYBATIS_CONFIG = "/mapper/mybatis-config.xml";
	private static String MAPPER_PATH = "/mapper/mybatis/*.xml";

	@Bean
	public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		// 设置mybatis configuration 扫描路径
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG));
		// 添加mapper 扫描路径
		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
		String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + MAPPER_PATH;
		sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
		// 设置datasource
		sqlSessionFactoryBean.setDataSource(dataSource());
		return sqlSessionFactoryBean;
	}

	private DataSource dataSource() {

		Map<String, Object> properties = new HashMap<>();
		properties.put(DruidDataSourceFactory.PROP_DRIVERCLASSNAME, driverClassName);
		properties.put(DruidDataSourceFactory.PROP_URL, dbUrl);
		properties.put(DruidDataSourceFactory.PROP_USERNAME, userName);
		properties.put(DruidDataSourceFactory.PROP_PASSWORD, password);
		// 添加统计、SQL注入、日志过滤器
		properties.put(DruidDataSourceFactory.PROP_FILTERS, "stat,wall,log4j2");
		// sql合并，慢查询定义为5s
		properties.put(DruidDataSourceFactory.PROP_CONNECTIONPROPERTIES, "druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000");
		try {
			return DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
