/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisystems;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Joseph Kellaway, Alex Murphy and Zakaria Robinson
 */
public class RentalHistory implements Iterable<Rental>, Serializable {
    private ArrayList<Rental> arlRentalHistory = new ArrayList<>();

    /**
     * Default construct for rental history
     */
    public RentalHistory() {
    }
    
    /**
     * Main constructor for rental history
     * @param rental The rental to be added to the rental history
     * @return returns boolean value to specify whether the rental was added to the history list
     */
    public Boolean addRental(Rental rental) {
        Boolean response = false;
        
        if (rental != null) {
            response = arlRentalHistory.add(rental);
        }
        return response;
    }

    /**
     * Gets the rental history array list
     * @return the rental history array list
     */
    public ArrayList<Rental> getRentalHistory() {
        return arlRentalHistory;
    }
    
    /**
     * Allows the class to iterate over itself
     * @return the iterable variation of the rental history list
     */
    @Override
    public Iterator<Rental> iterator() {
        return arlRentalHistory.iterator();
    }
}