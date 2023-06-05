package Generics;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {

    private T data;

    public Box(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.data.getClass().getName(), this.data);
    }


    @Override
    public int compareTo(Box<T> o) {
        return this.data.compareTo(o.data);
    }
}
