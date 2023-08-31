package models;

import utils.Utilities;

import java.util.Objects;

public class ElectricCar extends Car {
    private int range = 100;
    private float engineKWatts = 40;

    public ElectricCar(Manufacturer manufacturer, int year, float cost, String regNumber, String model, int secs0To60, int power, float torque, int topSpeed, int range, float engineKWatts) {
        super(manufacturer, year, cost, regNumber, model, secs0To60, power, torque, topSpeed);
        this.range = range;
        this.engineKWatts = engineKWatts;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        if (Utilities.validRange(range,100,500)) {
            this.range = range;
        }
    }

    public float getEngineKWatts() {
        return engineKWatts;
    }

    public void setEngineKWatts(float engineKWatts) {
        if (engineKWatts >= 40 && engineKWatts <= 60) {
            this.engineKWatts = engineKWatts;
        }
    }
    // Algorithm - carbon footprint of an ElectricCar is
    //   (engine kw * age of car) / load factor for electric car of 20000
    //   e.g. (40000 * 6) / 20000 = 12
    @Override
    public double getCarbonFootPrint() {
        return(this.engineKWatts * super.getAge() / 20000);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectricCar that)) return false;
        if (!super.equals(o)) return false;
        return getRange() == that.getRange() && Float.compare(that.getEngineKWatts(), getEngineKWatts()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRange(), getEngineKWatts());
    }
}
