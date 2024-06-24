package com.readowo.api.publishing.Services.Communication;

import com.readowo.api.Shared.BaseResponse;
import com.readowo.api.publishing.Models.Genre;

public class GenreResponse extends BaseResponse<Genre> {

    public GenreResponse(String message) {
        super(message);
    }

    public GenreResponse(Genre resource) {
        super(resource);
    }
}
