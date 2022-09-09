package org.francisca.Interfaces;

import org.francisca.Models.Users;

public interface IStoreServices {
    boolean sell(Users cashier, Users customer);

    String addProductToCart(Users customer , String productName , long quantityToBuy);

    void printReceipt(Users customer, double totalPrice, double walletTotal);

}
