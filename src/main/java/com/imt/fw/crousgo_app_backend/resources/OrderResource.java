package com.imt.fw.crousgo_app_backend.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.imt.fw.crousgo_app_backend.dto.OrderDTO;
import com.imt.fw.crousgo_app_backend.dto.OrderDTO.DishOrder;
import com.imt.fw.crousgo_app_backend.entities.Classroom;
import com.imt.fw.crousgo_app_backend.entities.Dish;
import com.imt.fw.crousgo_app_backend.entities.OrderDish;
import com.imt.fw.crousgo_app_backend.entities.Users;
import com.imt.fw.crousgo_app_backend.entities.Orders;
import com.imt.fw.crousgo_app_backend.repositories.ClassroomRepository;
import com.imt.fw.crousgo_app_backend.repositories.DishRepository;
import com.imt.fw.crousgo_app_backend.repositories.OrderRepository;
import com.imt.fw.crousgo_app_backend.repositories.UserRepository;

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

    @Inject
    private UserRepository UserRepository;

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
    public Response updateOrderState(@PathParam("id") Long id, Orders order){
        Optional<Orders> existingOrderOpt = orderRepository.findById(id);
        Orders existingOrder = existingOrderOpt.get();
        Users user = UserRepository.findByEmail(existingOrder.getUser_mail()).orElse(null);
        if (existingOrderOpt.isEmpty()) {
            return Response.status(404).entity("No order found").build();
        }
        
    
        // Vérifie si l'état actuel est 1 ou 2 et si le nouvel état est 5
        if ((existingOrder.getState() == 1 || existingOrder.getState() == 2) && order.getState() == 5) {
            // Annule la commande et créditez le compte utilisateur
            int orderAmount = existingOrder.getTotal();
            
            if (user == null) {
                return Response.status(404).entity("User not found").build();
            }
            int currentWalletBalance = user.getWallet();
            user.setWallet(currentWalletBalance + orderAmount); // Créditez le compte utilisateur
    
            // Met à jour l'état de la commande à annulé
            existingOrder.setState(5);
        } else {
            // Met à jour les champs de la commande existante avec les valeurs de l'objet `order` fourni
            existingOrder.setState(order.getState());
        }
    
        try {
            orderRepository.save(existingOrder);
            UserRepository.save(user); // Sauvegarde l'utilisateur après avoir mis à jour son portefeuille
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
            
            Users user = UserRepository.findByEmail(orderDTO.getUser_mail()).orElse(null);
            int totalOrderCost = calculateTotalOrderCost(orderDTO);
            if (user.getWallet() < totalOrderCost) {
                return Response.status(400).entity("Solde insuffisant").build();
            }
            user.setWallet(user.getWallet() - totalOrderCost);
            UserRepository.save(user);
            order.setTotal(totalOrderCost);
            Orders savedOrder = orderRepository.save(order);
            return Response.status(201).entity(savedOrder).build();
        } catch (Exception e) {
            System.out.println(e);
            return Response.status(500).entity("Error while adding order").build();
        }
    }


    private int calculateTotalOrderCost(OrderDTO orderDTO) {
        List<DishOrder> dishOrders = orderDTO.getDishes();
        int somme = 0;
        for (DishOrder dishOrder : dishOrders) {
            Dish dish = dishRepository.findById(dishOrder.getId()).orElse(null);
            somme += dish.getPrice() * dishOrder.getQuantity();       
        }
        return somme;
    }

    private Orders convertToEntity(OrderDTO orderDTO) {
        Orders order = new Orders();
        
        order.setUser_mail(orderDTO.getUser_mail());
            
        // Fetch dishes from database using dishIds from the DTO
        List<DishOrder> dishOrders = orderDTO.getDishes();
        List<OrderDish> orderDishes = new ArrayList<>();

        for (DishOrder dishOrder : dishOrders) {
            Dish dish = dishRepository.findById(dishOrder.getId()).orElse(null);
            if (dish != null) {
                OrderDish orderDish = new OrderDish();
                orderDish.setOrder(order);
                orderDish.setDish(dish);
                orderDish.setQuantity(dishOrder.getQuantity());
                orderDishes.add(orderDish);
            }
        }

        order.setOrderDishes(orderDishes);
        
        // Fetch classroom from database using classroomId and set to order
        Classroom classroom = classroomRepository.findById(orderDTO.getClassroomId()).orElse(null);
        order.setClassroom(classroom);
        
        return order;
    }



}
