package am.hay.cc.email.service;

import am.hay.cc.model.Order;

public interface EmailService {

    void sendSimpleMessage(String to, Order order, String text);
}
