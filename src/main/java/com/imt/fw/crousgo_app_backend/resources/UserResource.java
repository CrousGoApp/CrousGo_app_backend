package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Users;
import com.imt.fw.crousgo_app_backend.repositories.UserRepository;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("users")
public class UserResource {

    @Inject
    private UserRepository userRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser() {
        List<Users> users = userRepository.findAll();
        if (users.isEmpty()) {
            return Response.status(404).entity("No users found").build();
        }
        return Response.status(200).entity(users).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") Long id) {
        Optional<Users> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return Response.status(404).entity("User not found").build();
        }
        return Response.status(200).entity(user.get()).build();
    }

    @DELETE
    @Path("{id}")
    @PermitAll
    public Response deleteUserById(@PathParam("id") Long id) {
        if (userRepository.findById(id).isEmpty()) {
            return Response.status(404).entity("User not found").build();
        }
        try {
            userRepository.deleteById(id);
            return Response.status(200).entity("User deleted").build();
        } catch (Exception e) {
            return Response.status(500).entity("Error while deleting user").build();
        }
    }

    @PUT
    @Path("email/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response UpdateUserWalletByEmail(@PathParam("email") String email, Users user) {
        Optional<Users> existingUserOpt = userRepository.findByEmail(email);
        if (existingUserOpt.isEmpty()) {
            return Response.status(404).entity("User not found").build();
        }
        Users existingUser = existingUserOpt.get();
        
        // Vérifie que le montant saisi est positif
        if (user.getWallet() <= 0) {
            return Response.status(400).entity("Invalid amount. Please enter a positive value.").build();
        }
    
        // Additionne le solde saisi au solde actuel
        int newWalletBalance = existingUser.getWallet() + user.getWallet();
        existingUser.setWallet(newWalletBalance);
    
        try {
            userRepository.save(existingUser);
            return Response.status(200).entity("User updated").build();
        } catch (Exception e) {
            return Response.status(500).entity("Error while updating user").build();
        }
    }
    


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(Users user) {
        try {
            userRepository.save(user);
            return Response.status(201).entity("User created").build();
        } catch (Exception e) {
            return Response.status(500).entity("Error while creating user").build();
        }
    }
    @GET
    @Path("email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByEmail(@PathParam("email") String email) {
        Optional<Users> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            return Response.status(404).entity("User not found").build();
        }
        return Response.status(200).entity(user.get()).build();
    }

}
