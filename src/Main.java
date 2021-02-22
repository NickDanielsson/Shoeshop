import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    Repository r = new Repository();
    Scanner sc = new Scanner(System.in);
    String firstName = "";
    String password = "";
    List<Product> productList = new ArrayList<>();
    int customerNumber;
    String brandChoice = "";
    int sizeChoice = 0;
    int shoeAmount = 0;

    public Main () {

        System.out.println("Ange ditt förnamn:");
        firstName = sc.nextLine().trim().toLowerCase();
        System.out.println("Ange ditt lösenord:");
        password = sc.nextLine().trim().toLowerCase();

        customerNumber = r.logIn(firstName,password);
        System.out.println("Vilken sko vill du lägga till i beställningen?");
        System.out.println("Följande produkter finns:");

        productList = r.getProductList();
        productList.forEach(Product::printInfo);

        System.out.println("Vilket märke?");
        brandChoice = sc.nextLine().trim().toLowerCase();
        System.out.println("Vilken storlek?");
        sizeChoice = sc.nextInt();
        System.out.println(r.getProduct(brandChoice,sizeChoice));
        System.out.println("Ange antal par:");
        shoeAmount = sc.nextInt();
        System.out.println(r.getOrderId(customerNumber));

    }


    public static void main(String[] args) {

        Main main = new Main();

    }
}
