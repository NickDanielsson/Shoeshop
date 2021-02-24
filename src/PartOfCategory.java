/**
 * Created by Johan Rune
 * Date: 2021-02-24
 * Time: 19:46
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */
public class PartOfCategory {

    public int getId() {
        return id;
    }

    public Product getProductId() {
        return productId;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public PartOfCategory(int id, Product productId, Category categoryId) {
        this.id = id;
        this.productId = productId;
        this.categoryId = categoryId;
    }

    private int id = 0;
    Product productId;
    Category categoryId;

}
