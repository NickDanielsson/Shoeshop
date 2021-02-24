import java.sql.Timestamp;

public class Orders {

    private int id;
    private Customer customerId;
    private Timestamp timestamp;
    private Boolean orderShipped;

    public Orders(int id, Customer customerId, Timestamp timestamp, Boolean orderShipped) {
        this.id = id;
        this.customerId = customerId;
        this.timestamp = timestamp;
        this.orderShipped = orderShipped;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Boolean getOrderShipped() {
        return orderShipped;
    }
}