package org.example.application.services;

import org.example.infrastructure.mapper.ClientMapper;
import org.example.infrastructure.persistence.jpa.ClientJpaRepository;
import org.example.infrastructure.persistence.jpa.entity.ClientJpaEntity;
import org.example.infrastructure.web.response.AuthResponse;
import org.example.infrastructure.web.dto.LoginRequest;
import org.example.infrastructure.web.dto.RegisterRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.example.domain.enums.Role;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final ClientJpaRepository clientJpaRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final ClientMapper clientMapper;


    public AuthResponse login(LoginRequest request) {
        try {
            if (request.getUsername() == null || request.getPassword() == null) {
                throw new IllegalArgumentException("Username or password cannot be null");
            }

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            ClientJpaEntity user = clientJpaRepository.findByUsername(request.getUsername())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            System.out.println("User Details: " + user);

            String token = jwtService.getToken(clientMapper.toDomain(user));

            return AuthResponse.builder()
                    .token(token)
                    .username(user.getUsername())
                    .role(user.getRole().name())
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Authentication failed: " + e.getMessage());
        }
    }


    public AuthResponse register(RegisterRequest request) {
        ClientJpaEntity user = ClientJpaEntity.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .role(Role.CLIENT)
                .build();

        clientJpaRepository.save(user);

        String token = jwtService.getToken(clientMapper.toDomain(user));

        return AuthResponse.builder()
                .token(token)
                .username(user.getUsername())
                .role(user.getRole().name())
                .build();

    }

}