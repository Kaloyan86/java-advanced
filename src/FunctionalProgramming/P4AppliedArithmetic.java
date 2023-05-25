package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P4AppliedArithmetic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());

        //  "add" -> adds 1; "multiply" -> multiplies by 2; "subtract" -> subtracts 1; "print"
        // Consumer<InputParam> -> void -> use with accept
        // Function<InputParam, ReturnType> -> use with apply
        Function<List<Integer>, List<Integer>> addOne = list -> list.stream().map(num -> num + 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiplyByTwo = list -> list.stream().map(num -> num * 2).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtractOne = list -> list.stream().map(num -> num - 1).collect(Collectors.toList());
        Consumer<List<Integer>> print = list -> list.forEach(num -> System.out.print(num + " "));

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            switch (command) {
                case "add":
                    numbers = addOne.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyByTwo.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractOne.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
