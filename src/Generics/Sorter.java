package Generics;

public class Sorter {

    private Sorter() {
    }

    public static  <T extends Comparable<T>> void sort(CustomList<T> list) {

        for (int i = 0; i < list.getSize(); i++) {
            T currentElement = list.get(i);
            for (int j = i + 1; j < list.getSize(); j++) {
                if (currentElement.compareTo(list.get(j)) > 0) {
                    list.swap(i, j);
                }
            }
        }
    }
}
