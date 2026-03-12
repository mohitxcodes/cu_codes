// Write a Java program that performs the following operations:

// Take student name, roll number, and marks from the user using Scanner.

// Store the details in a file named student.txt.

// Read and display the file contents.
// rxk

package FileHandling;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class StudentData {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            File file = new File("student.txt");

            if (!file.exists()) {
                System.out.println("File already exists");

                FileWriter fileWriter = new FileWriter(file);

                System.out.println("Enter student name: ");
                String name = sc.nextLine();
                System.out.println("Enter student roll number: ");
                int rollNo = sc.nextInt();
                System.out.println("Enter student marks: ");
                int marks = sc.nextInt();

                fileWriter.write("Name: " + name + "\n");
                fileWriter.write("Roll Number: " + rollNo + "\n");
                fileWriter.write("Marks: " + marks + "\n");

                fileWriter.close();
            }
            if (file.createNewFile()) {
                System.out.println("File created successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileReader fr = new FileReader("student.txt");
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
