package parking;

public class Main {
    public static void main(String[] args) {
        // Initialize the repository
        Parking parking = new Parking("Underground parking garage", 5);
        // Initialize entity
        Car volvo = new Car("Volvo", "XC70", 2010);
        // Print Car
        System.out.println(volvo); // Volvo XC70 (2010)
        // Add Car
        parking.add(volvo);
        // Remove Car
        System.out.println(parking.remove("Volvo", "XC90")); // false
        System.out.println(parking.remove("Volvo", "XC70")); // true
        Car peugeot = new Car("Peugeot", "307", 2011);
        Car audi = new Car("Audi", "S4", 2005);
        parking.add(peugeot);
        parking.add(audi);
        // Get Latest Car
        Car latestCar = parking.getLatestCar();
        System.out.println(latestCar); // Peugeot 307 (2011)
        // Get Car
        Car audiS4 = parking.getCar("Audi", "S4");
        System.out.println(audiS4); // Audi S4 (2005)
        // Count
        System.out.println(parking.getCount()); // 2
        // Get Statistics
        System.out.println(parking.getStatistics());
        // The cars are parked in Underground parking garage:
        // Peugeot 307 (2011)
        // Audi S4 (2005)
    }
}
