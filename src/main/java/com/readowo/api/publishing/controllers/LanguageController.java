package com.readowo.api.publishing.controllers;

import com.readowo.api.publishing.Dtos.*;
import com.readowo.api.publishing.Models.Genre;
import com.readowo.api.publishing.Models.Language;
import com.readowo.api.publishing.Services.Communication.GenreResponse;
import com.readowo.api.publishing.Services.Communication.LanguageResponse;
import com.readowo.api.publishing.Services.IServices.ILanguageService;
import com.readowo.api.publishing.Services.IServices.ISagaService;
import com.readowo.api.publishing.Services.ServicesImpl.LanguageServiceImpl;
import com.readowo.api.publishing.mapping.LanguageMapper;
import com.readowo.api.publishing.mapping.SagaMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/language", produces = "application/json")
public class LanguageController {
    private final ILanguageService languageService;
    private final LanguageMapper mapper;

    public LanguageController(ILanguageService languageService, LanguageMapper mapper) {
        this.languageService = languageService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<LanguageDtos> getAllLanguages() {
        return mapper.modelList(languageService.listLanguages());
    }

    @GetMapping("{languageId}")
    public LanguageDtos getLanguageById(@PathVariable Long languageId) {
        return mapper.toResource(languageService.findLanguageById(languageId));
    }
    @PostMapping
    public ResponseEntity<LanguageDtos> saveLanguage(@RequestBody SaveLanguageDtos saveLanguageDtos) {
        return new ResponseEntity<>(mapper.toResource(languageService.saveLanguage(mapper.toModel(saveLanguageDtos))), HttpStatus.CREATED);
    }
    @PutMapping("{languageId}")
    public LanguageDtos updateLanguage(@PathVariable Long languageId, @RequestBody SaveLanguageDtos saveLanguageDtos) {
        return mapper.toResource(languageService.updateLanguage(languageId, mapper.toModel(saveLanguageDtos)));
    }
    @DeleteMapping("{languageId}")
    public ResponseEntity<?> deleteLanguage(@PathVariable Long languageId) {
        return languageService.deleteLanguage(languageId);
    }
}
