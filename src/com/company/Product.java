package com.company;

public class Product {
    String name;
    int price;
    String description;
    int quantity;

    //constructor
    public Product(String name, int price, String description, int quantity){
        this.name= name;
        this.price = price;
        this.description = description;
        this.quantity=quantity;
    }

    //method
    public String getName() {
        return name;
    }

    //method
    public int getPrice() {
        return price;
    }

    //method
    public String getDescription() {
        return description;
    }

    //method
    public int getQuantity() {
        return quantity;
    }

    //method used for printing
    public String toString() {
        return "Name: "+ this.name + ", Price: "+this.price+", Description: "+this.description + ", Quantity: "+this.quantity;
    }
}
