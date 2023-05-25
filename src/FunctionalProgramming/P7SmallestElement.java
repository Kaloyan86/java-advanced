package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P7SmallestElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<List<Integer>, Integer> findSmallestNumber = list -> Collections.min(list);
        BiFunction<List<Integer>, Integer, Integer> getLastIndexOfMinNum = (list, minNum) -> list.lastIndexOf(minNum);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());

        //  0 1 2 3 4 5 6 7 -> indexes
        //  1 2 3 0 4 5 6 0

        int smallestNumber = findSmallestNumber.apply(numbers);

        int lastIndex = getLastIndexOfMinNum.apply(numbers, smallestNumber);

        System.out.println(lastIndex);


    }
}
