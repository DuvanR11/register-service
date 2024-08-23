package org.example.application.services;

import lombok.RequiredArgsConstructor;
import org.example.domain.enums.Role;
import org.example.infrastructure.persistence.jpa.ClientJpaRepository;
import org.example.infrastructure.persistence.jpa.ServiceJpaRepository;
import org.example.infrastructure.persistence.jpa.entity.ClientJpaEntity;
import org.example.infrastructure.persistence.jpa.entity.ServiceJpaEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeedService {

    private final ServiceJpaRepository serviceJpaRepository;
    private final ClientJpaRepository clientJpaRepository;
    private final PasswordEncoder passwordEncoder;
    public void seedClients() {
        List<ClientJpaEntity> clients = Arrays.asList(
                ClientJpaEntity.builder().username("alice").password(passwordEncoder.encode("password123")).email("alice.smith@example.com").phoneNumber("111-222-3333").role(Role.CLIENT).build(),
                ClientJpaEntity.builder().username("bob").password(passwordEncoder.encode("password456")).email("bob.johnson@example.com").phoneNumber("222-333-4444").role(Role.CLIENT).build(),
                ClientJpaEntity.builder().username("carol").password(passwordEncoder.encode("password789")).email("carol.williams@example.com").phoneNumber("333-444-5555").role(Role.CLIENT).build(),
                ClientJpaEntity.builder().username("david").password(passwordEncoder.encode("password101")).email("david.brown@example.com").phoneNumber("444-555-6666").role(Role.CLIENT).build(),
                ClientJpaEntity.builder().username("eve").password(passwordEncoder.encode("password102")).email("eve.jones@example.com").phoneNumber("555-666-7777").role(Role.CLIENT).build(),
                ClientJpaEntity.builder().username("frank").password(passwordEncoder.encode("password103")).email("frank.miller@example.com").phoneNumber("666-777-8888").role(Role.CLIENT).build(),
                ClientJpaEntity.builder().username("grace").password(passwordEncoder.encode("password104")).email("grace.davis@example.com").phoneNumber("777-888-9999").role(Role.CLIENT).build(),
                ClientJpaEntity.builder().username("heidi").password(passwordEncoder.encode("password105")).email("heidi.garcia@example.com").phoneNumber("888-999-0000").role(Role.CLIENT).build(),
                ClientJpaEntity.builder().username("ivan").password(passwordEncoder.encode("password106")).email("ivan.rodriguez@example.com").phoneNumber("999-000-1111").role(Role.CLIENT).build(),
                ClientJpaEntity.builder().username("judy").password(passwordEncoder.encode("password107")).email("judy.wilson@example.com").phoneNumber("000-111-2222").role(Role.CLIENT).build()
        );

        clientJpaRepository.saveAll(clients);
    }

    public void seedHotelRooms() {
        List<ServiceJpaEntity> rooms = Arrays.asList(
                ServiceJpaEntity.builder().name("Habitación Individual").description("Habitación acogedora con una cama individual").price(79.99).build(),
                ServiceJpaEntity.builder().name("Habitación Doble").description("Habitación espaciosa con dos camas dobles").price(119.99).build(),
                ServiceJpaEntity.builder().name("Suite").description("Suite de lujo con área de estar separada").price(199.99).build(),
                ServiceJpaEntity.builder().name("Suite Deluxe").description("Suite premium con vistas panorámicas y comodidades adicionales").price(299.99).build(),
                ServiceJpaEntity.builder().name("Habitación Ejecutiva").description("Habitación elegante con comodidades ejecutivas para viajeros de negocios").price(159.99).build(),
                ServiceJpaEntity.builder().name("Habitación Familiar").description("Habitación grande adecuada para familias con varias camas y espacio adicional").price(139.99).build(),
                ServiceJpaEntity.builder().name("Suite de Luna de Miel").description("Suite romántica con características de lujo para recién casados").price(249.99).build(),
                ServiceJpaEntity.builder().name("Suite Penthouse").description("Suite exclusiva en el ático con terraza privada y comodidades de primera clase").price(399.99).build(),
                ServiceJpaEntity.builder().name("Habitación Estándar").description("Habitación cómoda con las comodidades esenciales a un precio asequible").price(69.99).build(),
                ServiceJpaEntity.builder().name("Habitación Accesible").description("Habitación diseñada para accesibilidad con características especiales para huéspedes con discapacidades").price(89.99).build()
        );

        serviceJpaRepository.saveAll(rooms);
    }
}