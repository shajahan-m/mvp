package com.mvp.common.config;


import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

/**
 * configuration class for mvp data source config.
 * @author techversant
 * @version 1.0
 * @since 2023
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "mvpEntityManagerFactory", transactionManagerRef = "mvpTransactionManager", basePackages = {
		"com.mvp.common.repository" })
public class MVPDataSourceConfig {

	/**
	 * this method for data source.
	 * @return DataSource object.
	 */

	@Primary
	@Bean(name = "mvpDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.mvp")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * this method for entity manager factory.
	 * @param EntityManagerFactoryBuilder object, DataSource object.
	 * @return LocalContainerEntityManagerFactoryBean object.
	 */

	@Primary
	@Bean(name = "mvpEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("mvpDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.mvp.common.entity").build();
	}

	/**
	 * this method for transaction manager.
	 * @param EntityManagerFactory object.
	 * @return PlatformTransactionManager object.
	 */

	@Primary
	@Bean(name = "mvpTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("mvpEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	/**
	 * this method for flyway db migration.
	 * @param datasource object.
	 * @return flyway object.
	 */
	@Bean(initMethod = "migrate")
	public Flyway flyway(@Qualifier("mvpDataSource") DataSource dataSource) {
	    Flyway flyway = Flyway.configure()
	            .baselineOnMigrate(true)
	            .dataSource(dataSource)
	            .load();
	    return flyway;
	}

}
