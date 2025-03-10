package com.symbolmarine.BatteryManager.service;

import com.symbolmarine.BatteryManager.model.Battery;
import com.symbolmarine.BatteryManager.model.Yeli;
import com.symbolmarine.BatteryManager.repository.BatteryRepository;
import com.symbolmarine.BatteryManager.repository.BatteryRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public class BatteryService {
//    @Autowired
//    private BatteryRepository batteryRepository;
    private static final List<Battery> batteryList = new ArrayList<>();

    static {

    }

//    @Transactional
    public void push(Battery battery) {
        batteryList.add(battery);
    }

    public List<Battery> pull(Integer count) {
        List<Battery> result = new ArrayList<>();
        ListIterator<Battery> iterator = batteryList.listIterator(batteryList.size());
        while (iterator.hasPrevious() && count > 0) {
            count -= 1;
            result.add(iterator.previous());
        }
        return result;
    }
}
