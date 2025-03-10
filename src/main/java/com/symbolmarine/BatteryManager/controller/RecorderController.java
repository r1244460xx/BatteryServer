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
@CrossOrigin("http://localhost:3000")
public class RecorderController {
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

    @GetMapping("/testPull")
    public String testPull(@RequestParam(defaultValue = "5") Integer count) {
        return """
                [{
                        "id": 1,
                        "uploadTime": "2025-03-09 14:00:00",
                        "createTime": "2025-03-09 13:59:00",
                        "yeli": {
                            "leftMotorRpm": 1200,
                            "leftMotorCurrent": 15.5,
                            "rightMotorRpm": 1300,
                            "rightMotorCurrent": 16.2
                        },
                        "gps": {
                            "rudderAngle": 45.0,
                            "longitude": 121.565418,
                            "latitude": 25.032969,
                            "angle": 90.0,
                            "speed": 30.5
                        }
                    },
                    {
                        "id": 2,
                        "uploadTime": "2025-03-09 14:05:00",
                        "createTime": "2025-03-09 14:04:30",
                        "yeli": {
                            "leftMotorRpm": 1100,
                            "leftMotorCurrent": 14.8,
                            "rightMotorRpm": 1250,
                            "rightMotorCurrent": 15.9
                        },
                        "gps": {
                            "rudderAngle": 40.0,
                            "longitude": 121.565520,
                            "latitude": 25.033050,
                            "angle": 85.0,
                            "speed": 28.3
                        }
                    },
                    {
                        "id": 3,
                        "uploadTime": "2025-03-09 14:10:00",
                        "createTime": "2025-03-09 14:09:45",
                        "yeli": {
                            "leftMotorRpm": 1150,
                            "leftMotorCurrent": 16.2,
                            "rightMotorRpm": 1270,
                            "rightMotorCurrent": 17.1
                        },
                        "gps": {
                            "rudderAngle": 50.0,
                            "longitude": 121.565600,
                            "latitude": 25.033120,
                            "angle": 95.0,
                            "speed": 32.1
                        }
                    },
                    {
                        "id": 4,
                        "uploadTime": "2025-03-09 14:15:00",
                        "createTime": "2025-03-09 14:14:40",
                        "yeli": {
                            "leftMotorRpm": 1300,
                            "leftMotorCurrent": 18.0,
                            "rightMotorRpm": 1400,
                            "rightMotorCurrent": 19.2
                        },
                        "gps": {
                            "rudderAngle": 55.0,
                            "longitude": 121.565700,
                            "latitude": 25.033200,
                            "angle": 100.0,
                            "speed": 35.4
                        }
                    },
                    {
                        "id": 5,
                        "uploadTime": "2025-03-09 14:20:00",
                        "createTime": "2025-03-09 14:19:50",
                        "yeli": {
                            "leftMotorRpm": 1250,
                            "leftMotorCurrent": 17.5,
                            "rightMotorRpm": 1350,
                            "rightMotorCurrent": 18.5
                        },
                        "gps": {
                            "rudderAngle": 48.0,
                            "longitude": 121.565800,
                            "latitude": 25.033280,
                            "angle": 92.0,
                            "speed": 29.8
                        }
                    }]
                """;
    }

    @GetMapping("/hello")
    public String hello() {
        return "{\"msg\":\"hello\"}";
    }
}
