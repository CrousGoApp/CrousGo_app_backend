package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Allergen;
import com.imt.fw.crousgo_app_backend.repositories.AllergenRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("allergen")
public class AllergenResource {

    @Autowired
    private AllergenRepository allergenRepository;

    @GET
    @Produces(value = "application/json")
    public List<Allergen> getAllergen() {
        return allergenRepository.findAll();
    }
}
