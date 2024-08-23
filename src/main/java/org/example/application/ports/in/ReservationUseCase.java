package org.example.application.ports.in;

import org.example.domain.models.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationUseCase {

    Reservation createReservation(Reservation reservation);

    Reservation updateReservation(Long id, Reservation reservation);

    void cancelReservation(Long id);

    List<Reservation> getReservations(LocalDateTime startDate, LocalDateTime endDate, Long clientId, Long serviceId);
}
