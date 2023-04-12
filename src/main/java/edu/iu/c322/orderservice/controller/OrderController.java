package edu.iu.c322.orderservice.controller;

import edu.iu.c322.orderservice.model.Item;
import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderRepository repository;

    public OrderController(OrderRepository repository){
        this.repository = repository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@Valid @RequestBody Order order){
        for(int i = 0; i < order.getItems().size(); i++){
            Item item = order.getItems().get(i);
            item.setOrder(order);
        }
        Order newOrder = repository.save(order);
        return newOrder.getOrderId();
    }

    // PUT localhost:8080/customers/2
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Order order, @PathVariable int id){
        order.setOrderId(id);
        repository.save(order);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        Order order = new Order();
        order.setOrderId(id);
        repository.delete(order);
    }}
