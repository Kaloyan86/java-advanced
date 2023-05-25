package FunctionalProgramming;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P8CustomComparator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                                  .map(Integer::parseInt)
                                  .toArray(Integer[]::new);

        // Comparator -> function приема 2 елемента и връща цяло число(0, 1, -1)
        // ако първият елемент == вторият елемент -> 0
        // ако първият елемент > вторият елемент -> 1
        // ако първият елемент < вторият елемент -> -1

        // sorted(0) -> не разменя двата елемента
        // sorted(1) -> разменя двата елемента
        // sorted(-1) -> не разменя двата елемента

        // 1 2 3 4 5 6
        // 2 4 6 1 3 5

        Comparator<Integer> comparator = (first, second) -> {
            // първо четно и второто нечетно -> не разменяме
            if (first % 2 == 0 && second % 2 != 0) {
                return -1;
            }
            // първо нечетно и второ четно -> разменяме
            if (first % 2 != 0 && second % 2 == 0) {
                return 1;
            }

            // сравняваме от по-малко към по-голямо
            return first.compareTo(second);
        };
        Arrays.sort(numbers, comparator);
        Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));
    }
}
