/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import command.interfaces.ICommandBehaviour;
import java.io.Serializable;
import unisystems.Car;
import unisystems.Rental;
import unisystems.Staff;
import unisystems.UniSystems;

/**
 *
 * @author Joseph Kellaway, Alex Murphy and Zakaria Robinson
 */
public class EditObjectCommand implements ICommandBehaviour, Serializable {
    private Object oldObject = null;
    private Object newObject = null;
    private UniSystems system = null;
    
    /**
     * this is  constructor for a command to edit an object
     * @param oldObject The old object to be deleted
     * @param newObject the new object to replace the old object
     * @param system The instance of the system holding the lists of objects
     */
    public EditObjectCommand(Object oldObject, Object newObject, UniSystems system) {
        this.newObject = newObject;
        this.system = system;        
        if (oldObject instanceof Car) {
            for (Car car : this.system.getCarList()) {
                if (car.getRegistration().equals(((Car) oldObject).getRegistration())) {
                    this.oldObject = car;
                }
            }
        } else if (oldObject instanceof Staff) {
            for (Staff staff : this.system.getStaffList()) {
                if (staff.getiD().equals(((Staff) oldObject).getiD())) {
                    this.oldObject = staff;
                }
            }
        }
    }
    
    /**
     * checks that all parameters exist
     * @return 
     */
    private Boolean isValid() {
        if (this.oldObject != null && this.newObject != null && this.system != null) {
            return true;
        }
        return false;
    }

    /**
     * deletes the old object and replaces it with the new object
     * @return Boolean value for if the command executed successfully
     */
    @Override
    public Boolean doCommand() {
        Boolean delResponse = false;
        Boolean createResponse = false;
        if (this.isValid()) {
            if (this.oldObject instanceof Car && this.newObject instanceof Car) {
                delResponse = this.system.deleteCar((Car) this.oldObject);
                createResponse = this.system.addNewCar((Car) this.newObject);
            } else if (this.oldObject instanceof Staff && this.newObject instanceof Staff) {
                delResponse = this.system.deleteStaff((Staff) this.oldObject);
                createResponse = this.system.addStaff((Staff) this.newObject);
            }
        }
        if (delResponse && createResponse) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * undoes the deletion of the old object and restores the new object with it
     * @return Boolean value for if the command has been undone successfully
     */
    @Override
    public Boolean undoCommand() {
        Boolean delResponse = false;
        Boolean createResponse = false;
        if (this.isValid()) {
            if (this.oldObject instanceof Car && this.newObject instanceof Car) {
                delResponse = this.system.deleteCar((Car) this.newObject);
                createResponse = this.system.addNewCar((Car) this.oldObject);
            } else if (this.oldObject instanceof Staff && this.newObject instanceof Staff) {
                delResponse = this.system.deleteStaff((Staff) this.newObject);
                createResponse = this.system.addStaff((Staff) this.oldObject);
            }
        }
        if (delResponse && createResponse) {
            return true;
        } else {
            return false;
        }
    }

}
