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

    Inventory inventory = new Inventory();

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
    void addingSameProductToCart() {
        // testing for duplicated product in cart
        String actualResult = store.addProductToCart(Franca, "carrot", 20);
        assertEquals("updated product", actualResult);

    }

    @Test
    void checkingOutOfStockProduct() {
        String actualResult = store.addProductToCart(Franca, "carrot", 500000);
        assertEquals("Out of Stock", actualResult);

    }



//    @Test
//    void sellTest() {
//        //this returns true;
//        store.addProductToCart(Franca, "banana", 4);
//        Boolean st = store.sell(cashier, Franca);
//        assertTrue(st);
//
//
//    }

    @Test
    void sell() {
        Users customer1 = new Users("franca", 1, 15.0, Roles.CUSTOMER);
        Boolean st = store.sell(cashier, customer1);
        assertTrue(st);

    }
}