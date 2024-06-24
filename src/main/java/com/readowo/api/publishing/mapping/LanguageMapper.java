package com.readowo.api.publishing.mapping;

import com.readowo.api.mapping.EnhancedModelMapper;
import com.readowo.api.publishing.Dtos.LanguageDtos;
import com.readowo.api.publishing.Dtos.SagaDtos;
import com.readowo.api.publishing.Dtos.SaveLanguageDtos;
import com.readowo.api.publishing.Dtos.SaveSagaDtos;
import com.readowo.api.publishing.Models.Language;
import com.readowo.api.publishing.Models.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class LanguageMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    public LanguageDtos toResource(Language model){
        return mapper.map(model, LanguageDtos.class);
    }
    public Language toModel(SaveLanguageDtos resource){
        return mapper.map(resource, Language.class);
    }
    public List<LanguageDtos> modelList(List<Language> languageList) {
        return mapper.mapList(languageList, LanguageDtos.class);
    }
}
