package org.example.domain.models;

import org.example.domain.enums.Estado;

import java.time.LocalDateTime;

public class Reservation {

    private Long id;
    private Client client;
    private Service service;
    private Estado status;
    private LocalDateTime reservationDate;
    private LocalDateTime cancellationDate;

    public Reservation() {}
    // Constructor
    public Reservation(Long id, Client client, Service service, Estado status, LocalDateTime reservationDate, LocalDateTime cancellationDate) {
        this.id = id;
        this.client = client;
        this.service = service;
        this.status = status;
        this.reservationDate = reservationDate;
        this.cancellationDate = cancellationDate;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Estado getStatus() {
        return status;
    }

    public void setStatus(Estado status) {
        this.status = status;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDateTime getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(LocalDateTime cancellationDate) {
        this.cancellationDate = cancellationDate;
    }
}
