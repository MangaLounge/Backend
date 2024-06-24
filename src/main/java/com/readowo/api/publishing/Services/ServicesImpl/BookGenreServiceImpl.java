package com.readowo.api.publishing.Services.ServicesImpl;


import com.readowo.api.ReadOwo.dtos.ResourceNotFoundException;
import com.readowo.api.Shared.Persistence.Repositories.UnitOfWork;
import com.readowo.api.publishing.Dtos.*;
import com.readowo.api.publishing.Models.Book;
import com.readowo.api.publishing.Models.BookGenre;
import com.readowo.api.publishing.Models.Saga;
import com.readowo.api.publishing.Repositories.BookGenreRepository;
import com.readowo.api.publishing.Repositories.BookRepository;
import com.readowo.api.publishing.Repositories.GenreRepository;
import com.readowo.api.publishing.Services.Communication.BookGenreResponse;
import com.readowo.api.publishing.Services.IServices.IBookGenreService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookGenreServiceImpl implements IBookGenreService {

    private final BookGenreRepository bookGenreRepository;
    private final UnitOfWork unitOfWork;
    private static final String ENTITY = "Saga";



    @Override
    public List<BookGenre> list() {
        return bookGenreRepository.findAll();
    }

    @Override
    public BookGenre findById(Long id) {
        return bookGenreRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public BookGenre saveBookGenre(BookGenre bookGenre) {
        return bookGenreRepository.save(bookGenre);
    }

    @Override
    public BookGenre updateBookGenre(Long id, BookGenre bookGenre) {
        return bookGenreRepository.findById(id).map(bookGenreToUpdate ->
                        bookGenreRepository.save(
                                bookGenreToUpdate.withBook(bookGenre.getBook())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public ResponseEntity<?> delete(Long bookGenreId) {
        return bookGenreRepository.findById(bookGenreId).map(bookGenre -> {
                    bookGenreRepository.delete(bookGenre);
                    return ResponseEntity.ok().build();})
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, bookGenreId));
    }

}
