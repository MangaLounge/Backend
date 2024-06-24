package com.readowo.api.ReadOwo.Services.Communication;

import com.readowo.api.ReadOwo.Models.User;
import com.readowo.api.Shared.BaseResponse;


public class UserResponse extends BaseResponse<User> {

    public UserResponse(String message) {super(message);}

    public UserResponse(User resource) {super(resource);}
}
