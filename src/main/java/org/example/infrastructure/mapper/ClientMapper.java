package org.example.infrastructure.mapper;

import org.example.domain.models.Client;
import org.example.infrastructure.persistence.jpa.entity.ClientJpaEntity;
import org.example.infrastructure.web.dto.ClientDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientMapper {

    public ClientDTO toDTO(Client client) {
        if (client == null) {
            return null;
        }
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setUsername(client.getUsername());
        dto.setEmail(client.getEmail());
        dto.setPhoneNumber(client.getPhoneNumber());
        return dto;
    }

    public Client toEntity(ClientDTO dto) {
        if (dto == null) {
            return null;
        }
        Client client = new Client();
        client.setId(dto.getId());
        client.setUsername(dto.getUsername());
        client.setEmail(dto.getEmail());
        client.setPhoneNumber(dto.getPhoneNumber());
        return client;
    }

    public Client toDomain(ClientJpaEntity entity) {
        if (entity == null) {
            return null;
        }
        Client client = new Client();
        client.setId(entity.getId());
        client.setUsername(entity.getUsername());
        client.setEmail(entity.getEmail());
        client.setPhoneNumber(entity.getPhoneNumber());
        return client;
    }

    public ClientJpaEntity toJpaEntity(Client client) {
        if (client == null) {
            return null;
        }
        ClientJpaEntity entity = new ClientJpaEntity();
        entity.setId(client.getId());
        entity.setUsername(client.getUsername());
        entity.setPassword(client.getPassword());
        entity.setEmail(client.getEmail());
        entity.setPhoneNumber(client.getPhoneNumber());
        return entity;
    }
}
