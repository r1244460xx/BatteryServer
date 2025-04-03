package com.symbol.BatteryServer.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class Gps implements Serializable {
    private Float latitude;

    private Float longitude;

    private Float angle;

    private Float speed;

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getAngle() {
        return angle;
    }

    public void setAngle(Float angle) {
        this.angle = angle;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }
}
