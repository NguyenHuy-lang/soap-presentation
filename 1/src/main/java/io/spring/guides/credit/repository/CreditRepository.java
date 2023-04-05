package io.spring.guides.credit.repository;//package io.spring.guides.gs_producing_web_service.repository;
import io.spring.guides.credit.Credit;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class CreditRepository {
    private static final Map<Credit, Integer> credits = new HashMap<>();

    @PostConstruct
    public void initData() throws ClassNotFoundException, SQLException {
        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish a database connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/order", "root", "123456789");

        // Create an SQL statement
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM tbl_credit";
        ResultSet rs = stmt.executeQuery(sql);

        // Loop through the ResultSet and retrieve data
        while (rs.next()) {
            String creditName = rs.getString("creditName");
            String creditType = rs.getString("creditType");
            String creditNum = rs.getString("creditNum");
            String creditCvc = rs.getString("creditCvc");
            String creditExpire = rs.getString("creditExpire");
            int creditAmountCurrent = rs.getInt("creditAmountCurrent");
            Credit credit = new Credit();

            credit.setCreditCvc(creditCvc);
            credit.setCreditAmountCurrent(creditAmountCurrent);
            credit.setCreditExpire(credit.getCreditExpire());
            credit.setCreditNum(creditNum);
            credit.setCreditType(creditType);
            credit.setCreditName(creditName);
            credits.put(credit, Integer.valueOf(creditAmountCurrent));
        }
        // Close the connection
        conn.close();

    }

    public String checkValidCredit(String creditName, String creditType,
                                   String creditNum, String creditCvc,
                                   Date creditExpire, Integer creditAmountTransfer) throws ParseException {

        for (Credit credit : credits.keySet()) {
            if (
                    credit.getCreditName().equals(creditName) &&
                    credit.getCreditNum().equals(creditNum) &&
                    credit.getCreditType().equals(creditType) &&
                    credit.getCreditCvc().equals(creditCvc) &&
                    credit.getCreditAmountCurrent() >= creditAmountTransfer
            ) {
                credit.setCreditAmountCurrent(credit.getCreditAmountCurrent() - creditAmountTransfer);
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/order", "root", "123456789");

                    String sql = "UPDATE tbl_credit SET creditAmountCurrent=?";

                    PreparedStatement pstmt = conn.prepareStatement(sql);


                    pstmt.setInt(1, credit.getCreditAmountCurrent());

                    int rowsAffected = pstmt.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Record updated successfully");
                    } else {
                        System.out.println("Record not found or update failed");
                    }
                } catch (Exception e) {

                }
                // Assuming you have already established a database connection as shown in your previous code


                return "success";
            }
        }

        return "Tài khoản quý khách không đủ tiền hoặc sai thông tin";
    }

    public static Date stringToDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.parse(dateString);
    }
}