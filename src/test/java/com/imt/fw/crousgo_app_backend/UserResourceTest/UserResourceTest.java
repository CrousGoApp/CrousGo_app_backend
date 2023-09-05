package com.imt.fw.crousgo_app_backend.UserResourceTest;
import com.imt.fw.crousgo_app_backend.entities.Users;
import com.imt.fw.crousgo_app_backend.repositories.UserRepository;
import com.imt.fw.crousgo_app_backend.resources.UserResource;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserResourceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserResource userResource;

    @Test
    public void testGetUser() {
        Users user1 = new Users();
        Users user2 = new Users();
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<Users> result = userResource.getUser();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetUserById() {
        Users user = new Users();
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Users result = userResource.getUserById(1L);
        assertEquals(user, result);
    }

    @Test
    public void testDeleteUserById() {
        doNothing().when(userRepository).deleteById(1L);

        userResource.deleteUserById(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testUpdateUserById() {
        Users user = new Users();
        when(userRepository.save(user)).thenReturn(user);

        userResource.updateUserById(1L, user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testCreateUser() {
        Users user = new Users();
        when(userRepository.save(user)).thenReturn(user);

        userResource.createUser(user);
        verify(userRepository, times(1)).save(user);
    }
}
