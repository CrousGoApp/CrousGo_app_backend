package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Allergen;
import com.imt.fw.crousgo_app_backend.repositories.AllergenRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.validation.constraints.NotNull;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Path("allergens")
public class AllergenResource {

    @Inject
    private AllergenRepository allergenRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Allergen> getAllergen() {
        List<Allergen> allergens = allergenRepository.findAll();
        if (allergens.isEmpty()) {
            throw new WebApplicationException("No allergens found", 404);
        }
        return allergens;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAllergen(@NotNull Allergen allergen) {
        try {
            allergenRepository.save(allergen);
            return Response.status(201).entity("Allergen created").build();
        } catch (Exception e) {
            throw new WebApplicationException("Allergen could not be created", 500);
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAllergen(@PathParam("id") Long id) {
        try {
            allergenRepository.deleteById(id);
            return Response.status(200).entity("Allergen deleted").build();
        } catch (Exception e) {
            throw new WebApplicationException("Allergen could not be deleted", 500);
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAllergen(@PathParam("id") Long id, Allergen allergen) {
        if (!allergenRepository.existsById(id)) {
            throw new WebApplicationException("Allergen not found", 404);
        }
        try {
            allergenRepository.save(allergen);
            return Response.status(200).entity("Allergen updated").build();
        } catch (Exception e) {
            throw new WebApplicationException("Allergen could not be updated", 500);
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Allergen getAllergenById(@PathParam("id") Long id) {
        Optional<Allergen> allergen = allergenRepository.findById(id);
        return allergen.orElseThrow(() -> new WebApplicationException("Allergen not found", 404));
    }
}
