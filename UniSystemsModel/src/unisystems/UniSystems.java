/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisystems;

import command.interfaces.ICommandBehaviour;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import observer.IObserver;
import observer.ISubject;


/**
 *
 * @author Joseph Kellaway, Alex Murphy and Zakaria Robinson
 */
public class UniSystems implements IObserver, ISubject, Serializable {
    private ArrayList<Car> arlCarList = new ArrayList<>();
    private ArrayList<Staff> arlStaffList = new ArrayList<>();
    private transient ArrayList<IObserver> observers = new ArrayList<>();
    private static UniSystems instance = new UniSystems();
    private ICommandBehaviour lastCommand = null;

    /**
     * Default constructor for UniSystems
     */
    protected UniSystems(){
    }

    /**
     * Gets the active instance of UniSystems. Allows the user to create an instance
     * if one doesn't exist, forcing the instance to follow the Singleton Design pattern.
     * @return Single initiation of UniSystems
     */
    public static UniSystems getInstance(){
        if (instance == null){
            instance = new UniSystems();
        }
        return instance;
    }
    
    /**
     * readResolve ensures that serialization works with the singleton design 
     * pattern. Makes sure that the instance is correctly deserialized
     * @return instance
     * @throws ObjectStreamException Thrown when there is an issue deserialising 
     */
    protected Object readResolve() throws ObjectStreamException {
        instance.setArlCarList(getCarList());
        instance.setArlStaffList(getStaffList());
        return instance;
    }
    
    /**
     * Used to create a variety of test data used during production of the unisystems data model and gui
     */
    public void createTestData()
    {
        Car item;
        item = new LongTermCar("A111 HEY", "Nissan", "Micra", false, true, 1, LocalDate.now(), TypeOfVehicle.CAR, true);
        this.addNewCar(item);
        item = new LongTermCar("B222 EGG", "Bugatti", "Veyron", true, false, 1, LocalDate.now(), TypeOfVehicle.VAN, false);
        this.addNewCar(item);
        item = new LongTermCar("C333 POO", "Ford", "Fiesta", true, false, 1, LocalDate.now(), TypeOfVehicle.MINIBUS, false);
        this.addNewCar(item);
        item = new ShortTermCar("D444 PEE", "Vauxhall", "Corsa", false, false, 1, LocalDate.now(), TypeOfVehicle.MINITRACTOR, true);
        this.addNewCar(item);
        item = new ShortTermCar("E555 GIN", "Mini", "Cooper", true, false, 1, LocalDate.now(), TypeOfVehicle.PICKUP, false);
        this.addNewCar(item);
        item = new ShortTermCar("F666 GER", "FIAT", "500", true, false, 1, LocalDate.now(), TypeOfVehicle.CAR, false);
        this.addNewCar(item);
        
        Staff person;
        person = new StaffMember(1, "Zak Robinson", "Stankray", VehicleAccessGroup.CATERINGTEAM);
        this.addStaff(person);
        person = new Administrator(2, "Joseph Kellaway", "Plymouth", VehicleAccessGroup.ACADEMICS, "kellaway");
        this.addStaff(person);
        person = new StaffMember(3, "Alex Murphy", "Test", VehicleAccessGroup.ACADEMICS);
        this.addStaff(person);
    }
    
    /**
     * Adds a new car to a list that holds both short and long term rental cars
     * @param newCar The car to be added to the list
     * @return True = successfully added false = failed to add correctly
     */
    public Boolean addNewCar(Car newCar)
    {
        Boolean blnResult = false;
        if (newCar != null){
            if (!this.arlCarList.contains(newCar)){
                blnResult = arlCarList.add(newCar);
                if (blnResult){
                    newCar.registerObserver(this);
                    this.notifyObservers();
                }
            }
        }
        return blnResult;
    }
    
    /**
     * Removes a car from the arraylist based on the passed index value
     * @param index The index of the car to be removed
     * @return true = removed successfully, false = failed to remove
     */
    public Boolean removeCarAt(Integer index)
    {
        Boolean blnResult = false;
        if(index < arlCarList.size() && index >= 0){
            if (arlCarList.get(index) != null){
                blnResult = this.deleteCar(arlCarList.get(index));
            }
        }
        return blnResult;
    }    
    
    /**
     * Deletes a car from the arraylist based on a car object that has been passed
     * @param oldCar The car to be removed
     * @return true = removed successfully, false = failed to remove
     */
    public Boolean deleteCar(Car oldCar)
    {
        Boolean blnResult = false;
        if (oldCar != null)
        {
            if (this.arlCarList.size() > 0 && this.arlCarList.contains(oldCar))
            {
                blnResult = this.arlCarList.remove(oldCar);
                if (blnResult){
                    oldCar.removeObserver(this);
                    this.notifyObservers();
                }
            }
        }
        return blnResult;
    }
    
    /**
     * Gets the arraylist of cars held within UniSystems instance
     * @return The arraylist of cars within UniSystems instance
     */
    public ArrayList<Car> getCarList()
    {
        ArrayList<Car> arlResult = new ArrayList<>();
        for (Car currItem : this.arlCarList)
        {
            arlResult.add(currItem);
        }
        return arlResult;
    }
    
    /**
     * Adds new staff to a list that holds both StaffMember and Administrator objects
     * @param newStaff The staff to be added to the list
     * @return True = successfully added false = failed to add correctly
     */
    public Boolean addStaff(Staff newStaff){
        Boolean blnResult = false;
        if (newStaff != null){
            if (!this.arlStaffList.contains(newStaff)){
                blnResult = arlStaffList.add(newStaff);
                if (blnResult){
                    newStaff.registerObserver(this);
                    this.notifyObservers();
                }
            }
        }
        return blnResult;
    }
    
    /**
     * Removes staff from the arraylist based on the passed index value
     * @param index The index of the staff to be removed
     * @return true = removed successfully, false = failed to remove
     */
    public Boolean removeStaffAt(Integer index)
    {
        Boolean blnResult = false;
        if(index < arlStaffList.size() && index >= 0){
            if (arlStaffList.get(index) != null){
                blnResult = this.deleteStaff(arlStaffList.get(index));
            }
        }
        return blnResult;
    }    
    
    /**
     * Deletes staff from the arraylist based on a staff object that has been passed
     * @param oldStaff The staff to be removed
     * @return true = removed successfully, false = failed to remove
     */
    public Boolean deleteStaff(Staff oldStaff){
        Boolean blnResult = false;
        if (oldStaff != null)
        {
            if (this.arlStaffList.size() > 0 && this.arlStaffList.contains(oldStaff))
            {
                blnResult = this.arlStaffList.remove(oldStaff);
                if (blnResult){
                    oldStaff.removeObserver(this);
                    this.notifyObservers();
                }
            }
        }
        return blnResult;
    }
    
    /**
     * Gets the arraylist of staff held within UniSystems instance
     * @return The arraylist of staff within UniSystems instance
     */
    public ArrayList<Staff> getStaffList() {
        ArrayList<Staff> arlResult = new ArrayList<>();
        for (Staff currItem : this.arlStaffList)
        {
            arlResult.add(currItem);
        }
        return arlResult;
    }

    /**
     * Pastes the entire staff list into the instance of UniSystems. Only accessed
     * when loading the system
     * @param arlStaffList The staff list to be loaded
     */
    public void setArlStaffList(ArrayList<Staff> arlStaffList) {
        this.arlStaffList = arlStaffList;
    }

    /**
     * Pastes the entire car list into the instance of UniSystems. Only accessed
     * when loading the system
     * @param arlCarList The car list to be loaded
     */
    public void setArlCarList(ArrayList<Car> arlCarList) {
        this.arlCarList = arlCarList;
    }
    
    /**
     * Gets the last command stored within UniSystems instance. Used with Command Pattern
     * (undo)
     * @return The last command run by the system
     */
    public ICommandBehaviour getLastCommand() {
        return lastCommand;
    }

    /**
     * Sets the last command stored within UniSystems instance. Used with Command Pattern
     * (undo)
     * @param lastCommand The last command run by the system
     */
    public void setLastCommand(ICommandBehaviour lastCommand) {
        this.lastCommand = lastCommand;
    }
       
    /**
     * Gets arraylist of observers related to the staff member
     * @return arraylist of observers
     */
    public ArrayList<IObserver> getObservers(){
        ArrayList<IObserver> arlResult = new ArrayList<>();
        for (IObserver currObserver : observers){
            arlResult.add(currObserver);
        }
        return arlResult;
    }
    
    /**
     * Adds the passed in observer to the observer array list
     * @param o observer to register
     * @return true = registered correctly, false = failed to register
     */
    @Override
    public Boolean registerObserver(IObserver o) {
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
     * Remove passed observer from the observer arraylist
     * @param o Observer to remove from the list
     * @return true = observer successfully removed from the list, false = failed to remove observer
     */
    @Override
    public Boolean removeObserver(IObserver o) {
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
     * Notify observers of notable situation
     */
    @Override
    public void notifyObservers() {
        if (this.observers != null && this.observers.size() > 0)
        {
            for (IObserver currentObserver : this.observers)
            {
                currentObserver.update();
            }
        }
    }

    /**
     * 
     */
    @Override
    public void update() {
        //method has to exist but is never called
    }
}