package com.readowo.api.ReadOwo.Repositories;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public interface IUnitOfWork {
    CompletableFuture<Void> complete();


    CompletionStage<Object> completeAsync();
}
