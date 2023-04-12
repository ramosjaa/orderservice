package edu.iu.c322.orderservice.repository;

import edu.iu.c322.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByCustomerId(int customerId);



    /*List<Order> orders = new ArrayList();

    @GetMapping("/orders")
    public int create(Order order){
        int id = orders.size() + 1;
        order.setCustomerId(id);
        orders.add(order);
        return id;
    }

    @GetMapping("/orders/{id}")
    public void update(Order order, @PathVariable int id){
        Order temp = getOrderById(id);
        if(temp != null){

        } else{
            throw new IllegalStateException("order id is not valid.");
        }
    }

    @GetMapping("/orders/{id}")
    public void delete(@PathVariable int id){
        Order temp = getOrderById(id);
        if(temp != null){
            orders.remove(temp);
        } else{
            throw new IllegalStateException("order id is not valid.");
        }
    }

    @GetMapping("/orders/{customerId}")
    private Order getOrderById(@PathVariable int customerId){
        return orders.stream().filter(temp -> temp.getCustomerId() == customerId).findAny().orElse(null);
    }*/
}
