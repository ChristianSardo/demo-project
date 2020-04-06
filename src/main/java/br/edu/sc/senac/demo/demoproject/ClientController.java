package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
public class ClientController {

	private List<ClientDTO> clients = new ArrayList<>();

	List<ClientDTO> getAllClients() {
		return this.clients;
	}

	Long insertClient(ClientDTO client) {
		clients.add(client);
		Long id = Long.valueOf(clients.size() - 1);
		return id;
	}
	
	ClientDTO getClient(int id) {
		if (id >= this.clients.size() || id < 0) {
			return null;
		}
		ClientDTO client = clients.get(id);
		return client;
	}
	
	ClientDTO removeClient(int id) {
		if (id >= clients.size() || id < 0) {
			return null;
		}
		ClientDTO client = clients.remove(id);
		return client;
	}
	
	ClientDTO uptadeClient(int id, ClientDTO updatedClient) {
		if (id >= clients.size() || id < 0) {
			return null;
		}
		ClientDTO oldClient = clients.remove(id);
		clients.add(id, updatedClient);
		return oldClient;
	}

}
