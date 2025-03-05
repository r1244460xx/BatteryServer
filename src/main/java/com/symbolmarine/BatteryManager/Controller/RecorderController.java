package com.symbolmarine.BatteryManager.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class RecorderController {
    @GetMapping
    public String sayHello() {
        return "<h1>Hello, World!</h1>";
    }
}
