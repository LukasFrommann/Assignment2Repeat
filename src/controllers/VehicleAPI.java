package controllers;

import models.*;
import utils.Serializer;

import java.io.*;
import java.util.*;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * The vehicle api class includes most of the methods outlined in the brief
 *
 * @author Lukas frommann
 * @version 2.0 (repeat)
 */

public class VehicleAPI implements Serializer { // todo implements Serializer {   (when load and saved written, include the 'implements Serializer here)

    // more private fields here (file)
    private List<Vehicle> vehicles;
    private File file;

    //TODO refer to the spec and add in the required methods here (make note of which methods are given to you first!)

    public VehicleAPI(File file) {
        vehicles = new ArrayList<Vehicle>();
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public boolean add(Vehicle vehicle) {
        return vehicles.add(vehicle);
    }

    //------______ Update methods _______-------
    public boolean upDateElectricCar(int indexToUpdate, ElectricCar updatedDetails) {
        Vehicle foundVehicle = findVehicle(indexToUpdate);
        if (foundVehicle instanceof ElectricCar) {
            foundVehicle.setCost(updatedDetails.getCost());
            foundVehicle.setModel(updatedDetails.getModel());
            foundVehicle.setManufacturer(updatedDetails.getManufacturer());
            foundVehicle.setYear(updatedDetails.getYear());
            foundVehicle.setVehicleTax(updatedDetails.getVehicleTax());
            ((ElectricCar)foundVehicle).setPower(updatedDetails.getPower());
            ((ElectricCar)foundVehicle).setSecs0To60(updatedDetails.getSecs0To60());
            ((ElectricCar)foundVehicle).setTopSpeed(updatedDetails.getTopSpeed());
            ((ElectricCar)foundVehicle).setTorque(updatedDetails.getTorque());
            ((ElectricCar)foundVehicle).setEngineKWatts(updatedDetails.getEngineKWatts());
            ((ElectricCar)foundVehicle).setRange(updatedDetails.getRange());
            return true;
        } else {
            return false;
        }
    }

    public boolean upDateCarbonFuelCar(int indexToUpdate, CarbonFuelCar updatedDetails) {
        Vehicle foundVehicle = findVehicle(indexToUpdate);
        if (foundVehicle instanceof CarbonFuelCar) {
            foundVehicle.setCost(updatedDetails.getCost());
            foundVehicle.setModel(updatedDetails.getModel());
            foundVehicle.setManufacturer(updatedDetails.getManufacturer());
            foundVehicle.setYear(updatedDetails.getYear());
            foundVehicle.setVehicleTax(updatedDetails.getVehicleTax());
            ((CarbonFuelCar)foundVehicle).setPower(updatedDetails.getPower());
            ((CarbonFuelCar)foundVehicle).setSecs0To60(updatedDetails.getSecs0To60());
            ((CarbonFuelCar)foundVehicle).setTopSpeed(updatedDetails.getTopSpeed());
            ((CarbonFuelCar)foundVehicle).setTorque(updatedDetails.getTorque());
            ((CarbonFuelCar)foundVehicle).setCarbonEmission(updatedDetails.getCarbonEmission());
            ((CarbonFuelCar)foundVehicle).setFuelConsumption(updatedDetails.getFuelConsumption());
            ((CarbonFuelCar)foundVehicle).setFuelType(updatedDetails.getFuelType());
            ((CarbonFuelCar)foundVehicle).setAutomatic(updatedDetails.isAutomatic());
            ((CarbonFuelCar)foundVehicle).setEngineSize(updatedDetails.getEngineSize());
            return true;
        } else {
            return false;
        }
    }
    public boolean upDateScooter(int indexToUpdate, Scooter updatedDetails) {
        Vehicle foundVehicle = findVehicle(indexToUpdate);
        if (foundVehicle instanceof Scooter) {
            foundVehicle.setCost(updatedDetails.getCost());
            foundVehicle.setModel(updatedDetails.getModel());
            foundVehicle.setVehicleTax(updatedDetails.getVehicleTax());
            foundVehicle.setManufacturer(updatedDetails.getManufacturer());
            foundVehicle.setYear(updatedDetails.getYear());
            ((Scooter)foundVehicle).setPower(updatedDetails.getPower());
            ((Scooter)foundVehicle).setWeight(updatedDetails.getWeight());
            ((Scooter)foundVehicle).setTopRiderWeight(updatedDetails.getTopRiderWeight());
            return true;
        } else {
            return false;
        }
    }

    public Vehicle deleteVehicle(int indexToDelete) {
        if (isValidIndex(indexToDelete)) {
            return vehicles.remove(indexToDelete);
        }
        return null;
    }

    public Vehicle findVehicle(int index){
        if (isValidIndex(index)){
            return vehicles.get(index);
        }
        return null;
    }
    public String searchByRegNumber(String regNumber){
        String matchingVehicles = "";
        for(Vehicle vehicle : vehicles){
            if (vehicle.getRegNumber().toUpperCase().contains(regNumber.toUpperCase())){
                matchingVehicles += vehicles.indexOf(vehicle) + ": " + vehicle + "\n";
            }
        }
        if (matchingVehicles.equals("")){
            return "No Vehicles match your search.";
        }
        else {
            return matchingVehicles;
        }
    }
    //------______ other methods _______-------
    public int numberOfVehicles(){
        return vehicles.size();
    }
    public boolean isValidIndex(int index){
        return (index >= 0) && (index < vehicles.size());
    }
    //Reporting Methods

    //------______ listAll methods _______-------
    public String listAllVehicles(){
        if (vehicles.isEmpty()){
            return "No vehicles around today buddy.";
        }
        else {
            String listAllVehicles = "";
            for (int i = 0; i < vehicles.size(); i++){
                listAllVehicles += i + ": " + vehicles.get(i) + "\n";
            }
            return listAllVehicles;
        }
    }
    public String listAllScooters(){
        if (vehicles.isEmpty()){
            return "No vehicles around today buddy.";
        }
        else {
            String listAllScooters = "";
            for (Vehicle vehicle : vehicles) {
                if (vehicle instanceof Scooter) {
                    listAllScooters += vehicle.toString();
                }
                if (listAllScooters.isEmpty()){
                    return "No Scooters around here today buddy.";
                }
            }
            return listAllScooters;
        }
    }
    public String listAllElectricCars(){
        if (vehicles.isEmpty()){
            return "No vehicles around today buddy.";
        }
        else {
            String listAllElectricCars = "";
            for (Vehicle vehicle : vehicles) {
                if (vehicle instanceof ElectricCar) {
                    listAllElectricCars += vehicle.toString();
                }
                if (listAllElectricCars.isEmpty()){
                    return "No Electric Cars around here today buddy.";
                }
            }
            return listAllElectricCars;
        }
    }
    public String listAllCarbonFuelCars(){
        if (vehicles.isEmpty()){
            return "No vehicles around today buddy.";
        }
        else {
            String listAllCarbonFuelCars = "";
            for (Vehicle vehicle : vehicles) {
                if (vehicle instanceof CarbonFuelCar) {
                    listAllCarbonFuelCars += vehicle.toString();
                }
                if (listAllCarbonFuelCars.isEmpty()){
                    return "No Traditional Cars around here today buddy.";
                }
            }
            return listAllCarbonFuelCars;
        }
    }
    public String listAllVehiclesByChosenManufacturer(Manufacturer manufacturer){
        if (vehicles.isEmpty()){
            return "No vehicles around today buddy.";
        }
        else {
            String listAllVehiclesByChosenManufacturer = "";
            for (int i = 0; i < vehicles.size(); i++){
                if (vehicles.get(i).getManufacturer().equals(manufacturer)){
                    listAllVehiclesByChosenManufacturer += i + ": " + vehicles.get(i) + "\n";
                }
            }
            return listAllVehiclesByChosenManufacturer;
        }
    }
    public String listAllVehiclesEqualToAGivenYear(int year){
        if (vehicles.isEmpty()){
            return "No vehicles around today buddy.";
        }
        else {
            String listAllVehiclesEqualToAGivenYear = "";
            for (int i = 0; i < vehicles.size(); i++){
                if (vehicles.get(i).getYear() == year){
                    listAllVehiclesEqualToAGivenYear += i + ": " + vehicles.get(i) + "\n";
                }
            }
            return listAllVehiclesEqualToAGivenYear;
        }
    }

    public String listAllVehiclesAfterAGivenYear(int year){
        if (vehicles.isEmpty()){
            return "No vehicles around today buddy.";
        }
        else {
            String listAllVehiclesAfterAGivenYear = "";
            for (int i = 0; i < vehicles.size(); i++){
                if (vehicles.get(i).getYear() > year){
                    listAllVehiclesAfterAGivenYear += i + ": " + vehicles.get(i) + "\n";
                }
            }
            return listAllVehiclesAfterAGivenYear;
        }
    }

    //------______ Number methods _______-------

    public int numberOfScooters(){
        if (vehicles.isEmpty()){
            return 0;
        }
        else {
            int numberOfScooters = 0;
            for (Vehicle vehicle : vehicles) {
                if (vehicle instanceof Scooter) {
                    numberOfScooters ++;
                }
            }
            return numberOfScooters;
        }
    }
    public int numberOfElectricCars(){
        if (vehicles.isEmpty()){
            return 0;
        }
        else {
            int numberOfElectricCars = 0;
            for (Vehicle vehicle : vehicles) {
                if (vehicle instanceof ElectricCar) {
                    numberOfElectricCars ++;
                }
            }
            return numberOfElectricCars;
        }
    }
    public int numberOfCarbonCars(){
        if (vehicles.isEmpty()){
            return 0;
        }
        else {
            int numberOfCarbonCars = 0;
            for (Vehicle vehicle : vehicles) {
                if (vehicle instanceof CarbonFuelCar) {
                    numberOfCarbonCars ++;
                }
            }
            return numberOfCarbonCars;
        }
    }







    // checks if regNumber is a new reg number i.e. it does not already exist in the collection
//    public boolean isValidNewRegNumber(String regNumber){
//        for(Vehicle vehicle: vehicles)     //todo - declare and instantiate vehicles
//            if (vehicle.getRegNumber().equals(regNumber))
//                return false;
//        return true;
//    }



    //---------------------
    // Persistence methods
    //---------------------
    /**
     * The load method uses the XStream component to read all the objects from the xml
     * file stored on the hard disk.  The read objects are loaded into the associated ArrayList
     *
     * @throws Exception An exception is thrown if an error occurred during the load e.g. a missing file.
     */
    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[]{Vehicle.class, Car.class, CarbonFuelCar.class,
                                            ElectricCar.class, Scooter.class, Manufacturer.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader(file));
        vehicles = (List<Vehicle>) in.readObject();
        in.close();
   }

    /**
     * The save method uses the XStream component to write all the objects in the ArrayList
     * to the xml file stored on the hard disk.
     *
     * @throws Exception An exception is thrown if an error occurred during the save e.g. drive is full.
     */
    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(file));
        out.writeObject(vehicles);
        out.close();
    }

    public String fileName(){
        return this.file.toString();
    }


}
