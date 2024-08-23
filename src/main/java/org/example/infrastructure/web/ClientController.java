package org.example.infrastructure.web;

import org.example.application.ports.in.ClientUseCase;
import org.example.application.services.ClientServiceImpl;
import org.example.domain.models.Client;
import org.example.infrastructure.mapper.ClientMapper;
import org.example.infrastructure.web.dto.ClientDTO;
import org.example.infrastructure.web.dto.ServiceDTO;
import org.example.infrastructure.web.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientServiceImpl clientUseCase;
    private final ClientMapper clientMapper;

    public ClientController(ClientServiceImpl clientUseCase, ClientMapper clientMapper) {
        this.clientUseCase = clientUseCase;
        this.clientMapper = clientMapper;
    }

    @PostMapping
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO) {
        Client client = clientMapper.toEntity(clientDTO);
        Client createdClient = clientUseCase.createClient(client);
        return clientMapper.toDTO(createdClient);
    }

    @PutMapping("/{id}")
    public ClientDTO updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        clientDTO.setId(id);
        Client client = clientMapper.toEntity(clientDTO);
        Client updatedClient = clientUseCase.updateClient(id, client);
        return clientMapper.toDTO(updatedClient);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientUseCase.deleteClient(id);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ClientDTO>>> getAllClients() {
        List<ClientDTO> clients =  clientUseCase.getAllClients().stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());

        ApiResponse<List<ClientDTO>> response = new ApiResponse<>(
                "success",
                200,
                clients,
                "clients retrieved successfully"
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable Long id) {
        // Obtener el cliente usando el caso de uso
        Client client = clientUseCase.getClientById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));

        // Convertir el cliente a DTO usando el mapper
        return clientMapper.toDTO(client);
    }
}