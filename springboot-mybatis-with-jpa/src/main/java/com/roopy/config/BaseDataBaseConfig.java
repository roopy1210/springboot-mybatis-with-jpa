package com.roopy.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.google.common.collect.ImmutableMap;

/**
 * Jpa, myBatis 정보 설정 클래스
 */
public class BaseDataBaseConfig {
	
	/**
	 * JPA 정보 설정
	 * 
	 * @param factory
	 * @param dbmsType
	 */
	protected void setConfigureEntityManagerFactory(LocalContainerEntityManagerFactoryBean factory, String dbmsType) {
		String dialectName = "P".equals(dbmsType) ? "org.hibernate.dialect.PostgreSQLDialect" : "org.hibernate.dialect.MySQL5Dialect";
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setJpaPropertyMap(ImmutableMap.of(
			"hibernate.hbm2ddl.auto","none",
			"hibernate.dialect", dialectName,
			"hibernate.open-in-view", "true",
			"hibernate.format_sql", "true"
		));
		factory.afterPropertiesSet();
		
	}
	
	/**
	 * MySQL 정보 설정
	 * 
	 * @param sessionFactoryBean
	 * @param dataSource
	 * @throws IOException
	 */
	protected void setConfigureSqlSessionFactory(SqlSessionFactoryBean sessionFactoryBean, DataSource dataSource) throws IOException {
		sessionFactoryBean.setDataSource(dataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactoryBean.setConfigLocation(new ClassPathResource("config/mybatis-config.xml"));
		sessionFactoryBean.setMapperLocations(resolver.getResources("classpath:sqlmap/**/*.xml"));
	}
}
