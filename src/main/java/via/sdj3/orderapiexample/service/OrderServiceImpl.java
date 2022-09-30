package via.sdj3.orderapiexample.service;

import org.springframework.stereotype.Service;
import via.sdj3.orderapiexample.model.Order;
import via.sdj3.orderapiexample.repository.OrderRepository;


import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    // inject the repo
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Iterable<Order> findAllItr() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}