package IteratorsAndComparators.StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> nameSet = new TreeSet<>(new NameComparator());
        Set<Person> ageSet = new TreeSet<>(new AgeComparator());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            nameSet.add(person);
            ageSet.add(person);
        }
        nameSet.forEach(System.out::println);
        System.out.println();
        ageSet.forEach(System.out::println);
    }
}
