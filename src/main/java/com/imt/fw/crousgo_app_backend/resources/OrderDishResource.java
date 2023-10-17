package com.imt.fw.crousgo_app_backend.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.imt.fw.crousgo_app_backend.entities.OrderDish;
import com.imt.fw.crousgo_app_backend.repositories.OrderDishRepository;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.validation.constraints.NotNull;
import jakarta.inject.Inject;


@Path("/orderDishes")
public class OrderDishResource {

    @Autowired
    private OrderDishRepository orderDishRepository;

    // Endpoint pour obtenir tous les OrderDish
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderDish> getAllOrderDishes() {
        return orderDishRepository.findAll();
    }

    // Endpoint pour créer un nouvel OrderDish
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public OrderDish createOrderDish(@RequestBody OrderDish orderDish) {
        return orderDishRepository.save(orderDish);
    }

    // Ajoutez d'autres endpoints selon vos besoins (par exemple, pour la mise à jour, la suppression, etc.)
}
