package DefiningClasses.P1_OpinionPoll;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> people = new TreeSet<>(Comparator.comparing(Person::getName));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

        people.stream().filter(p -> p.getAge() > 30)
              //.sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
              .forEach(System.out::println);
    }
}
