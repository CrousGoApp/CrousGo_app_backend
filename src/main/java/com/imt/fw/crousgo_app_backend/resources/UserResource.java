package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.User;
import com.imt.fw.crousgo_app_backend.repositories.UserRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("allergen")
public class UserResource {

    @Autowired
    private UserRepository allergenRepository;

    @GET
    @Produces(value = "application/json")
    public List<User> getUser() {
        return allergenRepository.findAll();
    }
}
