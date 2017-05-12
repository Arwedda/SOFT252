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
public class ReservationHistory implements Serializable {
    private ArrayList<Reservation> arlReservationHistory = new ArrayList<>();
    
    /**
     * Default constructor for a reservation history
     */
    public ReservationHistory(){
    }
    
    /**
     * Adds a reservation to the reservation history
     * @param reservation the reservation to add
     * @return true if it worked correctly, false if it failed
     */
    public Boolean addReservation(Reservation reservation) {
        Boolean response = false;
        
        if (reservation != null) {
            response = arlReservationHistory.add(reservation);
        }
        return response;
    }
    
    /**
     * Get the reservation history
     * @return the reservation history
     */
    public ArrayList<Reservation> getReservationHistory(){
        return arlReservationHistory;
    }
}