package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Categorie;
import com.imt.fw.crousgo_app_backend.repositories.CategorieRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.validation.constraints.NotNull;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Path("categories")
public class CategorieResource {

    @Inject
    private CategorieRepository categorieRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categorie> getCategorie() {
        List<Categorie> categories = categorieRepository.findAll();
        if (categories.isEmpty()) {
            throw new WebApplicationException("No categories found", 404);
        }
        return categories;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCategorie(@NotNull Categorie categorie) {
        try {
            categorieRepository.save(categorie);
            return Response.status(201).entity("Categorie created").build();
        } catch (Exception e) {
            throw new WebApplicationException("Categorie could not be created", 500);
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Categorie getCategorieById(@PathParam("id") Long id) {
        Optional<Categorie> categorie = categorieRepository.findById(id);
        return categorie.orElseThrow(() -> new WebApplicationException("Categorie not found", 404));
    }

    @DELETE
    @Path("{id}")
    public Response deleteCategorieById(@PathParam("id") Long id) {
        try {
            categorieRepository.deleteById(id);
            return Response.status(200).entity("Categorie deleted").build();
        } catch (Exception e) {
            throw new WebApplicationException("Categorie could not be deleted", 500);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCategorieById(@PathParam("id") Long id, Categorie categorie) {
        if (!categorieRepository.existsById(id)) {
            throw new WebApplicationException("Categorie not found", 404);
        }
        try {
            categorieRepository.save(categorie);
            return Response.status(200).entity("Categorie updated").build();
        } catch (Exception e) {
            throw new WebApplicationException("Categorie could not be updated", 500);
        }
    }
}
