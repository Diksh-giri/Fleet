package com.hway.fleet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hway.fleet.model.Vehicles;
import com.hway.fleet.service.VehicleService;

import jakarta.servlet.http.HttpSession;

@Controller
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("/vehicle/add")
	public String getvehicle(HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		
		return "VehicleAdd";
	}
	
	@PostMapping("/vehicle/add")
	public String postvehicle(@ModelAttribute Vehicles vehicle,HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		vehicleService.addVehicle(vehicle);
		
		return "redirect:/vehicle";
	}
	
	@GetMapping("/vehicle")
	public String vehicleList(Model model,HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		model.addAttribute("vList", vehicleService.getAllVehicle());
		
		return "Vehicle";
	}
	
	@GetMapping("/vehicle/delete")
	public String delete(@RequestParam int id,HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		vehicleService.deleteVehicle(id);
		
		return "redirect:/vehicle";
	}
	
	@GetMapping("/vehicle/edit")
	public String edit(@RequestParam int id, Model model,HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		model.addAttribute("vModel", vehicleService.getVehicleById(id));
		
		return "VehicleEdit";
	}
	
	@PostMapping("/vehicle/update")
	public String update(@ModelAttribute Vehicles vehicle,HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		vehicleService.updateVehicle(vehicle);
		
		return "redirect:/vehicle";
	}
	
	@GetMapping("/vehicle/search")
	public String showSearchForm() {
        return "VehicleSearch";
    }
	
	@PostMapping("/vehicle/search")
	public String search(@RequestParam String name,Model model,HttpSession session) {
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		List<Vehicles> vehicle = vehicleService.getVehicleByName(name);

		if (!(vehicle.isEmpty())) {
			model.addAttribute("vList", vehicle);
            return "VehicleSearch";
        } else {
            return "NoSearch";
        }
    }
}

