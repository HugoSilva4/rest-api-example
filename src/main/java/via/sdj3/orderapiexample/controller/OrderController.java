package via.sdj3.orderapiexample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import via.sdj3.orderapiexample.model.Order;
import via.sdj3.orderapiexample.service.OrderServiceImpl;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrderController {
    private Logger logger = LoggerFactory.getLogger(OrderController.class);
    private OrderServiceImpl orderService;
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    // CRUD endpoint follows

    // http://localhost:8090/api/orders
    @PostMapping("/orders")
    public ResponseEntity<Object> createOrder(@RequestBody Order order){
        try {
            Order createdOrder = orderService.create(order);
            return new ResponseEntity<Object>(createdOrder, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/orders")
    public ResponseEntity<Object> getAllOrders(){
        try {
            Iterable<Order> orders = orderService.findAllItr();
            return new ResponseEntity<Object>(orders, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    //@GetMapping("/orders/{id}")  // can include MediaType as well
    @GetMapping(value="/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getOrderById(@PathVariable("id") Long id){
        try {
            Optional<Order> order = orderService.findById(id);
            if (order.isPresent()) {
                return new ResponseEntity<Object>(order.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Object> updateOrder(@PathVariable("id") Long id, @RequestBody Order order){
        try {
            order.setId(id);
            Order savedOrder = orderService.update(order);
            return new ResponseEntity<Object>(savedOrder, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") Long id){
        try {
            orderService.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }
}