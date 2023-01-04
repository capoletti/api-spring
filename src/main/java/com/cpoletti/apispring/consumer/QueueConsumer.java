package com.cpoletti.apispring.consumer;

import com.cpoletti.apispring.dto.Customer;
import com.cpoletti.apispring.service.CustomerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Calendar;

@Component
public class QueueConsumer {

    @Autowired
    CustomerService customerService;

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(Customer customer) {
        //System.out.println("consumer: "+ customer);
        customerService.add(customer);
    }
}