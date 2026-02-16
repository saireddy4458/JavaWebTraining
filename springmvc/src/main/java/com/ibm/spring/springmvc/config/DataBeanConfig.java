package com.ibm.spring.springmvc.config;

import javax.activation.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataBeanConfig {
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/Users");
		ds.setUsername("Bhargav");
		ds.setPassword("Asdfqwer1234!@#$");
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(javax.sql.DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}