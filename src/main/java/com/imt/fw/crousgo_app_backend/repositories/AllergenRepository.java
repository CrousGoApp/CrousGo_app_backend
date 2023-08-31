package com.imt.fw.crousgo_app_backend.repositories;

import com.imt.fw.crousgo_app_backend.entities.Allergen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AllergenRepository extends JpaRepository<Allergen, Long> {
    Allergen findByName(String name);
}
