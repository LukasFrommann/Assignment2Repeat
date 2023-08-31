package models;

import jdk.jshell.execution.Util;
import utils.Utilities;

import java.util.Objects;

/**
 * The car class contains all the fields, constructor, setters and getters and to string.
 * It's an abstract class and extends vehicle
 *
 * @author Lukas frommann
 * @version 2.0 (repeat)
 */

public abstract class Car extends Vehicle {
    private int secs0To60 = 4;
    private int power = 120;
    private float torque = 100;
    private int topSpeed = 50;

    public Car(Manufacturer manufacturer, String vehicleTax, int year, float cost, String regNumber, String model, int secs0To60, int power, float torque, int topSpeed) {
        super(manufacturer, year, cost, regNumber, model, vehicleTax);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        if (!super.equals(o)) return false;
        return getSecs0To60() == car.getSecs0To60() && getPower() == car.getPower() && Float.compare(car.getTorque(), getTorque()) == 0 && getTopSpeed() == car.getTopSpeed();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSecs0To60(), getPower(), getTorque(), getTopSpeed());
    }

    @Override
    public String toString() {
        return "Car{" +
                "secs0To60=" + secs0To60 +
                ", power=" + power +
                ", torque=" + torque +
                ", topSpeed=" + topSpeed +
                '}';
    }
}
