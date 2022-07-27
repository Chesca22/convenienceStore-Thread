package org.francisca.Services;

import lombok.Getter;
import org.francisca.Models.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Inventory {

    public static List<Product> allProduct = new ArrayList<>();


    public List<Product> readingProducts() {

        String path = "/Users/decagon/IdeaProjects/Week-3/foodSalesList.csv";
        String line = "" ;
        try {
            BufferedReader myFile = new BufferedReader(new FileReader(path));
            while ((line = myFile.readLine()) != null) {
                String[] column = line.split(",");
                String category = column[0].toLowerCase();
                String name = column[1].toLowerCase();
                long quantity = Long.parseLong(column[2]);
                double price = Double.parseDouble(column[3]);
                if (getMatchIndex(name) >= 0) {
                    Product priKey = allProduct.get(getMatchIndex(name));
                    priKey.setQuantity(priKey.getQuantity() + quantity);
                } else {
                    allProduct.add(new Product(category.toLowerCase(), name.toLowerCase(), quantity, price));
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       // System.out.println(allProduct);
        return allProduct;
    }

    private static int getMatchIndex(String item) {
        for (Product ele : allProduct) {
            if (ele.getItemName().equalsIgnoreCase(item)) {
                return allProduct.indexOf(ele);
            }
        }
        return -1;
    }

    public void printProds() {
        for (Product ele : allProduct) {
            System.out.println(ele);
        }



    }

                    }

