package org.example.infrastructure.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.domain.enums.Estado;

import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "reservations")
public class ReservationJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private ClientJpaEntity client;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceJpaEntity service;

    @Enumerated(EnumType.STRING)
    private Estado status;

    private LocalDateTime reservationDate;
    private LocalDateTime cancellationDate;

}