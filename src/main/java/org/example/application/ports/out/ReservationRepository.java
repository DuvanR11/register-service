package org.example.application.ports.out;

import org.example.domain.models.Reservation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface ReservationRepository {
    Reservation save(Reservation reservation);

    void deleteById(Long id);

    Optional<Reservation> findById(Long id);

    List<Reservation> findByReservationDateBetween(LocalDateTime startDate, LocalDateTime endDate, Long clientId, Long serviceId);
}
