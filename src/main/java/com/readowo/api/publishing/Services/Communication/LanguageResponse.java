package com.readowo.api.publishing.Services.Communication;

import com.readowo.api.Shared.BaseResponse;
import com.readowo.api.publishing.Models.Language;

public class LanguageResponse extends BaseResponse<Language> {

    public LanguageResponse(String message) {
        super(message);
    }

    public LanguageResponse(Language resource) {
        super(resource);
    }
}
