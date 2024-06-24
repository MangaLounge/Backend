package com.readowo.api.ReadOwo.Services.ServicesImpl;

import com.readowo.api.ReadOwo.Models.User;
import com.readowo.api.ReadOwo.Repositories.UserRepository;
import com.readowo.api.ReadOwo.Services.Communication.UserResponse;
import com.readowo.api.ReadOwo.Services.IServices.IUserService;
import com.readowo.api.ReadOwo.dtos.ResourceNotFoundException;
import com.readowo.api.ReadOwo.dtos.SaveUserDto;
import com.readowo.api.ReadOwo.dtos.UserDto;
import com.readowo.api.Shared.Persistence.Repositories.UnitOfWork;
import com.readowo.api.publishing.Repositories.BookRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final UnitOfWork unitOfWork;

    private final BookRepository bookRepository;
    private static final String ENTITY = "User";



    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, userId));
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<?> deleteUser(Long userId) {
        return userRepository.findById(userId).map(user -> {
                    userRepository.delete(user);
                    return ResponseEntity.ok().build();})
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));
    }

    @Override
    public User updateUser(Long id, User user) {
        return userRepository.findById(id).map(userToUpdate ->
                        userRepository.save(
                                userToUpdate.withName(user.getName())
                                        .withEmail(user.getEmail())
                                        .withPassword(user.getPassword())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }
}
