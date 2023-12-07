package com.hway.fleet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hway.fleet.model.Employees;
import com.hway.fleet.service.DepartmentService;
import com.hway.fleet.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	@Autowired
	private DepartmentService deptService;

	@GetMapping("/employee")
	public String getEmpList(Model model,HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		model.addAttribute("empList",empService.getAllEmployee());
		return "Employee";
	}
	
	@GetMapping("/emp/add")
	public String getaddEmp(Model model, HttpSession session) {
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		model.addAttribute("dList",deptService.getAllDepartment());
		return "EmployeeAdd";
		
	}
	@PostMapping("/emp/add")
	public String postaddEmp(@ModelAttribute Employees emp,HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		empService.addEmployee(emp);
		return "redirect:/employee";
		
	}
	
	@GetMapping("/emp/delete")
	public String deleteEmp(@RequestParam int id, HttpSession session) {
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		empService.deleteEmployee(id);
		return "redirect:/employee";
		
	}
	
	@GetMapping("emp/edit")
	public String editEmp(@RequestParam int id, Model model, HttpSession session ) {
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		model.addAttribute("eModel", empService.getEmployeeById(id));
		model.addAttribute("dList", deptService.getAllDepartment());
		return "EmployeeEdit";
	}
	
	@PostMapping("/emp/update")
	public String updateEmp(@ModelAttribute Employees emp, HttpSession session) {
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		empService.updateEmployee(emp);
		return"redirect:/employee";
	}
	
	@GetMapping("/emp/search")
	public String showSearchForm() {
        return "EmployeeSearch";
    }
	
	@PostMapping("/emp/search")
	public String search(@RequestParam String fullName ,Model model,HttpSession session) {
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		List<Employees> employee = empService.getEmployeeByName(fullName);

		if (!(employee.isEmpty())) {
			model.addAttribute("empList", employee);
            return "EmployeeSearch";
        } else {
            return "NoSearch";
        }
    }
	
}
