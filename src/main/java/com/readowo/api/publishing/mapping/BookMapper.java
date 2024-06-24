package com.readowo.api.publishing.mapping;

import com.readowo.api.mapping.EnhancedModelMapper;
import com.readowo.api.publishing.Dtos.BookDtos;
import com.readowo.api.publishing.Dtos.SagaDtos;
import com.readowo.api.publishing.Dtos.SaveBookDtos;
import com.readowo.api.publishing.Dtos.SaveSagaDtos;
import com.readowo.api.publishing.Models.Book;
import com.readowo.api.publishing.Models.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class BookMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    public BookDtos toResource(Book model){
        return mapper.map(model, BookDtos.class);
    }
    public Book toModel(SaveBookDtos resource){
        return mapper.map(resource, Book.class);
    }
    public List<BookDtos> modelList(List<Book> bookList) {
        return mapper.mapList(bookList, BookDtos.class);
    }
}
