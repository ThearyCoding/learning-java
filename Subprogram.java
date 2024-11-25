import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import ConsoleTable.ct4j;

import java.text.NumberFormat;
import java.util.Locale;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Subprogram {
    private static final String FILENAME = "products.txt";
    private static Scanner input = new Scanner(System.in);

    public static int MenuInitialization() {
        System.out.println("1 >> Show all Products");
        System.out.println("2 >> Add More Products");
        System.out.println("3 >> Remove Products By ID");
        System.out.println("4 >> Edit Products By ID");
        System.out.println("5 >> Show Product By Type ");
        System.out.println("6 >> Exit The Program");

        int n;

        do {
            System.out.print("Select One Option = ");
            n = input.nextInt();
        } while (!(n >= 1 && n <= 6));

        return n;
    }

    public static List<Product> loadProductsFromFile() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                Product product = new Product();
                product.setId(Integer.parseInt(parts[0]));
                product.setName(parts[1]);
                product.setType(Product.ProductType.valueOf(parts[2]));
                product.setPrice(Double.parseDouble(parts[3]));
                product.setQuantity(Integer.parseInt(parts[4]));
                // Update the following line if amount is a method in Product class
                // product.amount();
                products.add(product);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());

        }
        return products;
    }

    public static void inputProduct(List<Product> products) {
        Scanner localInput = new Scanner(System.in);
        Product product = new Product();
        int newProductId = new Random().nextInt(101) + 100;

        product.setId(newProductId);
        System.out.print("Enter Name product = ");
        localInput.nextLine(); // Consume the newline character
        product.setName(localInput.nextLine());
        Product.ProductType type = null;

        while (true) {
            System.out.println("---------------- Product Type --------------------");
            System.out.println("1 = BEER");
            System.out.println("2 = Soft Drink");
            System.out.print("Enter new Product Type = ");
            int choice = localInput.nextInt();

            switch (choice) {
                case 1:
                    type = Product.ProductType.BEER;
                    break;
                case 2:
                    type = Product.ProductType.SOFTDRINK;
                    break;
                default:
                    System.out.println("Please choose a valid option.");
                    continue;
            }
            product.setType(type);
            System.out.println("Product type: " + type);
            break;
        }

        System.out.print("Enter Price product = ");
        product.setPrice(localInput.nextDouble());
        System.out.print("Enter Quantity product = ");
        product.setQuantity(localInput.nextInt());
        products.add(product);
        saveProductsToFile(products);
    }

    public static void ShowAllProducts(List<Product> products) {
        try {
            String[] header = { "ID", "Name", "Type", "Price", "Quantity", "Amount" };
            ct4j table = new ct4j();
            table.setHeader(header);
            double totalAmount = 0;

            for (Product product : products) {
                totalAmount += product.amount();
                table.addRow(
                        String.valueOf(product.getId()),
                        product.getName(),
                        String.valueOf(product.getType()),
                        NumberFormat.getCurrencyInstance(Locale.US).format(product.getPrice()),
                        String.valueOf(product.getQuantity()),
                        NumberFormat.getCurrencyInstance(Locale.US).format(product.amount()));
            }

            table.printTable();
            System.out.println("Total Amount: " + NumberFormat.getCurrencyInstance(Locale.US).format(totalAmount));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveProductsToFile(List<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Product product : products) {
                writer.write(String.format("%d,%s,%s,%.2f,%d,%.2f%n",
                        product.getId(), product.getName(), product.getType().name(), product.getPrice(),
                        product.getQuantity(), product.amount()));
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
