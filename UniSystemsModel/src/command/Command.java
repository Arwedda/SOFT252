/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import command.interfaces.ICommand;
import command.interfaces.ICommandBehaviour;
import java.io.Serializable;

/**
 *
 * @author Joseph Kellaway, Alex Murphy and Zakaria Robinson
 */
public class Command implements ICommand, Serializable {
    private ICommandBehaviour delegate;
    private Boolean blnExecuted;
    
    /**
     * Constructor for a command
     * @param objACommand this is a type of ICommandBehavior
     */
    public Command(ICommandBehaviour objACommand){
        this.delegate = objACommand;
    }

    /**
     * returns true if the command is executed
     * @return Boolean return for if the command has been executed or not
     */
    @Override
    public Boolean isExecuted() {
        return this.blnExecuted;
    }

    /**
     * sets the parameter for blnExecuted
     * @param flag Boolean value to set if the command has been executed
     * @return Returns the value passed into it. If null is passed it will return false
     */
    @Override
    public Boolean setExecuted(Boolean flag) {
        Boolean blnResult = false;
        if (flag != null){
            this.blnExecuted = flag;
            blnResult = flag;
        }
        return blnResult;
    }

    /**
     * returns boolean to state if the command has been undone
     * @return Boolean value for if the command has been undone
     */
    @Override
    public Boolean isUndone() {
        return !this.blnExecuted;
    }

    /**
     * executes the command objACommand
     * @return Boolean value for if the command has been executed successfully
     */
    @Override
    public Boolean doCommand() {
        Boolean done = false;
        done = this.delegate.doCommand();
        this.blnExecuted = done;
        return done;
    }
    /**
     * executes the reverse of the command (undo)
     * @return Boolean value for if the command has been undone successfully
     */
    @Override
    public Boolean undoCommand() {
        Boolean undone = false;
        undone = this.delegate.undoCommand();
        this.blnExecuted = !undone;
        return undone;
    }
}