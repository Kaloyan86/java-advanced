package DefiningClasses.P3_SpeedRacing;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        // TODO Map<String, Car>
        List<Car> cars = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCost = Double.parseDouble(tokens[2]);

            Car car = new Car(name, fuelAmount, fuelCost);
            cars.add(car);
        }

        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");

            String carModel = tokens[1];
            int amountOfKm = Integer.parseInt(tokens[2]);

            Car car = cars.stream().filter(c -> c.getModel().equals(carModel))
                          .findFirst()
                          .orElse(null);

            if (car.isFuelSufficient(amountOfKm)) {
                car.reduceFuel(amountOfKm);
                car.setTraveledDistance(car.getTraveledDistance() + amountOfKm);
               // car.increaseKm(amountOfKm);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }

            line = scanner.nextLine();
        }
        cars.forEach(System.out::println);
    }
}
