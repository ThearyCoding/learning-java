import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import ConsoleTable.ct4j;

public class mainProduct {

    private static final String FILENAME = "products.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Product> products = loadProductsFromFile();

        while (true) {
            int choice = showMenu();
            switch (choice) {
                case 1:
                    showAllProducts(products);
                    break;
                case 2:
                    addProduct(products);
                    break;
                case 3:
                    saveProductsToFile(products);
                    System.out.println("Products saved to file.");
                    break;
                case 4:
                    showProductByType(products);

                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private static int showMenu() {
        System.out.println("1. Show all Products");
        System.out.println("2. Add Product");
        System.out.println("3. Save Products to File");
        System.out.println("4. Show Product By category");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private static void showAllProducts(List<Product> products) {
        var talbe = new ct4j();
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            try {
                String[] header = { "ID", "Name", "Type", "Price", "Quantity", "Amount" };
                ct4j table = new ct4j();
                table.setHeader(header);
                double totalAmount = 0;

                for (Product product : products) {
                    totalAmount += product.getAmount();
                    table.addRow(
                            String.valueOf(product.getId()),
                            product.getName(),
                            String.valueOf(product.getType()),
                            NumberFormat.getCurrencyInstance(Locale.US).format(product.getPrice()),
                            String.valueOf(product.getQuantity()),
                            NumberFormat.getCurrencyInstance(Locale.US).format(product.amount));
                }
                table.printTable();
                System.out.println("Total Amount: " + NumberFormat.getCurrencyInstance(Locale.US).format(totalAmount));

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void showProductByType(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("no product available");
        } else {
            try {
                System.out.println("1 = BEER ");
                System.out.println("2 = Soft drinks");
                System.out.println("Please select (1.Beer, 2.Soft drinks) = ");

                int choice = scanner.nextInt();
                var talbe = new ct4j();
                String[] header = { "ID", "Name", "Type", "Price", "Quantity", "Amount" };
                ct4j table = new ct4j();
                table.setHeader(header);
                double totalAmount = 0;
                Product.ProductType productType = null;
                switch (choice) {
                    case 1:
                        productType = Product.ProductType.BEER;
                        break;
                    case 2:
                        productType = Product.ProductType.SOFTDRINK;
                        break;
                    default:
                        System.out.println("Invalid choice: " + choice);
                        return; 
                }

                for (Product product : products) {
                    if (product.getType() == productType) {
                        totalAmount += product.getAmount();
                        table.addRow(
                            String.valueOf(product.getId()),
                            product.getName(),
                            String.valueOf(product.getType()),
                            NumberFormat.getCurrencyInstance(Locale.US).format(product.getPrice()),
                            String.valueOf(product.getQuantity()),
                            NumberFormat.getCurrencyInstance(Locale.US).format(product.amount));
                    }
                    
                }
                table.printTable();
                    System.out.println("Total Amount: " + NumberFormat.getCurrencyInstance(Locale.US).format(totalAmount));
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }

    private static void addProduct(List<Product> products) {
        Product product = new Product();
        product.setId(generateProductId());
        scanner.nextLine();
        System.out.print("Enter Name: ");
        product.setName(scanner.nextLine());
        System.out.println("1. BEER");
        System.out.println("2. SOFTDRINK");
        System.out.print("Enter Type (1 or 2): ");
        int typeChoice = scanner.nextInt();
        product.setType(typeChoice == 1 ? Product.ProductType.BEER : Product.ProductType.SOFTDRINK);
        System.out.print("Enter Price: ");
        product.setPrice(scanner.nextDouble());
        System.out.print("Enter Quantity: ");
        product.setQuantity(scanner.nextInt());
        product.calculateAmount();
        products.add(product);
        System.out.println("Product added successfully.");
    }

    private static int generateProductId() {
        return new Random().nextInt(1000) + 1;
    }

    private static List<Product> loadProductsFromFile() {
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
                product.calculateAmount();
                products.add(product);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    private static void saveProductsToFile(List<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Product product : products) {
                writer.write(String.format("%d,%s,%s,%.2f,%d,%.2f%n",
                        product.getId(), product.getName(), product.getType(), product.getPrice(),
                        product.getQuantity(), product.getAmount()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
