package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {

    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    // Method add(Car car)
    // – adds an entity to the data if there is an empty cell for the car.
    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    // Method remove(String manufacturer, String model) –
    // removes the car by given manufacturer and model,
    // if such exists, and returns boolean.
    public boolean remove(String manufacturer, String model) {
        return this.data.removeIf(car -> car.getManufacturer().equals(manufacturer)
                                         && car.getModel().equals(model));
    }

    // Method getLatestCar() – returns the latest car (by year) or null if have no cars.
    public Car getLatestCar() {
        return this.data.stream()
                        .max(Comparator.comparingInt(Car::getYear))
                        .orElse(null);
    }

    // Method getCar(String manufacturer, String model) – returns the car with the given
    // manufacturer and model or null if there is no such car.
    public Car getCar(String manufacturer, String model) {
        return this.data.stream()
                        .filter(car -> car.getManufacturer().equals(manufacturer) &&
                                       car.getModel().equals(model))
                        .findFirst()
                        .orElse(null);
    }

    // Getter getCount() – returns the number of cars.
    public int getCount() {
        return this.data.size();
    }

    // getStatistics() – returns a String in the following format:
    //o "The cars are parked in {parking type}: {Car1} {Car2} (…)"
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:", this.type));
        this.data.forEach(car -> {
            sb.append(System.lineSeparator());
            sb.append(car.toString());
        });

        return sb.toString();
    }

}
