/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisystems;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Joseph Kellaway, Alex Murphy and Zakaria Robinson
 */
public class Reservation implements Serializable {
    private LocalDate reservationStartDate = null;
    private LocalDate reservationEndDate = null;
    private Integer staffId = 0;
    private Integer administratorId = 0;
    private ReservationState state = ReservationState.OPEN;
    
    /**
     * Default constructor for a reservation
     */
    public Reservation(){
    }
    
    /**
     * A reservation constructor that allows the user to pass the start date, end date,
     * member of staff requesting the reservation and the administrator who made it.
     * @param reservationStartDate The start date of the reservation
     * @param reservationEndDate The end date of the reservation
     * @param staffId The member of staff requesting the reservation
     * @param administratorId The administrator making the reservation
     */
    public Reservation(LocalDate reservationStartDate, LocalDate reservationEndDate, Integer staffId, Integer administratorId){
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.staffId = staffId;
        this.administratorId = administratorId;
        this.state = ReservationState.OPEN;
    }

    /**
     * Gets the reservation start date
     * @return Reservation start date
     */
    public LocalDate getReservationStartDate() {
        return reservationStartDate;
    }

    /**
     * Sets the reservation start date
     * @param reservationStartDate Reservation start date
     */
    public void setReservationStartDate(LocalDate reservationStartDate) {
        this.reservationStartDate = reservationStartDate;
    }

    /**
     * Gets the end date of the reservation
     * @return The end date of the reservation
     */    
    public LocalDate getReservationEndDate() {
        return reservationEndDate;
    }

    /**
     * Sets the end date of the reservation
     * @param reservationEndDate The end date of the reservation
     */
    public void setReservationEndDate(LocalDate reservationEndDate) {
        this.reservationEndDate = reservationEndDate;
    }

    /**
     * Gets the id of the staff member the reservation is assigned to
     * @return the id of the staff member
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * Gets the id of the staff member the reservation is assigned to
     * @param staffId the id of the staff member
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

     /** Gets the id of the administrator who made the reservation
     * @return the id off the staff member
     */
    public Integer getAdministratorId() {
        return administratorId;
    }

    /**
     * sets the adminid
     * @param administratorId sets the admin id that reserved the car
     */
    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    /**
     * returns the reservation state variable
     * @return the reservation state
     */
    public ReservationState getState() {
        return state;
    }

    /**
     * Sets the reservation state
     * @param state the value the user would like the reservation state to have
     */
    public void setState(ReservationState state) {
        this.state = state;
    }
    
    /**
     * Compares the start dates and end dates of a reservation with another value by
     * iterating through the dates to check if there is a clash with another object's dates
     * @param startDate Start date of the new object
     * @param endDate End date of the new object
     * @return True if a clash was found, false if a reservation can be made
     */
    public Boolean doDatesClash(LocalDate startDate, LocalDate endDate) {
        ArrayList<LocalDate> dates = new ArrayList<>();
        LocalDate tempDate = this.reservationStartDate;
        
        while (!tempDate.isAfter(this.reservationEndDate)) {
            dates.add(tempDate);
            tempDate = tempDate.plusDays(1);
        }
        
        if (dates.contains(startDate) || dates.contains(endDate)) {
            return true;
        }
        return false;
    }
    
    /**
     * constructs a user-friendly string out of the reservation variables to be displayed
     * @return returns a constructed string
     */
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        Integer renterID = this.staffId;
        String renterName = "No name";
        Integer adminID = this.administratorId;
        String adminName = "No name";

        for (Staff staff : UniSystems.getInstance().getStaffList()){
            if (renterID.equals(staff.getiD()))
            {
                renterName = staff.getName();
            }
            if (adminID.equals(staff.getiD())){
                adminName = staff.getName();
            }
        }
        result.append(renterID + " " + renterName + " from " + this.getReservationStartDate()
                + " until " + this.getReservationEndDate() + " booked by " + adminID + " " + adminName);
        return result.toString();
    }
}