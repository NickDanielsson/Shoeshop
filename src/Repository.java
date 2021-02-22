import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Repository {

    protected Properties p = new Properties();

    public Repository() {
        try {

            p.load(new FileInputStream("src/Settings.properties"));

            Class.forName("com.mysql.cj.jdbc.Driver");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int logIn(String name, String password) {

        int customerId = 0;
        ResultSet rs;
        try (Connection con = DriverManager.getConnection(p.getProperty("url"),
                p.getProperty("name"),
                p.getProperty("password"));
             PreparedStatement stmt = con.prepareStatement("SELECT id FROM customer WHERE first_name LIKE ?" +
                     " AND password_ LIKE ?")) {
            stmt.setString(1, name);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            while (rs.next())
                customerId = rs.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customerId;
    }

    public List<Product> getProductList() {

        List<Product> productList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(p.getProperty("url"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM shoes")) {

            while (rs.next()) {
                Product product = new Product(rs.getInt("id"), rs.getInt("size"),
                        rs.getInt("brandid"), rs.getString("color"),
                        rs.getDouble("price"), rs.getInt("number_in_stock"));
                productList.add(product);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    public String brandName(int brandId) {
        ResultSet rs;
        String brandName = "";
        try (Connection con = DriverManager.getConnection(p.getProperty("url"),
                p.getProperty("name"),
                p.getProperty("password"));
             PreparedStatement stmt = con.prepareStatement("SELECT brand FROM brand WhERE id = ?")) {
            stmt.setInt(1, brandId);
            rs = stmt.executeQuery();
            while (rs.next()) {
                brandName = rs.getString("brand");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return brandName;
    }

    public int getProduct(String brandChoice, int sizeChoice) {

        int brandId = getBrandId(brandChoice);
        int shoeId = 0;
        ResultSet rs;
        try (Connection con = DriverManager.getConnection(p.getProperty("url"),
                p.getProperty("name"),
                p.getProperty("password"));
             PreparedStatement stmt = con.prepareStatement("SELECT id FROM shoes WhERE brandid LIKE ? AND shoes.size LIKE ?")) {
            stmt.setInt(1, brandId);
            stmt.setInt(2, sizeChoice);
            rs = stmt.executeQuery();

            while (rs.next()) {
                shoeId = rs.getInt("id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return shoeId;
    }

    public int getBrandId(String brandName) {

        int brandId = 0;
        ResultSet rs;
        try (Connection con = DriverManager.getConnection(p.getProperty("url"),
                p.getProperty("name"),
                p.getProperty("password"));
             PreparedStatement stmt = con.prepareStatement("SELECT id FROM brand WhERE brand = ?")) {
            stmt.setString(1, brandName);
            rs = stmt.executeQuery();

            while (rs.next()) {
                brandId = rs.getInt("id");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return brandId;
    }

    public int getOrderId(int customerId) {

        int orderId = 0;
        ResultSet rs;
        try (Connection con = DriverManager.getConnection(p.getProperty("url"),
                p.getProperty("name"),
                p.getProperty("password"));
             PreparedStatement stmt = con.prepareStatement("SELECT id FROM orders WHERE customerid = ? AND order_shipped = ?")) {
            stmt.setInt(1, customerId);
            stmt.setBoolean(2, false);
            rs = stmt.executeQuery();

            while (rs.next()) {
                orderId = rs.getInt("id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderId;
    }

    public String addToCart(int customerId, int orderId, int shoeId, int quantity) {

        int rowsChanged = 0;
        String message = "";

        try (Connection con = DriverManager.getConnection(p.getProperty("url"),
                p.getProperty("name"),
                p.getProperty("password"));
             CallableStatement stmt = con.prepareCall("CALL AddToCart(?,?,?,?)")) {
            stmt.setInt(1, customerId);
            stmt.setInt(2, orderId);
            stmt.setInt(3, shoeId);
            stmt.setInt(4, quantity);
            rowsChanged = stmt.executeUpdate();

            if (rowsChanged == 0) {
                message = "Fel uppstod, skon lades inte till i beställningen!";

            }
            if (rowsChanged >= 1) {
                message = "Skon lades till i beställningen!";

            }

            }catch (SQLException esql){
            System.out.println(esql.getErrorCode() + ", " + esql.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return message;
    }
}