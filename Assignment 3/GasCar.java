/*
Part 2: Child Classes/Part 3: Polymorphism
For encapsulation purposes, I made the child class fields private and provide getter methods for them. I override the
vehicle abstract method for getFuelEfficiency with the appropriate calculation for this child class.
*/

public class GasCar extends Vehicle {

    //Child class variables
    private float tankCapacity;
    private String fuelType;

    //Getters for private variables
    public float getTankCapacity(){
        return tankCapacity;
    }

    public String getFuelType(){
        return fuelType;
    }

    //Default constructor
    public GasCar(){
        super();
        tankCapacity = 0.0f;
        fuelType = "unknown";
    }

    //Constructor with parameters
    public GasCar(String newMake, String newModel, String newLicensePlate, int newYear, int newMiles, float newTankCapacity, String newFuelType){
        super(newMake, newModel, newLicensePlate, newYear, newMiles);
        tankCapacity = newTankCapacity;
        fuelType = newFuelType;
    }

    //Methods
    @Override
    public float getFuelEfficiency(int new_miles){
        miles = miles + new_miles;
        if(tankCapacity == 0){
            System.out.println("0-Parameter fuel efficiency: " + 0.0f);
            return 0.0f;
        }
        else {
            float mpg = new_miles / tankCapacity;
            System.out.println(make + " " + model + " fuel efficiency: " + mpg + " mpg");
            return mpg;
        }
    }
}
