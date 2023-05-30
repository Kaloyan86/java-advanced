package Workshop;


public class Demo {

    public static void main(String[] args) {

        CustomStack customStack = new CustomStack();

        customStack.push(5);
        customStack.push(6);
        customStack.push(7);
        customStack.push(8);

        customStack.forEach(System.out::println);
    }
}








