package org.example.infrastructure.persistence.jpa.impl;

import org.example.application.ports.out.ReservationRepository;
import org.example.domain.models.Reservation;
import org.example.infrastructure.mapper.ReservationMapper;
import org.example.infrastructure.persistence.jpa.ReservationJpaRepository;
import org.example.infrastructure.persistence.jpa.entity.ReservationJpaEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ReservationRepositoryImpl implements ReservationRepository {

    private final ReservationJpaRepository reservationJpaRepository;
    private final ReservationMapper reservationMapper;

    public ReservationRepositoryImpl(ReservationJpaRepository reservationJpaRepository, ReservationMapper reservationMapper) {
        this.reservationJpaRepository = reservationJpaRepository;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public Reservation save(Reservation reservation) {
        ReservationJpaEntity entity = reservationMapper.toJpaEntity(reservation);
        return reservationMapper.toDomain(reservationJpaRepository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        reservationJpaRepository.deleteById(id);
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return reservationJpaRepository.findById(id).map(reservationMapper::toDomain);
    }

    @Override
    public List<Reservation> findByReservationDateBetween(LocalDateTime startDate, LocalDateTime endDate,  Long clientId, Long serviceId) {
        return reservationJpaRepository.findByReservationDateBetween(startDate, endDate, clientId, serviceId).stream()
                .map(reservationMapper::toDomain)
                .collect(Collectors.toList());
    }
}