package org.example.application.services;

import org.example.application.ports.in.ServiceUseCase;
import org.example.application.ports.out.ServiceRepository;
import org.example.domain.models.Service;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceUseCase {

    private final ServiceRepository serviceRepository;

    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Service createService(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public Service updateService(Long id, Service service) {
        Service existingService = serviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Service not found with id: " + id));

        existingService.setName(service.getName());
        existingService.setDescription(service.getDescription());
        existingService.setPrice(service.getPrice());

        return serviceRepository.save(existingService);
    }


    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Optional<Service> getServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

}
