package com.readowo.api.publishing.Services.ServicesImpl;

import com.readowo.api.ReadOwo.dtos.ResourceNotFoundException;
import com.readowo.api.publishing.Dtos.BookDtos;
import com.readowo.api.publishing.Dtos.SaveBookDtos;
import com.readowo.api.publishing.Models.Book;
import com.readowo.api.publishing.Models.Saga;
import com.readowo.api.publishing.Repositories.BookRepository;
import com.readowo.api.publishing.Services.Communication.BookResponse;
import com.readowo.api.publishing.Services.IServices.IBookService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class BookServiceImpl implements IBookService {

    private final BookRepository bookRepository;
    private static final String ENTITY = "Book";
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, bookId));
    }
    @Override
    public Book saveBook(Book book) {
        book.setId(null);
        book.setVisitCount(0);
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        return bookRepository.findById(id).map(bookToUpdate -> {
            if (book.getSynopsis() != null) {
                bookToUpdate.setSynopsis(book.getSynopsis());
            }
            if (book.getThumbnailUrl() != null) {
                bookToUpdate.setThumbnailUrl(book.getThumbnailUrl());
            }
            if (book.getTitle() != null) {
                bookToUpdate.setTitle(book.getTitle());
            }
            if (book.getFullText() != null) {
                bookToUpdate.setFullText(book.getFullText());
            }
            if (book.getVisitCount() >= 0) {
                bookToUpdate.setVisitCount(book.getVisitCount());
            }
            return bookRepository.save(bookToUpdate);
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public ResponseEntity<?> deleteBook(Long bookId) {
        return bookRepository.findById(bookId).map(book -> {
                    bookRepository.delete(book);
                    return ResponseEntity.ok().build();})
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY,bookId));
    }
}
