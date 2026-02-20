import java.io.*;

public class InventoryManager {

    private static final String FILE_NAME = "products.txt";

    public void addProduct(Product product) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(product.toString());
            bw.newLine();
            System.out.println("Product added successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public void displayProducts() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- Product List ---");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Product p = new Product(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        Double.parseDouble(data[3])
                );
                System.out.println(p.display());
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    public void searchProduct(int searchId) {
        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (Integer.parseInt(data[0]) == searchId) {
                    Product p = new Product(
                            Integer.parseInt(data[0]),
                            data[1],
                            Integer.parseInt(data[2]),
                            Double.parseDouble(data[3])
                    );
                    System.out.println("Product Found:");
                    System.out.println(p.display());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Product not found.");
            }
        } catch (IOException e) {
            System.out.println("Error searching product.");
        }
    }

    public void calculateTotalStockValue() {
        double total = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int qty = Integer.parseInt(data[2]);
                double price = Double.parseDouble(data[3]);
                total += qty * price;
            }
            System.out.println("Total Stock Value: ₹" + total);
        } catch (IOException e) {
            System.out.println("Error calculating stock value.");
        }
    }
}