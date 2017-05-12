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
public class Rental implements Serializable {
    private Integer staffId = 0;
    private LocalDate dateRented = null;
    private LocalDate returnDate = null;
    private LocalDate dateReturned = null;
    private String notes = "Not returned yet.";

    /**
     * the default constructor
     */
    public Rental(){
    }
    
    /**
     * Constructor for a rental object
     * @param staffId the staff id 
     * @param dateRented the date the rental is made
     * @param returnDate the date the rental is to be returned
     * @param dateReturned the date the rental was actually returned
     * @param notes notes on the details of the rental once it's returned
     */
    public Rental(Integer staffId, LocalDate dateRented, LocalDate returnDate, LocalDate dateReturned, String notes){
        this.staffId = staffId;
        this.dateRented = dateRented;
        this.returnDate = returnDate;
        this.dateReturned = dateReturned;
        this.notes = notes;
    }

    /**
     * Gets the Staffid of the rental
     * @return the Staffid
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * sets the staffid
     * @param staffId The value the user wants to set the Staffid too
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     * gets the rentalDate of the rental
     * @return returns the dateRented
     */
    public LocalDate getDateRented() {
        return dateRented;
    }

    /**
     * sets the dateRented
     * @param dateRented the date that the user would like to set 
     */
    public void setDateRented(LocalDate dateRented) {
        this.dateRented = dateRented;
    }

    /**
     * returns the returnDate of the rental
     * @return The returnDate of the rental
     */
    public LocalDate getReturnDate() {
        return returnDate;
    }

    /**
     * sets the returnDate
     * @param returnDate the valu8e that the user would like to set as the returnDate
     */
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * returns the dateReturned of the rental object
     * @return The dateReturned variable of the rental
     */
    public LocalDate getDateReturned() {
        return dateReturned;
    }

    /**
     * sets the dateRented
     * @param dateReturned The value the user would klike to set as the dateReturned
     */
    public void setDateReturned(LocalDate dateReturned) {
        this.dateReturned = dateReturned;
    }

    /**
     * gets the notes of the rental
     * @return the notes string variable of the rental
     */
    public String getNotes() {
        return notes;
    }

    /**
     * sets the notes value
     * @param notes the text value the user would like to set as the notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * compares the start dates and end dates of a rental with another value by iterating through the dates to check if there is a clash with another object
     * @param startDate start date of the new object
     * @param endDate end date of the new object
     * @return returns true if a clash was found
     */
    public Boolean doDatesClash(LocalDate startDate, LocalDate endDate) {
        ArrayList<LocalDate> dates = new ArrayList<>();
        LocalDate tempDate = this.dateRented;
        LocalDate tempReturnDate = this.returnDate;

        if (this.dateReturned != null){
            tempReturnDate = this.dateReturned;
        }
        
        while (!tempDate.isAfter(tempReturnDate)) {
            dates.add(tempDate);
            tempDate = tempDate.plusDays(1);
        }
        
        if (dates.contains(startDate) || dates.contains(endDate)) {
            return true;
        }
        return false;
    }
    
    /**
     * constructs a string out of the rentals variables to be displayed
     * @return returns a constructed string
     */
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        Integer iD = this.staffId;
        String name = "No name";

        for (Staff staff : UniSystems.getInstance().getStaffList()){
            if (iD == staff.getiD())
            {
                name = staff.getName();
            }
        }
        result.append(name + " " + this.dateRented + " to " + this.returnDate);
        return result.toString();
    }
}