package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class P3CustomMinFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                                  .map(Integer::parseInt)
                                  .toArray(Integer[]::new);

        // Function<InputParam, ReturnType> -> use with apply

        //        Function<Integer[], Integer> findSmallestNumber = arr -> Arrays.stream(arr)
        //                                                                       .mapToInt(e -> e)
        //                                                                       .min()
        //                                                                       .getAsInt();

        //        Function<Integer[], Integer> findSmallestNumber = arr -> Arrays.stream(arr)
        //                                                                       .sorted()
        //                                                                       .toArray(Integer[]::new)[0];

        Function<Integer[], Integer> findSmallestNumber = arr -> Collections.min(List.of(arr));

        Integer smallestNumber = findSmallestNumber.apply(numbers);
        System.out.println(smallestNumber);
    }
}
