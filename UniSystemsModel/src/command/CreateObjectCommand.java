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
public class CreateObjectCommand implements ICommandBehaviour, Serializable {
    private Object objToCreate = null;
    private UniSystems system = null;

    /**
     * constructor for a command that creates objects
     * @param objToCreate The object to be created by the command
     * @param system The instance of the system holding the lists of objects
     */
    public CreateObjectCommand(Object objToCreate, UniSystems system) {
        this.objToCreate = objToCreate;
        this.system = system;
    }
    
    /**
     * returns true if both objToCreate and system exist
     * @return 
     */
    private Boolean isValid() {
        if (this.objToCreate != null && this.system != null) {
            return true;
        }
        return false;
    }
    
    /**
     * executes the command. Checks the type of object and creates the object in the system
     * @return Boolean value for if the command has been executed successfully
     */
    @Override
    public Boolean doCommand() {
        if (this.isValid()) {
            if (this.objToCreate instanceof Car) {
                return this.system.addNewCar((Car) this.objToCreate);
            } else if (this.objToCreate instanceof Staff) {
                return this.system.addStaff((Staff) this.objToCreate);
            }
        }
        return false;
    }

    /**
     * undoes the create command
     * @return Boolean value for if the command has been undone successfully
     */
    @Override
    public Boolean undoCommand() {
        if (this.isValid()) {
            if (this.objToCreate instanceof Car) {
                return this.system.deleteCar((Car) this.objToCreate);
            } else if (this.objToCreate instanceof Staff) {
                return this.system.deleteStaff((Staff) this.objToCreate);
            }
        }
        return false;
    }  
}