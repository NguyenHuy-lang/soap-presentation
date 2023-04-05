package io.spring.guides.product_inventory.repository;
import io.spring.guides.product_inventory.Product;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProductRepository {
    private static final Map<String, Integer> orders = new HashMap<>();

    @PostConstruct
    public void initData() throws ClassNotFoundException, SQLException {
        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish a database connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/order", "root", "123456789");

        // Create an SQL statement
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM tbl_product";
        ResultSet rs = stmt.executeQuery(sql);

        // Loop through the ResultSet and retrieve data
        while (rs.next()) {
            String name = rs.getString("name");
            Integer quantity = rs.getInt("quantity");
            Product product = new Product();
            product.setNameProduct(name);
            product.setQuantity(String.valueOf(quantity));
            orders.put(name, quantity);
        }
        // Close the connection
        conn.close();

    }

    public String checkQuantityInventory(String namProduct, String quantity) {
        Assert.notNull(namProduct, "The country's name must not be null");
        if (orders.get(namProduct) > Integer.parseInt(quantity)) {
            return "Còn hàng";
        } else {
            return "Hết hàng";
        }
    }
}