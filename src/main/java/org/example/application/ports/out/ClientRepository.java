package org.example.application.ports.out;

import org.example.domain.models.Client;

import java.util.List;
import java.util.Optional;


public interface ClientRepository {
    Client save(Client client);

    void deleteById(Long id);

    Optional<Client> findById(Long id);

    List<Client> findAll();

}
