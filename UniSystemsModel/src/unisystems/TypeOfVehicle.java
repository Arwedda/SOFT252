/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisystems;

import java.io.Serializable;

/**
 *
 * @author Joseph Kellaway, Alex Murphy and Zakaria Robinson
 */
public enum TypeOfVehicle implements Serializable {
    PICKUP,
    VAN,
    CAR,
    MINIBUS,
    MINITRACTOR;
    
    /**
     * Default constructor for TypeOfVehicle enum
     */
    TypeOfVehicle(){
    }
    
    /**
     * Creates a user-friendly string to describe the TypeOfVehicle
     * @return User-friendly string to describe the type of vehicle
     */
    @Override
    public String toString()
    {
        String strResult = "";
        switch (this)
        {
            case PICKUP:
                strResult = "Pick-up";
                break;
            case VAN:
                strResult = "Van";
                break;
            case CAR:
                strResult = "Car";
                break;
            case MINIBUS:
                strResult = "Mini-bus";
                break;
            case MINITRACTOR:
                strResult = "Mini-tractor";
                break;
        }
        return strResult;
    }
}
