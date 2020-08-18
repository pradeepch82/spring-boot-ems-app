package com.atossyntel.ems.spring.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.atossyntel.ems.model.Employee;
import com.atossyntel.ems.service.EmployeeService;


@Controller
public class EmsSpringController {


	@Autowired
	private EmployeeService employeeService;

	public EmsSpringController() {
		System.out.println("######### EmsRestController created########");
	}
	@RequestMapping("/semployees")
	public ModelAndView getAllEmployees() {
		
		System.out.println("In getAllEmployeed............");
		
	return new ModelAndView("employeeList", "employees", employeeService.findAllEmployees());
	}

	
	
	
	
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String editEmployee(@PathVariable("id")  int id,ModelMap map) {
		map.addAttribute("employee", employeeService.findEmployee(id));
		map.addAttribute("employees", employeeService.findAllEmployees());
	   return "editEmployee";
	}

	
 @RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteEmployee(@RequestParam("employeeId")  int id,ModelMap map) {
		employeeService.deleteEmployee(id);
		map.addAttribute("employees", employeeService.findAllEmployees());
	   return "employeeList";
	}

	
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String newEmployee(ModelMap map) {
		map.addAttribute("employee",new Employee());
		map.addAttribute("employees", employeeService.findAllEmployees());
	   
		return "addEmployee";
	}

	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employee")  Employee employee,  ModelMap map) {
		
		System.out.println("In update Employee :"+employee);
		employeeService.updateEmployee(employee);
		
		map.addAttribute("employees", employeeService.findAllEmployees());
	   return "employeeList";
	}

	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee")  Employee employee,  ModelMap map) {
		
		System.out.println("In add Employee :"+employee);
		employeeService.addEmployee(employee);
		
		map.addAttribute("employees", employeeService.findAllEmployees());
	   return "employeeList";
	}

	
	
}
