package org.francisca.Services;

import lombok.*;
import org.francisca.Interfaces.IStoreServices;
import org.francisca.Models.Product;
//import org.francisca.Models.Store;
import org.francisca.Models.Users;
//import org.francisca.Models.customerDTO;
import org.francisca.Models.customerDTO;
import org.francisca.Roles;

import java.util.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


    public class StoreServices implements IStoreServices, Runnable{
    private QueueClass queue;
    private Users cashier;
    private Inventory inventory = new Inventory();
    private customerDTO cust = new customerDTO();

    private  Users customer;
    private Product product;

    public  StoreServices(Users cashier, Users customer){
        this.cashier = cashier;
        this.customer = customer;
    }



    public boolean sell(Users cashier, Users customer) {
        double totalPrice = 0;
        double walletTotal = 0;
        boolean result = true;
        if (cashier.getRoles().equals(Roles.CASHIER) && customer.getRoles().equals(Roles.CUSTOMER)) {
        for(Map.Entry<String, Product> entry: customer.getCart().entrySet()){
            totalPrice += entry.getValue().getQuantity() * entry.getValue().getUnitPrice();
            if (customer.getWallet() >= totalPrice) {
                walletTotal = customer.getWallet() - totalPrice;
                  result = true;
            }
            else {
                        System.out.println(" Insufficient money in wallet");
                        result = false;
            }
            }
            printReceipt(customer,totalPrice, walletTotal);

        }
        else {
            System.out.println("NOT AUTHORIZED USER");
        }
//
   return result;
    }

    public String addProductToCart(Users customer , String productName , long quantityToBuy){
        String output = "";
        for (Product productInInventory : inventory.readingProducts()){
            if (productInInventory.getItemName().equalsIgnoreCase(productName)){
                if (productInInventory.getQuantity() >= quantityToBuy){
                    if (customer.getCart().containsKey(productName)){
                        Product duplicateProduct = customer.getCart().get(productName);
                        duplicateProduct.setQuantity(duplicateProduct.getQuantity() + quantityToBuy);
                        productInInventory.setQuantity(productInInventory.getQuantity() - duplicateProduct.getQuantity());
                        System.out.println(quantityToBuy + " more " + duplicateProduct.getItemName() + "has been added to cart");
                        output = "updated product";

                    }else{
                        customer.getCart().put(productName , new Product(productInInventory.getCategory() , productName , quantityToBuy , productInInventory.getUnitPrice()));
                        productInInventory.setQuantity(productInInventory.getQuantity() - quantityToBuy);
                        output = "product added";
                        System.out.println( quantityToBuy + " "+productName + " has been added to cart");
                    }
                }else{
                    output = "Out of Stock";
                }
            }else {
                output = "Product Not Found";
            }
        }
        return output;
    }



                public void printReceipt(Users customer, double totalPrice, double walletTotal) {


                for (Map.Entry<String, Product> entry : customer.getCart().entrySet()) {

                String si = "*********SHOPPING FOR ALL***********";
                System.out.println(si);
                System.out.println(     "Customer's Name: " + customer.getName() + "\n" +
                                 "Item Name: " + entry.getValue().getItemName()  + ",  Item quantity:  " + entry.getValue().getQuantity() + "\n" +
                               "TOTAL PRICE: =" + totalPrice + "\n"+
                            "WALLET BALANCE: = " + walletTotal + "\n"+
                            "Signed: " + cashier.getName() + " for company" +"\n"+
                            "THANKS FOR BUYING" );
            }

        }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    sell(cashier,customer);

    }
}