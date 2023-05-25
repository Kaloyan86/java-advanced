package FunctionalProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class P11ThePartyReservationFilterModule {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                                    .collect(Collectors.toList());

        Map<String, Predicate<String>> predicates = new HashMap<>();

        String line = scanner.nextLine();

        while (!line.equals("Print")) {

            // "{command;filter type;filter parameter}
            String[] tokens = line.split(";");
           // Add filter; Starts with;    P
            String name = tokens[1] + tokens[2];

            if (line.contains("Add")) {
                Predicate<String> predicate;
                switch (tokens[1]) {
                    case "Starts with":
                        predicate = s -> s.startsWith(tokens[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                    case "Ends with":
                        predicate = s -> s.endsWith(tokens[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                    case "Length":
                        predicate = s -> s.length() == Integer.parseInt(tokens[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                    case "Contains":
                        predicate = s -> s.contains(tokens[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                }

            } else { // Remove predicate
                predicates.remove(name);
            }

            line = scanner.nextLine();
        }

        for (String guest : guests) {
            boolean isGoing = true;
            for (String key : predicates.keySet()) {
                if (predicates.get(key).test(guest)) {
                    isGoing = false;
                    break;
                }
            }

            if (isGoing) {
                System.out.print(guest + " ");
            }
        }
    }
}
