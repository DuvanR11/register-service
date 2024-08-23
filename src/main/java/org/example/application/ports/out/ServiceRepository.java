package org.example.application.ports.out;

import org.example.domain.models.Service;

import java.util.List;
import java.util.Optional;


public interface ServiceRepository {
    Service save(Service service);

    void deleteById(Long id);

    Optional<Service> findById(Long id);

    List<Service> findAll();
}
