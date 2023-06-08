package IteratorsAndComparators.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        List<Person> personList = new ArrayList<>();
        while (!line.equals("END")) {
            String[] tokens = line.split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            personList.add(person);
            line = scanner.nextLine();
        }
        int n = Integer.parseInt(scanner.nextLine());

        Person personToCompare = personList.get(n - 1);
        personList.remove(personToCompare);
        int equals = 0;
        int diff = 0;

        for (Person person : personList) {
            int res = personToCompare.compareTo(person);
            if (res == 0) {
                equals++;
            } else {
                diff++;
            }
        }

        if (equals == 0) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", equals + 1, diff, personList.size() + 1);
        }

    }
}
