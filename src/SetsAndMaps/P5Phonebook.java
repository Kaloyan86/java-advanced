package SetsAndMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P5Phonebook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String[] tokens = input.split("-");

            String name = tokens[0];
            String number = tokens[1];

            phonebook.put(name, number);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("stop")) {

            if (phonebook.containsKey(input)) {
                String phoneNumber = phonebook.get(input);
                System.out.printf("%s -> %s\n", input, phoneNumber);
            } else {
                System.out.printf("Contact %s does not exist.\n", input);
            }

            input = scanner.nextLine();
        }

    }
}
