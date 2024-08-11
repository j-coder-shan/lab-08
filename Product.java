public class Product {
    String productId;
    String productName;
    String category;
    double unitPrice;
    int quantitySold;
    double salesAmount;

    Product(String productId, String productName, String category, double unitPrice, int quantitySold) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.unitPrice = unitPrice;
        this.quantitySold = quantitySold;
        this.salesAmount = getSalesAmount();
    }

    double getSalesAmount() {
        return this.unitPrice * this.quantitySold;
    }

    public String toString(){
        return String.format("%-15s %-20s %-15s %-15s %-15s", this.productId, this.productName, this.category, this.unitPrice, this.quantitySold, this.salesAmount);
    }


}

