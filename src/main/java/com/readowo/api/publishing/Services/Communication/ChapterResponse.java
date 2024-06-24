package com.readowo.api.publishing.Services.Communication;

import com.readowo.api.Shared.BaseResponse;
import com.readowo.api.publishing.Models.Chapters;

public class ChapterResponse extends BaseResponse<Chapters> {

    public ChapterResponse(String message) {
        super(message);
    }

    public ChapterResponse(Chapters resource) {
        super(resource);
    }
}
