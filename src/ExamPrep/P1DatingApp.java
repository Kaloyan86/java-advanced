package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1DatingApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Male -> Stack
        Deque<Integer> maleStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
              .map(Integer::parseInt)
              .forEach(maleStack::push);

        // Female -> Queue
        Deque<Integer> femaleQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
              .map(Integer::parseInt)
              .forEach(femaleQueue::offer);

        int matches = 0;

        while (!maleStack.isEmpty() && !femaleQueue.isEmpty()) {
            int male = maleStack.peek();
            int female = femaleQueue.peek();
            // • If someone’s value is equal to or below 0,
            // you should remove him/her from the records before trying to match him/her with anybody.
            if (female <= 0) {
                femaleQueue.poll();
                continue;
            } else if (male <= 0) {
                maleStack.pop();
                continue;
            }

            // • Special case - if someone’s value divisible by 25 without remainder,
            // you should remove him/her and the next person of the same gender.
            if (female % 25 == 0) {
                femaleQueue.poll();
                femaleQueue.poll();
                continue;
            } else if (male % 25 == 0) {
                maleStack.pop();
                maleStack.pop();
                continue;
            }

            // • If their values are equal, you have to match them and remove both of them.
            if (male == female) {
                matches++;
                maleStack.pop();
                femaleQueue.poll();
            } else { // Otherwise you should remove only the female and decrease the value of the male by 2.
                femaleQueue.poll();
                int decreasedMale = maleStack.pop() - 2;
                maleStack.push(decreasedMale);
            }

        }
        System.out.printf("Matches: %d\n", matches);
        System.out.printf("Males left: %s\n", result(maleStack));
        System.out.printf("Females left: %s", result(femaleQueue));
    }

    private static String result(Deque<Integer> arrDeque) {

        String result = "none";

        if (!arrDeque.isEmpty()) {
            result = arrDeque.stream()
                             .map(String::valueOf)
                             .collect(Collectors.joining(", "));
        }

        return result;
    }
}
