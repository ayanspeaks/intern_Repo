package com.mps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Order {
    private int orderId;
    private String name;
    private double price;
    private String month;
    private int year;
    private String city;
    private String category;
    private int quantity;

    public Order() {
    }

    public Order(int orderId, String name, double price, String month, int year, String city, String category, int quantity) {
        this.orderId = orderId;
        this.name = name;
        this.price = price;
        this.month = month;
        this.year = year;
        this.city = city;
        this.category = category;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", name=" + name + ", price=" + price + 
               ", month=" + month + ", year=" + year + ", city=" + city + 
               ", category=" + category + ", quantity=" + quantity + "]";
    }

    public int getOrderId() {
        return orderId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getCity() {
        return city;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }
}

public class Exp4Orders {

    // 1) Find the year with the highest number of orders
    public static void getYearWithHighestOrders(List<Order> orderList) {
        // Group by year and count each group's size
        Map<Integer, Long> yearCountMap = 
            orderList.stream()
                     .collect(Collectors.groupingBy(Order::getYear, Collectors.counting()));

        // Find the entry with the maximum count
        Optional<Map.Entry<Integer, Long>> maxYearEntry = 
            yearCountMap.entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue());

        if (maxYearEntry.isPresent()) {
            System.out.println("Year with highest orders: " + maxYearEntry.get().getKey() +
                               " (Orders: " + maxYearEntry.get().getValue() + ")");
        } else {
            System.out.println("No orders found.");
        }
    }

    // 2) Find the category-wise order counts
    public static void getCategoryWiseOrders(List<Order> orderList) {
        Map<String, Long> categoryCountMap =
            orderList.stream()
                     .collect(Collectors.groupingBy(Order::getCategory, Collectors.counting()));

        System.out.println("\nCategory-wise order counts:");
        categoryCountMap.forEach((category, count) -> 
            System.out.println(category + " => " + count)
        );
    }

    // 3) Print the maximum price among all orders
    public static void getMaxPrice(List<Order> orderList) {
        Optional<Double> maxPrice = 
            orderList.stream()
                     .map(Order::getPrice)
                     .max(Double::compare);

        if (maxPrice.isPresent()) {
            System.out.println("\nMaximum order price: " + maxPrice.get());
        } else {
            System.out.println("\nNo orders to find max price from.");
        }
    }

    // 4) Average monthly spending in the e-com (total of all orders / 12)
    public static void getAvgMonthlySpending(List<Order> orderList) {
        DoubleSummaryStatistics stats = 
            orderList.stream()
                     .collect(Collectors.summarizingDouble(Order::getPrice));

        double avgMonthlySpending = stats.getSum() / 12; // dividing total by 12 months
        System.out.println("\nAverage monthly spending: " + avgMonthlySpending);
    }

    // 5) Find the minimum order price in the total orders
    public static void getMinOrderPrice(List<Order> orderList) {
        Optional<Double> minPrice =
            orderList.stream()
                     .map(Order::getPrice)
                     .min(Double::compare);

        if (minPrice.isPresent()) {
            System.out.println("\nMinimum order price: " + minPrice.get());
        } else {
            System.out.println("\nNo orders to find min price from.");
        }
    }

    // 6) Find the first order of the customer (based on earliest year)
    public static void getFirstOrderOfTheCustomer(List<Order> orderList) {
        // Group by customer name and pick the order with the earliest year
        Map<String, Optional<Order>> earliestOrderMap =
            orderList.stream()
                     .collect(Collectors.groupingBy(
                         Order::getName,
                         Collectors.minBy(Comparator.comparing(Order::getYear))
                     ));

        System.out.println("\nFirst order of each customer:");
        earliestOrderMap.forEach((customer, orderOpt) -> {
            if (orderOpt.isPresent()) {
                System.out.println("Customer: " + customer + ", First Order: " + orderOpt.get());
            }
        });
    }

    public static void main(String[] args) {

        List<Order> orderList = new ArrayList<>();

        // Creating 10 sample orders
        orderList.add(new Order(101, "Alice",   350.0, "January",   2023, "New York",    "Electronics", 2));
        orderList.add(new Order(102, "Bob",     120.0, "March",     2023, "Los Angeles", "Groceries",   3));
        orderList.add(new Order(103, "Charlie", 500.0, "February",  2024, "Chicago",     "Electronics", 1));
        orderList.add(new Order(104, "Alice",   200.0, "May",       2024, "New York",    "Clothing",    2));
        orderList.add(new Order(105, "Eve",     100.0, "June",      2023, "Houston",     "Home",        1));
        orderList.add(new Order(106, "Frank",   600.0, "January",   2024, "Miami",       "Electronics", 1));
        orderList.add(new Order(107, "Gina",     80.0, "March",     2024, "Dallas",      "Groceries",   5));
        orderList.add(new Order(108, "Henry",   300.0, "December",  2023, "Seattle",     "Furniture",   2));
        orderList.add(new Order(109, "Ivy",     220.0, "November",  2023, "Boston",      "Electronics", 3));
        orderList.add(new Order(110, "James",    75.0, "August",    2024, "Phoenix",     "Groceries",   4));

        // 1) Find highest orders in the year
        getYearWithHighestOrders(orderList);

        // 2) Find out category-wise orders
        getCategoryWiseOrders(orderList);

        // 3) Print max price
        getMaxPrice(orderList);

        // 4) Avg monthly spending in the e-com
        getAvgMonthlySpending(orderList);

        // 5) Find out min order price in the total orders
        getMinOrderPrice(orderList);

        // 6) Find out the 1st order of the customer
        getFirstOrderOfTheCustomer(orderList);
    }
}