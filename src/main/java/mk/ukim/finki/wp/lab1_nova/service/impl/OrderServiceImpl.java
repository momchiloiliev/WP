package mk.ukim.finki.wp.lab1_nova.service.impl;

import mk.ukim.finki.wp.lab1_nova.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab1_nova.model.Order;
import mk.ukim.finki.wp.lab1_nova.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.wp.lab1_nova.model.exceptions.InvalidUserCredentialsExceptions;
import mk.ukim.finki.wp.lab1_nova.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.wp.lab1_nova.repository.InMemoryUserRepository;
import mk.ukim.finki.wp.lab1_nova.repository.OrderRepository;
import mk.ukim.finki.wp.lab1_nova.service.OrderService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final InMemoryUserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, InMemoryUserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

//    @Override
//    public Order placeOrder(String balloonColor, String clientName, String address, LocalDateTime dateTime) {
//        User user = userRepository.findByUsername(clientName).orElseThrow(InvalidUserCredentialsExceptions::new);
//        return orderRepository.saveOrUpdate(new Order(balloonColor,"","ime", "adress"));
//    }

public Optional<User> findByUsername(String username){
    return DataHolder.users.stream().filter(r->r.getUsername().equals(username)).findFirst();
}

    public Optional<User> findByUsernameAndPassword(String username, String password){
        return DataHolder.users.stream().filter(r->r.getUsername().equals(username) && r.getPassword().equals(password)).findFirst();
    }


//    @Override
//    public Order placeOrder(String balloonColor, String clientName, String address, LocalDateTime dateTime) {
//        User user = userRepository.findByUsername(clientName).orElseThrow(InvalidUserCredentialsExceptions::new);
//        return orderRepository.saveOrUpdate(new Order(balloonColor,"","imee","address"));
//    }

    @Override
    public List<Order> searchByClient(String name, String address) {
        return null;
    }

    @Override
    public User login(String username, String password) {
        if(username == null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,password).orElseThrow(InvalidUserCredentialsExceptions::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        return null;
    }

//    @Override
//    public User register(String username, String password, String repeatPassword, String name, String surname) {
//        if(username == null || username.isEmpty() || password==null || password.isEmpty()){
//            throw new InvalidArgumentsException();
//        }
//
//        if(!password.equals(repeatPassword)){
//            throw new PasswordsDoNotMatchException();
//        }
//        User user = new User(username,password,name,surname);
//        return userRepository.saveOrUpdate(user);
//    }



}
