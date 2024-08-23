package org.example.infrastructure.mapper;

import org.example.application.ports.out.ClientRepository;
import org.example.application.ports.out.ServiceRepository;
import org.example.domain.models.Client;
import org.example.domain.models.Reservation;
import org.example.domain.models.Service;
import org.example.infrastructure.persistence.jpa.entity.ClientJpaEntity;
import org.example.infrastructure.persistence.jpa.entity.ReservationJpaEntity;
import org.example.infrastructure.persistence.jpa.entity.ServiceJpaEntity;
import org.example.infrastructure.web.dto.ClientDTO;
import org.example.infrastructure.web.dto.ReservationDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReservationMapper {

    private final ClientMapper clientMapper;
    private final ServiceMapper serviceMapper;
    private final ClientRepository clientRepository;
    private final ServiceRepository serviceRepository;

    public ReservationMapper(
            ClientRepository clientRepository,
            ServiceRepository serviceRepository,
            ClientMapper clientMapper,
            ServiceMapper serviceMapper
            ) {
        this.clientRepository = clientRepository;
        this.serviceRepository = serviceRepository;
        this.clientMapper = clientMapper;
        this.serviceMapper = serviceMapper;
    }

    public ReservationDTO toDTO(Reservation reservation) {
        if (reservation == null) {
            return null;
        }
        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setClient(clientMapper.toDTO(reservation.getClient()));
        dto.setService(serviceMapper.toDTO(reservation.getService()));
        dto.setStatus(reservation.getStatus());
        dto.setReservationDate(reservation.getReservationDate());
        dto.setCancellationDate(reservation.getCancellationDate());
        return dto;
    }

    public Reservation toEntity(ReservationDTO dto) {
        if (dto == null) {
            return null;
        }
        Reservation reservation = new Reservation();
        reservation.setId(dto.getId());

        Client client = clientRepository.findById(dto.getClient().getId())
                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + dto.getClient().getId()));

        Service service = serviceRepository.findById(dto.getService().getId())
                .orElseThrow(() -> new IllegalArgumentException("Service not found with id: " + dto.getService().getId()));

        reservation.setClient(client);
        reservation.setService(service);
        reservation.setReservationDate(dto.getReservationDate());
        reservation.setStatus(dto.getStatus());
        reservation.setCancellationDate(dto.getCancellationDate());

        return reservation;
    }


    public Reservation toDomain(ReservationJpaEntity entity) {
        if (entity == null) {
            return null;
        }
        Reservation reservation = new Reservation();
        reservation.setId(entity.getId());
        reservation.setClient(clientMapper.toDomain(entity.getClient()));
        reservation.setService(serviceMapper.toDomain(entity.getService()));
        reservation.setStatus(entity.getStatus());
        reservation.setReservationDate(entity.getReservationDate());
        reservation.setCancellationDate(entity.getCancellationDate());
        return reservation;
    }

    // Convierte de entidad de dominio a entidad JPA
    public ReservationJpaEntity toJpaEntity(Reservation reservation) {
        if (reservation == null) {
            return null;
        }
        ReservationJpaEntity entity = new ReservationJpaEntity();
        entity.setId(reservation.getId());
        entity.setClient(clientMapper.toJpaEntity(reservation.getClient()));
        entity.setService(serviceMapper.toJpaEntity(reservation.getService()));
        entity.setStatus(reservation.getStatus());
        entity.setReservationDate(reservation.getReservationDate());
        entity.setCancellationDate(reservation.getCancellationDate());
        return entity;
    }


}