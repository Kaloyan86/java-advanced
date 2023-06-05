package Generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        CustomList<String> customList = new CustomList<>();

        for (String s : customList) {

        }



        while (!input.equals("END")) {

            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {

                case "Add":
                    customList.add(tokens[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(tokens[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    int countGreaterThan = customList.countGreaterThan(tokens[1]);
                    System.out.println(countGreaterThan);
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
                case "Print":
//                    customList.forEach(System.out::println);

                    for (String s : customList) {
                        System.out.println(s);
                    }
                    break;
            }


            input = scanner.nextLine();
        }
    }

    private static <T extends Comparable<T>> int countGreaterResults(List<T> data, T element) {
        int count = 0;

        for (T el : data) {
            int res = el.compareTo(element);
            if (res > 0) {
                count++;
            }
        }

        return count;
    }

    private static <T> void swap(List<T> data, int firstIndex, int secondIndex) {
        T firstElement = data.get(firstIndex);
        T secondElement = data.get(secondIndex);

        data.set(firstIndex, secondElement);
        data.set(secondIndex, firstElement);
    }
}
