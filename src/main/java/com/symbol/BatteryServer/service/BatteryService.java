package com.symbol.BatteryServer.service;

import com.symbol.BatteryServer.model.Battery;
import com.symbol.BatteryServer.repository.BatteryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BatteryService {

    private final BatteryRepository batteryRepository;
    private final BatteryCacheService batteryCacheService;

    public BatteryService(BatteryRepository batteryRepository, BatteryCacheService batteryCacheService) {
        this.batteryRepository = batteryRepository;
        this.batteryCacheService = batteryCacheService;
    }

    @Transactional
    public void push(Battery battery) {
        batteryRepository.save(battery);
        batteryCacheService.push(battery);
    }

    public List<Battery> pull(Integer count) {
        return batteryCacheService.pull(count);
    }
}
