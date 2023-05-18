package SetsAndMaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        Sets keep unique elements
        HashSet<E> -> Does not guarantee the constant order of elements over time
        TreeSet<E> -> The elements are ordered incrementally
        LinkedHashSet<E> -> The order of appearance is preserved

        Maps hold a set of <key, value> pairs,
        Keys are unique
        HashMap<K, V> -> Does not guarantee the constant order of elements over time
        TreeMap<K, V> -> The elements are ordered incrementally by the key
        LinkedHashMap<K, V> -> The order of appearance is preserved

        Equals and HashCode contract
        Collisions in HashMap and HashSet
        */

        // Student-> id, name
//        Map<Integer, String> studentsMap = new HashMap<>();
//        studentsMap.put(5, "Kaloyan");
//        studentsMap.put(1, "Peter");
//        studentsMap.put(9, "Ivan");
//        studentsMap.put(9, "Martin");
//
//        studentsMap.forEach((key, value) -> System.out.printf("ID: %d NAME: %s\n", key, value));

        Set<String> names = new HashSet<>();
        names.add("Kaloyan");
        names.add("Peter");
        names.add("Martin");
        names.add("Kaloyan");

        names.forEach(System.out::println);
    }
}
