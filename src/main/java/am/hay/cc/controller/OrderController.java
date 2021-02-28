package am.hay.cc.controller;

import am.hay.cc.email.service.EmailService;
import am.hay.cc.model.Order;
import am.hay.cc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final EmailService emailService;

    @Autowired
    public OrderController(final OrderService orderService, final EmailService emailService) {
        this.orderService = orderService;
        this.emailService = emailService;
    }

    @GetMapping("")
    public ResponseEntity<List<Order>> getAll() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> getById(@PathVariable(value = "id") final String id) {
        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Order> create(@RequestBody final Order order) {
        emailService.sendSimpleMessage("ghazaryan.gevor97@outlook.com", order, "hello");
        return new ResponseEntity<>(orderService.save(order), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") final String id, @RequestBody final Order order) {
        return new ResponseEntity<>(orderService.updateById(order, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") final String id) {
        return new ResponseEntity<>(orderService.deleteByID(id), HttpStatus.OK);
    }

}
