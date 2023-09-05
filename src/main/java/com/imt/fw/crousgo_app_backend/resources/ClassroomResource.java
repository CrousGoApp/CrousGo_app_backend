package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Classroom;
import com.imt.fw.crousgo_app_backend.repositories.ClassroomRepository;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.validation.constraints.NotNull;
import jakarta.inject.Inject;

import java.util.List;

@Path("classrooms")
public class ClassroomResource {

    @Inject
    private ClassroomRepository classroomRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Classroom> getClassroom() {
        return classroomRepository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createClassroom(@NotNull Classroom classroom){
        classroomRepository.save(classroom);
    }

    @DELETE
    @Path("{id}")
    public void deleteClassroom(@PathParam("id") Long id){
        classroomRepository.deleteById(id);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateClassroom(@PathParam("id") Long id, Classroom classroom){
        classroomRepository.save(classroom);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Classroom getClassroomById(@PathParam("id") Long id){
        return classroomRepository.findById(id).orElse(null);
    }
}
