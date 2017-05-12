/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisystems;

/**
 *
 * @author Joseph Kellaway, Alex Murphy and Zakaria Robinson
 */
public class StaffMember extends Staff {
    /**
     * Default constructor for a StaffMember called from the super class
     */
    public StaffMember(){
        super();
    }
    
    /**
     * Parameter fed constructor for a StaffMember called from the super class
     * @param iD StaffMember's unique ID
     * @param name StaffMember's name
     * @param address StaffMember's address
     * @param vehicleAccessGroup StaffMember's VehicleAccessGroup
     */
    public StaffMember(Integer iD, String name, String address, VehicleAccessGroup vehicleAccessGroup){
        super(iD, name, address, vehicleAccessGroup);
    }
}
