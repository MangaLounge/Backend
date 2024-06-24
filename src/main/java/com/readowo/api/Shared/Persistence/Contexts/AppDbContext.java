package com.readowo.api.Shared.Persistence.Contexts;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;

@Component
public class AppDbContext {
    private final EntityManager entityManager;

    public AppDbContext(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void flush() {
        entityManager.flush();
    }
}
