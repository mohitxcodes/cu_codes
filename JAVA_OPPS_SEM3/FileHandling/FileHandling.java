package FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileHandling {

    public static void main(String[] args) {
        File file = new File("test.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully");
            } else {
                System.out.println("File already exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("Hello World");
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        file.delete();

    }

}
