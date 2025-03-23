import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteAFile {
    public static void main(String[] args) {
        String writtenFile = "WriteAFileExample.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writtenFile))) {
            writer.write("Hello, World!");
            writer.newLine();
            writer.write("This is a test.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}