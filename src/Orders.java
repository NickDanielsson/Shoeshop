import java.sql.Timestamp;

public class Orders {

    private int id;
    private int customerId;
    private Timestamp timestamp;
    private Boolean orderShipped;

    public Orders(int id, int customerId, Timestamp timestamp, Boolean orderShipped) {
        this.id = id;
        this.customerId = customerId;
        this.timestamp = timestamp;
        this.orderShipped = orderShipped;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getOrderShipped() {
        return orderShipped;
    }

    public void setOrderShipped(Boolean orderShipped) {
        this.orderShipped = orderShipped;
    }
}
