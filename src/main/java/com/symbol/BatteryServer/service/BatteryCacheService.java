package com.symbol.BatteryServer.service;

import com.symbol.BatteryServer.model.Battery;
import com.symbol.BatteryServer.repository.BatteryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Deque;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

@Service
public class BatteryCacheService {
    private final int cacheSize = 50;

    private final Deque<Battery> batteryCache = new LinkedBlockingDeque<>(cacheSize);

    private final BatteryRepository batteryRepository;

    public  BatteryCacheService(BatteryRepository batteryRepository) {
        this.batteryRepository = batteryRepository;
    }

    @PostConstruct
    public void init() {
        List<Battery> list = batteryRepository.findByIdDesc(PageRequest.of(0, cacheSize));
        list.forEach(batteryCache::addLast);
    }

    public void push(Battery battery) {
        if (batteryCache.size() == cacheSize) {
            batteryCache.removeLast();
        }
        batteryCache.addFirst(battery);
    }

    public List<Battery> pull(Integer count) {
        return batteryCache.stream().toList();
    }
}
