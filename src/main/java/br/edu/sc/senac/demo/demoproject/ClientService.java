package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")

public class ClientService {

	@GetMapping("/list")
	
	public List<ClientDTO> list() {
		ArrayList<ClientDTO> list = new ArrayList<ClientDTO>();
		
		ClientDTO client1 = new ClientDTO(Long.valueOf(0), "Marcelo", "21/10/2003");
		list.add(0, client1);
		
		ClientDTO client2 = new ClientDTO(Long.valueOf(1), "Carlos", "14/11/2001");
		list.add(1, client2);
		
		ClientDTO client3 = new ClientDTO(Long.valueOf(2), "José", "02/09/2003");
		list.add(2, client3);
		
		return list;
		
	}
	@GetMapping("{id}/details")
	public ResponseEntity<ClientDTO> clientDeteils(@PathVariable final int id) {
		ClientDTO client = list().get(id);
		if (client.equals(ClientDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(client, HttpStatus.OK);
	}

}
