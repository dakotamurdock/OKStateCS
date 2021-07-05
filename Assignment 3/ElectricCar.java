/*
Part 2: Child Classes/Part 3: Polymorphism
For encapsulation purposes, I made the child class fields private and provide getter methods for them. I override the
vehicle abstract method for getFuelEfficiency with the appropriate calculation for this child class.
*/

public class ElectricCar extends Vehicle {

    //Child class variables
    private float batteryCapacity;

    //Default constructor
    public ElectricCar(){
        super();
        batteryCapacity = 0.0f;
    }

    //Constructor with parameters
    public ElectricCar(String newMake, String newModel, String newLicensePlate, int newYear, int newMiles, float newBatteryCapacity){
        super(newMake, newModel, newLicensePlate, newYear, newMiles);
        batteryCapacity = newBatteryCapacity;
    }

    //Getters for private variables
    public float getBatteryCapacity(){
        return batteryCapacity;
    }

    //Methods
    @Override
    public float getFuelEfficiency(int new_miles){
        miles = miles + new_miles;
        if(batteryCapacity == 0){
            System.out.println("0-Parameter fuel efficiency: " + 0.0f);
            return 0.0f;
        }
        else {
            float mpge = new_miles * 2 / batteryCapacity;
            System.out.println(make + " " + model + " fuel efficiency: " + mpge + " mpge");
            return mpge;
        }
    }
}
