package StreamsFilesAndDirectories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class P12CreateZipArchive {

    public static void main(String[] args) throws IOException {
        String path1 = "C:\\Users\\Kaloyan\\Desktop\\java-advanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String path2 = "C:\\Users\\Kaloyan\\Desktop\\java-advanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String path3 = "C:\\Users\\Kaloyan\\Desktop\\java-advanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String outputPath = "C:\\Users\\Kaloyan\\Desktop\\java-advanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\files.zip";

        List<String> paths = List.of(path1, path2, path3);

        FileOutputStream fos = new FileOutputStream(outputPath);

        ZipOutputStream zos = new ZipOutputStream(fos);
        for (String path : paths) {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zos.putNextEntry(zipEntry);

            int read = fis.read();
            while (read != -1) {
                zos.write(read);
                read = fis.read();
            }
            fis.close();
        }
        zos.close();
        fos.close();
    }
}
