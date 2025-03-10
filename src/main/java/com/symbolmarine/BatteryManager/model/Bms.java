package com.symbolmarine.BatteryManager.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Bms {

    public enum BatteryStatus {
        Charge, Discharge
    }

    private Byte bmsCapacity;

    private Float bmsPower;

    private Float bmsTotalVoltage;

    private Float bmsMonitorVoltage;

    private Float bmsTotalCurrent;

    private Float bmsGeneratorACurrent;

    private Float bmsGeneratorBCurrent;

    private Float bmsPowerCurrent;

    private Float bmsTemperature;

    @Enumerated(EnumType.ORDINAL)
    private BatteryStatus batteryStatus;

    private String relayStatus;

    private String bmsFlag;

    public void setBmsCapacity(Byte bmsCapacity) {
        this.bmsCapacity = bmsCapacity;
    }

    public void setBmsPower(Float bmsPower) {
        this.bmsPower = bmsPower;
    }

    public void setBmsTotalVoltage(Float bmsTotalVoltage) {
        this.bmsTotalVoltage = bmsTotalVoltage;
    }

    public void setBmsMonitorVoltage(Float bmsMonitorVoltage) {
        this.bmsMonitorVoltage = bmsMonitorVoltage;
    }

    public void setBmsTotalCurrent(Float bmsTotalCurrent) {
        this.bmsTotalCurrent = bmsTotalCurrent;
    }

    public void setBmsGeneratorACurrent(Float bmsGeneratorACurrent) {
        this.bmsGeneratorACurrent = bmsGeneratorACurrent;
    }

    public void setBmsGeneratorBCurrent(Float bmsGeneratorBCurrent) {
        this.bmsGeneratorBCurrent = bmsGeneratorBCurrent;
    }

    public void setBmsPowerCurrent(Float bmsPowerCurrent) {
        this.bmsPowerCurrent = bmsPowerCurrent;
    }

    public void setBmsTemperature(Float bmsTemperature) {
        this.bmsTemperature = bmsTemperature;
    }

    public void setBatteryStatus(BatteryStatus batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

    public void setRelayStatus(String relayStatus) {
        this.relayStatus = relayStatus;
    }

    public void setBmsFlag(String bmsFlag) {
        this.bmsFlag = bmsFlag;
    }

    public Byte getBmsCapacity() {
        return bmsCapacity;
    }

    public Float getBmsPower() {
        return bmsPower;
    }

    public Float getBmsTotalVoltage() {
        return bmsTotalVoltage;
    }

    public Float getBmsMonitorVoltage() {
        return bmsMonitorVoltage;
    }

    public Float getBmsTotalCurrent() {
        return bmsTotalCurrent;
    }

    public Float getBmsGeneratorACurrent() {
        return bmsGeneratorACurrent;
    }

    public Float getBmsGeneratorBCurrent() {
        return bmsGeneratorBCurrent;
    }

    public Float getBmsPowerCurrent() {
        return bmsPowerCurrent;
    }

    public Float getBmsTemperature() {
        return bmsTemperature;
    }

    public BatteryStatus getBatteryStatus() {
        return batteryStatus;
    }

    public String getRelayStatus() {
        return relayStatus;
    }

    public String getBmsFlag() {
        return bmsFlag;
    }

}
