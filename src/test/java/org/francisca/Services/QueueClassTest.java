package org.francisca.Services;

import org.francisca.Models.Product;
import org.francisca.Models.Users;
import org.francisca.Roles;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueClassTest {
   Inventory myInventory = new Inventory();
   StoreServices store = new StoreServices();
    QueueClass queueClass = new QueueClass();

    Users Franca = new Users("Franc", 001, 2500, Roles.CUSTOMER);
    Users Eunice = new Users("Eunice", 002, 1000, Roles.CUSTOMER);
    Users Thelma = new Users("Thelma", 003, 1500, Roles.CUSTOMER);
    Users Dorcas = new Users("Dorcas", 004, 2000, Roles.CUSTOMER);

    @Test

    void addCustomersToQueue() {

        assertEquals("added",queueClass.addCustomerToQueueList(Thelma));
        assertEquals("added",queueClass.addCustomerToQueueList(Eunice));
        assertEquals("added",queueClass.addCustomerToQueueList(Franca));
        assertEquals("added",queueClass.addCustomerToQueueList(Dorcas));
    }


    @Test
    void addToCustomerQueueList() {

        queueClass.addCustomerToQueueList(Franca);
        queueClass.addCustomerToQueueList(Eunice);
        queueClass.addCustomerToQueueList(Dorcas);

        assertEquals("done", queueClass.printQueue());
    }

    @Test

    void addProductToQueueWhenProductInStore() {
        store.addProductToCart(Franca, "carrot", 4);
        store.addProductToCart(Thelma, "carrot", 5);
        store.addProductToCart(Eunice, "carrot", 3);
        store.addProductToCart(Dorcas, "whole wheat", 4);

        assertEquals("item added",queueClass.addProductToQueue(Thelma));
        assertEquals("item added",queueClass.addProductToQueue(Eunice));
        assertEquals("item added",queueClass.addProductToQueue(Franca));
        assertEquals("item added",queueClass.addProductToQueue(Dorcas));
    }

    @Test
    void printingWithPriorityQueue() {
        store.addProductToCart(Franca, "carrot", 4);
        store.addProductToCart(Thelma, "carrot", 5);
        store.addProductToCart(Eunice, "carrot", 3);
        store.addProductToCart(Dorcas, "whole wheat", 4);

        queueClass.addCustomerToQueueList(Franca);
        queueClass.addCustomerToQueueList(Eunice);
        queueClass.addCustomerToQueueList(Thelma);
        queueClass.addCustomerToQueueList(Dorcas);

        assertEquals("done", queueClass.printingWithPriorityQueue());
    }




}