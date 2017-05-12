/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.interfaces;

/**
 *
 * @author Joseph Kellaway, Alex Murphy and Zakaria Robinson
 */
public interface ICommand extends ICommandBehaviour {
    Boolean isExecuted();
    
    Boolean setExecuted(Boolean flag);
    
    Boolean isUndone();
}