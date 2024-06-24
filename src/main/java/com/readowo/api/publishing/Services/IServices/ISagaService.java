package com.readowo.api.publishing.Services.IServices;

import com.readowo.api.publishing.Dtos.SaveSagaDtos;
import com.readowo.api.publishing.Models.Saga;
import com.readowo.api.publishing.Services.Communication.SagaResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ISagaService {
    List<Saga> listSagas();
    Saga findSagaById(Long sagaId);
    Saga saveSaga(Saga saga);
    Saga updateSaga(Long id, Saga saga) ;
    ResponseEntity<?> deleteSaga(Long sagaId);
}
