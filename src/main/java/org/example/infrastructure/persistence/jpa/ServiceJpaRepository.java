package org.example.infrastructure.persistence.jpa;

import org.example.infrastructure.persistence.jpa.entity.ServiceJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceJpaRepository extends JpaRepository<ServiceJpaEntity, Long> {
}
