package com.readowo.api.ReadOwo.Controllers;

import com.readowo.api.ReadOwo.Models.UserProfile;
import com.readowo.api.ReadOwo.Services.Communication.UserProfileResponse;
import com.readowo.api.ReadOwo.Services.IServices.IUserProfileService;
import com.readowo.api.ReadOwo.Services.IServices.IUserService;
import com.readowo.api.ReadOwo.Services.ServicesImpl.UserProfileServiceImpl;
import com.readowo.api.ReadOwo.dtos.SaveUserProfileDto;
import com.readowo.api.ReadOwo.dtos.UserDto;
import com.readowo.api.ReadOwo.dtos.UserProfileDto;
import com.readowo.api.ReadOwo.mapping.UserMapper;
import com.readowo.api.ReadOwo.mapping.UserProfileMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/userProfile", produces = "application/json")
public class UserProfileController {
    private final IUserProfileService userProfileService;
    private final UserProfileMapper mapper;

    public UserProfileController(IUserProfileService userProfileService, UserProfileMapper mapper) {
        this.userProfileService = userProfileService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<UserProfileDto> getAllUserProfiles() {
        return mapper.modelList(userProfileService.getAllUserProfiles());
    }

    @GetMapping("{userId}")
    public UserProfileDto getOneUserProfile(@PathVariable Long userId) {
        return mapper.toResource(userProfileService.getUserProfileById(userId));
    }

    @PostMapping
    public UserProfileDto saveUserProfile(@RequestBody SaveUserProfileDto saveUserProfileDto) {
        return mapper.toResource(userProfileService.saveUserProfile(mapper.toModel(saveUserProfileDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfileResponse> updateUserProfile(@PathVariable("id") Long id, @RequestBody SaveUserProfileDto saveUserProfileDto) {
        UserProfileResponse response = userProfileService.updateUserProfile(id, saveUserProfileDto);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserProfileResponse> deleteUserProfile(@PathVariable(value = "id") Long userProfileId) {
        UserProfileResponse response = userProfileService.deleteUserProfile(userProfileId);
        return ResponseEntity.ok().body(response);
    }
}
