package com.citiustech.dao;

import java.util.List;

import com.citiustech.model.Emp;

public interface EmployeeDao {
	
	public int insertEmp(Emp emp);
	public int updateEmp (Emp emp);
	public int deleteEmp(Emp emp);
	public Emp getEmp(int emp_id);
	public List<Emp> getAllEmployees();
	

}
