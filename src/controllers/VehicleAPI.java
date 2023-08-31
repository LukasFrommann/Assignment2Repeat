package controllers;

import models.*;
import utils.FuelTypeUtility;
import utils.Serializer;
import utils.Utilities;

import java.io.*;
import java.util.*;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class VehicleAPI implements Serializer { // todo implements Serializer {   (when load and saved written, include the 'implements Serializer here)

    // more private fields here (file)
    private List<Vehicle> vehicles;
    private File file;

    //TODO refer to the spec and add in the required methods here (make note of which methods are given to you first!)

    public VehicleAPI() {
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

    public boolean updateVehicle(int indexToUpdate, Vehicle updateDetails) {
        //find the vehicle object by the index number.
        Vehicle foundVehicle = findVehicle(indexToUpdate);
        //if the vehicle exists, use the details passed in the updateDetails parameter to
        //update the found product in the arraylist
        if (foundVehicle != null) {
            foundVehicle.setManufacturer(updateDetails.getManufacturer());
            foundVehicle.setYear(updateDetails.getYear());
            foundVehicle.setCost(updateDetails.getCost());
            foundVehicle.setModel(updateDetails.getModel());
            foundVehicle.setRegNumber(updateDetails.getRegNumber());
            return true;
        }
        //if the product was not found, return false, indicating that the update was not successful
        return false;
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
    //other methods
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




    //------______ listAll methods _______-------





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
