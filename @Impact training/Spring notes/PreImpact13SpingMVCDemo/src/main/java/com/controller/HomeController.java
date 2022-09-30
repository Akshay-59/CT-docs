package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.citiustech.JavaConfigurationClass;
import com.citiustech.dao.EmployeeDao;
import com.citiustech.model.Emp;
import com.model.Prod;

@Controller
//@RequestMapping("/homec")
public class HomeController {
	
	static ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigurationClass.class);
	
	static EmployeeDao empDao = context.getBean("empDao", EmployeeDao.class);
	
	
	//handler method
	@RequestMapping("/home")
	public String getIndex() {
		
		return "index";
		
	}
	
	@RequestMapping("/empsucc")
	//for getting data from view to controller we have have used @RequestParam
	//for getting data from view to controller we can also use @ModelAttribute
	//Now second task we will have to send data from controller to view
	// Model class
	//ModelAndViewClass
//	public String empAddSuccess(@RequestParam("emp_id") int id,
//			@RequestParam("emp_name") String emp_name, Model model) {
//		System.out.println(id);
//		System.out.println(emp_name);
//		model.addAttribute("emp_id",id);
//		model.addAttribute("emp_name",emp_name);
//		return "empSucc";
//		
//	}
	
	
	public ModelAndView empAddSuccess(@RequestParam("emp_id") int id,
			@RequestParam("emp_name") String emp_name) {
		ModelAndView mv = new ModelAndView();
		System.out.println(id);
		System.out.println(emp_name);
		mv.addObject("emp_id",id);
		mv.addObject("emp_name",emp_name);
		mv.setViewName("empSucc");
		
		List<String> employee = new ArrayList<String>(); 
		employee.add("John");
		employee.add("Syed");
		employee.add("Simon");
		mv.addObject("emps",employee);
		
		Emp emp = new Emp();
		emp.setEmp_id(id);
		emp.setEmp_name(emp_name);
		empDao.insertEmp(emp);
		System.out.println("Employee Added Successfully");
		
		return mv;
		
	}
	
	//to open jsp page for adding product
	@RequestMapping(path="/addProd")
	public String addProduct() {
		return "prod";
	}
	
	//method for collecting data from view for product using @ModelAttribute
	@RequestMapping(path="/prd", method = RequestMethod.POST)
	public String prodSucc(@ModelAttribute Prod prod) {
		System.out.println(prod.getProd_id());
		System.out.println(prod.getProd_name());
		System.out.println(prod.getProd_price());
		
		return "prod2";
	}
	
	@RequestMapping("/getEmps")
	public ModelAndView getAllEmployee() {
		
		ModelAndView mv = new ModelAndView();
		List<Emp> emp = empDao.getAllEmployees();
		mv.addObject("aemp",emp);
		mv.setViewName("getEmp");
		return mv;
	}
	

}
