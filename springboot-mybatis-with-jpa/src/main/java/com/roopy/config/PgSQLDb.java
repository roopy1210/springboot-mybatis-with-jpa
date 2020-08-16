package com.roopy.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * PostgreSQL DB 설정
 */
@Configuration
@EnableJpaRepositories(
	entityManagerFactoryRef = "pgsqlEntityManagerFactory",
	transactionManagerRef = "pgsqlTransactionManager",
	basePackages = {"com.roopy.persistence.repository"}
)
@MapperScan(
	sqlSessionFactoryRef = "pgsqlSqlSessionFactory",
	basePackages = {"com.roopy.persistence.mapper"}
)
public class PgSQLDb extends BaseDataBaseConfig {

	/**
	 * 데이터베이스 연결
	 * <pre>
	 * NOTE: 데이터베이스 설정 정보는 application.yml에 설정된 
	 *       dataSource 설정 정보이다.
	 *       여기 정보를 가져오는 부분이 @ConfigurationProperties
	 *       이다.
	 * </pre>
	 * 
	 * @return
	 */
	@Bean(name = "pgsqlDataSource")
	@ConfigurationProperties(prefix = "spring.datasoure.pgsqlds")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	/**
	 * EntityManagerFactory 생성
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean(name = "pgsqlEntityManagerFactory")
	public EntityManagerFactory entityManagerFactory(@Qualifier("pgsqlDataSource") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		factory.setPackagesToScan("com.roopy.domain");
		factory.setPersistenceUnitName("PostgreSQL");
		setConfigureEntityManagerFactory(factory, "P"); 
		
		return factory.getObject();
	}
	
	/**
	 * SessionFactory 생성
	 * 
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "pgsqlSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("pgsqlDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		setConfigureSqlSessionFactory(sessionFactoryBean, dataSource);
		
		return sessionFactoryBean.getObject();
	}
	
	/**
	 * Transaction 설정
	 * 
	 * @param entityManagerFactory
	 * @return
	 */
	@Bean(name = "pgsqlTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("pgsqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		
		return transactionManager;
	}
}
