package com.readowo.api.ReadOwo.Controllers;

import com.readowo.api.ReadOwo.Services.IServices.IUserService;
import com.readowo.api.ReadOwo.dtos.SaveUserDto;
import com.readowo.api.ReadOwo.dtos.UserDto;
import com.readowo.api.ReadOwo.mapping.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users", produces = "application/json")
public class UserController {
    private final IUserService userService;
    private final UserMapper mapper;
    public UserController(IUserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }
    @GetMapping
    public List<UserDto> getAllUsers() {
        return mapper.modelList(userService.getAllUsers());
    }

    @GetMapping("{userId}")
    public UserDto getOneUser(@PathVariable Long userId) {
        return mapper.toResource(userService.getUserById(userId));
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody SaveUserDto saveUserDtos) {
        return new ResponseEntity<>(mapper.toResource(userService.saveUser(mapper.toModel(saveUserDtos))), HttpStatus.CREATED);
    }

    @PutMapping("{userId}")
    public UserDto updateUser(@PathVariable Long userId, @RequestBody SaveUserDto saveUserDtos) {
        return mapper.toResource(userService.updateUser(userId, mapper.toModel(saveUserDtos)));
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
}
