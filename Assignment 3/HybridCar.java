/*
Part 2: Child Classes/Part 3: Polymorphism
For encapsulation purposes, I made the child class fields private and provide getter methods for them. I override the
vehicle abstract method for getFuelEfficiency with the appropriate calculation for this child class.
*/

public class HybridCar extends Vehicle {

    //Child class variables
    private float batteryCapacity;
    private float tankCapacity;
    private String fuelType;

    //Default constructor
    public HybridCar() {
        super();
        batteryCapacity = 0.0f;
        tankCapacity = 0.0f;
        fuelType = "unknown";
    }

    //Constructor with parameters
    public HybridCar(String newMake, String newModel, String newLicensePlate, int newYear, int newMiles, float newBatteryCapacity, float newTankCapacity, String newFuelType) {
        super(newMake, newModel, newLicensePlate, newYear, newMiles);
        batteryCapacity = newBatteryCapacity;
        tankCapacity = newTankCapacity;
        fuelType = newFuelType;
    }

    //Getters for private variables
    public float getTankCapacity(){
        return tankCapacity;
    }

    public String getFuelType(){
        return fuelType;
    }

    public float getBatteryCapacity(){
        return batteryCapacity;
    }

    //Methods
    @Override
    public float getFuelEfficiency(int new_miles){
        miles = miles + new_miles;
        if(tankCapacity == 0 || batteryCapacity == 0){
            System.out.println("0-Parameter fuel efficiency: " + 0.0f);
            return 0.0f;
        }
        else {
            float mpg = new_miles / tankCapacity;
            float mpge = new_miles * 2 / batteryCapacity;
            float totalMpg = (mpg + mpge) / 2;
            System.out.println(make + " " + model + " fuel efficiency: " + totalMpg + " total mpg");
            return totalMpg;
        }
    }
}
