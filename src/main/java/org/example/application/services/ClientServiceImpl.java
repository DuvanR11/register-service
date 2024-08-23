package org.example.application.services;

import org.example.application.ports.in.ClientUseCase;
import org.example.application.ports.out.ClientRepository;
import org.example.domain.models.Client;
import org.example.infrastructure.persistence.jpa.entity.ClientJpaEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientUseCase {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long id, Client client) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));

        existingClient.setUsername(client.getUsername());
        existingClient.setEmail(client.getEmail());
        existingClient.setPhoneNumber(client.getPhoneNumber());

        return clientRepository.save(existingClient);
    }


    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

}
