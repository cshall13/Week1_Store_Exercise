package com.company;
//import library ArrayLIst
import java.util.ArrayList;

public class Vendor {

    //method to that returns vendorList as a whole with products that have been added
    public ArrayList<Product> getVendorList() {
        return vendorList;
    }

    //private ArrayList which takes the Product constructor as an argument. called it vendorList and created a new ArrayList
    private ArrayList<Product> vendorList = new ArrayList<Product>();

    //method to add Product from Product class constructor(1st argument) and product variable(2nd argument) to the vendorList
    public void addProduct(Product product) {
        vendorList.add(product);
    }

    //method to remove Product from Product class constructor(1st argument) and product variable(2nd argument) from the vendorList
    public void removeProduct(Product product) {
        vendorList.remove(product);
    }

    //default constructor
   public Vendor(){

    }

    //constructor made for inventory variable as a for loop to loop over vendorList(made up of Product class and product(which = p))
    //prints out the product(p) at the index to a string using the toString method
    public void inventory(){
        for(Product p: vendorList)
            System.out.println(p.toString());
    }
}
