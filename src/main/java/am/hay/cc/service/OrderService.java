package am.hay.cc.service;

import am.hay.cc.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();

    Order save(final Order order);

    Order updateById(final Order order, final String id);

    boolean deleteByID(final String id);

    Order findById(final String id);
}
