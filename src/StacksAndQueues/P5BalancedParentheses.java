package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P5BalancedParentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split(""))
                                   .collect(Collectors.toList());

        String result = isBalanced(input) ? "YES" : "NO";

        System.out.println(result);
    }


    private static boolean isBalanced(List<String> input) {
        if (input.size() % 2 != 0) {
            return false;
        }
        //       (({[(
        ArrayDeque<String> openParentheses = new ArrayDeque<>();
        for (String brace : input) {
            switch (brace) {
                case "}":
                    String openBrace = openParentheses.pop();
                    if (!openBrace.equals("{")) {
                        return false;
                    }
                    break;
                case "]":
                    openBrace = openParentheses.pop();
                    if (!openBrace.equals("[")) {
                        return false;
                    }
                    break;
                case ")":
                    openBrace = openParentheses.pop();
                    if (!openBrace.equals("(")) {
                        return false;
                    }
                    break;
                default:
                    openParentheses.push(brace);
                    break;
            }
        }

        return openParentheses.isEmpty();
    }
}
