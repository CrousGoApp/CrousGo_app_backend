package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Orders;
import com.imt.fw.crousgo_app_backend.repositories.OrderRepository;

import jakarta.validation.constraints.NotNull;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Path("orders")
public class OrderResource {

    @Autowired
    private OrderRepository orderRepository;

    @GET
    @Produces(value = "application/json")
    public List<Orders> getOrder() {
        return orderRepository.findAll();
    }

    // get order by id
    @GET
    @Path("/{id}")
    @Produces(value = "application/json")
    public Orders getOrderById(@PathParam("id") Long id){
        return orderRepository.findById(id).orElse(null);
    }

    // delete order by id
    @DELETE
    @Path("/{id}")
    public void deleteOrder(@PathParam("id") Long id){
        orderRepository.deleteById(id);
    }

    //update order by id
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void updateOrder(@PathParam("id") Long id, @NotNull @RequestBody Orders order){
        orderRepository.save(order);
    }

}
