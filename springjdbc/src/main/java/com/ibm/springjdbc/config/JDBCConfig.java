package com.ibm.springjdbc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.ibm.springjdbc,com.ibm.springjdbcbasics.templates")
public class JDBCConfig {
	
	@Bean
    public DataSource setDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");  // change per your DB
        ds.setUrl("jdbc:mysql://localhost:3306/HR");
        ds.setUsername("Bhargav");
        ds.setPassword("Asdfqwer1234!@#$");
        return ds;
    }

	 @Bean
	    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	        return new JdbcTemplate(dataSource);
	    }
	
}
