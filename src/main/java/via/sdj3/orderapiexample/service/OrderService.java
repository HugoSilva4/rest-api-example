package via.sdj3.orderapiexample.service;

import org.springframework.stereotype.Service;
import via.sdj3.orderapiexample.model.Order;


import java.util.List;
import java.util.Optional;

@Service // shorthand for @Bean to register OrderService interface as a bean
public interface OrderService {
    Order create(Order order);
    List<Order> findAll();  //  use List or Iterable
    Iterable<Order> findAllItr(); // use List or Iterable
    Optional<Order> findById(Long id);
    Order update(Order order);
    void deleteById(Long id);
}