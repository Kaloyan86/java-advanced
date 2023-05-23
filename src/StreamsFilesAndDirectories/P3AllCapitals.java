package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P3AllCapitals {

    public static void main(String[] args) {

        String inputPath = "C:\\Users\\Kaloyan\\Desktop\\java-advanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\Kaloyan\\Desktop\\java-advanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
                     BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))
        //     BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath,true  ))

        ) {
            String line = reader.readLine();
            while (line != null) {

                writer.write(line.toUpperCase());
                writer.write(System.lineSeparator());

                line = reader.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
