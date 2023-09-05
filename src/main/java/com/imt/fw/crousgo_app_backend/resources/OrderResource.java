package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Orders;
import com.imt.fw.crousgo_app_backend.repositories.OrderRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("orders")
public class OrderResource {

    @Inject
    private OrderRepository orderRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Orders> getOrder() {
        return orderRepository.findAll();
    }

    // get order by id
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Orders getOrderById(@PathParam("id") Long id){
        return orderRepository.findById(id).orElse(null);
    }

    // delete order by id
    @DELETE
    @Path("{id}")
    public void deleteOrder(@PathParam("id") Long id){
        orderRepository.deleteById(id);
    }

    // update order by id
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateOrder(@PathParam("id") Long id, Orders order){
        orderRepository.save(order);
    }
}
