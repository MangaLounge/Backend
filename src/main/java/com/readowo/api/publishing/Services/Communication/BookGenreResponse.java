package com.readowo.api.publishing.Services.Communication;

import com.readowo.api.Shared.BaseResponse;
import com.readowo.api.publishing.Models.Book;
import com.readowo.api.publishing.Models.BookGenre;

public class BookGenreResponse extends BaseResponse<BookGenre> {
    public BookGenreResponse(String message) {
        super(message);
    }

    public BookGenreResponse(BookGenre resource) {
        super(resource);
    }
}
