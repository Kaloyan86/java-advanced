package ExamPrep;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1EnergyDrink22Oct2022 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> caffeine = new ArrayDeque<>(); // Stack
        Deque<Integer> drinks = new ArrayDeque<>();  // Queue

        Arrays.stream(scanner.nextLine().split(", "))
              .forEach(e -> caffeine.push(Integer.parseInt(e)));

        Arrays.stream(scanner.nextLine().split(", "))
              .forEach(e -> drinks.offer(Integer.parseInt(e)));

        int stamatsCaffeine = 0;

        while (!caffeine.isEmpty() && !drinks.isEmpty()) {

            int currentDrink = drinks.poll();
            int currentCaffeine = caffeine.pop();

            int currentCaffValue = currentCaffeine * currentDrink;

            if (stamatsCaffeine + currentCaffValue <= 300) {
                stamatsCaffeine += currentCaffValue;
            } else {

                drinks.offer(currentDrink);
                stamatsCaffeine -= 30;
                if (stamatsCaffeine < 0) {
                    stamatsCaffeine = 0;
                }
            }
        }
        if (drinks.isEmpty()){
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }else {
            System.out.print("Drinks left: ");
//            String result = drinks.toString().replaceAll("[\\[\\]]", "");
            String result = drinks.stream()
                                   .map(String::valueOf)
                                   .collect(Collectors.joining(", "));
            System.out.println(result);
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", stamatsCaffeine);

    }
}
