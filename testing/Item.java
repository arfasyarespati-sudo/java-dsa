package testing;

public class Item {
    private final String sku;
    private String name;
    private String category;
    private double price;
    private int stock;
    
        Item(String sku, String name, String category, double price, int stock) {
            if (sku == null || sku.isBlank()) {
                throw new IllegalArgumentException("SKU Cannot be empty");
            }
            this.sku = sku;
            this.name = name;
            this.category = category;
            this.price = price;
            this.stock = stock;
        }
        
        public String getSku() {
            return sku;
        }
         public String getName() {
            return name;
        }
         public String getCategory() {
            return category;
        }
         public double getPrice() {
            return price;
        }
         public int getStock() {
            return stock;
        }
        public void setPrice(double price) {
            if (price < 0) {
                throw new IllegalArgumentException("Price cannot be minus");
            }
        }
}
