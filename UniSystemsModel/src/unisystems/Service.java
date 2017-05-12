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
public class Service implements Serializable {
    private LocalDate serviceDate = null;
    private LocalDate returnDate = null;
    private String serviceNotes = "Unknown";
    
    /**
     * The default construct for a Service.
     */
    public Service(){
    }
    
    /**
     * A constructor for a service that contains a service start date
     * @param serviceDate the start date for the service
     */
    public Service(LocalDate serviceDate){
        this.serviceDate = serviceDate;
    }
    
    /**
     * A constructor for a service that contains all information
     * @param serviceDate the start date for the service
     * @param returnDate the end date of the service
     * @param serviceNotes any notes about the service
     */
     public Service(LocalDate serviceDate, LocalDate returnDate, String serviceNotes){
        this.serviceDate = serviceDate;
        this.returnDate = returnDate;
        this.serviceNotes = serviceNotes;
    }

     /**
      * Gets the service start date
      * @return service start date
      */
    public LocalDate getServiceDate() {
        return serviceDate;
    }

     /**
      * Sets the service start date
      * @param serviceDate Start date for the service
      */
    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

     /**
      * Gets the service end date
      * @return service end date
      */
    public LocalDate getReturnDate() {
        return returnDate;
    }

     /**
      * Sets the service return date
      * @param returnDate The return date for the service
      */
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

     /**
      * Gets notes stored about the service
      * @return notes about the service
      */
    public String getServiceNotes() {
        return serviceNotes;
    }

     /**
      * Sets a note about the service
      * @param serviceNotes The notes made when returning a service
      */
    public void setServiceNotes(String serviceNotes) {
        this.serviceNotes = serviceNotes;
    }
    
    /**
     * Checks whether the service clashes with set of dates passed in.
     * @param startDate the start date to compare this service to
     * @param endDate the end date to compare this service to
     * @return true = dates do clash, false = dates don't clash
     */
    public Boolean doDatesClash(LocalDate startDate, LocalDate endDate) {
        if (this.returnDate == null){
            return true;
        }
        ArrayList<LocalDate> dates = new ArrayList<>();
        LocalDate tempDate = this.serviceDate;
        
        while (!tempDate.isAfter(this.returnDate)) {
            dates.add(tempDate);
            tempDate = tempDate.plusDays(1);
        }
        
        if (dates.contains(startDate) || dates.contains(endDate)) {
            return true;
        }
        return false;
    }
}