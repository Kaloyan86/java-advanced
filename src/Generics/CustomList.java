package Generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {

    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    // void add(T element)
    public void add(T element) {
        this.data.add(element);
    }

    // T remove(int index)
    public T remove(int index) {
        checkIndex(index);
        return this.data.remove(index);
    }

    // boolean contains(T element)
    public boolean contains(T element) {
        return this.data.contains(element);
    }

    // void swap(int index, int index)
    public void swap(int firstIndex, int secondIndex) {
        checkIndex(firstIndex);
        checkIndex(secondIndex);

        T firstElement = this.data.get(firstIndex);
        T secondElement = this.data.get(secondIndex);

        this.data.set(firstIndex, secondElement);
        this.data.set(secondIndex, firstElement);
    }

    // int countGreaterThan(T element)
    public int countGreaterThan(T element) {
        int count = 0;

        for (T el : this.data) {
            if (el.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    // T getMax()
    public T getMax() {
        checkEmpty();

        T max = this.data.get(0);
        for (T el : this.data) {
            if (el.compareTo(max) > 0) {
                max = el;
            }
        }
        // return Collections.max(this.data);
        return max;
    }

    // T getMin()
    public T getMin() {
        checkEmpty();

        //        T min = this.data.get(0);
        //        for (T el : this.data) {
        //            if (el.compareTo(min) < 0) {
        //                min = el;
        //            }
        //        }

        return Collections.min(this.data);
    }

    public int getSize() {
        return this.data.size();
    }

    public T get(int index) {
        checkIndex(index);
        return this.data.get(index);
    }

    private void checkEmpty() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
    }

    private void checkIndex(int index) {
        if ((index < 0 || index >= this.data.size())) {
            throw new IndexOutOfBoundsException(
            String.format("Index %d is out of bounds for size %d.", index, this.data.size()));
        }
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < data.size();
            }

            @Override
            public T next() {
                return data.get(index++);
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        // this comes from Parent class Iterable
        Iterable.super.forEach(action);

        // our custom implementation
        // this.data.forEach(action);
    }
}
