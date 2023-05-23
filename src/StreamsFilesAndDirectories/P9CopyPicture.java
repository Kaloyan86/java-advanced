package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P9CopyPicture {

    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Kaloyan\\Desktop\\java-advanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\pic.jpg";
        String outputPath = "C:\\Users\\Kaloyan\\Desktop\\java-advanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\pic-copy.jpg";

        try (
        FileInputStream fis = new FileInputStream(inputPath);
        FileOutputStream fos = new FileOutputStream(outputPath);
        ) {
            Files.copy(Path.of(inputPath), fos);

//            int readByte = fis.read();
//            while (readByte != -1) {
//                fos.write(readByte);
//                readByte = fis.read();
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
