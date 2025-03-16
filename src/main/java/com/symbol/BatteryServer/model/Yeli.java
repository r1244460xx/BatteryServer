package com.symbol.BatteryServer.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Yeli {

    private Short leftRpm;

    private Float leftCurrent;

    private Short rightRpm;

    private Float rightCurrent;

    public Short getLeftRpm() {
        return leftRpm;
    }

    public Float getLeftCurrent() {
        return leftCurrent;
    }

    public Short getRightRpm() {
        return rightRpm;
    }

    public Float getRightCurrent() {
        return rightCurrent;
    }

    public void setLeftRpm(Short leftRpm) {
        this.leftRpm = leftRpm;
    }

    public void setLeftCurrent(Float leftCurrent) {
        this.leftCurrent = leftCurrent;
    }

    public void setRightRpm(Short rightRpm) {
        this.rightRpm = rightRpm;
    }

    public void setRightCurrent(Float rightCurrent) {
        this.rightCurrent = rightCurrent;
    }
}
