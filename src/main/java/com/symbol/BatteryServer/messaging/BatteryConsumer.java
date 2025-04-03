package com.symbol.BatteryServer.messaging;

import com.symbol.BatteryServer.model.Battery;
import com.symbol.BatteryServer.service.BatteryService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BatteryConsumer {

    private final BatteryService batteryService;

    public BatteryConsumer(BatteryService batteryService) {
        this.batteryService = batteryService;
    }

    @JmsListener(destination = "battery.queue", containerFactory = "jmsListenerContainerFactory")
    public void consumeBattery(Battery battery) throws Exception {
        batteryService.push(battery);
    }
}