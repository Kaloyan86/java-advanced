package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1FoodFinder19Feb2022 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> vowels = new ArrayDeque<>(); // Queue
        Deque<String> consonants = new ArrayDeque<>(); // Stack

        Arrays.stream(scanner.nextLine().split("\\s+"))
              .forEach(vowels::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
              .forEach(consonants::push);

        List<String> words = List.of("pear", "flour", "pork", "olive");
        List<String> foundWords = new java.util.ArrayList<>(List.of("____", "_____", "____", "_____"));

        while (!consonants.isEmpty()) {
            String vowel = vowels.poll();
            String consonant = consonants.pop();

            for (int i = 0; i < words.size(); i++) {
                String currentWord = words.get(i);
                String emptyWord = foundWords.get(i);
                if (currentWord.contains(vowel)) {
                    int vowelIndex = currentWord.indexOf(vowel);
                    String newWord = emptyWord.substring(0, vowelIndex)
                                     + currentWord.charAt(vowelIndex) + emptyWord.substring(vowelIndex + 1);
                    foundWords.set(i, newWord);
                }
                if (currentWord.contains(consonant)) {
                    int consonantIndex = currentWord.indexOf(consonant);
                    emptyWord = foundWords.get(i);
                    String newWord = emptyWord.substring(0, consonantIndex)
                                     + currentWord.charAt(consonantIndex) + emptyWord.substring(consonantIndex + 1);
                    foundWords.set(i, newWord);
                }
            }
            vowels.offer(vowel);
        }

        List<String> result = foundWords.stream()
                                        .filter(word -> !word.contains("_"))
                                        .collect(Collectors.toList());
        System.out.printf("Words found: %d\n", result.size());
        result.forEach(System.out::println);
    }
}
