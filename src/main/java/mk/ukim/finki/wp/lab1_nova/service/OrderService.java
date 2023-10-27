package mk.ukim.finki.wp.lab1_nova.service;

import mk.ukim.finki.wp.lab1_nova.model.Order;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


public interface OrderService {
//    Order placeOrder(String balloonColor, String clientName, String address);

    List<Order> searchByClient(String name, String address);
    User login(String username, String password);
    User register(String username, String password, String repeatPassword, String name, String surname);

//    List<Order> filterOrders(LocalDateTime from, LocalDateTime to);
}
