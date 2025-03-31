package com.symbol.BatteryServer.controller;

import com.symbol.BatteryServer.model.Battery;
import com.symbol.BatteryServer.service.BatteryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/battery")
public class BatteryController {

    private final BatteryService batteryService;

    public BatteryController(BatteryService batteryService) {
        this.batteryService = batteryService;
    }

    @PostMapping
    public ResponseEntity<String> push(@RequestBody Battery battery) {
        batteryService.push(battery);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"status\" : \"ok\"}");
    }

    @GetMapping
    public List<Battery> pull(@RequestParam(defaultValue = "50") Integer count) {
        if (count < 1) {
            throw new IllegalArgumentException("Passed count: " + count + " cannot be smaller than 0");
        }
        return batteryService.pull(count);
    }

    @GetMapping("/hello")
    public String hello() {
        return "{\"msg\":\"hello\"}";
    }
}
