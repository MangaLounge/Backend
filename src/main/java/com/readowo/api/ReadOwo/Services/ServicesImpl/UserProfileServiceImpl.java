package com.readowo.api.ReadOwo.Services.ServicesImpl;

import com.readowo.api.ReadOwo.Models.UserProfile;
import com.readowo.api.ReadOwo.Repositories.UserProfileRepository;
import com.readowo.api.ReadOwo.Services.Communication.UserProfileResponse;
import com.readowo.api.ReadOwo.Services.IServices.IUserProfileService;
import com.readowo.api.ReadOwo.Services.IServices.IUserService;
import com.readowo.api.ReadOwo.dtos.ResourceNotFoundException;
import com.readowo.api.ReadOwo.dtos.SaveUserProfileDto;
import com.readowo.api.ReadOwo.dtos.UserProfileDto;
import com.readowo.api.Shared.Persistence.Repositories.UnitOfWork;
import com.readowo.api.publishing.Repositories.BookRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor

public class UserProfileServiceImpl implements IUserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UnitOfWork unitOfWork;

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    private static final String ENTITY = "UserProfile";



    @Override
    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile getUserProfileById(Long userProfileId) {
        return userProfileRepository.findById(userProfileId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, userProfileId));
    }

    @Override
    public UserProfile saveUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfileResponse deleteUserProfile(Long userProfileId) {

        Optional<UserProfile> existingUserProfile = userProfileRepository.findById(userProfileId);
        if (!existingUserProfile.isPresent()) {
            return new UserProfileResponse("User Profile not found.");
        }

        try {
            userProfileRepository.delete(existingUserProfile.get());
            unitOfWork.complete();
            return new UserProfileResponse(existingUserProfile.get());
        } catch (Exception e) {
            return new UserProfileResponse("An error occurred while deleting the user profile: " + e.getMessage());
        }
    }

    @Override
    public UserProfileResponse updateUserProfile(Long id, SaveUserProfileDto saveUserProfileDto) {
        Optional<UserProfile> optionalUserProfile = userProfileRepository.findById(id);
        if (optionalUserProfile.isPresent()) {
            UserProfile existingUserProfile = optionalUserProfile.get();
            modelMapper.map(saveUserProfileDto, existingUserProfile);
            UserProfile updatedUserProfile = userProfileRepository.save(existingUserProfile);
            UserProfileDto userProfileDto = modelMapper.map(updatedUserProfile, UserProfileDto.class);
            return new UserProfileResponse(String.valueOf(userProfileDto));
        } else {
            return new UserProfileResponse("User Profile not found");
        }
    }
}
