/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisystems;

import java.io.Serializable;
import java.util.ArrayList;
import observer.IObserver;
import observer.ISubject;

/**
 *
 * @author Joseph Kellaway, Alex Murphy and Zakaria Robinson
 */
public abstract class Staff implements ISubject, Serializable {
    private Integer iD = 0;
    private String name = "unknown";
    private String address = "unknown";
    private VehicleAccessGroup vehicleAccessGroup = null;
    private transient ArrayList<IObserver> observers = new ArrayList<>();

    /**
     * Default construct for Staff
     */
    public Staff(){
    }

    /**
     * Parameter fed constructor for Staff, abstract class so never used but instead
     * feeds sub classes StaffMember and Administrator
     * @param iD Staff's unique ID
     * @param name Staff name
     * @param address Staff address
     * @param vehicleAccessGroup group of vehicles accessible by this staff
     */
    public Staff(Integer iD, String name, String address, VehicleAccessGroup vehicleAccessGroup){
        this.iD = iD;
        this.name = name;
        this.address = address;
        this.vehicleAccessGroup = vehicleAccessGroup;
    }

    /**
     * Gets the staff member's id
     * @return staff member's id
     */
    public Integer getiD() {
        return iD;
    }

    /**
     * Sets the staff member's id
     * @param iD staff member's id
     */
    public void setiD(Integer iD) {
        this.iD = iD;
    }

    /**
     * Gets the staff member's name
     * @return staff member's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the staff member's name
     * @param name staff member's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the staff member's address
     * @return staff member's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the staff member's address
     * @param address staff member's address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the staff member's VehicleAccessGroup
     * @return staff member's VehicleAccessGroup
     */
    public VehicleAccessGroup getVehicleAccessGroup() {
        return vehicleAccessGroup;
    }

    /**
     * Sets the staff member's VehicleAccessGroup
     * @param vehicleAccessGroup Staff member's VehicleAcceessGroup
     */
    public void setVehicleAccessGroup(VehicleAccessGroup vehicleAccessGroup) {
        this.vehicleAccessGroup = vehicleAccessGroup;
    }
   
    /**
     * Gets arraylist of observers related to the staff member
     * @return arraylist of observers
     */
    public ArrayList<IObserver> getObservers(){
        ArrayList<IObserver> arlResult = new ArrayList<>();
        for (IObserver currObserver : observers){
            arlResult.add(currObserver);
        }
        return arlResult;
    }
    
    /**
     * Adds the passed in observer to the observer array list
     * @param o observer to register
     * @return true = registered correctly, false = failed to register
     */
    @Override
    public Boolean registerObserver(IObserver o) {
        Boolean blnAdded = false;
        if (o != null)
        {
            if (this.observers == null)
            {
                this.observers = new ArrayList<>();
            }
            if (!this.observers.contains(o))
            {
                blnAdded = this.observers.add(o);
            }
        }
        return blnAdded;
    }

    /**
     * Remove passed observer from the observer arraylist
     * @param o Observer to remove from the list
     * @return true = observer successfully removed from the list, false = failed to remove observer
     */
    @Override
    public Boolean removeObserver(IObserver o) {
        Boolean blnRemoved = false;
        if (o != null)
        {
            if (this.observers != null && this.observers.size() > 0)
            {
                blnRemoved = this.observers.remove(o);
            }
        }
        return blnRemoved;
    }

    /**
     * Notify observers of notable situation
     */
    @Override
    public void notifyObservers() {
        if (this.observers != null && this.observers.size() > 0)
        {
            for (IObserver currentObserver : this.observers)
            {
                currentObserver.update();
            }
        }
    }
    
    /**
     * builds a string of staff information to output to the user
     * @return A user-friendly string to display staff details
     */
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("Staff: ");
        result.append(iD + " " + name);
        
        return result.toString();
    }
}