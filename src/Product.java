public class Product {

    private int id;
    private int size;
    private int brand;
    private String color;
    private double price;
    private int numberInStock;
    private Repository r = new Repository();

    public Product(int id, int size, int brand, String color, double price, int numberInStock) {
        this.id = id;
        this.size = size;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.numberInStock = numberInStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(int numberInStock) {
        this.numberInStock = numberInStock;
    }

    public void printInfo () {
        System.out.println("Märke: " + r.brandName(this.brand) + " " + this.size + " " + this.color + " " + this.price);
    }
}
