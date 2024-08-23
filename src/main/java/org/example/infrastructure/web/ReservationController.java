package org.example.infrastructure.web;

import org.example.application.ports.in.ReservationUseCase;
import org.example.domain.models.Reservation;
import org.example.infrastructure.mapper.ReservationMapper;
import org.example.infrastructure.web.dto.ClientDTO;
import org.example.infrastructure.web.dto.ReservationDTO;
import org.example.infrastructure.web.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationUseCase reservationUseCase;
    private final ReservationMapper reservationMapper;

    public ReservationController(ReservationUseCase reservationUseCase, ReservationMapper reservationMapper) {
        this.reservationUseCase = reservationUseCase;
        this.reservationMapper = reservationMapper;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ReservationDTO>> createReservation(@RequestBody ReservationDTO reservationDTO) {
        Reservation reservation = reservationMapper.toEntity(reservationDTO);
        Reservation createdReservation = reservationUseCase.createReservation(reservation);
        ReservationDTO reservationRes = reservationMapper.toDTO(createdReservation);

        ApiResponse<ReservationDTO> response = new ApiResponse<>(
                "success",
                200,
                reservationRes,
                "reservations retrieved successfully"
        );

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ReservationDTO updateReservation(@PathVariable Long id, @RequestBody ReservationDTO reservationDTO) {
        reservationDTO.setId(id);
        Reservation reservation = reservationMapper.toEntity(reservationDTO);
        Reservation updatedReservation = reservationUseCase.updateReservation(id, reservation);
        return reservationMapper.toDTO(updatedReservation);
    }

    @DeleteMapping("/{id}")
    public void cancelReservation(@PathVariable Long id) {
        reservationUseCase.cancelReservation(id);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ReservationDTO>>> getReservations(
            @RequestParam(required = false) Long clientId,
            @RequestParam(required = false) Long serviceId,
            @RequestParam(required = false) LocalDateTime startDate,
            @RequestParam(required = false) LocalDateTime endDate
    ) {
        List<ReservationDTO> reservations = reservationUseCase.getReservations(startDate, endDate, clientId, serviceId).stream()
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList());

        ApiResponse<List<ReservationDTO>> response = new ApiResponse<>(
                "success",
                200,
                reservations,
                "reservations retrieved successfully"
        );

        return ResponseEntity.ok(response);
    }
}
