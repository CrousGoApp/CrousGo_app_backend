package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Users;
import com.imt.fw.crousgo_app_backend.repositories.UserRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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
}
