package Project_Shop;

public class Product {
    private int productId;
    private String title;
    private double price;

    public Product(int productId, String title, double price) {
        this.productId = productId;
        this.title = title;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
