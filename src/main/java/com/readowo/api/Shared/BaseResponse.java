package com.readowo.api.Shared;

import lombok.Data;

@Data
public abstract class BaseResponse<T> {
    protected boolean success;
    protected String message;
    protected T resource;

    protected BaseResponse(String message) {
        this.success = false;
        this.message = message;
        this.resource = null;
    }

    protected BaseResponse(T resource) {
        this.success = true;
        this.message = "";
        this.resource = resource;
    }



}
