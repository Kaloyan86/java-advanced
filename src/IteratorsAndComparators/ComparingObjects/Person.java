package IteratorsAndComparators.ComparingObjects;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }


    @Override
    public int compareTo(Person person) {
        if (this.name.equals(person.name)) {
            if (this.age == person.age) {
                if (this.town.equals(person.town)) {
                    return 0;
                }
                return 1;
            }
            return 1;
        }
        return 1;
    }
}
