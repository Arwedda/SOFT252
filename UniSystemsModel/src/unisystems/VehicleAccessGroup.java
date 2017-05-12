/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisystems;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Joseph Kellaway, Alex Murphy and Zakaria Robinson
 */
public enum VehicleAccessGroup implements Serializable {
    ACADEMICS(TypeOfVehicle.CAR, TypeOfVehicle.MINIBUS),
    RESIDENTIALSERVICES(TypeOfVehicle.CAR, TypeOfVehicle.PICKUP, TypeOfVehicle.VAN),
    CATERINGTEAM(TypeOfVehicle.CAR, TypeOfVehicle.VAN),
    PROFESSIONALSERVICES(TypeOfVehicle.CAR, TypeOfVehicle.VAN),
    ESTATES(TypeOfVehicle.CAR),
    CLEANINGTEAM(TypeOfVehicle.CAR, TypeOfVehicle.VAN),
    MAINTENANCE(TypeOfVehicle.CAR, TypeOfVehicle.PICKUP, TypeOfVehicle.MINITRACTOR, TypeOfVehicle.VAN),
    SECURITY(TypeOfVehicle.CAR),
    DPD(TypeOfVehicle.CAR, TypeOfVehicle.VAN);
    
    private ArrayList<TypeOfVehicle> vehicles = new ArrayList<>();
    
    /**
     * Default constructor for a vehicle access group
     */
    VehicleAccessGroup(){
    }
    
    /**
     * Parameter-fed constructor for a vehicle access group. Adds TypeOfVehicle enum to each access group
     * @param vehicles TypeOfVehicle accessible by specific access group
     */
    VehicleAccessGroup(TypeOfVehicle... vehicles) {
        for (TypeOfVehicle vehicle : vehicles) {
            this.vehicles.add(vehicle);
        }
    }
    
    /**
     * Gets the list of vehicle types that the VehicleAccessGroup can rent
     * @return The list of vehicle types that the VehicleAccessGroup can rent
     */
    public ArrayList<TypeOfVehicle> getVehicles() {
        return this.vehicles;
    }
    
    /**
     * Converts the Vehicle Access Group enum to a user-friendly string
     * @return User-friendly string
     */
    @Override
    public String toString()
    {
        String strResult = "";
        switch (this)
        {
            case ACADEMICS:
                strResult = "Academics";
                break;
            case RESIDENTIALSERVICES:
                strResult = "Residential Services";
                break;
            case CATERINGTEAM:
                strResult = "Catering Team";
                break;
            case PROFESSIONALSERVICES:
                strResult = "Professional Services";
                break;
            case ESTATES:
                strResult = "Estates";
                break;
            case CLEANINGTEAM:
                strResult = "Cleaning Team";
                break;
            case MAINTENANCE:
                strResult = "Maintenance";
                break;
            case SECURITY:
                strResult = "Security";
                break;
            case DPD:
                strResult = "DPD";
                break;
        }
        return strResult;
    }
}