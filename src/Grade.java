public class Grade {

    private int id;
    private Customer customerId;
    private Product productId;
    private Grade_choice gradeChoiceId;
    private String comments = "";

    public Grade(int id, Customer customerId, Product productId, Grade_choice gradeChoiceId, String comments) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.gradeChoiceId = gradeChoiceId;
        this.comments = comments;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public Product getProductId() {
        return productId;
    }

    public Grade_choice getGradeChoiceId() {
        return gradeChoiceId;
    }

    public String getComments() {
        return comments;
    }
}

