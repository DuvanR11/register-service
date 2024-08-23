package org.example.application.ports.in;

import org.example.domain.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientUseCase {

    Client createClient(Client client);

    Client updateClient(Long id, Client client);

    void deleteClient(Long id);

    Optional<Client> getClientById(Long id);

    List<Client> getAllClients();
}