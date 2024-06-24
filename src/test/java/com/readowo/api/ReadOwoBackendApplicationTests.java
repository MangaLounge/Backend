package com.readowo.api;

import com.readowo.api.ReadOwo.Models.User;
import com.readowo.api.ReadOwo.Repositories.UserRepository;
import com.readowo.api.ReadOwo.Services.ServicesImpl.UserServiceImpl;
import com.readowo.api.ReadOwo.dtos.SaveUserDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
class ReadOwoBackendApplicationTests {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testSaveUser() {
        SaveUserDto saveUserDto = new SaveUserDto();
        saveUserDto.setName("Lucas");
        saveUserDto.setEmail("lucas@gmail.com");
        saveUserDto.setPassword("1234");

        User userToSave = new User();
        userToSave.setName(saveUserDto.getName());
        userToSave.setEmail(saveUserDto.getEmail());
        userToSave.setPassword(saveUserDto.getPassword());

        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setName("Lucas");
        savedUser.setEmail("lucas@gmail.com");
        savedUser.setPassword("1234");

        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        User result = userService.saveUser(userToSave);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Lucas", result.getName());
        assertEquals("lucas@gmail.com", result.getEmail());
        assertEquals("1234", result.getPassword());

        verify(userRepository, times(1)).save(userToSave);
        System.out.println("Usuario creado: " + result);
    }

    @Test
    void testGetUserById() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setName("Lucas");
        user.setEmail("lucas@gmail.com");
        user.setPassword("1234");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        User result = userService.getUserById(userId);

        assertNotNull(result);

        assertEquals(userId, result.getId());
        assertEquals("Lucas", result.getName());
        assertEquals("lucas@gmail.com", result.getEmail());
        assertEquals("1234", result.getPassword());

        verify(userRepository, times(1)).findById(userId);
        System.out.println("Usuario obtenido: " + result);
    }

    @Test
    void testUpdateUser() {
        Long userId = 1L;
        User existingUser = new User();
        existingUser.setId(userId);
        existingUser.setName("Lucas");
        existingUser.setEmail("lucas@gmail.com");
        existingUser.setPassword("1234");

        User updatedUser = new User();
        updatedUser.setId(userId);
        updatedUser.setName("Lucas Actualizado");
        updatedUser.setEmail("lucas_actualizado@gmail.com");
        updatedUser.setPassword("1234actualizado");

        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(updatedUser)).thenReturn(updatedUser);

        User result = userService.updateUser(userId, updatedUser);

        assertNotNull(result);
        assertEquals(userId, result.getId());
        assertEquals("Lucas Actualizado", result.getName());
        assertEquals("lucas_actualizado@gmail.com", result.getEmail());
        assertEquals("1234actualizado", result.getPassword());

        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).save(updatedUser);

        System.out.println("Resultado del test testUpdateUser: Usuario actualizado correctamente: " + result);
    }
    @Test
    void testDeleteUser() {
        Long userId = 1L;
        User existingUser = new User();
        existingUser.setId(userId);
        existingUser.setName("Lucas");
        existingUser.setEmail("lucas@gmail.com");
        existingUser.setPassword("1234");

        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        doNothing().when(userRepository).delete(existingUser);

        ResponseEntity<?> responseEntity = userService.deleteUser(userId);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).delete(existingUser);

        System.out.println("Resultado del test testDeleteUser: Usuario eliminado correctamente.");
    }
}
