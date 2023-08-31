package utils;

import java.util.ArrayList;

public class VehicleTaxUtility {
    private static ArrayList<String> taxTypes = new ArrayList<String>(){{
    add("low");
    add("medium");
    add("high");
    }};

    public static boolean validVehicleTax(String taxType){
        return (taxType.contains(taxType));
    }
}