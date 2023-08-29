package com.imt.fw.crousgo_app_backend.repositories;

import com.imt.fw.crousgo_app_backend.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface DishRepository extends JpaRepository<Dish, Long> {
}
