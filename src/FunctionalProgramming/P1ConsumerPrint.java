package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P1ConsumerPrint {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Consumer<InputParam> -> void -> use with accept

        String[] strings = scanner.nextLine().split("\\s+");

        Consumer<String> print = word -> System.out.println(word);
        //
        //        for (String word : strings) {
        //            print.accept(word);
        //        }
        Arrays.stream(strings).forEach(print);

    }
}
