package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Categorie;
import com.imt.fw.crousgo_app_backend.entities.Classroom;
import com.imt.fw.crousgo_app_backend.repositories.ClassroomRepository;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Path("classrooms")
public class ClassroomResource {

    @Autowired
    private ClassroomRepository classroomRepository;

    @GET
    @Produces(value = "application/json")
    public List<Classroom> getClassroom() {
        return classroomRepository.findAll();
    }

    @POST
    @Consumes("application/json")
    public void createClassroom(@NotNull @RequestBody Classroom classroom){
        classroomRepository.save(classroom);
}}
