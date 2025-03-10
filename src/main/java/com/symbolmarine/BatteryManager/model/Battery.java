package com.symbolmarine.BatteryManager.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "battery")
public class Battery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "upload_time")
    private LocalDateTime uploadTime;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bmsCapacity", column = @Column(name = "bms_capacity")),
            @AttributeOverride(name = "bmsPower", column = @Column(name = "bms_total_power")),
            @AttributeOverride(name = "bmsTotalVoltage", column = @Column(name = "bms_total_voltage")),
            @AttributeOverride(name = "bmsMonitorVoltage", column = @Column(name = "bms_monitor_voltage")),
            @AttributeOverride(name = "bmsTotalCurrent", column = @Column(name = "bms_total_current")),
            @AttributeOverride(name = "bmsGeneratorACurrent", column = @Column(name = "bms_generator_a_current")),
            @AttributeOverride(name = "bmsGeneratorBCurrent", column = @Column(name = "bms_generator_b_current")),
            @AttributeOverride(name = "bmsPowerCurrent", column = @Column(name = "bms_sun_power_current")),
            @AttributeOverride(name = "bmsTemperature", column = @Column(name = "bms_battery_temperature")),
            @AttributeOverride(name = "batteryStatus", column = @Column(name = "bms_battery_status")),
            @AttributeOverride(name = "relayStatus", column = @Column(name = "bms_relay_status")),
            @AttributeOverride(name = "bmsFlag", column = @Column(name = "bms_flag"))
    })
    private Bms bms;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "leftRpm", column = @Column(name = "yeli_left_rpm")),
            @AttributeOverride(name = "leftCurrent", column = @Column(name = "yeli_left_current")),
            @AttributeOverride(name = "rightRpm", column = @Column(name = "yeli_right_rpm")),
            @AttributeOverride(name = "rightCurrent", column = @Column(name = "yeli_right_current"))
    })
    private Yeli yeli;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "gps_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "gps_longitude")),
            @AttributeOverride(name = "angle", column = @Column(name = "gps_angle")),
            @AttributeOverride(name = "speed", column = @Column(name = "gps_speed"))
    })
    private Gps gps;

}
