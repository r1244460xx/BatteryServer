package com.symbol.BatteryServer.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.io.Serializable;

@Embeddable
public class Bms implements Serializable {

    public enum BatteryStatus {
        Charge, Discharge
    }

    private Byte capacity;

    private Float totalPower;

    private Float totalVoltage;

    private Float monitorVoltage;

    private Float totalCurrent;

    private Float generatorACurrent;

    private Float generatorBCurrent;

    private Float sunPowerCurrent;

    private Float temperature;

    @Enumerated(EnumType.ORDINAL)
    private BatteryStatus batteryStatus;

    private String relayStatus;

    private String flag;

    public Byte getCapacity() {
        return capacity;
    }

    public void setCapacity(Byte capacity) {
        this.capacity = capacity;
    }

    public Float getTotalPower() {
        return totalPower;
    }

    public void setTotalPower(Float totalPower) {
        this.totalPower = totalPower;
    }

    public Float getTotalVoltage() {
        return totalVoltage;
    }

    public void setTotalVoltage(Float totalVoltage) {
        this.totalVoltage = totalVoltage;
    }

    public Float getMonitorVoltage() {
        return monitorVoltage;
    }

    public void setMonitorVoltage(Float monitorVoltage) {
        this.monitorVoltage = monitorVoltage;
    }

    public Float getTotalCurrent() {
        return totalCurrent;
    }

    public void setTotalCurrent(Float totalCurrent) {
        this.totalCurrent = totalCurrent;
    }

    public Float getGeneratorACurrent() {
        return generatorACurrent;
    }

    public void setGeneratorACurrent(Float generatorACurrent) {
        this.generatorACurrent = generatorACurrent;
    }

    public Float getGeneratorBCurrent() {
        return generatorBCurrent;
    }

    public void setGeneratorBCurrent(Float generatorBCurrent) {
        this.generatorBCurrent = generatorBCurrent;
    }

    public Float getSunPowerCurrent() {
        return sunPowerCurrent;
    }

    public void setSunPowerCurrent(Float sunPowerCurrent) {
        this.sunPowerCurrent = sunPowerCurrent;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public BatteryStatus getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(BatteryStatus batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

    public String getRelayStatus() {
        return relayStatus;
    }

    public void setRelayStatus(String relayStatus) {
        this.relayStatus = relayStatus;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
