package mk.ukim.finki.wp.lab1_nova.repository;

import mk.ukim.finki.wp.lab1_nova.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab1_nova.model.Order;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class OrderRepository {
    public Optional<Order> findByClientName(String clientName){
        return DataHolder.orders.stream().filter(r->r.getClientName().equals(clientName)).findFirst();
    }

    public Optional<Order> findByClientNameAndOrderId(String clientName,Long orderId){
        return DataHolder.orders.stream().filter(r->r.getClientName().equals(clientName)&&r.getOrderId().equals(orderId)).findFirst();
    }

    public Order saveOrUpdate(Order order){
        DataHolder.orders.removeIf(r->r.getClientName().equals(order.getClientName()));
        DataHolder.orders.add(order);
        return order;
    }

    public void delete(String clientName){
        DataHolder.orders.removeIf(r->r.getClientName().equals(clientName));
    }

}

