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
public class Administrator extends Staff {
    private String password = "password";
    
    /**
     * Call the default constructor from the super class
     */
    public Administrator(){
        super();
    }
    
    /**
     * Constructor for a new admin object
     * @param iD Admin ID
     * @param name admin name
     * @param address admin address
     * @param vehicleAccessGroup staff members VehicleAccessGroup
     * @param password password for log in
     */
    public Administrator(Integer iD, String name, String address, VehicleAccessGroup vehicleAccessGroup, String password){
        super(iD, name, address, vehicleAccessGroup);
        this.password = password;
    }

    /**
     * Returns the password
     * @return The stored passed
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the password
     * @param password The password to store
     */
    public void setPassword(String password) {
        this.password = password;
    }
}