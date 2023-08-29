package com.imt.fw.crousgo_app_backend.resources;

import com.imt.fw.crousgo_app_backend.entities.Order;
import com.imt.fw.crousgo_app_backend.repositories.OrderRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("order")
public class OrderResource {

    @Autowired
    private OrderRepository orderRepository;

    @GET
    @Produces(value = "application/json")
    public List<Order> getOrder() {
        return orderRepository.findAll();
    }
}
