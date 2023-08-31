package models;

import utils.Utilities;
import utils.VehicleTaxUtility;

import java.util.Objects;

/**
 * The vehicle class contains all the fields, constructor, setters and getters and to string.
 * It's an abstract class
 *
 * @author Lukas frommann
 * @version 2.0 (repeat)
 */
public abstract class Vehicle {

    private Manufacturer manufacturer;
    private int year = 2000;
    private float cost = 1000;
    private String regNumber = "No reg";
    private String model = "No model";
    private String vehicleTax = "low";

    public Vehicle(Manufacturer manufacturer, int year, float cost, String regNumber, String model, String vehicleTax) {
        this.manufacturer = manufacturer;
        this.year = year;
        this.cost = cost;
        this.regNumber = regNumber;
        this.model = model;
        this.vehicleTax = vehicleTax;
    }

    public String getVehicleTax() {
        return vehicleTax;
    }

    public void setVehicleTax(String vehicleTax) {
        if (VehicleTaxUtility.validVehicleTax(vehicleTax)) {
            this.vehicleTax = vehicleTax;
        }
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (Utilities.validRange(year, 2000, 2023)) {
            this.year = year;
        }
    }

    public int getAge() {
        return 2023 - this.year;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        if (cost >= 1000) {
            this.cost = cost;
        }
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        if (Utilities.validStringlength(regNumber, 8)) {
            this.regNumber = regNumber;
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (Utilities.validStringlength(model, 15)) {
            this.model = model;
        }
    }

    public abstract double getCarbonFootPrint();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;
        return getYear() == vehicle.getYear() && Float.compare(vehicle.getCost(), getCost()) == 0 && Objects.equals(getManufacturer(), vehicle.getManufacturer()) && Objects.equals(getRegNumber(), vehicle.getRegNumber()) && Objects.equals(getModel(), vehicle.getModel()) && Objects.equals(getVehicleTax(), vehicle.getVehicleTax());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getManufacturer(), getYear(), getCost(), getRegNumber(), getModel(), getVehicleTax());
    }

    @Override
    public String toString(){
        String newStr = "";
        if (this.getAge() == 0){
            newStr = "Brand new!";
        }
        else if (this.getAge() == 1){
            newStr = "1 year old";
        }
        else {
            newStr = this.getAge() + "years old";
        }
        return "Vehicle{ model='" + this.model + "', regNumber='" + this.regNumber + "', age='" + newStr + "', cost='" + this.cost + ", manufacturer=" + this.manufacturer + "', vehicleTax '" + this.vehicleTax + "}";
    }
}
