package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P5LineNumbers {

    public static void main(String[] args) {

        String inputPath = "C:\\Users\\Kaloyan\\Desktop\\java-advanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath = "C:\\Users\\Kaloyan\\Desktop\\java-advanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (
        BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
        BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))
        ) {

            String line = reader.readLine();
            int count = 1;
            while (line != null) {

                writer.write(String.format("%d. %s\n", count, line));

               // writer.write(count + ". " + line);
              //  writer.newLine();

                count++;
                line = reader.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
