package io.spring.guides.gs_producing_web_service.repository;

import io.spring.guides.gs_producing_web_service.Order;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Component
public class OrderRepository {
    private static final Map<MyKey, String> orders = new HashMap<>();

    @PostConstruct
    public void initData() throws ClassNotFoundException, SQLException {
        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish a database connection


        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/order", "root", "123456789");

        // Create an SQL statement
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM tbl_order";
        ResultSet rs = stmt.executeQuery(sql);

        // Loop through the ResultSet and retrieve data
        while (rs.next()) {
            String orderNumber = rs.getString("orderNumber");
            String companyId = rs.getString("companyID");
            String status = rs.getString("status");
            Order order = new Order();
            order.setCompanyId(companyId);
            order.setStatus(status);
            order.setOrderNumber(orderNumber);
            MyKey myKey = new MyKey(orderNumber, companyId);
            orders.put(myKey, status);
        }
        // Close the connection
        conn.close();

    }

    public String findOrderByOrderNumberAndCompanyId(String orderNumber, String companyId) {

        Assert.notNull(new MyKey(orderNumber, companyId), "The country's name must not be null");
        return orders.get(new MyKey(orderNumber, companyId));
    }
}