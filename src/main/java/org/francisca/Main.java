package org.francisca;

import org.francisca.Models.*;
import org.francisca.Services.Inventory;
import org.francisca.Services.ManagerRole;
import org.francisca.Services.QueueClass;
import org.francisca.Services.StoreServices;

import java.util.ArrayList;
import java.util.List;


public class Main {
        public static void main(String[] args) {

            Users applicant = new Users("Moses", Roles.APPLICANT);
            Users manager = new Users("MD", Roles.MANAGER);
            ManagerRole hireApplicant = new ManagerRole();
            Users cashier = hireApplicant.canHire(20, "OND", applicant, manager);
            System.out.println(cashier);
            System.out.println(">".repeat(100));

            /*All products available in the store*/

           Inventory myInventory = new Inventory();
            System.out.println(myInventory.readingProducts());

            StoreServices newStore = new StoreServices();
            System.out.println("*".repeat(100));
            System.out.println("****************************CUSTOMERS IN STORE");

            System.out.println(">".repeat(100));
            System.out.println("details of items added to cart");
            //**************************** Customers added to cart *************************//
            Users customer1 = new Users("Donald Trump", 001, 3205, Roles.CUSTOMER);
            newStore.addProductToCart(customer1, "Banana", 5);
             newStore.addProductToCart(customer1, "whole wheat", 20);

            Users customer2 = new Users("Barrack Obama", 002, 4505, Roles.CUSTOMER);
            newStore.addProductToCart(customer2, "Carrot", 5);
            newStore.addProductToCart(customer2, "Banana", 8);

            Users customer3 = new Users("Bill Clinton", 003, 2500, Roles.CUSTOMER);
            newStore.addProductToCart(customer3, "Banana", 12);
            newStore.addProductToCart(customer3, "whole wheat", 12);
            newStore.addProductToCart(customer3, "carrot", 12);

            Users customer4 = new Users(" Joe Biden", 004, 2005, Roles.CUSTOMER);
            newStore.addProductToCart(customer4, "carrot", 25);
            newStore.addProductToCart(customer4, "whole wheat", 30);

            //******************************** ITEMS IN CUSTOMER CART ********************************//
            System.out.println(customer1.getName() + " " + customer1.getCart());

            System.out.println("*".repeat(100));

            System.out.println(customer2.getName() + " " + customer2.getCart());

            System.out.println("*".repeat(100));

            System.out.println(customer3.getName() + " " + customer3.getCart());

            System.out.println("*".repeat(100));

            System.out.println(customer4.getName() + " " + customer4.getCart());

            //********************************* IMPLEMENTING FIRST COME FIRST SERVE ***********************//
            QueueClass queue = new QueueClass();
            System.out.println("<".repeat(100));
            System.out.println("************************  FIRST COME FIRST SERVE");
            System.out.println("<".repeat(100));

            queue.addCustomerToQueueList(customer1);
            queue.addCustomerToQueueList(customer2);
            queue.addCustomerToQueueList(customer3);
            queue.addCustomerToQueueList(customer4);
            System.out.println("<".repeat(100));

            queue.printQueue();

            //************************* IMPLEMENTING PRIORITY QUEUE **************************//

            System.out.println("<".repeat(100));
            System.out.println("**************************** PRIORITY QUEUE ");
            System.out.println("<".repeat(100));

            //******************** Adding items to priority queue ****************************
            System.out.println("****************************ADDING CUSTOMER'S ITEMS TO QUEUE");
            queue.addProductToQueue(customer1);
            queue.addProductToQueue(customer2);
            queue.addProductToQueue(customer3);
            queue.addProductToQueue(customer4);
            //********************** Printing items base on priority *********************//
            System.out.println("<".repeat(100));
            System.out.println(" ******************************PRINTING ITEMS BASED ON PRIORITY");
            queue.printingWithPriorityQueue();

            System.out.println("*".repeat(100));

            StoreServices storeServices = new StoreServices(cashier, customer1);
            Thread thread0= new Thread(storeServices);

            StoreServices storeServices1 = new StoreServices(cashier, customer2);
            Thread thread1= new Thread(storeServices1);

            StoreServices storeServices2= new StoreServices(cashier, customer3);
            Thread thread2  = new Thread(storeServices2);

            StoreServices storeServices3= new StoreServices(cashier, customer3);
            Thread thread3  = new Thread(storeServices3);


            List<Thread> threads = new ArrayList<>();
            threads.add(thread0);
            threads.add(thread1);
            threads.add(thread2);
            threads.add(thread3);


            for(Thread tr:threads) {
              tr.start();


              try {
               Thread.sleep(5000);
              } catch (InterruptedException e) {
               System.out.println("interrupt");
              }
             }
       // System.out.println(myInventory.readingProducts());

        }

}