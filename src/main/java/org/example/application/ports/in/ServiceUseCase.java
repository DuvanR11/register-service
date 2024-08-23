package org.example.application.ports.in;

import org.example.domain.models.Service;

import java.util.List;
import java.util.Optional;


public interface ServiceUseCase {

    Service createService(Service service);

    Service updateService(Long id, Service service);

    void deleteService(Long id);

    Optional<Service> getServiceById(Long id);

    List<Service> getAllServices();
}
