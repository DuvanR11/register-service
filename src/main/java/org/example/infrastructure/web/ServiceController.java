package org.example.infrastructure.web;

import org.example.application.ports.in.ServiceUseCase;
import org.example.domain.models.Service;
import org.example.infrastructure.mapper.ServiceMapper;
import org.example.infrastructure.web.dto.ServiceDTO;
import org.example.infrastructure.web.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/services")
public class ServiceController {

    private final ServiceUseCase serviceUseCase;
    private final ServiceMapper serviceMapper;

    public ServiceController(ServiceUseCase serviceUseCase, ServiceMapper serviceMapper) {
        this.serviceUseCase = serviceUseCase;
        this.serviceMapper = serviceMapper;
    }

    @PostMapping
    public ServiceDTO createService(@RequestBody ServiceDTO serviceDTO) {
        Service service = serviceMapper.toEntity(serviceDTO);
        Service createdService = serviceUseCase.createService(service);
        return serviceMapper.toDTO(createdService);
    }

    @PutMapping("/{id}")
    public ServiceDTO updateService(@PathVariable Long id, @RequestBody ServiceDTO serviceDTO) {
        serviceDTO.setId(id);
        Service service = serviceMapper.toEntity(serviceDTO);
        Service updatedService = serviceUseCase.updateService(id, service);
        return serviceMapper.toDTO(updatedService);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
        serviceUseCase.deleteService(id);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ServiceDTO>>> getAllServices() {
        List<ServiceDTO> services = serviceUseCase.getAllServices().stream()
                .map(serviceMapper::toDTO)
                .collect(Collectors.toList());

        ApiResponse<List<ServiceDTO>> response = new ApiResponse<>(
                "success",
                200,
                services,
                "Services retrieved successfully"
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ServiceDTO getServiceById(@PathVariable Long id) {
        Service service = serviceUseCase.getServiceById(id)
                .orElseThrow(() -> new IllegalArgumentException("Service not found with id: " + id));

        return serviceMapper.toDTO(service);
    }

}