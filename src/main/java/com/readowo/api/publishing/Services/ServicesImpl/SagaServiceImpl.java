package com.readowo.api.publishing.Services.ServicesImpl;

import com.readowo.api.ReadOwo.Repositories.IUnitOfWork;
import com.readowo.api.ReadOwo.dtos.ResourceNotFoundException;
import com.readowo.api.publishing.Dtos.SagaDtos;
import com.readowo.api.publishing.Dtos.SaveSagaDtos;
import com.readowo.api.publishing.Models.Saga;
import com.readowo.api.publishing.Repositories.SagaRepository;
import com.readowo.api.publishing.Services.Communication.SagaResponse;
import com.readowo.api.publishing.Services.IServices.ISagaService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class SagaServiceImpl implements ISagaService {
    private final SagaRepository sagaRepository;
    private final IUnitOfWork unitOfWork;
    private static final String ENTITY = "Saga";
    @Override
    public List<Saga> listSagas() {
        return sagaRepository.findAll();
    }

    @Override
    public Saga findSagaById(Long sagaId) {
        return sagaRepository.findById(sagaId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, sagaId));
    }

    @Override
    public Saga saveSaga(Saga saga) {
        return sagaRepository.save(saga);
    }

    @Override
    public Saga updateSaga(Long id, Saga saga) {
        return sagaRepository.findById(id).map(sagaToUpdate ->
                        sagaRepository.save(
                                sagaToUpdate.withSynopsis(saga.getSynopsis())
                                        .withTitle(saga.getTitle())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public ResponseEntity<?> deleteSaga(Long sagaId) {
        return sagaRepository.findById(sagaId).map(saga -> {
                    sagaRepository.delete(saga);
                    return ResponseEntity.ok().build();})
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, sagaId));
    }

}
