package com.readowo.api.publishing.Services.ServicesImpl;

import com.readowo.api.ReadOwo.dtos.ResourceNotFoundException;
import com.readowo.api.Shared.Persistence.Repositories.UnitOfWork;
import com.readowo.api.publishing.Dtos.ChapterDtos;
import com.readowo.api.publishing.Dtos.SaveChapterDtos;
import com.readowo.api.publishing.Models.Chapters;
import com.readowo.api.publishing.Models.Saga;
import com.readowo.api.publishing.Repositories.BookRepository;
import com.readowo.api.publishing.Repositories.ChaptersRepository;
import com.readowo.api.publishing.Services.Communication.ChapterResponse;
import com.readowo.api.publishing.Services.IServices.IChaptersService;
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
public class ChaptersServiceImpl implements IChaptersService {

    private final ChaptersRepository chaptersRepository;
    private final UnitOfWork unitOfWork;
    private final BookRepository bookRepository;
    private static final String ENTITY = "Chapters";



    @Override
    public List<Chapters> getAllChapters() {
        return chaptersRepository.findAll();
    }

    @Override
    public Chapters getChaptersById(Long chaptersId) {
        return chaptersRepository.findById(chaptersId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, chaptersId));
    }

    @Override
    public Chapters saveChapters(Chapters chapters) {
        return chaptersRepository.save(chapters);
    }
    @Override
    public ResponseEntity<?> deleteChapters(Long chaptersId) {
        return chaptersRepository.findById(chaptersId).map(chapters -> {
                    chaptersRepository.delete(chapters);
                    return ResponseEntity.ok().build();})
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, chaptersId));
    }
    @Override
    public Chapters updateChapters(Long id, Chapters chapters) {
        return chaptersRepository.findById(id).map(chaptersToUpdate ->
                        chaptersRepository.save(
                                chaptersToUpdate.withSynopsis(chapters.getSynopsis())
                                        .withTitle(chapters.getTitle())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }
}
