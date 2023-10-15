package com.imt.fw.crousgo_app_backend.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user")
    private String user_mail;

    @OneToMany
    @JoinTable(
            name = "order_dish",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dish> dish;

    @OneToOne
    @JoinTable(
            name = "order_classroom",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "classroom_id")
    )
    private Classroom classroom;

    public Long getId() {
        return id;
    }

    public String getusers_id() {
        return user_mail;
    }

    public void setusers_id(Users users_id) {
        this.user_mail = user_mail;
    }

    public List<Dish> getDish() {
        return dish;
    }

    public void setDish(List<Dish> dish) {
        this.dish = dish;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
