package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Classroom;
import com.imt.fw.crousgo_app_backend.repositories.ClassroomRepository;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.validation.constraints.NotNull;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Path("classrooms")
public class ClassroomResource {

    @Inject
    private ClassroomRepository classroomRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Classroom> getClassroom() {
        List<Classroom> classrooms = classroomRepository.findAll();
        if (classrooms.isEmpty()) {
            throw new WebApplicationException("No classrooms found", 404);
        }
        return classrooms;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createClassroom(@NotNull Classroom classroom) {
        try {
            classroomRepository.save(classroom);
            return Response.status(201).entity("Classroom created").build();
        } catch (Exception e) {
            throw new WebApplicationException("Classroom could not be created", 500);
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteClassroom(@PathParam("id") Long id) {
        if (!classroomRepository.existsById(id)) {
            throw new WebApplicationException("Classroom not found", 404);
        }
        try {
            classroomRepository.deleteById(id);
            return Response.status(200).entity("Classroom deleted").build();
        } catch (Exception e) {
            throw new WebApplicationException("Classroom could not be deleted", 500);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateClassroom(@PathParam("id") Long id, Classroom classroom) {
        if (!classroomRepository.existsById(id)) {
            throw new WebApplicationException("Classroom not found", 404);
        }
        try {
            classroomRepository.save(classroom);
            return Response.status(200).entity("Classroom updated").build();
        } catch (Exception e) {
            throw new WebApplicationException("Classroom could not be updated", 500);
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Classroom getClassroomById(@PathParam("id") Long id) {
        Optional<Classroom> classroom = classroomRepository.findById(id);
        return classroom.orElseThrow(() -> new WebApplicationException("Classroom not found", 404));
    }
}
