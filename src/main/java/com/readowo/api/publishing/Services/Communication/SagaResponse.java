package com.readowo.api.publishing.Services.Communication;

import com.readowo.api.Shared.BaseResponse;
import com.readowo.api.publishing.Models.Saga;

public class SagaResponse extends BaseResponse<Saga> {

    public SagaResponse(String message) {super(message);}

    public SagaResponse(Saga resource) {super(resource);}
}
