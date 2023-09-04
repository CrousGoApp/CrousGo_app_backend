package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Users;
import com.imt.fw.crousgo_app_backend.repositories.UserRepository;

import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.*;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GET
    @Produces(value = "application/json")
    public List<Users> getUser() {
        return userRepository.findAll();
    }

    // Get user by id
    @GET
    @Path("{id}")
    @Produces(value = "application/json")
    public Users getUserById(@PathParam("id") Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Delete user by id    
    @DELETE
    @Path("{id}")
    @PermitAll
    public void deleteUserById(@PathParam("id") Long id) {
        userRepository.deleteById(id);
    }

    // Update user by id
    @PUT
    @Path("{id}")
    @Produces(value = "application/json")
    public void updateUserById(@PathParam("id") Long id, @RequestBody Users user) {
        userRepository.save(user);
    }

    // Create user
    @POST
    @Produces(value = "application/json")
    public void createUser(@RequestBody Users user){
        userRepository.save(user);
    }

}
