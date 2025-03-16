package com.symbol.BatteryServer.model;

import jakarta.persistence.*;

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
            @AttributeOverride(name = "capacity", column = @Column(name = "bms_capacity")),
            @AttributeOverride(name = "totalPower", column = @Column(name = "bms_total_power")),
            @AttributeOverride(name = "totalVoltage", column = @Column(name = "bms_total_voltage")),
            @AttributeOverride(name = "monitorVoltage", column = @Column(name = "bms_monitor_voltage")),
            @AttributeOverride(name = "totalCurrent", column = @Column(name = "bms_total_current")),
            @AttributeOverride(name = "generatorACurrent", column = @Column(name = "bms_generator_a_current")),
            @AttributeOverride(name = "generatorBCurrent", column = @Column(name = "bms_generator_b_current")),
            @AttributeOverride(name = "sunPowerCurrent", column = @Column(name = "bms_sun_power_current")),
            @AttributeOverride(name = "temperature", column = @Column(name = "bms_battery_temperature")),
            @AttributeOverride(name = "batteryStatus", column = @Column(name = "bms_battery_status")),
            @AttributeOverride(name = "relayStatus", column = @Column(name = "bms_relay_status")),
            @AttributeOverride(name = "flag", column = @Column(name = "bms_flag"))
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Bms getBms() {
        return bms;
    }

    public void setBms(Bms bms) {
        this.bms = bms;
    }

    public Yeli getYeli() {
        return yeli;
    }

    public void setYeli(Yeli yeli) {
        this.yeli = yeli;
    }

    public Gps getGps() {
        return gps;
    }

    public void setGps(Gps gps) {
        this.gps = gps;
    }
}
