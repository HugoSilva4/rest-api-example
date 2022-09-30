package via.sdj3.orderapiexample.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import via.sdj3.orderapiexample.model.Order0;
import via.sdj3.orderapiexample.repository.OrderRepository0;

import java.util.List;

@RestController
@RequestMapping("/")
public class OrderController0 {
    private OrderRepository0 orderRepo;

    public OrderController0(OrderRepository0 orderRepo) {
        this.orderRepo = orderRepo;
    }

    // @GetMapping can be used as well -- see the main controller
    @RequestMapping(value = "/orders/{id}", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
    @ResponseBody
    public Order0 getOrderById(@PathVariable Long id) {
        return orderRepo.findById(id);
    }

    @RequestMapping(value = "/orders", //
            method = RequestMethod.GET, //,
    produces = {MediaType.APPLICATION_JSON_VALUE} )
    @ResponseBody
    public List<Order0> getAllOrders() {
        List<Order0> list = orderRepo.findAll();
        return list;
    }

    @RequestMapping(value = "/orders",
    method = RequestMethod.POST)
    @ResponseBody
    public Order0 createOrder(@RequestBody Order0 order) {
        return orderRepo.save(order);
    }
}
