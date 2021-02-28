package am.hay.cc.email.impl;

import am.hay.cc.email.MailSenderManager;
import am.hay.cc.model.Order;
import am.hay.cc.service.HomeCleaningService;
import am.hay.cc.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@PropertySource("classpath:email.properties")
public class EmailServiceImpl implements EmailService {


    private final MailSenderManager mailSenderManager;
    private final HomeCleaningService homeCleaningService;

    @Autowired
    public EmailServiceImpl(MailSenderManager mailSenderManager, HomeCleaningService homeCleaningService) {
        this.mailSenderManager = mailSenderManager;
        this.homeCleaningService = homeCleaningService;
    }


    public void sendSimpleMessage(String to, Order order, String text) {
        String subject = order.getClientEmail() + " " +
                order.getClientName() + " " +
                order.getClientPhoneNumber() + " " +
                order.getSquare() + " " +
                homeCleaningService.findById(order.getCleaningTypeId());
        new Thread(() -> mailSenderManager.sendMail(to, subject, text)).start();
    }
}
