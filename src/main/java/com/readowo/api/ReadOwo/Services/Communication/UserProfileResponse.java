package com.readowo.api.ReadOwo.Services.Communication;

import com.readowo.api.ReadOwo.Models.UserProfile;
import com.readowo.api.Shared.BaseResponse;


public class UserProfileResponse extends BaseResponse<UserProfile> {

    public UserProfileResponse(String message) {super(message);}

    public UserProfileResponse(UserProfile resource) {super(resource);}
}
