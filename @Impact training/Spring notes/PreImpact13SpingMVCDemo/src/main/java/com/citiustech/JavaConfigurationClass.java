package com.citiustech;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.citiustech.dao.EmployeeDao;
import com.citiustech.dao.EmployeeDaoImpl;

@Configuration
public class JavaConfigurationClass {
	
	@Bean(name= {"ds"})
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		ds.setUrl("jdbc:sqlserver://localhost;databaseName=PreImpact13;instanceName=SQLEXPRESS2019");
		ds.setUsername("sa");
		ds.setPassword("password_123");
		return ds;
	}
	@Bean(name= {"jdbcTemp"})
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	@Bean(name= {"empDao"})
	public EmployeeDao getEmployeeDao() {
		EmployeeDaoImpl empDao = new EmployeeDaoImpl();
		empDao.setJdbcTemplate(getTemplate());
		return empDao;
		
	}

}
