package org.francisca.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Product {

    private String category;
    private String itemName;
    private long quantity;
    private double unitPrice;


    public Product(String itemName, long quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.unitPrice = price;
    }


    @Override
    public String toString() {
        return "\n" +"Product { " +
                "category= " + category +
                ", itemName= " + itemName  +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}' ;
    }


}
