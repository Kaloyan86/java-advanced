package FunctionalProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class Demo {

    static int students = 50;
    static String course = "Java Advanced";

    public static void main(String[] args) {

        //Function<InputParam, ReturnType> -> use with apply
        //Consumer<InputParam> -> void -> use with accept
        //Supplier<ReturnType> -> use with get
        //Predicate<InputParam> -> return true / false -> use with test
        //BiFunction<InputParam1, InputParam2, ReturnType> -> use with apply

        Scanner scanner = new Scanner(System.in);

        //Function<InputParam, ReturnType> -> use with apply

        Function<Integer, Integer> multiply = e -> e * e;

        int result = multiply.apply(5);

        //Consumer<InputParam> -> void -> use with accept
        Consumer<String> printWord = word -> System.out.println(word);
        //        printWord.accept("Hello World!");

        //Supplier<ReturnType> -> use with get
        Supplier<Map<String, Integer>> getCourse = () -> {
            Map<String, Integer> courseMap = new HashMap<>();
            courseMap.put(course, students);
            return courseMap;
        };
        Map<String, Integer> map = getCourse.get();

        //Predicate<InputParam> -> return true / false -> use with test
        Predicate<Integer> checkIsEven = number -> number % 2 == 0;
        boolean isEvenNumber = checkIsEven.test(5);
        System.out.println(isEvenNumber);

        //BiFunction<InputParam1, InputParam2, ReturnType> -> use with apply
        BiFunction<Integer, Integer, String> multiplyTwoNumbers = (num1, num2) -> String.valueOf(num1 * num2);

        String result2 = multiplyTwoNumbers.apply(6, 6);

    }

    private static int a(int x) {
        return x * x;
    }

    private static int b(int num1, int num2) {
        return num1 * num2;
    }

    private static void print(String word) {
        System.out.println(word);
    }

    private static Map<String, Integer> getCourse() {
        Map<String, Integer> courseMap = new HashMap<>();
        courseMap.put(course, students);
        return courseMap;
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
