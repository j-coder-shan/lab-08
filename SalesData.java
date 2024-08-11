import java.util.Scanner;

public class SalesData {
    static String[][] products;
    static double electronicsSalesAmount;
    static double totalSalesAmount;

    private static void insertProducts() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of products: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        products = new String[n][6];

        for (int i = 0; i < n; i++) {
            System.out.println(STR."Enter details for product \{i + 1}:");

            System.out.print("Product ID: ");
            String productId = scanner.nextLine();

            System.out.print("Product Name: ");
            String productName = scanner.nextLine();

            System.out.print("Category: ");
            String category = scanner.nextLine();

            System.out.print("Unit Price (Rs.): ");
            String unitPrice = scanner.nextLine();

            System.out.print("Quantity Sold: ");
            String quantitySold = scanner.nextLine();

            products[i] = new String[]{productId, productName, category, unitPrice, quantitySold, STR."Rs. \{Double.parseDouble(unitPrice) * Integer.parseInt(quantitySold)}"};
        }
        displayDetails();
    }

    private static void displayDetails() {
        System.out.println("--------------------------------------------------------------------------------\n" +
                "Product Details:");
        System.out.printf("%-15s %-20s %-15s %-15s %-15s%n", "| Product ID", "| Product Name", "| Category", "| Unit Price", "| Quantity Sold");
        for (String[] product : products) {
            System.out.printf("%-15s %-20s %-15s %-15s %-15s%n", STR."| \{product[0]}", STR."| \{product[1]}", STR."| \{product[2]}", STR."| \{product[3]}", STR."| \{product[4]}");
        }
    }

    public static void displaySalesAmount(int len) {
        System.out.println("--------------------------------------------------------------------------------\n" +
                "Sales Amount for each product:");
        for (int i = 0; i < len; i++) {
            System.out.println(STR."  \{i + 1}. Sales amount for product \{products[i][0]} : \{products[i][5]}");
        }
    }
    private static void correct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to correct any details? (y/n)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            System.out.println("Enter the product ID to correct details: ");
            String productId = scanner.nextLine();
            for (int i = 0; i < products.length; i++) {
                if (products[i][0].equals(productId)) {
                    System.out.println("Enter the field to correct: (Product Name/ Category/ Unit Price/ Quantity Sold)");
                    String field = scanner.nextLine();
                    switch (field) {
                        case "Product Name":
                            System.out.print("Enter new product name: ");
                            products[i][1] = scanner.nextLine();
                            break;
                        case "Category":
                            System.out.print("Enter new category: ");
                            products[i][2] = scanner.nextLine();
                            break;
                        case "Unit Price":
                            System.out.print("Enter new unit price: ");
                            products[i][3] = scanner.nextLine();
                            products[i][5] = STR."Rs. \{Double.parseDouble(products[i][3]) * Integer.parseInt(products[i][4])}";
                            break;
                        case "Quantity Sold":
                            System.out.print("Enter new quantity sold: ");
                            products[i][4] = scanner.nextLine();
                            products[i][5] = STR."Rs. \{Double.parseDouble(products[i][3]) * Integer.parseInt(products[i][4])}";
                            break;
                        default:
                            System.out.println("Invalid field!");
                    }
                    break;
                }
            }
        }

    }
    public static void topSales() {
        System.out.println("--------------------------------------------------------------------------------\n" +
                "Products with sales amount greater than Rs. 40,000:");
        System.out.printf("%-15s %-20s %-15s %-15s %-15s%n", "| Product ID", "| Product Name", "| Category", "| Unit Price", "| Quantity Sold");
        for (String[] product : products) {
            if (Double.parseDouble(product[5].substring(4)) > 40000) {
                System.out.printf("%-15s %-20s %-15s %-15s %-15s%n", STR."| \{product[0]}", STR."| \{product[1]}", STR."| \{product[2]}", STR."| \{product[3]}", STR."| \{product[4]}");
            }
        }
    }
    public static void electronicsSales() {
        electronicsSalesAmount = 0;
        for (String[] product : products) {
            if (product[2].equalsIgnoreCase("Electronics")) {
                electronicsSalesAmount  += Double.parseDouble(product[5].substring(4));
            }
        }
        System.out.println(STR."--------------------------------------------------------------------------------\nSales amount received from Electronics category: Rs. \{electronicsSalesAmount}");
    }
    public static void totalSales() {
        totalSalesAmount = 0;
        for (String[] product : products) {
            totalSalesAmount += Double.parseDouble(product[5].substring(4));
        }
        System.out.println(STR."--------------------------------------------------------------------------------\nTotal sales amount: Rs. \{totalSalesAmount}");
        System.out.println(STR."Percentage of sales amount received from Electronics category: \{electronicsSalesAmount / totalSalesAmount * 100}%");
    }

    public static void main(String[] args) {
        //Question 1
        insertProducts();

        //Question 2
        displaySalesAmount(products.length);

        //Question 3
        SelectionSort selectionSort = new SelectionSort(products);

        //Question 4
        correct();
        selectionSort = new SelectionSort(products);

        //Question 5
        topSales();

        //Question 6
        electronicsSales();

        //Question 7
        totalSales();
    }


}