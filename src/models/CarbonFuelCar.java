package models;

import jdk.jshell.execution.Util;
import utils.FuelTypeUtility;
import utils.Utilities;

import java.util.Objects;

public class CarbonFuelCar extends Car {
    private float fuelConsumption = 5;
    private float carbonEmission = 1;
    private boolean automatic = false;
    private String fuelType = "petrol";
    private int engineSize = 800;

    public CarbonFuelCar(Manufacturer manufacturer, int year, float cost, String regNumber, String model, int secs0To60, int power, float torque, int topSpeed, float fuelConsumption, float carbonEmission, boolean automatic, String fuelType, int engineSize) {
        super(manufacturer, year, cost, regNumber, model, secs0To60, power, torque, topSpeed);
        this.fuelConsumption = fuelConsumption;
        this.carbonEmission = carbonEmission;
        this.automatic = automatic;
        this.fuelType = fuelType;
        this.engineSize = engineSize;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption) {
        if (fuelConsumption >= 5 && fuelConsumption <= 20){
            this.fuelConsumption = fuelConsumption;
        }
    }

    public float getCarbonEmission() {
        return carbonEmission;
    }

    public void setCarbonEmission(float carbonEmission) {
        if (carbonEmission > 0) {
            this.carbonEmission = carbonEmission;
        }
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        if (FuelTypeUtility.validFuelType(fuelType)) {
            this.fuelType = fuelType;
        }
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        if (Utilities.validRange(engineSize,800,2500)) {
            this.engineSize = engineSize;
        }
    }
    // Algorithm - carbon footprint of a CarbonFuelCar is
    //   (engine size * fuel consumption * carbon emission * age of car) / load factor for carbon fueled car of 2000
    //  e.g. (1200 * 6 * 5 * 6) / 2000 = 43.2
    @Override
    public double getCarbonFootPrint() {
        return(this.engineSize * this.fuelConsumption * this.carbonEmission * super.getAge() / 2000);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarbonFuelCar that)) return false;
        if (!super.equals(o)) return false;
        return Float.compare(that.getFuelConsumption(), getFuelConsumption()) == 0 && Float.compare(that.getCarbonEmission(), getCarbonEmission()) == 0 && isAutomatic() == that.isAutomatic() && getEngineSize() == that.getEngineSize() && Objects.equals(getFuelType(), that.getFuelType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFuelConsumption(), getCarbonEmission(), isAutomatic(), getFuelType(), getEngineSize());
    }
}
