package com.citiustech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.citiustech.model.Emp;

public class RowMapperImpl implements RowMapper<Emp> {

	public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Emp emp =new Emp();
		emp.setEmp_id(rs.getInt(1));
		emp.setEmp_name(rs.getString(2));
		return emp;
	}

}
