package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Users;
import com.imt.fw.crousgo_app_backend.repositories.UserRepository;

import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("users")
public class UserResource {

    @Inject
    private UserRepository userRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> getUser() {
        return userRepository.findAll();
    }

    // Get user by id
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
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
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUserById(@PathParam("id") Long id, Users user) {
        userRepository.save(user);
    }

    // Create user
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(Users user) {
        userRepository.save(user);
    }
}
