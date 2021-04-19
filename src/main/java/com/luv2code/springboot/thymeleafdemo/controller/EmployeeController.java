package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import com.luv2code.springboot.thymeleafdemo.ThymeleafdemoApplication;

@Controller
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private Environment env;
	 
	private String authKey;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	public boolean authorize(HttpServletRequest request) {
		authKey=env.getProperty("Auth-Key");
		String authKeyHead = request.getHeader("Auth-Key");
		dispLog(request);
		List<Employee> employeeList = null;
		if(authKeyHead != null && authKey != null && authKeyHead.equals(authKey))
		{	
			return true;
		}
		else {
			return false;
		}
	}
	
	// rest api to get all details
	@GetMapping("/getList")		
	@ResponseBody
	public ResponseEntity<List<Employee>> getEmployees(HttpServletRequest request)
	{			
		List<Employee> employeeList = null;
		if(authorize(request))
		{
			employeeList= employeeService.findAll();
			return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
		}		
		else
		{
			return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.FORBIDDEN);
		}						
	
	}
	
	// rest api to delete row
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id,HttpServletRequest request) {
		if(authorize(request))
		{
			employeeService.deleteById(id);
			return new ResponseEntity<String>("redirect:index", HttpStatus.OK);
		}		
		else
		{
			return new ResponseEntity<String>("", HttpStatus.FORBIDDEN);
		}			
		
	}
	
	// rest api to find emp by id
	@GetMapping("/employeeList/{id}")
	public ResponseEntity<Employee> getByIDNew(@PathVariable int id,HttpServletRequest request) {		
		// get the employee from the service
		if(authorize(request))
		{
			Employee theEmployee = employeeService.findById(id);
			return new ResponseEntity<Employee>(theEmployee, HttpStatus.OK);
		}				
		
		else
		{
			return new ResponseEntity<Employee>(HttpStatus.FORBIDDEN);
		}
				
	}
	
	//rest api to update emp
	@PostMapping("/save")	
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee,HttpServletRequest request) {			
		if(authorize(request))
		{
			employeeService.save(employee);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}				
		
		else
		{
			return new ResponseEntity<Employee>(HttpStatus.FORBIDDEN);		
		}
								
	}
	
	
	@PostMapping("/add")	
	public ResponseEntity<Employee> addEmployee(@Validated @RequestBody Employee employee,HttpServletRequest request) {							
		if(authorize(request))
		{
			employeeService.save(employee);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}			
		else
		{
			return new ResponseEntity<Employee>(HttpStatus.FORBIDDEN);		
		}					
	}
	
	public void dispLog(HttpServletRequest request) {
		String authKeyHead = request.getHeader("Auth-Key");
		ThymeleafdemoApplication.logger.debug(request.getRemoteAddr()+" "+request.getRequestURI()+" "+request.getMethod()+" "+request.getHeader("User-Agent"));
	}
	
}



