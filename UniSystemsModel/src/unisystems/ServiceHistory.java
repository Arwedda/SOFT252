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
public class ServiceHistory implements Iterable<Service>, Serializable {
    private ArrayList<Service> arlServiceHistory = new ArrayList<>();
    
    /**
     * Default constructor for a service history
     */
    public ServiceHistory(){
    }
    
    /**
     * Adds a service to the service history
     * @param service A new service to add to the service history
     * @return returns true if the service was successfully added, false if it failed
     */
    public Boolean addService(Service service) {
        Boolean response = false;
        if (service != null) {
            response = arlServiceHistory.add(service);
        }
        return response;
    }
    
    /**
     * Gets the service history
     * @return the service history
     */
    public ArrayList<Service> getServiceHistory(){
        return arlServiceHistory;
    }
    
    /**
     * Allows the class to iterate over itself
     * @return the iterable variation of the service history list
     */
    @Override
    public Iterator<Service> iterator() {
        return arlServiceHistory.iterator();
    }
}