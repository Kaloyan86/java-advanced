package Workshop;

public class Demo {

    public static void main(String[] args) {


        DoublyLinkedList list = new DoublyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        int[] ints = list.toArray();

        System.out.println();

    }
}








