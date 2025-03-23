import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DiaryWriter {
    public static void main(String[] args) {
        String diaryFile = "Diary.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(diaryFile));
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter content. Enter END to finish:");
            String input;
            while (!(input = scanner.nextLine()).equalsIgnoreCase("END")) {
                writer.write(input);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to the diary file: " + e.getMessage());
        }
    }
}