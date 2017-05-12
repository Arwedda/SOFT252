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
public class DeleteObjectCommand implements ICommandBehaviour, Serializable {
    private Object objToDelete = null;
    private UniSystems system = null;
    
    /**
     * constructor for a command that deletes objects
     * @param objToDelete The object to be deleted by the command
     * @param system The instance of the system holding the lists of objects
     */
    public DeleteObjectCommand(Object objToDelete, UniSystems system) {
        this.objToDelete = objToDelete;
        this.system = system;
    }
    
    /**
     * returns true if both objToDelete and system exist
     * @return 
     */
    private Boolean isValid() {
        if (this.objToDelete != null && this.system != null) {
            return true;
        }
        return false;
    }

    /**
     *  executes the command. Checks the type of object and deletes the object in the system
     * @return Boolean value for if the command executed successfully
     */
    @Override
    public Boolean doCommand() {
        if (this.isValid()) {
            if (this.objToDelete instanceof Car) {
                return this.system.deleteCar((Car) this.objToDelete);
            } else if (this.objToDelete instanceof Staff) {
                return this.system.deleteStaff((Staff) this.objToDelete);
            }
        }
        return false;
    }

    /**
     * undoes the delete command
     * @return Boolean value for if the command is undone successfully
     */
    @Override
    public Boolean undoCommand() {
        if (this.isValid()) {
            if (this.objToDelete instanceof Car) {
                return this.system.addNewCar((Car) this.objToDelete);
            } else if (this.objToDelete instanceof Staff) {
                return this.system.addStaff((Staff) this.objToDelete);
            }
        }
        return false;
    }
}