package com.readowo.api.publishing.Services.IServices;

import com.readowo.api.publishing.Dtos.SaveLanguageDtos;
import com.readowo.api.publishing.Models.Language;
import com.readowo.api.publishing.Services.Communication.LanguageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ILanguageService {

    List<Language> listLanguages();
    Language findLanguageById(Long languageId);
    Language saveLanguage(Language language);
    Language updateLanguage(Long id, Language language);
    ResponseEntity<?> deleteLanguage(Long languageId);
}
