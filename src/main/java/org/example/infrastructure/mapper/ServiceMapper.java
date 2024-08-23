package org.example.infrastructure.mapper;

import org.example.domain.models.Service;
import org.example.infrastructure.persistence.jpa.entity.ServiceJpaEntity;
import org.example.infrastructure.web.dto.ServiceDTO;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper {

    public ServiceDTO toDTO(Service service) {
        if (service == null) {
            return null;
        }
        ServiceDTO dto = new ServiceDTO();
        dto.setId(service.getId());
        dto.setName(service.getName());
        dto.setDescription(service.getDescription());
        dto.setPrice(service.getPrice());
        return dto;
    }

    public Service toEntity(ServiceDTO dto) {
        if (dto == null) {
            return null;
        }
        Service service = new Service();
        service.setId(dto.getId());
        service.setName(dto.getName());
        service.setDescription(dto.getDescription());
        service.setPrice(dto.getPrice());
        return service;
    }

    public Service toDomain(ServiceJpaEntity entity) {
        if (entity == null) {
            return null;
        }
        Service service = new Service();
        service.setId(entity.getId());
        service.setName(entity.getName());
        service.setDescription(entity.getDescription());
        service.setPrice(entity.getPrice());
        return service;
    }

    public ServiceJpaEntity toJpaEntity(Service service) {
        if (service == null) {
            return null;
        }
        ServiceJpaEntity entity = new ServiceJpaEntity();
        entity.setId(service.getId());
        entity.setName(service.getName());
        entity.setDescription(service.getDescription());
        entity.setPrice(service.getPrice());
        return entity;
    }
}
