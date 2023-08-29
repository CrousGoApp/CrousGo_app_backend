package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Classroom;
import com.imt.fw.crousgo_app_backend.repositories.ClassroomRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("allergen")
public class ClassroomResource {

    @Autowired
    private ClassroomRepository allergenRepository;

    @GET
    @Produces(value = "application/json")
    public List<Classroom> getClassroom() {
        return allergenRepository.findAll();
    }
}
