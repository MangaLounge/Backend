package com.readowo.api.publishing.Services.Communication;

import com.readowo.api.Shared.BaseResponse;
import com.readowo.api.publishing.Models.Book;

public class BookResponse extends BaseResponse<Book> {

    public BookResponse(String message) {
        super(message);
    }

    public BookResponse(Book resource) {
        super(resource);
    }
}
