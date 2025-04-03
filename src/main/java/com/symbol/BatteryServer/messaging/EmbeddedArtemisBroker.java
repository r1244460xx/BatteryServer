package com.symbol.BatteryServer.messaging;

import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl;
import org.apache.activemq.artemis.core.server.embedded.EmbeddedActiveMQ;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class EmbeddedArtemisBroker {

    private EmbeddedActiveMQ broker;

    @PostConstruct
    public void start() throws Exception {
        ConfigurationImpl config = new ConfigurationImpl();
        config.setPersistenceEnabled(false)
                .setSecurityEnabled(false)
                .addAcceptorConfiguration("in-vm", "vm://0");

        broker = new EmbeddedActiveMQ();
        broker.setConfiguration(config);
        broker.start();
        System.out.println("✅ Embedded Artemis broker 已啟動！");
    }

    @PreDestroy
    public void stop() throws Exception {
        if (broker != null) {
            broker.stop();
            System.out.println("🛑 Embedded Artemis broker 已停止！");
        }
    }
}
