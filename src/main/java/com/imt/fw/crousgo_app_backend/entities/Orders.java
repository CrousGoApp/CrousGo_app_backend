package com.imt.fw.crousgo_app_backend.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_email")
    private String user_mail;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDish> orderDishes;


    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    public Long getId() {
        return id;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String users_id) {
        this.user_mail = users_id;
    }

    public List<OrderDish> getOrderDishes() {
        return orderDishes;
    }

    public void setOrderDishes(List<OrderDish> orderDishes) {
        this.orderDishes = orderDishes;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
