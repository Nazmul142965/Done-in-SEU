package bd.edu.seu.dresscollection;

import java.time.LocalDate;

public class tableDetails {
    private String name;
    private String type;
    private String size;
    private String color;
    private double price;
    private String details;
    private LocalDate date;
    private int quantity;
    private String customer;
    private boolean boost;
    private String coupon;
    private String image;

    public tableDetails(String name,String type, String size, String color, double price, String details, LocalDate date, int quantity, String coupon ,String customer, boolean boost , String image) {

        this.name = name;
        this.type = type;
        this.size = size;
        this.color = color;
        this.price = price;
        this.details = details;
        this.date = date;
        this.quantity = quantity;
        this.customer = customer;
        this.boost = boost;
        this.coupon = coupon;
        this.image = image;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public boolean isBoost() {
        return boost;
    }

    public void setBoost(boolean boost) {
        this.boost = boost;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}