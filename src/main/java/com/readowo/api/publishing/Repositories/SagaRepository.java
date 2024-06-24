package com.readowo.api.publishing.Repositories;

import com.readowo.api.publishing.Models.Saga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SagaRepository extends JpaRepository<Saga, Long> {
}
