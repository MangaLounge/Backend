package com.readowo.api.publishing.Services.ServicesImpl;

import com.readowo.api.ReadOwo.Repositories.IUnitOfWork;
import com.readowo.api.ReadOwo.dtos.ResourceNotFoundException;
import com.readowo.api.publishing.Dtos.ChapterDtos;
import com.readowo.api.publishing.Dtos.GenreDtos;
import com.readowo.api.publishing.Dtos.SaveChapterDtos;
import com.readowo.api.publishing.Dtos.SaveGenreDtos;
import com.readowo.api.publishing.Models.Chapters;
import com.readowo.api.publishing.Models.Genre;
import com.readowo.api.publishing.Models.Saga;
import com.readowo.api.publishing.Repositories.GenreRepository;
import com.readowo.api.publishing.Services.Communication.ChapterResponse;
import com.readowo.api.publishing.Services.Communication.GenreResponse;
import com.readowo.api.publishing.Services.IServices.IGenreService;
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
public class GenreServiceImpl implements IGenreService {
    private final GenreRepository genreRepository;
    private final IUnitOfWork unitOfWork;
    private static final String ENTITY = "Genre";


    @Override
    public List<Genre> listGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre findGenreById(Long genreId) {
        return genreRepository.findById(genreId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, genreId));
    }

    @Override
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }


    @Override
    public Genre updateGenre(Long id, Genre genre) {
        return genreRepository.findById(id).map(genreToUpdate ->
                        genreRepository.save(
                                genreToUpdate.withName(genre.getName())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public ResponseEntity<?> deleteGenre(Long genreId) {
        return genreRepository.findById(genreId).map(genre -> {
                    genreRepository.delete(genre);
                    return ResponseEntity.ok().build();})
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, genreId));
    }


}
