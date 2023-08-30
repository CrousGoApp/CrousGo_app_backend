package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Allergen;
import com.imt.fw.crousgo_app_backend.entities.Categorie;
import com.imt.fw.crousgo_app_backend.repositories.CategorieRepository;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Path("categories")
public class CategorieResource {

    @Autowired
    private CategorieRepository categorieRepository;

    @GET
    @Produces(value = "application/json")
    public List<Categorie> getCategorie() {
        return categorieRepository.findAll();
    }
    @POST
    @Consumes("application/json")
    public void createCategorie(@NotNull @RequestBody Categorie categorie){
        categorieRepository.save(categorie);
    }
}
