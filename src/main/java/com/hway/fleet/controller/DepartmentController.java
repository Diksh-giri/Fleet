package com.hway.fleet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hway.fleet.model.Department;
import com.hway.fleet.service.DepartmentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/dept/add")
	public String getDept(HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		return "DepartmentAdd";
	}
	
	@PostMapping("/dept/add")
	public String postDept(@ModelAttribute Department dept,HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		deptService.addDepartment(dept);
		
		return "redirect:/department";
	}
	
	@GetMapping("/department")
	public String deptList(Model model,HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		model.addAttribute("dList", deptService.getAllDepartment());
		
		return "Department";
	}
	
	@GetMapping("/dept/delete")
	public String delete(@RequestParam int id,HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		deptService.deleteDepartment(id);
		
		return "redirect:/department";
	}
	
	@GetMapping("/dept/edit")
	public String edit(@RequestParam int id, Model model,HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		model.addAttribute("dModel", deptService.getDepartmentById(id));
		
		return "DepartmentEdit";
	}
	
	@PostMapping("/dept/update")
	public String update(@ModelAttribute Department dept,HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		deptService.updateDepartment(dept);
		
		return "redirect:/department";
	}
	@GetMapping("/dept/search")
	public String showSearchForm() {
        return "DepartmentSearch";
    }
	
	@PostMapping("/dept/search")
	public String search(@RequestParam String deptName,Model model,HttpSession session) {
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		List<Department> department = deptService.getDepartmentByName(deptName);

		if (!( department).isEmpty()) {
			model.addAttribute("dList", department);
            return "DepartmentSearch";
        } else {
            return "NoSearch";
        }
    }
		
	}

