package org.francisca.Services;

import org.francisca.Models.Product;
import org.francisca.Models.Users;
import org.francisca.Roles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreServicesTest {

    StoreServices store = new StoreServices();
    Product product = new Product();
    Users Franca = new Users("Franc", 001, 3000, Roles.CUSTOMER);

    Users Eunice = new Users("Eunice", 002, 2500,Roles.CUSTOMER);
    Users cashier = new Users("May", Roles.CASHIER);


    @Test
    //("Should return true when the customer has enough money in his wallet")
    void sellWhenNotEmpty() {
        Franca.setWallet(100);
        assertTrue(store.sell(cashier, Franca));
    }

    @Test
    void addProductToCart() {
        // testing for duplicated product in cart
        Inventory.allProduct.add(new Product("bars" , "carrot" , 90 , 9));
      //  Inventory.allProduct.add(new Product("cookies" , "Potato chips" , 20 , 9));
        String actualResult = store.addProductToCart(Inventory.allProduct, Franca, "carrot", 10);
        assertEquals("product added", actualResult);

    }



    @Test
    void sellTest() {
        //this returns true;
        Inventory.allProduct.add(new Product("bars" , "carrot" , 90 , 9));
        store.addProductToCart(Inventory.allProduct, Franca, "banana", 4);
        Boolean st = store.sell(cashier, Franca);
        assertTrue(st);
       // assertEquals(true, st);


    }

    @Test
    void sell() {
        // testing for the amount of money in customer's wallet, when no or less money in wallet
        Inventory.allProduct.add(new Product("bars" , "carrot" , 90 , 1.77));
        Users customer1 = new Users("franca", 1, 15.0, Roles.CUSTOMER);
        Product product = new Product("carrot", 20, 1.77);
        Boolean st = store.sell(cashier, customer1);
        assertTrue(st);

    }
}