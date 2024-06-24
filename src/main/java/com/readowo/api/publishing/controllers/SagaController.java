package com.readowo.api.publishing.controllers;

import com.readowo.api.ReadOwo.Services.IServices.IUserService;
import com.readowo.api.ReadOwo.dtos.SaveUserDto;
import com.readowo.api.ReadOwo.dtos.UserDto;
import com.readowo.api.ReadOwo.mapping.UserMapper;
import com.readowo.api.publishing.Dtos.SagaDtos;
import com.readowo.api.publishing.Dtos.SaveSagaDtos;
import com.readowo.api.publishing.Models.Saga;
import com.readowo.api.publishing.Services.Communication.SagaResponse;
import com.readowo.api.publishing.Services.IServices.ISagaService;
import com.readowo.api.publishing.Services.ServicesImpl.SagaServiceImpl;
import com.readowo.api.publishing.mapping.SagaMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/saga", produces = "application/json")
public class SagaController {
    private final ISagaService sagaService;
    private final SagaMapper mapper;

    public SagaController(ISagaService sagaService, SagaMapper mapper) {
        this.sagaService = sagaService;
        this.mapper = mapper;
    }
    @GetMapping
    public List<SagaDtos> getAllSagas() {
        return mapper.modelList(sagaService.listSagas());
    }

    @GetMapping("{sagaId}")
    public SagaDtos getOneSaga(@PathVariable Long sagaId) {
        return mapper.toResource(sagaService.findSagaById(sagaId));
    }

    @PostMapping
    public ResponseEntity<SagaDtos> saveSaga(@RequestBody SaveSagaDtos saveSagaDtos) {
        return new ResponseEntity<>(mapper.toResource(sagaService.saveSaga(mapper.toModel(saveSagaDtos))), HttpStatus.CREATED);
    }

    @PutMapping("{sagaId}")
    public SagaDtos updateSaga(@PathVariable Long sagaId, @RequestBody SaveSagaDtos saveSagaDtos) {
        return mapper.toResource(sagaService.updateSaga(sagaId, mapper.toModel(saveSagaDtos)));
    }
    @DeleteMapping("{sagaId}")
    public ResponseEntity<?> deleteSaga(@PathVariable Long sagaId) {
        return sagaService.deleteSaga(sagaId);
    }
}
