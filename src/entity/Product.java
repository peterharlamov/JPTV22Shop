package entity;

public class Product {

    private String productName;
    private int price;
    private int productRating;
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getProductRating() { return productRating; }
    public void setProductRating(int productRating) {
        this.productRating = productRating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
