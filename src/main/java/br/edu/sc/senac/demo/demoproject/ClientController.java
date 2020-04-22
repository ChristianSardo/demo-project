package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;

@Controller
final class ClientController {

	private final ClientRepository clientRepository;

	ClientController(final ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	private static void updateEntityFromDTO(final ClientDTO clientDTO, final ClientEntity clientEntity) {
		clientEntity.setName(clientDTO.getName());
		clientEntity.setEmail(clientDTO.getEmail());
		clientEntity.setDate(clientDTO.getDate());
	}

	private static ClientEntity toEntity(final ClientDTO clientDTO) {
		final String name = clientDTO.getName();
		final String cargo = clientDTO.getEmail();
		final String dataNascimento = clientDTO.getDate();
		return new ClientEntity(name, cargo, dataNascimento);
	}

	private static ClientDTO toDTO(final ClientEntity clientEntity) {
		final String name = clientEntity.getName();
		final String email = clientEntity.getEmail();
		final String date = clientEntity.getDate();
		return new ClientDTO(name, email, date);
	}

	List<ClientDTO> getAllClients() {
		final List<ClientDTO> clients = new ArrayList<>();

		final Iterable<ClientEntity> entities = this.clientRepository.findAll();
		for (final ClientEntity clientEntity : entities) {
			ClientDTO clientDTO = ClientController.toDTO(clientEntity);
			clients.add(clientDTO);
		}
		return clients;
	}

	ClientDTO getClient(final Long id) {
		final Optional<ClientEntity> optionalClient = this.clientRepository.findById(id);
		if (optionalClient.isPresent()) {
			ClientEntity clientEntity = optionalClient.get();
			return ClientController.toDTO(clientEntity);
		}
		return ClientDTO.NULL_VALUE;
	}

	ClientDTO removeClient(final Long id) {
		final Optional<ClientEntity> optionalClient = this.clientRepository.findById(id);
		if (optionalClient.isPresent()) {
			final ClientEntity clientEntity = optionalClient.get();
			this.clientRepository.delete(clientEntity);
			return ClientController.toDTO(clientEntity);
		}
		return ClientDTO.NULL_VALUE;
	}

	Long insertClient(final ClientDTO clientDTO) {
		final ClientEntity clientEntity = ClientController.toEntity(clientDTO);
		this.clientRepository.save(clientEntity);
		return clientEntity.getClientId();
	}

	ClientDTO updateClient(final Long id, final ClientDTO clientDTO) {
		final Optional<ClientEntity> optionalClient = this.clientRepository.findById(id);
		if (optionalClient.isPresent()) {
			final ClientEntity clientEntity = optionalClient.get();
			final ClientDTO oldClientDTO = ClientController.toDTO(clientEntity);
			ClientController.updateEntityFromDTO(clientDTO, clientEntity);
			this.clientRepository.save(clientEntity);
			return oldClientDTO;
		}
		return ClientDTO.NULL_VALUE;
	}

}
