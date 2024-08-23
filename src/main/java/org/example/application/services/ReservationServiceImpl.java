package org.example.application.services;

import org.example.application.ports.in.ReservationUseCase;
import org.example.application.ports.out.ReservationRepository;
import org.example.domain.enums.Estado;
import org.example.domain.models.Reservation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationUseCase {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Long id, Reservation reservation) {
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found with id: " + id));

        existingReservation.setReservationDate(reservation.getReservationDate());
        existingReservation.setClient(reservation.getClient());
        existingReservation.setService(reservation.getService());
        existingReservation.setStatus(Estado.RESERVADO);
        existingReservation.setCancellationDate(reservation.getCancellationDate());

        return reservationRepository.save(existingReservation);
    }


    @Override
    public void cancelReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> getReservations(LocalDateTime startDate, LocalDateTime endDate, Long clientId, Long serviceId) {
        return reservationRepository.findByReservationDateBetween(startDate, endDate, clientId, serviceId);
    }
}
