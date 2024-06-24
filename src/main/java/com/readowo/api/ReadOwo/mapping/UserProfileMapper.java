package com.readowo.api.ReadOwo.mapping;

import com.readowo.api.ReadOwo.Models.UserProfile;
import com.readowo.api.ReadOwo.dtos.SaveUserProfileDto;
import com.readowo.api.ReadOwo.dtos.UserProfileDto;
import com.readowo.api.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class UserProfileMapper {
    @Autowired
    private EnhancedModelMapper mapper;
    public UserProfileDto toResource(UserProfile model){
        return mapper.map(model, UserProfileDto.class);
    }
    public UserProfile toModel(SaveUserProfileDto resource){
        return mapper.map(resource, UserProfile.class);
    }
    public List<UserProfileDto> modelList(List<UserProfile> userProfileListList) {
        return mapper.mapList(userProfileListList, UserProfileDto.class);
    }
}
