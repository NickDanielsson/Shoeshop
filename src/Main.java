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

    public Main () {

        System.out.println("Ange ditt förnamn:");
        firstName = sc.nextLine().trim().toLowerCase();
        System.out.println("Ange ditt lösenord:");
        password = sc.nextLine().trim().toLowerCase();

        customerNumber = r.logIn(firstName,password);
        customerOrder = r.getOrderId(customerNumber);


        System.out.println("Vilken sko vill du lägga till i beställningen?");
        System.out.println("Följande produkter finns:");
        productList = r.getProductList();
        productList.forEach(Product::printInfo);

        System.out.println();
        System.out.println("vilken sko vill du se betyg på?");
        r.getShoeGrade(getProductId());
        System.out.println("Vilket märke?");
        brandChoice = sc.nextLine().trim().toLowerCase();

        System.out.println("Vilken storlek?");
        sizeChoice = sc.nextInt();
        productId = r.getProduct(brandChoice,sizeChoice);


        System.out.println("Ange antal par:");
        shoeAmount = sc.nextInt();
        feedback = r.addToCart(customerNumber,customerOrder,productId,shoeAmount);
        System.out.println(feedback);

        System.out.println("1) Se din order\n" + "2) Bekräfta order\n" + "3) Avsluta");

        userInput = sc.nextInt();
        switch (userInput){
            case 1 -> r.getCustomerOrder(customerNumber,customerOrder).forEach(Product::printOrderInfo);
            case 2 -> System.out.println("lägg till metod");
            case 3 -> {
                System.out.println("Programmet avslutas");
                System.exit(0);
            }
            default -> System.out.println("JAMEN TJABA TJABA!");
        }
        sc.nextLine();

       // setGrade();


    }


    public static void main(String[] args) {

        Main main = new Main();

    }

    public void setGrade () {

        System.out.println("Vilken av dina produkter vill du betygsätta?");
        r.getCustomerOrder(customerNumber,customerOrder).forEach(Product::printOrderInfo);
        System.out.println("Ange märke och storlek på produkten du vill betygsätta:");
        System.out.println("Vilket märke?");

       getProductId();

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

    }

    public int getProductId () {


        brandChoice = sc.next().trim().toLowerCase();
        System.out.println("Vilken storlek?");
        sizeChoice = sc.nextInt();
        sc.nextLine();
        return productId = r.getProduct(brandChoice,sizeChoice);

    }
}
