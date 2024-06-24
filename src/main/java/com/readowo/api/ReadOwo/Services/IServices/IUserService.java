package com.readowo.api.ReadOwo.Services.IServices;

import com.readowo.api.ReadOwo.Models.User;
import com.readowo.api.ReadOwo.Services.Communication.UserResponse;
import com.readowo.api.ReadOwo.dtos.SaveUserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAllUsers();
    User getUserById(Long userId);
    User saveUser(User user);
    ResponseEntity<?> deleteUser(Long userId);
    User updateUser(Long id, User user);
}
