package com.symbolmarine.BatteryManager.service;

import com.symbolmarine.BatteryManager.model.Battery;
import com.symbolmarine.BatteryManager.repository.BatteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public class BatteryService {
    @Autowired
    private BatteryRepository batteryRepository;
    private static final List<Battery> batteryList = new ArrayList<>();

    static {

    }

//    @Transactional
    public void push(Battery battery) {
        batteryList.add(battery);
    }

    public List<Battery> pull(Integer count) {
        return batteryRepository.findTop50ByOrderByIdDesc();
    }
}
