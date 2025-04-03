package com.symbol.BatteryServer.messaging;

import com.symbol.BatteryServer.model.Battery;
import jakarta.jms.ConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class BatteryProducer {
    private final JmsTemplate jmsTemplate;

    public BatteryProducer(ConnectionFactory connectionFactory) {
        this.jmsTemplate = new JmsTemplate(connectionFactory);
    }

    public void sendBatteryMessage(Battery battery) {
        jmsTemplate.convertAndSend("battery.queue", battery);
    }
}
