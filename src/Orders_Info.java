import java.util.List;

public class Orders_Info {

    public int getId() {
        return id;
    }

    public Orders getOrdersId() {
        return ordersId;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Orders_Info(int id, Orders ordersId, int quantity, List<Product> productList) {
        this.id = id;
        this.ordersId = ordersId;
        this.quantity = quantity;
        this.productList = productList;
    }

    private int id;
    private Orders ordersId;
    private int quantity;
    private List<Product> productList;

}
