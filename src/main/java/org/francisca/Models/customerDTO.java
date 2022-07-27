package org.francisca.Models;

import lombok.*;

import java.util.Comparator;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class customerDTO implements Comparator<customerDTO> {


private String customerName;
private String productName;
private long productQuantity;





    @Override
    public int compare(customerDTO o1, customerDTO o2) {
        return Long.compare(o2.getProductQuantity(), o1.getProductQuantity());
    }
}
