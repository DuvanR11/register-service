package org.example.infrastructure.persistence.jpa.impl;

import org.example.application.ports.out.ClientRepository;
import org.example.domain.models.Client;
import org.example.infrastructure.mapper.ClientMapper;
import org.example.infrastructure.persistence.jpa.ClientJpaRepository;
import org.example.infrastructure.persistence.jpa.entity.ClientJpaEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClientRepositoryImpl implements ClientRepository {

    private final ClientJpaRepository clientJpaRepository;
    private final ClientMapper clientMapper;

    public ClientRepositoryImpl(ClientJpaRepository clientJpaRepository, ClientMapper clientMapper) {
        this.clientJpaRepository = clientJpaRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public Client save(Client client) {
        ClientJpaEntity entity = clientMapper.toJpaEntity(client);
        return clientMapper.toDomain(clientJpaRepository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        clientJpaRepository.deleteById(id);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientJpaRepository.findById(id).map(clientMapper::toDomain);
    }

    @Override
    public List<Client> findAll() {
        return clientJpaRepository.findAll().stream()
                .map(clientMapper::toDomain)
                .collect(Collectors.toList());
    }
}
