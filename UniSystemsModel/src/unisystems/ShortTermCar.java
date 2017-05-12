/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisystems;

import java.time.LocalDate;

/**
 *
 * @author Joseph Kellaway, Alex Murphy and Zakaria Robinson
 */
public class ShortTermCar extends Car {
    /**
     * Default constructor to create ShortTermCars through the super class'
     * default constructor
     */
    public ShortTermCar(){
        super();
    }
    
    /**
     * Constructor with pre-defined variables to create a ShortTermCar through the
     * super class' pre-define constructor
     * @param registration The car registration (unique)
     * @param make The car's make
     * @param model The car's model
     * @param isAvailable Whether the car is available
     * @param isUnderRepair Whether the car is under repair
     * @param mileage The car's current mileage
     * @param serviceDue When the car's next service is due
     * @param vehicleType The type of vehicle being created (Enum)
     * @param toBeSold Whether the car is being sold
     */
    public ShortTermCar(String registration, String make, String model,
            Boolean isAvailable, Boolean isUnderRepair,
            Integer mileage, LocalDate serviceDue, TypeOfVehicle vehicleType, Boolean toBeSold){
        
        super(registration, make, model, isAvailable, isUnderRepair,
               mileage, serviceDue, vehicleType, toBeSold);
    }
}