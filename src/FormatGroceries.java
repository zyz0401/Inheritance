import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FormatGroceries {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\yxian\\Downloads"; 
        String outputFile = "FormattedGroceries.txt";
        double total = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            writer.write("***********************************************************");
            writer.newLine();
            writer.write("ID Item Quantity(KG) Price(€)");
            writer.newLine();
            writer.write("********************************************************");
            writer.newLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String item = parts[1];
                double quantity = Double.parseDouble(parts[2]);
                double price = Double.parseDouble(parts[3]);

                total += quantity * price;

                writer.write(String.format("%d %s %.1f %.1f", id, item, quantity, price));
                writer.newLine();
            }

            writer.write("***********************************************************");
            writer.newLine();
            writer.write("The grocery shopping total is: €" + total);
            writer.newLine();
            writer.write("***********************************************************");

        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}