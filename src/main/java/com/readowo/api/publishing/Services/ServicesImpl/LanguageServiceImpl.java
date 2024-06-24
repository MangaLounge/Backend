package com.readowo.api.publishing.Services.ServicesImpl;

import com.readowo.api.ReadOwo.Repositories.IUnitOfWork;
import com.readowo.api.ReadOwo.dtos.ResourceNotFoundException;
import com.readowo.api.publishing.Dtos.GenreDtos;
import com.readowo.api.publishing.Dtos.LanguageDtos;
import com.readowo.api.publishing.Dtos.SaveGenreDtos;
import com.readowo.api.publishing.Dtos.SaveLanguageDtos;
import com.readowo.api.publishing.Models.Genre;
import com.readowo.api.publishing.Models.Language;
import com.readowo.api.publishing.Models.Saga;
import com.readowo.api.publishing.Repositories.LanguageRepository;
import com.readowo.api.publishing.Services.Communication.GenreResponse;
import com.readowo.api.publishing.Services.Communication.LanguageResponse;
import com.readowo.api.publishing.Services.IServices.ILanguageService;
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
public class LanguageServiceImpl implements ILanguageService {

    private final LanguageRepository languageRepository;
    private final IUnitOfWork unitOfWork;
    private static final String ENTITY = "Language";
    @Override
    public List<Language> listLanguages() {
        return languageRepository.findAll();
    }

    @Override
    public Language findLanguageById(Long languageId) {
        return languageRepository.findById(languageId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, languageId));
    }

    @Override
    public Language saveLanguage(Language language) {
        return languageRepository.save(language);
    }


    @Override
    public Language updateLanguage(Long id, Language language) {
        return languageRepository.findById(id).map(languageToUpdate ->
                        languageRepository.save(
                                languageToUpdate.withAbbreviation(language.getAbbreviation())
                                        .withName(language.getName())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public ResponseEntity<?> deleteLanguage(Long languageId) {
        return languageRepository.findById(languageId).map(language -> {
                    languageRepository.delete(language);
                    return ResponseEntity.ok().build();})
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, languageId));
    }
}
