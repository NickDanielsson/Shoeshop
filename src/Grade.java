public class Grade {

    private int id;
    private int customerId;
    private int shoeId;
    private int gradeChoiceId;

    public Grade(int id, int customerId, int shoeId, int gradeChoiceId) {
        this.id = id;
        this.customerId = customerId;
        this.shoeId = shoeId;
        this.gradeChoiceId = gradeChoiceId;
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

    public int getShoeId() {
        return shoeId;
    }

    public void setShoeId(int shoeId) {
        this.shoeId = shoeId;
    }

    public int getGradeChoiceId() {
        return gradeChoiceId;
    }

    public void setGradeChoiceId(int gradeChoiceId) {
        this.gradeChoiceId = gradeChoiceId;
    }
}
