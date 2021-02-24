import java.sql.Timestamp;

/**
 * Created by Johan Rune
 * Date: 2021-02-24
 * Time: 19:43
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */
public class SlutILager {
    int id = 0;
    Product productId;
    Timestamp date;

    public SlutILager(int id, Product productId, Timestamp date) {
        this.id = id;
        this.productId = productId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Product getProductId() {
        return productId;
    }

    public Timestamp getDate() {
        return date;
    }
}
