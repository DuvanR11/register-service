package org.example.infrastructure.persistence.jpa.impl;

import org.example.application.ports.out.ServiceRepository;
import org.example.domain.models.Service;
import org.example.infrastructure.mapper.ServiceMapper;
import org.example.infrastructure.persistence.jpa.ServiceJpaRepository;
import org.example.infrastructure.persistence.jpa.entity.ServiceJpaEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ServiceRepositoryImpl implements ServiceRepository {

    private final ServiceJpaRepository serviceJpaRepository;
    private final ServiceMapper serviceMapper;

    public ServiceRepositoryImpl(ServiceJpaRepository serviceJpaRepository, ServiceMapper serviceMapper) {
        this.serviceJpaRepository = serviceJpaRepository;
        this.serviceMapper = serviceMapper;
    }

    @Override
    public Service save(Service service) {
        ServiceJpaEntity entity = serviceMapper.toJpaEntity(service);
        return serviceMapper.toDomain(serviceJpaRepository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        serviceJpaRepository.deleteById(id);
    }

    @Override
    public Optional<Service> findById(Long id) {
        return serviceJpaRepository.findById(id).map(serviceMapper::toDomain);
    }

    @Override
    public List<Service> findAll() {
        return serviceJpaRepository.findAll().stream()
                .map(serviceMapper::toDomain)
                .collect(Collectors.toList());
    }
}