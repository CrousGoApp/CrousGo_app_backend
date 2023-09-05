package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Orders;
import com.imt.fw.crousgo_app_backend.repositories.OrderRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Path("orders")
public class OrderResource {

    @Inject
    private OrderRepository orderRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrder() {
        List<Orders> orders = orderRepository.findAll();
        if (orders.isEmpty()) {
            return Response.status(404).entity("No orders found").build();
        }
        return Response.status(200).entity(orders).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderById(@PathParam("id") Long id){
        Optional<Orders> order = orderRepository.findById(id);
        if (order.isEmpty()) {
            return Response.status(404).entity("No order found").build();
        }
        return Response.status(200).entity(order.get()).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteOrder(@PathParam("id") Long id){
        if (orderRepository.findById(id).isEmpty()) {
            return Response.status(404).entity("No order found").build();
        }
        try {
            orderRepository.deleteById(id);
            return Response.status(200).entity("Order deleted").build();
        } catch (Exception e) {
            return Response.status(500).entity("Error while deleting order").build();
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOrder(@PathParam("id") Long id, Orders order){
        if (orderRepository.findById(id).isEmpty()) {
            return Response.status(404).entity("No order found").build();
        }
        try {
            orderRepository.save(order);
            return Response.status(200).entity("Order updated").build();
        } catch (Exception e) {
            return Response.status(500).entity("Error while updating order").build();
        }
    }
}
