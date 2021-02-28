package am.hay.cc.service.impl;

import am.hay.cc.exception.PersistFailureException;
import am.hay.cc.exception.RecordNotFoundException;
import am.hay.cc.model.Order;
import am.hay.cc.repository.OrderRepository;
import am.hay.cc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order save(final Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateById(final Order order, final String id) {
        return orderRepository.findById(id).map(
                existingOrder -> {
                    order.setId(existingOrder.getId());
                    existingOrder = order;
                    return orderRepository.save(existingOrder);
                }).orElseThrow(() -> new PersistFailureException("Persist not succeed"));
    }

    @Override
    public boolean deleteByID(final String id) {
        try {
            orderRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Order findById(final String id) {
        return orderRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Benefit record not found"));
    }
}


