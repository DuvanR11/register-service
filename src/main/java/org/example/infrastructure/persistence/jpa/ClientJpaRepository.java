package org.example.infrastructure.persistence.jpa;

import org.example.infrastructure.persistence.jpa.entity.ClientJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientJpaRepository extends JpaRepository<ClientJpaEntity, Long> {

    Optional<ClientJpaEntity> findByUsername(String name);
}