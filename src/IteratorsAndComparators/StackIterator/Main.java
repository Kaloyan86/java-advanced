package IteratorsAndComparators.StackIterator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        StackIterator stack = new StackIterator();
        while (!line.equals("END")) {
            String[] tokens = line.split("[\\s,]+");

            switch (tokens[0]) {

                case "Push":
                    for (int i = 1; i < tokens.length; i++) {
                        stack.push(Integer.parseInt(tokens[i]));
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            line = scanner.nextLine();
        }
        stack.forEach(System.out::println);
        stack.forEach(System.out::println);

    }
}
