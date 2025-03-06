package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

// A simple class to hold order details
class OrderData {
    private int orderId;
    private String name;
    private double price;
    private String month;
    private int year;
    private String city;
    private String category;
    private int quantity;

    public OrderData(int orderId, String name, double price, String month,
                     int year, String city, String category, int quantity) {
        this.orderId = orderId;
        this.name = name;
        this.price = price;
        this.month = month;
        this.year = year;
        this.city = city;
        this.category = category;
        this.quantity = quantity;
    }

    public int getOrderId()   { return orderId; }
    public String getName()   { return name;    }
    public double getPrice()  { return price;   }
    public String getMonth()  { return month;   }
    public int getYear()      { return year;    }
    public String getCity()   { return city;    }
    public String getCategory(){ return category;}
    public int getQuantity()  { return quantity;}
}

public class MavenAssignment {
    public static void main(String[] args) {
        try {
            OrderData[] orders = {
                new OrderData(101, "Ayan",     350.0, "January",   2023, "Kolkata",   "Electronics", 2),
                new OrderData(102, "Anik",     120.0, "March",     2023, "Dhaka",     "Groceries",   3),
                new OrderData(103, "Charlie",  500.0, "February",  2024, "Delhi",     "Electronics", 1),
                new OrderData(104, "Arun",     200.0, "May",       2024, "Mumbai",    "Clothing",    2),
                new OrderData(105, "Bubli",    100.0, "June",      2023, "Chennai",   "Home",        1),
                new OrderData(106, "Bablu",    600.0, "January",   2024, "Pune",      "Electronics", 1),
                new OrderData(107, "Gian",     80.0,  "March",     2024, "Hyderabad", "Groceries",   5),
                new OrderData(108, "Ayan",     300.0, "January",   2020, "Kolkata",   "Electronics", 2),
                new OrderData(109, "Nobita",   220.0, "November",  2023, "Punjab",    "Electronics", 3),
                new OrderData(110, "Ashmita",  75.0,  "August",    2024, "Ahmedabad", "Groceries",   4)
            };

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/students",
                "root",
                "root@39"
            );

            Statement stmt = con.createStatement();

            try {
                stmt.execute("DROP TABLE IF EXISTS ecommerce");
            } catch(Exception ex) {

            }
            String createTableSQL = 
                "CREATE TABLE ecommerce ("
                + "order_id INT PRIMARY KEY, "
                + "name VARCHAR(50), "
                + "price DOUBLE, "
                + "month VARCHAR(20), "
                + "year INT, "
                + "city VARCHAR(50), "
                + "category VARCHAR(50), "
                + "quantity INT"
                + ")";
            stmt.execute(createTableSQL);

            // 5) Insert the sample data into the table
            for (OrderData order : orders) {
                String insertSQL = 
                    "INSERT INTO ecommerce VALUES("
                    + order.getOrderId() + ", "
                    + "'" + order.getName() + "', "
                    + order.getPrice() + ", "
                    + "'" + order.getMonth() + "', "
                    + order.getYear() + ", "
                    + "'" + order.getCity() + "', "
                    + "'" + order.getCategory() + "', "
                    + order.getQuantity()
                    + ")";
                stmt.execute(insertSQL);
            }


            // 1) Find highest orders in the year
            System.out.println("\n1) Year with the highest number of orders:");
            String query1 =
                "SELECT year, COUNT(*) AS order_count "
                + "FROM ecommerce "
                + "GROUP BY year "
                + "ORDER BY order_count DESC "
                + "LIMIT 1";
            try (ResultSet rs = stmt.executeQuery(query1)) {
                if (rs.next()) {
                    System.out.println("   Year: " + rs.getInt("year")
                        + ", Orders: " + rs.getLong("order_count"));
                }
            }

            // 2) Find out category-wise orders (i.e., how many orders per category)
            System.out.println("\n2) Category-wise order counts:");
            String query2 =
                "SELECT category, COUNT(*) AS cat_count "
                + "FROM ecommerce "
                + "GROUP BY category";
            try (ResultSet rs = stmt.executeQuery(query2)) {
                while (rs.next()) {
                    System.out.println("   " + rs.getString("category") 
                        + " => " + rs.getLong("cat_count"));
                }
            }

            // 3) Print max price
            System.out.println("\n3) Max price:");
            String query3 = "SELECT MAX(price) AS max_price FROM ecommerce";
            try (ResultSet rs = stmt.executeQuery(query3)) {
                if (rs.next()) {
                    System.out.println("   Max price is: " + rs.getDouble("max_price"));
                }
            }

            // 4) Average monthly spending in the e-com
            //    (Take sum of all prices and divide by 12)
            System.out.println("\n4) Average monthly spending:");
            String query4 = 
                "SELECT (SUM(price) / 12) AS avg_monthly_spending FROM ecommerce";
            try (ResultSet rs = stmt.executeQuery(query4)) {
                if (rs.next()) {
                    System.out.println("   Avg monthly spending is: " 
                        + rs.getDouble("avg_monthly_spending"));
                }
            }

            // 5) Find out min order price in the total orders
            System.out.println("\n5) Minimum order price:");
            String query5 = "SELECT MIN(price) AS min_price FROM ecommerce";
            try (ResultSet rs = stmt.executeQuery(query5)) {
                if (rs.next()) {
                    System.out.println("   Min price is: " + rs.getDouble("min_price"));
                }
            }

            // 6) Find out the 1st order of the customer (earliest year per customer)
            System.out.println("\n6) First order (earliest year) of each customer:");
            String query6 =
                "SELECT name, MIN(year) AS earliest_year "
                + "FROM ecommerce "
                + "GROUP BY name";
            try (ResultSet rs = stmt.executeQuery(query6)) {
                while (rs.next()) {
                    System.out.println("   " + rs.getString("name") 
                        + " => Earliest year: " + rs.getInt("earliest_year"));
                }
            }

            // 7) Close the connection
            //stmt.close();
            //con.close();

            System.out.println("\nOperation Completed Successfully.");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}