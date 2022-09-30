package via.sdj3.orderapiexample.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {

    @PostMapping("/orders")  // C endpoint
    public String createOrder() {
        System.out.println("\n [Backend - Server] create operation is reached");
        return "HTTP POST - Create";
    }

    @GetMapping("/orders/{id}")  // R endpoint
    public String getOrder() {
        System.out.println("\n [Backend - Server] Read operation is reached");
        return "HTTP GET - Read";
    }

    @PutMapping("/orders/{id}")  // U endpoint
    public String updateOrder() {
        System.out.println("\n [Backend - Server] update operation is reached");
        return "HTTP PUT - Update";
    }

    @DeleteMapping("/orders/{id}")  // D endpoint
    public String deleteOrder() {
        System.out.println("\n [Backend - Server] delete operation is reached");
        return "HTTP DELETE - Delete";
    }

}