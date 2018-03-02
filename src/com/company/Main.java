package com.company;

/* *************3 pillars of OOP
encapsulation
inheritance
polymorphism -> can call the same method (from a parent class) in a sub class but can customize the method behavior(known as method overriding) */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

            //create a ArrayList that takes Product
          static ArrayList<Product> storeInventory = new ArrayList<Product>();
          static ArrayList<Product> cart = new ArrayList<Product>();
          static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {


        //System.out.println("View Content");


	// write your code here
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

//        Product[] vendor_one = new Product[5];
//        vendor_one[0] = new Product("Shirt", 10, "Pink");
//        vendor_one[1] = new Product(" Pants", 30, "Black");
//        vendor_one[2] = new Product(" Shoes", 20, "White");
//        vendor_one[3] = new Product(" Hats", 20, "Balck");
//        vendor_one[4] = new Product(" Socks", 10, "White");
//
//        Product[] vendor_two = new Product[5];
//        vendor_two[0] = new Product("orange", 5, "sunkist fruit");
//        vendor_two[1] = new Product("mango", 5, "delicious");
//        vendor_two[2] = new Product("grapes", 5, "wine makers");
//        vendor_two[3] = new Product("apple", 5, "keep the doctor away");
//        vendor_two[4] = new Product("apricot", 5, "questionable");
//
//        Product[] vendor_three = new Product[5];
//        vendor_three[0] = new Product(" Donuts", 3, "Plain");
//        vendor_three[1] = new Product("Cupcakes", 4, "Blue Berry");
//        vendor_three[2]= new Product("Chocolate", 2, "Kitkat");
//        vendor_three[3]= new Product(" Bacon", 4, "Spicy");
//        vendor_three[4]= new Product(" Coke", 2, "Lemon");

//        for(int i = 0; i < vendor_one.length; i++){
//            System.out.println("Name: " +vendor_one[i].getName()+ ", Price: $"+ vendor_one[i].getPrice()+ ", Description: "+ vendor_one[i].getDescription());
//        }
//        for(int i = 0; i < vendor_two.length; i++){
//            System.out.println("Name: " +vendor_two[i].getName()+ ", Price: $"+ vendor_two[i].getPrice()+ ", Description: "+ vendor_two[i].getDescription());
//        }
//        for(int i = 0; i < vendor_three.length; i++){
//            System.out.println("Name: " +vendor_three[i].getName()+ ", Price: $"+ vendor_three[i].getPrice()+ ", Description: "+ vendor_three[i].getDescription());
//        }

        Vendor walmart = new Vendor();
        walmart.addProduct(shirt);
        walmart.addProduct(pants);
        walmart.addProduct(shoes);
        walmart.addProduct(socks);
        walmart.addProduct(hats);

        Vendor target = new Vendor();
        target.addProduct(orange);
        target.addProduct(mango);
        target.addProduct(apples);
        target.addProduct(apricot);
        target.addProduct(grapes);


        Vendor kroger = new Vendor();
        kroger.addProduct(donuts);
        kroger.addProduct(cupcakes);
        kroger.addProduct(bacon);
        kroger.addProduct(chocolate);
        kroger.addProduct(coke);


        //walmart.inventory();
        //kroger.inventory();
        //target.inventory();


        for(Product pro: walmart.getVendorList()){
            if(pro.quantity!=0){
                storeInventory.add(pro);

            }
        }
        for(Product pro: kroger.getVendorList()) {
            if (pro.quantity != 0) {
                storeInventory.add(pro);

            }
        }
        for(Product pro: target.getVendorList()) {
                if (pro.quantity != 0) {
                    storeInventory.add(pro);

                }
            }
//        System.out.println("==========================================");
//
//            for(Product pro: storeInventory){
//                System.out.println(pro.toString());
//            }

        int status=2;

            while(status != 5){
                System.out.println("Please make a selection");

                 status = sc.nextInt();


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

        public static void viewCart(){
            for(Product product: cart)
                System.out.println("Name: " +product.name+ ", Price: $"+product.price);
        }

        public static void addToCart() {
        int i=1;
              for( i=1; i<storeInventory.size(); i++){
                  System.out.println(i+". "+storeInventory.get(i).name);
              }
            System.out.println("got here!");
            System.out.println("Please select inventory item");
            int input = sc.nextInt();
            System.out.println("here too!");

          if (storeInventory.get(input).quantity > 0) {
              cart.add(storeInventory.get(input));
              storeInventory.get(input).quantity--;
            }else
                System.out.println("Sorry. Item is out of stock. Check back later.");
      }

        public static void removeFromCart(){
            int i=1;
            for( i=1; i<storeInventory.size(); i++){
                System.out.println(i+". "+storeInventory.get(i).name);
            }

            System.out.println("Please select inventory item");
            int input = sc.nextInt();
            cart.remove(storeInventory.get(input));
            storeInventory.get(input).quantity ++;
        }

        public static void availableInventory(){
            for(Product pro: storeInventory){
                if(pro.quantity>0)
                    System.out.println(pro.toString());
        }
    }

    public static void checkOut(){
        int total = 0;
        for(Product product: cart) {
            System.out.println("Name: " + product.name + ", Price: $" + product.price);
            total += product.price;
        }
        System.out.println("Total: $"+total);
        System.exit(0);
    }









}
