public class SelectionSort {
    SelectionSort(String[][] products) {
        for (int i = 0; i < products.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < products.length; j++) {
                if (Double.parseDouble(products[j][5].substring(4)) < Double.parseDouble(products[minIndex][5].substring(4))) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                String[] temp = products[i];
                products[i] = products[minIndex];
                products[minIndex] = temp;
            }
        }

        // Display sorted products
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Sorted Products by Sales Amount:");
        System.out.printf("%-15s %-20s %-15s %-15s %-15s %-15s%n", "| Product ID", "| Product Name", "| Category", "| Unit Price", "| Quantity Sold", "| Sales Amount");

        for (String[] product : products) {
            System.out.printf("%-15s %-20s %-15s %-15s %-15s %-15s%n", "| " + product[0], "| " + product[1], "| " + product[2], "| " + product[3], "| " + product[4], "| " + product[5]);
        }
    }
}
