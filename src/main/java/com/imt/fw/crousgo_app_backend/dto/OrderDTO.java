package com.imt.fw.crousgo_app_backend.dto;

import java.util.List;

public class OrderDTO {
    private String user_mail;
    private List<DishOrder> dishes; 
    private Long classroomId;

    public static class DishOrder {
        private Long id;
        private int quantity;

        public Long getId(){
            return id;
        }

        public void setId(Long id){
            this.id = id;
        }

        public int getQuantity(){
            return quantity;
        }

        public void setQuantity(int quantity){
            this.quantity = quantity;
        }
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public List<DishOrder> getDishes() { 
        return dishes;
    }

    public void setDishes(List<DishOrder> dishes) { 
        this.dishes = dishes;
    }

    public Long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }
}
