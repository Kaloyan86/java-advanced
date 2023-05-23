package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P2SumBytes {

    public static void main(String[] args) {
        String path = "C:\\Users\\Kaloyan\\Desktop\\java-advanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(path));
             BufferedReader reader1 = new BufferedReader(new FileReader(path))
        ) {
            int read = reader1.read();
            long sum = 0;
            while (read != -1) {
                sum += read;
                if (read == 10 || read == 13) {
                    System.out.println(read);
                }
                read = reader1.read();
            }
            System.out.println(sum);

//            String line = reader.readLine();
//            long sum1 = 0;
//            while (line != null) {
//                char[] chars = line.toCharArray();
//                for (char c : chars) {
//                    sum1 += c;
//                }
//                line = reader.readLine();
//            }
//            System.out.println(sum1);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
