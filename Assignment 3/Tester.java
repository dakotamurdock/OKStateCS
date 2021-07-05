/*
Part 4: Tester class
I first create instances of each child class with both the 0-parameter constructor and the constructor with parameters.
I then broke up testing into sections of each child class. I test that the parent class fields were assigned appropriately
and then the specific child class fields are also assigned with appropriate values. Finally I test that the getFuelEfficiency
method both calculates mpg/mpge as expected and that the miles field is updated with new_miles.
*/

public class Tester {
    public static void main(String[] args) {

        //Creating object instances with and without parameters & calculating fuel efficiencies
        GasCar genericGas = new GasCar();
        GasCar mustang = new GasCar("Ford", "Mustang", "PNYBOY", 2020, 14532, 15.5f, "gas");
        ElectricCar genericElectric = new ElectricCar();
        ElectricCar modelS = new ElectricCar("Tesla", "Model S", "GOGRN1", 2020, 1440, 75.0f);
        HybridCar genericHybrid = new HybridCar();
        HybridCar prius = new HybridCar("Toyota", "Prius", "GRNOLA", 2020, 25421, 4.4f, 10.6f, "gas");

        //Begin Testing
        System.out.println("VEHICLE INHERITANCE & POLYMORPHISM PROGRAM TEST RESULTS:");
        System.out.println("");
        System.out.println("Testing beginning...");

        //Test GasCar parent class info
        System.out.println("GasCar parent class tests beginning...");
        if (!((genericGas.make).equals("unknown"))) {
            System.out.println("0-parameter constructor make: FAIL");
        }
        if (!((mustang.make).equals("Ford"))) {
            System.out.println("Parameter constructor make: FAIL");
        }
        if (!((genericGas.model).equals("unknown"))) {
            System.out.println("0-parameter constructor model: FAIL");
        }
        if (!((mustang.model).equals("Mustang"))) {
            System.out.println("Parameter constructor model: FAIL");
        }
        if (!(genericGas.year == 0)) {
            System.out.println("0-parameter constructor year: FAIL");
        }
        if (!(mustang.year == 2020)) {
            System.out.println("Parameter constructor year: FAIL");
        }
        if (!((genericGas.licensePlate).equals("unknown"))) {
            System.out.println("0-parameter constructor license plate: FAIL");
        }
        if (!((mustang.licensePlate).equals("PNYBOY"))) {
            System.out.println("Parameter constructor license plate: FAIL");
        }
        if (!(genericGas.miles == 0)) {
            System.out.println("0-parameter constructor miles: FAIL");
        }
        if (!(mustang.miles == 14532)) {
            System.out.println("Parameter constructor miles: FAIL");
        }
        System.out.println("GasCar parent class tests complete...");

        //Test GasCar child class info
        System.out.println("GasCar child class tests beginning...");
        if (!(genericGas.getTankCapacity() == 0)) {
            System.out.println("0-parameter constructor tank capacity: FAIL");
        }
        if (!(mustang.getTankCapacity() == 15.5f)) {
            System.out.println("Parameter constructor tank capacity: FAIL");
        }
        if (!((genericGas.getFuelType()).equals("unknown"))) {
            System.out.println("0-parameter constructor fuel type: FAIL");
        }
        if (!((mustang.getFuelType()).equals("gas"))) {
            System.out.println("Parameter constructor fuel type: FAIL");
        }
        System.out.println("GasCar child class tests complete...");

        //Test GasCar methods
        System.out.println("GasCar method tests beginning...");
        if (!(genericGas.getFuelEfficiency(450) == 0.0f)) {
            System.out.println("0-parameter constructor get fuel efficiency method: FAIL");
        }
        if (!(mustang.getFuelEfficiency(450) == 29.032259f)) {
            System.out.println("Parameter constructor get fuel efficiency method: FAIL");
        }
        if (!(genericGas.miles == 450)) {
            System.out.println("0-parameter constructor method updated miles: FAIL");
        }
        if (!(mustang.miles == (14532 + 450))) {
            System.out.println("Parameter constructor method updated miles: FAIL");
        }
        System.out.println("GasCar method tests complete...");
        System.out.println("");

        //Test ElectricCar parent class info
        System.out.println("ElectricCar parent class tests beginning...");
        if (!((genericElectric.make).equals("unknown"))) {
            System.out.println("0-parameter constructor make: FAIL");
        }
        if (!((modelS.make).equals("Tesla"))) {
            System.out.println("Parameter constructor make: FAIL");
        }
        if (!((genericElectric.model).equals("unknown"))) {
            System.out.println("0-parameter constructor model: FAIL");
        }
        if (!((modelS.model).equals("Model S"))) {
            System.out.println("Parameter constructor model: FAIL");
        }
        if (!(genericElectric.year == 0)) {
            System.out.println("0-parameter constructor year: FAIL");
        }
        if (!(modelS.year == 2020)) {
            System.out.println("Parameter constructor year: FAIL");
        }
        if (!((genericElectric.licensePlate).equals("unknown"))) {
            System.out.println("0-parameter constructor license plate: FAIL");
        }
        if (!((modelS.licensePlate).equals("GOGRN1"))) {
            System.out.println("Parameter constructor license plate: FAIL");
        }
        if (!(genericElectric.miles == 0)) {
            System.out.println("0-parameter constructor miles: FAIL");
        }
        if (!(modelS.miles == 1440)) {
            System.out.println("Parameter constructor miles: FAIL");
        }
        System.out.println("ElectricCar parent class tests complete...");

        //Test ElectricCar child class info
        System.out.println("ElectricCar child class tests beginning...");
        if (!(genericElectric.getBatteryCapacity() == 0)) {
            System.out.println("0-parameter constructor battery capacity: FAIL");
        }
        if (!(modelS.getBatteryCapacity() == 75.0f)) {
            System.out.println("Parameter constructor battery capacity: FAIL");
        }
        System.out.println("ElectricCar child class tests complete...");

        //Test ElectricCar methods
        System.out.println("ElectricCar method tests beginning...");
        if (!(genericElectric.getFuelEfficiency(400) == 0.0f)) {
            System.out.println("0-parameter constructor get fuel efficiency method: FAIL");
        }
        if (!(modelS.getFuelEfficiency(400) == 10.666667f)) {
            System.out.println("Parameter constructor get fuel efficiency method: FAIL");
        }
        if (!(genericElectric.miles == 400)) {
            System.out.println("0-parameter constructor method updated miles: FAIL");
        }
        if (!(modelS.miles == (1440 + 400))) {
            System.out.println("Parameter constructor method updated miles: FAIL");
        }
        System.out.println("ElectricCar method tests complete...");
        System.out.println("");

        //Test HybridCar parent class info
        System.out.println("HybridCar parent class tests beginning...");
        if (!((genericHybrid.make).equals("unknown"))) {
            System.out.println("0-parameter constructor make: FAIL");
        }
        if (!((prius.make).equals("Toyota"))) {
            System.out.println("Parameter constructor make: FAIL");
        }
        if (!((genericHybrid.model).equals("unknown"))) {
            System.out.println("0-parameter constructor model: FAIL");
        }
        if (!((prius.model).equals("Prius"))) {
            System.out.println("Parameter constructor model: FAIL");
        }
        if (!(genericHybrid.year == 0)) {
            System.out.println("0-parameter constructor year: FAIL");
        }
        if (!(prius.year == 2020)) {
            System.out.println("Parameter constructor year: FAIL");
        }
        if (!((genericHybrid.licensePlate).equals("unknown"))) {
            System.out.println("0-parameter constructor license plate: FAIL");
        }
        if (!((prius.licensePlate).equals("GRNOLA"))) {
            System.out.println("Parameter constructor license plate: FAIL");
        }
        if (!(genericHybrid.miles == 0)) {
            System.out.println("0-parameter constructor miles: FAIL");
        }
        if (!(prius.miles == 25421)) {
            System.out.println("Parameter constructor miles: FAIL");
        }
        System.out.println("HybridCar parent class tests complete...");

        //Test HybridCar child class info
        System.out.println("HybridCar child class tests beginning...");
        if (!(genericHybrid.getBatteryCapacity() == 0)) {
            System.out.println("0-parameter constructor battery capacity: FAIL");
        }
        if (!(prius.getBatteryCapacity() == 4.4f)) {
            System.out.println("Parameter constructor battery capacity: FAIL");
        }
        if (!(genericHybrid.getTankCapacity() == 0)) {
            System.out.println("0-parameter constructor tank capacity: FAIL");
        }
        if (!(prius.getTankCapacity() == 10.6f)) {
            System.out.println("Parameter constructor tank capacity: FAIL");
        }
        if (!((genericHybrid.getFuelType()).equals("unknown"))) {
            System.out.println("0-parameter constructor fuel type: FAIL");
        }
        if (!((prius.getFuelType()).equals("gas"))) {
            System.out.println("Parameter constructor fuel type: FAIL");
        }
        System.out.println("HybridCar child class tests complete...");

        //Test HybridCar methods
        System.out.println("HybridCar method tests beginning...");
        if (!(genericHybrid.getFuelEfficiency(600) == 0.0f)) {
            System.out.println("0-parameter constructor get fuel efficiency method: FAIL");
        }
        if (!(prius.getFuelEfficiency(600) == 164.66551f)) {
            System.out.println("Parameter constructor get fuel efficiency method: FAIL");
        }
        if (!(genericHybrid.miles == 600)) {
            System.out.println("0-parameter constructor method updated miles: FAIL");
        }
        if (!(prius.miles == (25421 + 600))) {
            System.out.println("Parameter constructor method updated miles: FAIL");
        }
        System.out.println("HybridCar method tests complete...");
        System.out.println("");
        System.out.println("Tests complete.");
    }
}