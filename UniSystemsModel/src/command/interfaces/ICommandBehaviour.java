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
public interface ICommandBehaviour {
    Boolean doCommand();
    
    Boolean undoCommand();
}