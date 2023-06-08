package IteratorsAndComparators.ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        ListyIterator<String> listyIterator = new ListyIterator<>();

        while (!line.equals("END")) {
            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {

                case "Create":
                    if (tokens.length > 1) {
                        String[] elements = Arrays.copyOfRange(tokens, 1, tokens.length);
                        listyIterator = new ListyIterator<>(elements);
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    listyIterator.forEach(s -> System.out.print(s + " "));
                    System.out.println();
                    break;
            }

            line = scanner.nextLine();
        }


    }
}
