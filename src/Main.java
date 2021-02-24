import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    Repository r = new Repository();
    Scanner sc = new Scanner(System.in);
    private String firstName = "";
    private String password = "";
    private List<Product> productList;
    private int customerNumber;
    private int customerOrder = 0;
    private  String brandChoice = "";
    private int sizeChoice = 0;
    private int shoeAmount = 0;
    private int productId = 0;
    private String feedback = "";
    private List<Product> customerOrderList;
    private int userInput;
    private int gradeChoice;
    private String comment ="";
    private List<String> commentsList;

    public Main () {

        System.out.println("Ange ditt förnamn:");
        firstName = sc.nextLine().trim().toLowerCase();
        System.out.println("Ange ditt lösenord:");
        password = sc.nextLine().trim().toLowerCase();

        customerNumber = r.logIn(firstName,password);
        customerOrder = r.getOrderId(customerNumber);

        choiceMeny();
    }




    public void setGrade () {

        System.out.println("Vilken av dina produkter vill du betygsätta?");
        r.getCustomerOrder(customerNumber,customerOrder).forEach(Product::printOrderInfo);
        productId = getProductId();

        System.out.println("Vilket betyg vill du ge?");
        System.out.println("1 - Mycket missnöjd.");
        System.out.println("2 - Missnöjd.");
        System.out.println("3 - Ganska nöjd.");
        System.out.println("4 - Nöjd.");
        System.out.println("5 - Mycket nöjd.");

        gradeChoice = sc.nextInt();
        sc.nextLine();

        System.out.println("Ange kommentar om du vill.");

        comment = sc.nextLine();

        System.out.println(r.rate(gradeChoice,comment,customerNumber,productId));

        choiceMeny();
    }












    public int getProductId () {

        System.out.println("Vilket märke?");
        brandChoice = sc.next().trim().toLowerCase();
        System.out.println("Vilken storlek?");
        sizeChoice = sc.nextInt();
        sc.nextLine();
        return r.getProduct(brandChoice,sizeChoice);

    }


    public void choiceMeny () {
        System.out.println(
            "1. Lägga till i varukorgen \n" +
            "2. Se varukorgen \n" +
            "3. Sätta betyg och omdöme på skor \n" +
            "4. Se betyg och omdömen på skor \n" +
            "5. Logga ut");
        int customerChoice = sc.nextInt();

        switch (customerChoice) {
            case 1 -> addProducts();
            case 2 -> printCustomerOrder();
            case 3 -> setGrade ();
            case 4 -> getGrade();
            case 5 -> System.exit(0);
        }

    }

    public void addProducts (){

        System.out.println("Följande produkter finns:");
        productList = r.getProductList();
        productList.forEach(Product::printInfo);
        System.out.println("Vilken sko vill du lägga till i beställningen?");
        productId = getProductId();
        System.out.println("Ange antal par:");
        shoeAmount = sc.nextInt();
        feedback = r.addToCart(customerNumber,customerOrder,productId,shoeAmount);
        System.out.println(feedback);

        choiceMeny();
    }

    public void printCustomerOrder () {
        r.getCustomerOrder(customerNumber, customerOrder).forEach(Product::printOrderInfo);

        choiceMeny();
    }

    public void getGrade (){
        System.out.println("Vilken produkt vill du se betyg och omdöme för?");
        productList = r.getProductList();
        productList.forEach(Product::printInfo);

        productId = getProductId();
        r.getShoeGrade(productId);
        System.out.println("Med kommentarerna:");
        commentsList = r.getShoesComments(productId);
        commentsList.forEach(System.out::println);

        choiceMeny();

    }


    public static void main(String[] args) {
        Main main = new Main();

    }


}
