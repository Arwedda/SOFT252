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
public enum ReservationState implements Serializable {
    OPEN,
    COLLECTED,
    CANCELLED,
    MISSED;
    
    /**
     * The default constructor for a reservation state
     */
    ReservationState(){
    }
    
    /**
     * converts the reservation state to a user-friendly word
     * @return reservation state
     */
    @Override
    public String toString()
    {
        String strResult = "";
        switch (this)
        {
            case OPEN:
                strResult = "Open";
                break;
            case COLLECTED:
                strResult = "Collected";
                break;
            case CANCELLED:
                strResult = "Cancelled";
                break;
            case MISSED:
                strResult = "Missed";
                break;
        }
        return strResult;
    }
}