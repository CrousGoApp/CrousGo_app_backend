package com.imt.fw.crousgo_app_backend.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Dish {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "dish_allergen",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "allergen_id")
    )
    private List<Allergen> allergens;

    @ManyToMany
    @JoinTable(
            name = "dish_categorie",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id")
    )
    private List<Categorie> categorie;

    @Column(name = "picture")
    private String picture;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Allergen> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<Allergen> allergens) {
        this.allergens = allergens;
    }

    public List<Categorie> getCategorie() {
        return categorie;
    }

    public void setCategorie(List<Categorie> categorie) {
        this.categorie = categorie;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
