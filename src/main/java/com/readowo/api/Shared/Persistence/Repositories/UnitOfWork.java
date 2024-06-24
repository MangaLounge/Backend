package com.readowo.api.Shared.Persistence.Repositories;

import com.readowo.api.ReadOwo.Repositories.IUnitOfWork;
import com.readowo.api.Shared.Persistence.Contexts.AppDbContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Component
public  class UnitOfWork implements IUnitOfWork {

    private final AppDbContext context;

    @Autowired
    public UnitOfWork(AppDbContext context1) {
        this.context = context1;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public CompletableFuture<Void> complete() {
        context.flush();
        return CompletableFuture.completedFuture(null);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public CompletionStage<Object> completeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            context.flush();
            return new Object(); // El valor de retorno puede ser cualquier cosa, ya que no se utiliza en este caso
        });
    }



}
