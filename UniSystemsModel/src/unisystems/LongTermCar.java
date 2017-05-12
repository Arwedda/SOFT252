/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisystems;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Joseph Kellaway, Alex Murphy and Zakaria Robinson
 */
public class LongTermCar extends Car {
    private ArrayList<Reservation> arlReservationList = new ArrayList<>();

    /**
     * Calls the constructor from the super class
     */
    public LongTermCar(){
        super();
    }
    
    /**
     * Constructor with pre-defined variables to create a LongTermCar through the
     * super class' pre-define constructor
     * @param registration The car registration (unique)
     * @param make The car's make
     * @param model The car's model
     * @param isAvailable Whether the car is available
     * @param isUnderRepair Whether the car is under repair
     * @param mileage The car's current mileage
     * @param serviceDue When the car's next service is due
     * @param vehicleType The type of vehicle being created (Enum)
     * @param toBeSold Whether the car is being sold
     */
    public LongTermCar(String registration, String make, String model, Boolean isAvailable, Boolean isUnderRepair, Integer mileage, LocalDate serviceDue, TypeOfVehicle vehicleType, Boolean toBeSold){
        super(registration, make, model, isAvailable, isUnderRepair,
                mileage, serviceDue, vehicleType, toBeSold);
        ArrayList<Reservation> arlReservationList = null;
    }
    
    /**
     * creates a new reservation and adds it to the list
     * @param newReservation a new reservation object
     * @return returns true if it was added successfully
     */
    public Boolean addNewReservation(Reservation newReservation){
        if (newReservation != null){
            if (!this.arlReservationList.contains(newReservation)){
                arlReservationList.add(newReservation);
                return true;
            }
        }
        return false;
    }
    
    /**
     * removes the reservation object at index location
     * @param index the place the reservation in the list
     * @return returns true if deletion was succesful
     */
    public Boolean removeReservationAt(Integer index){
        if(index < arlReservationList.size() && index >= 0){
            arlReservationList.remove(arlReservationList.get(index));
            return true;
        }
        return false;
    }
    
    /**
     * removes the reservation object from the list if it exists in the list
     * @param oldReservation the reservation object that we want to remove from the list
     * @return returns true if deletion was successful
     */
    public Boolean removeReservation(Reservation oldReservation){
        if (oldReservation != null){
            if (this.arlReservationList.size() > 0 && this.arlReservationList.contains(oldReservation)){
                this.arlReservationList.remove(oldReservation);
                return true;
            }
        }
        return false;
    }

    /**
     * calls and returns the car's registration list
     * @return returns the car's registration list 
     */
    public ArrayList<Reservation> getArlReservationList(){
        return arlReservationList;
    }
}