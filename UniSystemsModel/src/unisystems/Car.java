/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisystems;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import observer.IObserver;
import observer.ISubject;

/**
 *
 * @author Joseph Kellaway, Alex Murphy and Zakaria Robinson
 */
public abstract class Car implements ISubject, Serializable {
    private String registration = "UNKNOWN";
    private String make = "UNKNOWN";
    private String model = "UNKNOWN";
    private Boolean isAvailable = true;
    private Boolean isUnderRepair = false;
    private Integer mileage = 0;
    private LocalDate serviceDue = LocalDate.now().plusYears(1);
    private TypeOfVehicle typeOfVehicle = null;
    private Boolean toBeSold = false;
    private RentalHistory rentalHistory = new RentalHistory();
    private ServiceHistory serviceHistory = new ServiceHistory();
    private ArrayList<IObserver> observers = new ArrayList<>();

    /**
     * Default constructor for the car object
     */
    public Car(){
    }

    /**
     * Constructor for the car object
     * @param registration car registration
     * @param make car make
     * @param model model of car
     * @param isAvailable if the car is available to rent or not
     * @param isUnderRepair if the car is currently in repair
     * @param mileage the mileage of the car
     * @param serviceDue if a service is due for the car
     * @param typeOfVehicle the type of car that it is
     * @param toBeSold  if the car is waiting to be sold
     */
    public Car(String registration, String make, String model, Boolean isAvailable,
            Boolean isUnderRepair, Integer mileage, LocalDate serviceDue, TypeOfVehicle typeOfVehicle,
            Boolean toBeSold){
        this.registration = registration;
        this.make = make;
        this.model = model;
        this.isAvailable = isAvailable;
        this.isUnderRepair = isUnderRepair;
        this.mileage = mileage;
        this.serviceDue = serviceDue;
        this.typeOfVehicle = typeOfVehicle;
        this.toBeSold = toBeSold;
        this.rentalHistory = new RentalHistory();
        this.serviceHistory = new ServiceHistory();
    }

    /**
     * returns the registration of the car
     * @return The registration of the car
     */
    public String getRegistration(){
        return registration;
    }

    /**
     * sets the registration of the car if it exists
     * @param registration The registration of the car
     */
    public void setRegistration(String registration) {
        if (registration != null && !registration.isEmpty()) {
            this.registration = registration;
            notifyObservers();
        }
    }

    /**
     * sets the make of the car
     * @return the make of the car
     */
    public String getMake(){
        return make;
    }

    /**
     * sets the make of the car if it exists
     * @param make the make of the car
     */
    public void setMake(String make){
        if (make != null && !make.isEmpty()) {
            this.make = make;
            notifyObservers();
        }
    }

    /**
     * sets the model of the car
     * @return The model of the car
     */
    public String getModel(){
        return model;
    }

    /**
     * sets the model of the car if it exists
     * @param model The model of the car
     */
    public void setModel(String model){
        if (model != null && !model.isEmpty()) {
            this.model = model;
            notifyObservers();
        }
    }

    /**
     * gets the availability of the car
     * @return the availability of the car as a boolean
     */
    public Boolean getAvailability(){
        return isAvailable;
    }

    /**
     * sets the availability of the car
     * @param isAvailable returns the availability of the car
     */
    public void setAvailability(Boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    /**
     * gets the ServiceDue date
     * @return returns the ServiceDue date
     */
    public LocalDate getServiceDue(){
        return serviceDue;
    }

    /**
     * sets the ServiceDue date
     * @param serviceDue the ServiceDue date
     */
    public void setServiceDue(LocalDate serviceDue){
        this.serviceDue = serviceDue;
    }

    /**
     * gets the isUnderRepair boolean
     * @return the isUnderRepair boolean
     */
    public Boolean getRepairStatus(){
        return isUnderRepair;
    }

    /**
     * sets the isUnderRepair boolean
     * @param isUnderRepair the isUnderRepair boolean
     */
    public void setRepairStatus(Boolean isUnderRepair){
        this.isUnderRepair = isUnderRepair;
    }

    /**
     * returns the mileage of the car
     * @return the mileage of the car
     */
    public Integer getMileage(){
        return mileage;
    }

    /**
     * sets the mileage of the car if the mileage exists
     * @param mileage the mileage of the car
     */
    public void setMileage(Integer mileage){
        if (mileage != null && mileage >= 0){
            this.mileage = mileage;
            notifyObservers();
        }
    }
    
    /**
     * returns if the car is ready to be sold
     * @return the boolean stating if the car is waiting to be sold
     */
    public Boolean getSaleStatus(){
        return this.toBeSold;
    }

    /**
     * sets the car's ready to be sold status
     * @param toBeSold return the boolean stating if the car is waiting to be sold
     */
    public void setSaleStatus(Boolean toBeSold){
        this.toBeSold = toBeSold;
    }
    
    /**
     * returns the type of vehicle
     * @return the type of vehicle enum
     */
    public TypeOfVehicle getTypeOfVehicle(){
        return this.typeOfVehicle;
    }
    
    /**
     * sets the type of vehicle
     * @param typeOfVehicle the type of vehicle enum
     */
    public void setTypeOfVehicle(TypeOfVehicle typeOfVehicle){
        this.typeOfVehicle = typeOfVehicle;
    }
    
    /**
     * adds a rental object to the rental history held by the car
     * @param rental a rental object 
     */
    public void addRental(Rental rental){
        this.rentalHistory.addRental(rental);
    }
    
    /**
     * returns the rental history of the car
     * @return this is the rental history object in the car
     */
    public RentalHistory getRentalHistory(){
        return this.rentalHistory;
    }
    
    /**
     * adds a service to the service history list held by the car
     * @param service A new service object to be added
     */
    public void addService(Service service){
        this.serviceHistory.addService(service);
    }
    
    /**
     * returns the service history held by the car
     * @return the service history held by the car
     */
    public ServiceHistory getServiceHistory(){
        return this.serviceHistory;
    }

    /**
     * creates a new list and populates it with observers
     * returns a list of the objects current observers
     * @return a list of the observers
     */
    public ArrayList<IObserver> getObservers(){
        ArrayList<IObserver> arlResult = new ArrayList<>();
        for (IObserver currObserver : observers){
            arlResult.add(currObserver);
        }
        return arlResult;
    }
    
    /**
     * creates a new array of observers if one does not exist
     * adds a new observer to the list if it doesn't already exist in the list
     * @param o the observer to be added to the list.
     * @return boolean about if it was successfully added
     */
    @Override
    public Boolean registerObserver(IObserver o){
        Boolean blnAdded = false;
        if (o != null)
        {
            if (this.observers == null)
            {
                this.observers = new ArrayList<>();
            }
            if (!this.observers.contains(o))
            {
                blnAdded = this.observers.add(o);
            }
        }
        return blnAdded;
    }

    /**
     * removes the observer passed in if it exists
     * @param o the observer to be removed
     * @return return true if it was successful
     */
    @Override
    public Boolean removeObserver(IObserver o){
        Boolean blnRemoved = false;
        if (o != null)
        {
            if (this.observers != null && this.observers.size() > 0)
            {
                blnRemoved = this.observers.remove(o);
            }
        }
        return blnRemoved;
    }

    /**
     * notifies observers
     */
    @Override
    public void notifyObservers(){
        if (this.observers != null && this.observers.size() > 0)
        {
            for (IObserver currentObserver : this.observers)
            {
                currentObserver.update();
            }
        }
    }
    
    /**
     * creates a string from the properties of car
     * @return the completed string
     */
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("Car: ");
        result.append(registration + " " + make + " " + model + " " + typeOfVehicle + " " + mileage);
        return result.toString();
    }
}