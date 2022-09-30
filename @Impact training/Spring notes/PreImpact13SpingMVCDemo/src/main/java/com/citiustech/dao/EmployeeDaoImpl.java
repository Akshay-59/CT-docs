package com.citiustech.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.citiustech.model.Emp;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insertEmp(Emp emp) {
		String query="insert into Employee values(?,?)";
		int rows =this.jdbcTemplate.update(query,emp.getEmp_id(),emp.getEmp_name());
		return rows;
	}

	public int updateEmp(Emp emp) {
		String query = "update Employee set emp_name=? where emp_id=? ";
		int rows = this.jdbcTemplate.update(query,emp.getEmp_name(),emp.getEmp_id());
		return rows;
	}

	public int deleteEmp(Emp emp) {
		String query = "delete from Employee where emp_id=?";
		int rows = this.jdbcTemplate.update(query,emp.getEmp_id());
		return rows;
	}

	public Emp getEmp(int emp_id) {
		
		String query= "select * from Employee where emp_id=?";
		RowMapper<Emp> rowMapper = new RowMapperImpl();
		Emp emp = this.jdbcTemplate.queryForObject(query, rowMapper,emp_id);
		return emp;
	}

	public List<Emp> getAllEmployees() {
		String query = "select * from Employee";
		List<Emp> emp= this.jdbcTemplate.query(query, new RowMapperImpl());
		return emp;
	}

}
