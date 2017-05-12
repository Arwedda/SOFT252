/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.util.Stack;
import command.interfaces.ICommand;
import command.interfaces.ICommandTracker;
import java.io.Serializable;
import unisystems.UniSystems;

/**
 *
 * @author Joseph Kellaway, Alex Murphy and Zakaria Robinson
 */
public class CommandTracker implements ICommandTracker, Serializable {
    private Stack<ICommand> stkDone = new Stack<>();
    private Stack<ICommand> stkUndone = new Stack<>();
    
    /**
     * executes the command objACommand
     * @param objACommand The command to be executed
     * @return Returns true if the command was successful, false if it fails
     */
    @Override
    public Boolean executeCommand(ICommand objACommand) {
        Boolean blnExecuted = false;
        if (objACommand != null){
            if (objACommand.doCommand()){
                this.stkDone.push(objACommand);
                blnExecuted = true;
                
                if (UniSystems.getInstance().getLastCommand() instanceof CreateObjectCommand || UniSystems.getInstance().getLastCommand() instanceof EditObjectCommand) {
                    this.stkUndone = new Stack<>();
                }
            }
        }
        return blnExecuted;
    }

    /**
     * undoes the last command run
     * @return Boolean value for if the last command has been undone successfully
     */
    @Override
    public Boolean undoLastCommand() {
        Boolean blnUndone = false;
        if (this.isUndoable()){
            ICommand lastCommand = this.stkDone.pop();
            if (lastCommand.undoCommand()){
                this.stkUndone.push(lastCommand);
                blnUndone = true;
            }
        }
        return blnUndone;
    }

    /**
    * redoes last command in the undone stack
    * @return Boolean value for if the last command has been redone successfully
    */
    @Override
    public Boolean redoLastCommand() {
        Boolean blnDone = false;  
        if (this.isRedoable()){
            ICommand lastCommand = this.stkUndone.pop();

            if (lastCommand.doCommand()){
                this.stkDone.push(lastCommand);
                blnDone = true;
            }
        }
        return blnDone;
    }

    /**
     * returns true if a command is able to be undone
     * @return Boolean value for if commands can be undone
     */
    @Override
    public Boolean isUndoable() {
        return !stkDone.isEmpty();
    }

    /**
     * returns true if a command is able to be redone
     * @return Boolean value for if commands can be redone
     */
    @Override
    public Boolean isRedoable() {
        return !stkUndone.isEmpty();
    }
}