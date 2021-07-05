/*
Part 1: Base Class/Part 3: Polymorphism
I made an abstract vehicle class because we are not creating any instances of the vehicle, but rather just instances of
the child classes. I also made the getFuelEfficiency an abstract method of the vehicle class to require in each of the
child classes.
*/

abstract class Vehicle {

    //Parent class variables
    protected String make;
    protected String model;
    protected String licensePlate;
    protected int year;
    protected int miles;

    //Default constructor
    public Vehicle(){
        make = "unknown";
        model = "unknown";
        licensePlate = "unknown";
        year = 0;
        miles = 0;
    }

    //Constructor with parameters
    public Vehicle(String newMake, String newModel, String newLicensePlate, int newYear, int newMiles){
        make = newMake;
        model = newModel;
        licensePlate = newLicensePlate;
        year = newYear;
        miles = newMiles;
    }

    //Required method for child classes
    abstract float getFuelEfficiency(int new_miles);
}
