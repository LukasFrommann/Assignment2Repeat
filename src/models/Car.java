package models;

import jdk.jshell.execution.Util;
import utils.Utilities;

public abstract class Car extends Vehicle {
    private int secs0To60 = 4;
    private int power = 120;
    private float torque = 100;
    private int topSpeed = 50;

    public Car(Manufacturer manufacturer, int year, float cost, String regNumber, String model, int secs0To60, int power, float torque, int topSpeed) {
        super(manufacturer, year, cost, regNumber, model);
        this.secs0To60 = secs0To60;
        this.power = power;
        this.torque = torque;
        this.topSpeed = topSpeed;
    }

    public int getSecs0To60() {
        return secs0To60;
    }

    public void setSecs0To60(int secs0To60) {
        if (Utilities.validRange(secs0To60,4,25)) {
            this.secs0To60 = secs0To60;
        }
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if (Utilities.validRange(power,120,300)) {
            this.power = power;
        }
    }

    public float getTorque() {
        return torque;
    }

    public void setTorque(float torque) {
        if (torque >= 100 && torque <= 400) {
            this.torque = torque;
        }
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        if (Utilities.validRange(topSpeed,50,3000)) {
            this.topSpeed = topSpeed;
        }
    }

    @Override
    public abstract double getCarbonFootPrint();


}
