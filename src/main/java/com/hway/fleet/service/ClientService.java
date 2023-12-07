package com.hway.fleet.service;

import java.util.List;

import com.hway.fleet.model.Clients;

public interface ClientService {
	
	void addClient (Clients client);
	
	void deleteClient(int id);
	
	void updateClient(Clients client);
	
	List<Clients> getAllClient();
	
	Clients getClientById (int id);

	List<Clients> getClientByName(String name);
	
	
	

}
