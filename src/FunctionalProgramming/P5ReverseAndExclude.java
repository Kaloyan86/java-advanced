package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P5ReverseAndExclude {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());

        // Reverse List
        Collections.reverse(numbers);

        Predicate<Integer> checkIsDivisible = num -> num % n == 0;
        // Премахва всички елементи които удовлетворяват условието в предиката
        numbers.removeIf(checkIsDivisible);

//        List<Integer> toRemove = numbers.stream()
//                                        .filter(e -> checkIsDivisible.test(e))
//                                        .collect(Collectors.toList());

//        for (Integer num : toRemove) {
//            numbers.remove(num);
//        }

//        numbers.removeAll(toRemove);

        numbers.forEach(e -> System.out.print(e + " "));
    }
}
