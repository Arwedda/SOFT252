/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisystems;

import command.interfaces.ICommand;
import command.interfaces.ICommandBehaviour;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import observer.IObserver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joseph Kellaway, Alex Murphy and Zakaria Robinson
 */
public class UniSystemsTest {
    private ArrayList<Car> arlCarList = new ArrayList<>();
    private ArrayList<Staff> arlStaffList = new ArrayList<>();
    private transient ArrayList<IObserver> observers = new ArrayList<>();
    private static UniSystems instance = new UniSystems();
    private ICommandBehaviour lastCommand = null;
    
    public UniSystemsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetInstance() {
    }

    @Test
    public void testReadResolve() throws Exception {
    }

    @Test
    public void testCreateTestData() {
    }

    @Test
    public void testAddNewCar() {
        Car car = new ShortTermCar("A111 HEY", "Nissan", "Micra", false, true, 1, LocalDate.now(), TypeOfVehicle.CAR, true);
        this.instance.addNewCar(car);
        
        assertEquals("Objects should be equal.", car, this.instance.getCarList().get(0));        
    }

    @Test
    public void testRemoveCarAt() {
        this.arlCarList = new ArrayList<>();
        
        Car car = new ShortTermCar("A111 HEY", "Nissan", "Micra", false, true, 1, LocalDate.now(), TypeOfVehicle.CAR, true);
        this.instance.addNewCar(car);
        
        this.instance.removeCarAt(0);
        
        assertEquals("Object should be null.", 0, this.instance.getCarList().size());
    }

    @Test
    public void testDeleteCar() {
        this.arlCarList = new ArrayList<>();
        
        Car car = new ShortTermCar("A111 HEY", "Nissan", "Micra", false, true, 1, LocalDate.now(), TypeOfVehicle.CAR, true);
        this.instance.addNewCar(car);
        
        this.instance.deleteCar(car);
        
        assertEquals("Object should be null.", 0, this.instance.getCarList().size());
    }

    @Test
    public void testGetCarList() {
        
    }

    @Test
    public void testSetArlCarList() {
        this.arlCarList = new ArrayList<>();
        this.instance.setArlCarList(this.arlCarList);
        
        assertEquals("Objects should be equal.", this.arlCarList, this.instance.getCarList());
    }

    @Test
    public void testAddStaff() {
        this.arlStaffList = new ArrayList<>();
        
        Staff person = new StaffMember(1, "Zak Robinson", "Stankray", VehicleAccessGroup.CATERINGTEAM);
        this.instance.addStaff(person);
        
        assertEquals("Objects should be equal.", person, this.instance.getStaffList().get(0));
        this.instance.removeStaffAt(0);
    }

    @Test
    public void testRemoveStaffAt() {
        this.arlStaffList = new ArrayList<>();
        
        Staff person = new StaffMember(1, "Zak Robinson", "Stankray", VehicleAccessGroup.CATERINGTEAM);
        this.instance.addStaff(person);
        
        this.instance.removeStaffAt(0);
        
        assertEquals("Object should be null.", 0, this.instance.getStaffList().size());
    }

    @Test
    public void testDeleteStaff() {
        arlStaffList = new ArrayList<>();
        
        Staff person = new StaffMember(1, "Zak Robinson", "Stankray", VehicleAccessGroup.CATERINGTEAM);
        this.instance.addStaff(person);
        
        this.instance.deleteStaff(person);
        
        assertEquals("Object should be null.", 0, this.instance.getStaffList().size());
    }

    @Test
    public void testGetStaffList() {
    }

    @Test
    public void testSetArlStaffList() {
        this.arlStaffList = new ArrayList<>();
        this.instance.setArlStaffList(this.arlStaffList);
        
        assertEquals("Objects should be equal.", this.arlStaffList, this.instance.getStaffList());
    }

    @Test
    public void testGetLastCommand() {
    }

    @Test
    public void testSetLastCommand() {
        this.lastCommand = new ICommand() {
            @Override
            public Boolean isExecuted() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Boolean setExecuted(Boolean flag) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Boolean isUndone() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Boolean doCommand() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Boolean undoCommand() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        this.instance.setLastCommand(this.lastCommand);
        
        assertEquals("Objects should be equal.", this.lastCommand, this.instance.getLastCommand());
    }

    @Test
    public void testGetObservers() {
    }

    @Test
    public void testRegisterObserver() {
        IObserver o = new IObserver() {
            @Override
            public void update() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        this.instance.registerObserver(o);
        
        assertEquals("Objects should be equal.", o, this.instance.getObservers().get(0));
        this.instance.removeObserver(o);
    }

    @Test
    public void testRemoveObserver() {
        IObserver o = null;
        this.instance.registerObserver(o);
        this.instance.removeObserver(o);
        
        assertEquals("Object should be null.", 0, this.instance.getObservers().size());
    }

    @Test
    public void testNotifyObservers() {
    }

    @Test
    public void testUpdate() {
    }
    
    @Test
    public void testIsComplete() {
    }
}
