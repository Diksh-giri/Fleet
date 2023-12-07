package com.hway.fleet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hway.fleet.model.Clients;
import com.hway.fleet.service.ClientService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping("/client/add")
	public String getclient(HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		return "ClientAdd";
	}
	
	@PostMapping("/client/add")
	public String postclient(@ModelAttribute Clients client,HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		clientService.addClient(client);
		
		return "redirect:/client";
	}
	
	@GetMapping("/client")
	public String clientList(Model model,HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		model.addAttribute("cList", clientService.getAllClient());
		
		return "Client";
	}
	
	@GetMapping("/client/delete")
	public String delete(@RequestParam int id,HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		clientService.deleteClient(id);
		
		return "redirect:/client";
	}
	
	@GetMapping("/client/edit")
	public String edit(@RequestParam int id, Model model,HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		model.addAttribute("cModel", clientService.getClientById(id));
		
		return "ClientEdit";
	}
	
	@GetMapping("/client/search")
	public String showSearchForm() {
        return "ClientSearch";
    }
	
	@PostMapping("/client/search")
	public String search(@RequestParam String name,Model model,HttpSession session) {
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		List<Clients> client = clientService.getClientByName(name);

		if (!(client.isEmpty())) {
			model.addAttribute("cList", client);
            return "ClientSearch";
        } else {
            return "NoSearch";
        }
    }
	
	@PostMapping("/client/update")
	public String update(@ModelAttribute Clients client,HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
		}
		
		clientService.updateClient(client);
		
		return "redirect:/client";
	}
}

