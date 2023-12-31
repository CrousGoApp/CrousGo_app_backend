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

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderDish> orderDishes;

    @Column(name = "state")
    private int state = 1;

    @Column(name = "total")
    private int total = 0;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    public int getTotal(){
        return this.total;
    }

    public void setTotal(int total){
        this.total = total;
    }

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

    public int getState(){
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
