package com.readowo.api.publishing.mapping;

import com.readowo.api.ReadOwo.Models.User;
import com.readowo.api.ReadOwo.dtos.SaveUserDto;
import com.readowo.api.ReadOwo.dtos.UserDto;
import com.readowo.api.mapping.EnhancedModelMapper;
import com.readowo.api.publishing.Dtos.SagaDtos;
import com.readowo.api.publishing.Dtos.SaveSagaDtos;
import com.readowo.api.publishing.Models.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class SagaMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    public SagaDtos toResource(Saga model){
        return mapper.map(model, SagaDtos.class);
    }
    public Saga toModel(SaveSagaDtos resource){
        return mapper.map(resource, Saga.class);
    }
    public List<SagaDtos> modelList(List<Saga> sagaList) {
        return mapper.mapList(sagaList, SagaDtos.class);
    }
}
