package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P6WordCount {

    public static void main(String[] args) {
        String path1 = "C:\\Users\\Kaloyan\\Desktop\\java-advanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String path2 = "C:\\Users\\Kaloyan\\Desktop\\java-advanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String output = "C:\\Users\\Kaloyan\\Desktop\\java-advanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt";

        Map<String, Integer> words = new HashMap<>();
        try (
        BufferedReader reader1 = Files.newBufferedReader(Path.of(path1));
        BufferedReader reader2 = Files.newBufferedReader(Path.of(path2));
        BufferedWriter writer = Files.newBufferedWriter(Path.of(output))
        ) {

            String line = reader1.readLine();
            while (line != null) {
                String[] input = line.split("\\s+");
                for (String word : input) {
                    words.put(word, 0);
                }

                line = reader1.readLine();
            }

            line = reader2.readLine();
            while (line != null) {
                List<String> text = Arrays.stream(line.split("\\s+"))
                                          .collect(Collectors.toList());

                words.forEach((k, v) -> {
                    int count = 0;
                    for (String word : text) {
                        if (word.equals(k)) {
                            count++;
                        }
                    }
                    words.put(k, words.get(k) + count);
                });
                line = reader2.readLine();
            }

            words.entrySet()
                 .stream()
                 .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                 .forEach(entry -> {
                     try {
                         writer.write(String.format("%s - %d\n", entry.getKey(), entry.getValue()));
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
