package org.umaxcode.exceptionHandling.exercise3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReadingExceptionDemo {

    static String readFile(String filePath) {

        StringBuilder fileContent = new StringBuilder();
        Scanner scanner = null;
        try {
            File file = new File(filePath);
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine() + "\n";
                fileContent.append(text);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while processing file: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return fileContent.toString();
    }

    public static void main(String[] args) {

        final String FILE_PATH = "src/main/java/org/umaxcode/exceptionHandling/exercise3/filename.txt";

        System.out.println(readFile(FILE_PATH));
    }
}
