package org.example.infrastructure.persistence.jpa;

import org.example.infrastructure.persistence.jpa.entity.ReservationJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationJpaRepository extends JpaRepository<ReservationJpaEntity, Long> {
    @Query("SELECT r FROM ReservationJpaEntity r WHERE " +
            "(:startDate IS NULL OR r.reservationDate >= :startDate) AND " +
            "(:endDate IS NULL OR r.reservationDate <= :endDate) AND " +
            "(:clientId IS NULL OR r.client.id = :clientId) AND " +
            "(:serviceId IS NULL OR r.service.id = :serviceId)")
    List<ReservationJpaEntity> findByReservationDateBetween(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("clientId") Long clientId,
            @Param("serviceId") Long serviceId
    );

}
