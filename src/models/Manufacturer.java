package models;

import utils.Utilities;

import java.util.Objects;

/**
 * The manufacturer class contains all the fields, constructor, setters and getters and to string.
 * It includes all that was in the repeat assignment brief.
 *
 * @author Lukas frommann
 * @version 2.0 (repeat)
 */

public class Manufacturer {
    private String manufacturerName = ""; // max 20 chars
    private int numEmployees = 1;   // >= 1, default 1
    private String manufacturerPhoneNumber;
    private String manufacturerCountry;
    private double developerLatitude;
    private double developerLongitude;

    public Manufacturer(String manufacturerName, int numEmployees, String manufacturerPhoneNumber, String manufacturerCountry, double developerLatitude, double developerLongitude) {
        this.manufacturerName = Utilities.truncateString(manufacturerName, 20);
        setNumEmployees(numEmployees);
        this.manufacturerPhoneNumber = this.manufacturerPhoneNumber;
        this.manufacturerCountry = this.manufacturerCountry;
        this.developerLatitude = this.developerLatitude;
        this.developerLongitude = this.developerLongitude;
    }


    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        if (Utilities.validStringlength(manufacturerName, 20)) {
            this.manufacturerName = manufacturerName;
        }
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        if (numEmployees >=1)
          this.numEmployees = numEmployees;
    }

    public String getManufacturerPhoneNumber() {
        return manufacturerPhoneNumber;
    }

    public void setManufacturerPhoneNumber(String manufacturerPhoneNumber) {
        this.manufacturerPhoneNumber = manufacturerPhoneNumber;
    }

    public String getManufacturerCountry() {
        return manufacturerCountry;
    }

    public void setManufacturerCountry(String manufacturerCountry) {
        if (Utilities.validStringlength(manufacturerCountry,30)) {
            this.manufacturerCountry = manufacturerCountry;
        }
    }

    public double getDeveloperLatitude() {
        return developerLatitude;
    }

    public void setDeveloperLatitude(double developerLatitude) {
        if(developerLatitude >= -90 && developerLatitude <= 90){
            this.developerLatitude = developerLatitude;
        }
    }

    public double getDeveloperLongitude() {
        return developerLongitude;
    }

    public void setDeveloperLongitude(double developerLongitude) {
        if(developerLongitude >= -180 && developerLongitude <= 180) {
            this.developerLongitude = developerLongitude;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manufacturer that)) return false;
        return getNumEmployees() == that.getNumEmployees() && Double.compare(that.getDeveloperLatitude(), getDeveloperLatitude()) == 0 && Double.compare(that.getDeveloperLongitude(), getDeveloperLongitude()) == 0 && Objects.equals(getManufacturerName(), that.getManufacturerName()) && Objects.equals(getManufacturerPhoneNumber(), that.getManufacturerPhoneNumber()) && Objects.equals(getManufacturerCountry(), that.getManufacturerCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getManufacturerName(), getNumEmployees(), getManufacturerPhoneNumber(), getManufacturerCountry(), getDeveloperLatitude(), getDeveloperLongitude());
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manufacturerName='" + manufacturerName + '\'' +
                ", numEmployees=" + numEmployees + (numEmployees==1 ? " employee" : " employees")+
                ", manufacturerPhoneNumber='" + manufacturerPhoneNumber + '\'' +
                ", manufacturerCountry='" + manufacturerCountry + '\'' +
                ", developerLatitude=" + developerLatitude +
                ", developerLongitude=" + developerLongitude +
                '}';
    }
}
