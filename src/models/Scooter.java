package models;

import utils.Utilities;

import java.util.Objects;

public abstract class Scooter extends Vehicle {
    private int power = 250;
    private int topRiderWeight = 100;
    private float weight = 5;

    public Scooter(Manufacturer manufacturer, int year, float cost, String regNumber, String model, String vehicleTax, int power, int topRiderWeight, float weight) {
        super(manufacturer, year, cost, regNumber, model, vehicleTax);
        this.power = power;
        this.topRiderWeight = topRiderWeight;
        this.weight = weight;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if (Utilities.validRange(power,250,1000)) {
            this.power = power;
        }
    }

    public int getTopRiderWeight() {
        return topRiderWeight;
    }

    public void setTopRiderWeight(int topRiderWeight) {
        if (Utilities.validRange(topRiderWeight,100,120)) {
            this.topRiderWeight = topRiderWeight;
        }
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        if (weight >= 5 && weight <= 100) {
            this.weight = weight;
        }
    }
    // Algorithm - carbon footprint of a Scooter is
    //  ( power (of scooter) * weight (of scooter) * age (of scooter) ) / load factor for Scooter of 15000
    //  e.g.  (250 * 45 * 2) / 15000 = 1.5
    @Override
    public double getCarbonFootPrint() {
        return(this.power * this.weight * super.getAge() / 15000);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scooter scooter)) return false;
        if (!super.equals(o)) return false;
        return getPower() == scooter.getPower() && getTopRiderWeight() == scooter.getTopRiderWeight() && Float.compare(scooter.getWeight(), getWeight()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPower(), getTopRiderWeight(), getWeight());
    }


}

