package com.imt.fw.crousgo_app_backend.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinTable(
            name = "order_user",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Users users_id;

    @OneToMany
    @JoinTable(
            name = "order_dish",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dish> dish;

    @Column(name = "classroom")
    private Long classroom;

    public Integer getId() {
        return id;
    }

    public Users getusers_id() {
        return users_id;
    }

    public void setusers_id(Users users_id) {
        this.users_id = users_id;
    }

    public List<Dish> getDish() {
        return dish;
    }

    public void setDish(List<Dish> dish) {
        this.dish = dish;
    }

    public Long getClassroom() {
        return classroom;
    }

    public void setClassroom(Long classroom) {
        this.classroom = classroom;
    }
}
