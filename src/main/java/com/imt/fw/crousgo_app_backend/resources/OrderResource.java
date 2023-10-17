package com.imt.fw.crousgo_app_backend.resources;

import java.util.List;
import java.util.Optional;

import com.imt.fw.crousgo_app_backend.dto.OrderDTO;
import com.imt.fw.crousgo_app_backend.entities.Classroom;
import com.imt.fw.crousgo_app_backend.entities.Dish;
import com.imt.fw.crousgo_app_backend.entities.Orders;
import com.imt.fw.crousgo_app_backend.repositories.ClassroomRepository;
import com.imt.fw.crousgo_app_backend.repositories.DishRepository;
import com.imt.fw.crousgo_app_backend.repositories.OrderRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



@Path("orders")
public class OrderResource {
    @Inject
    private DishRepository dishRepository;

    @Inject
    private ClassroomRepository classroomRepository;

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOrder(OrderDTO orderDTO) {
        try {
            
            Orders order = convertToEntity(orderDTO);
            
            Orders savedOrder = orderRepository.save(order);
            return Response.status(201).entity(savedOrder).build();
        } catch (Exception e) {
            System.out.println(e);
            return Response.status(500).entity("Error while adding order").build();
        }
    }

    private Orders convertToEntity(OrderDTO orderDTO) {
    Orders order = new Orders();
    
    order.setUser_mail(orderDTO.getUser_mail());
        
    // Fetch dishes from database using dishIds and set to order
    List<Dish> dishes = dishRepository.findAllById(orderDTO.getDishIds());
    order.setDish(dishes);

    // Fetch classroom from database using classroomId and set to order
    Classroom classroom = classroomRepository.findById(orderDTO.getClassroomId()).orElse(null);
    order.setClassroom(classroom);

    return order;

    }


}
