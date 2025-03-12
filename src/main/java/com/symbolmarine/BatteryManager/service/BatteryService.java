package com.symbolmarine.BatteryManager.service;

import com.symbolmarine.BatteryManager.model.Battery;
import com.symbolmarine.BatteryManager.repository.BatteryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public class BatteryService {
    @Autowired
    private BatteryRepository batteryRepository;

    @Transactional
    public void push(Battery battery) {
        batteryRepository.save(battery);
    }

    public List<Battery> pull(Integer count) {
        return batteryRepository.findTop50ByOrderByIdDesc();
    }
}
