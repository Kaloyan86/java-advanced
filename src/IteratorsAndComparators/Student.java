package IteratorsAndComparators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Student implements Comparable<Student>, Iterable<Integer> {

    private String name;
    private int age;
    List<Integer> grades;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        grades = new ArrayList<>();
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    @Override
    public int compareTo(Student s) {
        if (this.name.equals(s.name)) {
            if (this.age == s.age) {
                return 0;
            }
            return 1;
        }
        return 1;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<Integer> {

        int count = 0;

        @Override
        public boolean hasNext() {
            return count < grades.size();
        }

        @Override
        public Integer next() {
            return grades.get(count++);
        }
    }
}
