package org.example.infrastructure.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.enums.Estado;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationDTO implements Serializable {
    private Long id;
    private ClientDTO client;
    private ServiceDTO service;
    private Estado status;
    private LocalDateTime reservationDate;
    private LocalDateTime cancellationDate;
}