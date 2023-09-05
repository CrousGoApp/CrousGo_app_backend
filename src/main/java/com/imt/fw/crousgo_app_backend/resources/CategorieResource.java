package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Categorie;
import com.imt.fw.crousgo_app_backend.repositories.CategorieRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.validation.constraints.NotNull;
import jakarta.inject.Inject;

import java.util.List;

@Path("categories")
public class CategorieResource {

    @Inject
    private CategorieRepository categorieRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categorie> getCategorie() {
        return categorieRepository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createCategorie(@NotNull Categorie categorie){
        categorieRepository.save(categorie);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Categorie getCategorieById(@PathParam("id") Long id){
        return categorieRepository.findById(id).orElse(null);
    }

    @DELETE
    @Path("{id}")
    public void deleteCategorieById(@PathParam("id") Long id){
        categorieRepository.deleteById(id);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateCategorieById(@PathParam("id") Long id, Categorie categorie){
        categorieRepository.save(categorie);
    }
}
