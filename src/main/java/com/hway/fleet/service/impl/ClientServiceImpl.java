package com.hway.fleet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hway.fleet.model.Clients;
import com.hway.fleet.repository.ClientRepository;
import com.hway.fleet.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{

	
	
	@Autowired
	private ClientRepository clientRepo;
	
	@Override
	public void addClient(Clients client) {
		clientRepo.save(client);
	}

	@Override
	public void deleteClient(int id) {
		clientRepo.deleteById(id);
		
	}

	@Override
	public void updateClient(Clients client) {
		clientRepo.save(client);
	}

	@Override
	public List<Clients> getAllClient() {
		
		return clientRepo.findAll();
	}

	@Override
	public Clients getClientById(int id) {

		return clientRepo.findById(id).get();
	}

	
	  @Override 
	  public List<Clients> getClientByName(String name) {
	  
	  return clientRepo.findByName(name); }
	 

}
