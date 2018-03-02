package com.company;

/* *************3 pillars of OOP
encapsulation
inheritance
polymorphism -> can call the same method (from a parent class) in a sub class but can customize the method behavior(known as method overriding) */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        //================================================================================================================
        //***********these variables and initializations are being formed in the Main class but outside of the main method
        //essentially making these a global variable that can belong to more of the 'project'
    // STATIC belongs to the template or the class only...cannot go everywhere*******************

//create a new ArrayList that takes Product class( meaning constructor)******THAT IS ALSO THE TYPE; call it storeInventory. this is initializing that list
    static ArrayList<Product> storeInventory = new ArrayList<Product>();
//create a new ArrayList that takes Product class( meaning constructor)******THAT IS ALSO THE TYPE; call it cart; this is initializing that list
    static ArrayList<Product> cart = new ArrayList<Product>();
//scanner is a library for user input in the command line; this is initizalizing that library
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

    //initializing all of the products(using constructor method from Product class)
        Product shirt = new Product(" Shirt", 10, "Pink",1);
        Product pants= new Product(" Pants", 30, "Black", 2);
        Product shoes = new Product(" Shoes", 20, "White", 0);
        Product hats = new Product(" Hats", 20, "Balck", 3);
        Product socks= new Product(" Socks", 10, "White", 2);

        Product orange = new Product("orange", 5, "sunkist fruit",1);
        Product mango = new Product("mango", 5, "delicious",0);
        Product grapes = new Product("grapes", 5, "wine makers",1);
        Product apples = new Product("apple", 5, "keep the doctor away",1);
        Product apricot = new Product("apricot", 5, "questionable",2);

        Product donuts = new Product(" Donuts", 3, "Plain",0);
        Product cupcakes = new Product("Cupcakes", 4, "Blue Berry",2);
        Product chocolate = new Product("Chocolate", 2, "Kitkat",1);
        Product bacon = new Product(" Bacon", 4, "Spicy",1);
        Product coke= new Product(" Coke", 2, "Lemon",3);


    //initialzing new vendor
        Vendor walmart = new Vendor();
    //using addProduct method from Vendor class to add products to the new vendor
        walmart.addProduct(shirt);
        walmart.addProduct(pants);
        walmart.addProduct(shoes);
        walmart.addProduct(socks);
        walmart.addProduct(hats);

    //initialzing new vendor
        Vendor target = new Vendor();
    //using addProduct method from Vendor class to add products to the new vendor
        target.addProduct(orange);
        target.addProduct(mango);
        target.addProduct(apples);
        target.addProduct(apricot);
        target.addProduct(grapes);

    //initialzing new vendor 
        Vendor kroger = new Vendor();
    //using addProduct method from Vendor class to add products to the new vendor
        kroger.addProduct(donuts);
        kroger.addProduct(cupcakes);
        kroger.addProduct(bacon);
        kroger.addProduct(chocolate);
        kroger.addProduct(coke);


    //for each loop ( : signifies the 'each' for 'each' index) over vendorList for walmart (made by Products constructor and individual products are called pro(variable))
        for(Product pro: walmart.getVendorList()){
    //if statement says if the quantity of the product does not = 0 then move that product to storeInventory ArrayList;
            if(pro.quantity!=0){
    //.add method is a default java method; pro is the variable for product which is being passed by the add method to storeInventory
                storeInventory.add(pro);
            }
        }

    //for each loop ( : signifies the 'each' for 'each' index) over vendorList for walmart (made by Products constructor and individual products are called pro(variable))
        for(Product pro: kroger.getVendorList()) {
    //if statement says if the quantity of the product does not = 0 then move that product to storeInventory ArrayList;
            if (pro.quantity != 0) {
    //.add method is a default java method; pro is the variable for product which is being passed by the add method to storeInventory
                storeInventory.add(pro);
            }
        }

    //for each loop ( : signifies the 'each' for 'each' index) over vendorList for target (made by Products constructor and individual products are called pro(variable))
        for(Product pro: target.getVendorList()) {
    //if statement says if the quantity of the product does not = 0 then move that product to storeInventory ArrayList;
            if (pro.quantity != 0) {
    //.add method is a default java method; pro is the variable for product which is being passed by the add method to storeInventory
                    storeInventory.add(pro);
                }
            }

//        System.out.println("==========================================");

    //initializing int variable; calling it status; setting it equal to 2 for reference in the while loop
        int status=2;

    //while loop looping through status cases; loop keeps running while status does not equal 5; when status equals 5 the loop will stop running
            while(status != 5){

    //asking for UI
                System.out.println("Please make a selection");

    //resetting the status variable to equal the scanner. the scanner object has inherited the method nextInt; will change the status to move to
    // the next integer
                 status = sc.nextInt();
    //switch statement displays the code (here it is methods) that is related to the integer; break signifies moving to the next integer(which we have called status)
                switch(status){
                    case 1: viewCart();
                        break;
                    case 2:availableInventory();
                        break;
                    case 3: addToCart();
                        break;
                    case 4: removeFromCart();
                        break;
                    case 5:checkOut();
                        break;
                }
            }
        }

    //methods created outside of main method to be used/referenced with the main class ( essentially global methods)
        public static void viewCart(){
    //for each loop ( : signifies the 'each' for 'each' index) that loops over the cart object made up of products(variable) from
    // the Product class and the constructor in that class
            for(Product product: cart)
                System.out.println("Name: " +product.name+ ", Price: $"+product.price);
        }
    //addToCart method
        public static void addToCart() {
    //set int value to 1 and calling it i
        int i=1;
    //for loop starts at index 1. loops through the whole storeInventory list(storeInventory.size()) and iterates one time after every loop
              for( i=1; i<storeInventory.size(); i++){
  //prints out the index of the storeInventory but prints the name instead of the index number(becuase of the name dot notation)
                  System.out.println(i+". "+storeInventory.get(i).name);
              }

            System.out.println("Please select inventory item");

    //user input moves scanner to next integer(nextInt())
            int input = sc.nextInt();
    //if statement uses java default get method (which takes user input) to the storeInventory list if the quantity of the item is greater
    // than 0; that item is added to the cart using java default add method (which takes previous step as argument)
          if (storeInventory.get(input).quantity > 0) {
              cart.add(storeInventory.get(input));
  //that item is removed from storeInventory list
              storeInventory.get(input).quantity--;
            }else
    //printed output if the item in storeInventory = 0
                System.out.println("Sorry. Item is out of stock. Check back later.");
      }

    //removeFromCart method
        public static void removeFromCart(){
    //set int and index variable to start loop
            int i=1;
    //for loop starts at index 1. loops through the whole storeInventory list(storeInventory.size()) and iterates one time after every loop
            for( i=1; i<storeInventory.size(); i++){
    //prints out the index of the storeInventory but prints the name instead of the index number(becuase of the name dot notation)
                System.out.println(i+". "+storeInventory.get(i).name);
            }

            System.out.println("Please select inventory item");
    //user input moves scanner to next integer(nextInt())
            int input = sc.nextInt();
    //java default remove method being passed the user input for the item to remove from the cart
            cart.remove(storeInventory.get(input));
    //incrementing the quantity back and moving the item in storeInventory
            storeInventory.get(input).quantity ++;
        }

    //available inventory method
        public static void availableInventory(){
    //for each loop ( : signifies 'each' for 'each' index) loop over storeInventory list which has items
    // (pro) from Product class(made by the constructor in Product class)
            for(Product pro: storeInventory){
    //if statement says if the quantity of item (pro) is greater than 0 print item(pro)
                if(pro.quantity>0)
                    System.out.println(pro.toString());
        }
    }

    //checkOut method
    public static void checkOut(){
    //set int to 0 and name it total
        int total = 0;
    //for each loop ( : signifies 'each' for 'each' index) loops over cart list which has items(product) from Product
    // class (made by the constructor in Product class)
        for(Product product: cart) {
    //prints product name and price to the command line
            System.out.println("Name: " + product.name + ", Price: $" + product.price);
    //increments the total variable to add and equal all prices of the products in cart
            total += product.price;
        }
    //print total
        System.out.println("Total: $"+total);
    //exit the program..... gracefully
        System.exit(0);
    }









}
