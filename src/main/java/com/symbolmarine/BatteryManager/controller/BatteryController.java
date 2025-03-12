package com.symbolmarine.BatteryManager.controller;

import com.symbolmarine.BatteryManager.model.Battery;
import com.symbolmarine.BatteryManager.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/battery")
@CrossOrigin(value = "http://localhost:3000")
public class BatteryController {
    @Autowired
    private BatteryService batteryService;

    @PostMapping
    public ResponseEntity<String> push(@RequestBody Battery battery) {
        batteryService.push(battery);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"status\" : \"ok\"}");
    }

    @GetMapping
    public List<Battery> pull(@RequestParam(defaultValue = "50") Integer count) {
        return batteryService.pull(count);
    }

    @GetMapping("/hello")
    public String hello() {
        return "{\"msg\":\"hello\"}";
    }
}
