package br.edu.sc.senac.demo.demoproject;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")

public class ClientService {

	private final ClientController clientController;

	ClientService(final ClientController clientController) {
		this.clientController = clientController;
	}

	@GetMapping("/list")
	public List<ClientDTO> list() {
		return this.clientController.getAllClients();
	}
	
	@GetMapping("/{id}/details")
	public ResponseEntity<ClientDTO> getClient(@PathVariable int id) {
		ClientDTO client = this.clientController.getClient(id);
		if (client == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(client, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<ClientDTO> removeClient(@PathVariable Long id) {
		int index = id.intValue();
		ClientDTO client = this.clientController.removeClient(index);
		if (client.equals(ClientDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(client, HttpStatus.OK);
	}

	@PostMapping("/addpayload")
	public Long addClient(@RequestBody ClientDTO client) {
		return this.clientController.insertClient(client);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClientDTO> uptadeClient(@PathVariable int id, @RequestBody ClientDTO updatedClient) {
		ClientDTO oldClient = this.clientController.uptadeClient(id, updatedClient);
		if (oldClient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(oldClient, HttpStatus.OK);
	}
}
