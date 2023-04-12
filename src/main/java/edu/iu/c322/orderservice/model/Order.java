package edu.iu.c322.orderservice.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int orderId;
    private int customerId;
    private double total;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address shippingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment-id")
    private Payment payment;

    @OneToMany(mappedBy="order", cascade = CascadeType.ALL)
    private List<Item> items;

    public int getOrderId() {
        return orderId;
    }
    public int getCustomerId(){
        return customerId;
    }
    public double getTotal() {
        return total;
    }
    public List<Item> getItems() {
        return items;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
}