package org.francisca.Services;

import lombok.Getter;
import lombok.Setter;
import org.francisca.Models.Product;
import org.francisca.Models.Users;
import org.francisca.Models.customerDTO;

import java.util.*;

@Setter
@Getter
public class QueueClass {
    private Queue<Users> queueList = new LinkedList<>();
    public Queue<Users> priorityQueueList = new PriorityQueue<>();

    private Queue<customerDTO> carrotQueue = new PriorityQueue<>( new customerDTO());
    private Queue<customerDTO> barnQueue = new PriorityQueue<>(4, new customerDTO());
    private Queue<customerDTO> bananaQueue = new PriorityQueue<>(4, new customerDTO());
    private Queue<customerDTO> wholeWheatQueue = new PriorityQueue<>(4, new customerDTO());
    private Queue<customerDTO> potatoChipQueue = new PriorityQueue<>(4, new customerDTO());
    private Product product;
    private StoreServices storeServices;


    // ***************************** IMPLEMENTATION ONE(1) BASED FIRST COME FIRST SERVE **********************//

    public String addCustomerToQueueList(Users customer) {

        queueList.add(customer);
        return "added";
    }

    public String printQueue() {
        while (queueList.peek() != null) {
            System.out.println(queueList.poll() + " successful");
        }
        return "done";
    }

    // ***************************** IMPLEMENTATION ONE(1) BASED FIRST COME FIRST SERVE **********************//

    public String addProductToQueue(Users customer){
        String output="";
        for(Map.Entry<String, Product> entry: customer.getCart().entrySet()){
            if(entry.getKey().equalsIgnoreCase("carrot")){
                carrotQueue.add(new customerDTO(customer.getName(), entry.getValue().getItemName(), entry.getValue().getQuantity()));
                System.out.println(customer.getName() + "  " + entry.getValue().getItemName() + " added to queue");
                output = "item added";
            }
            if(entry.getKey().equalsIgnoreCase("whole wheat")){
                wholeWheatQueue.add(new customerDTO(customer.getName(), entry.getValue().getItemName(), entry.getValue().getQuantity()));
                System.out.println(customer.getName() + "  " +  entry.getValue().getItemName() + " added to queue");
                output = "item added";
            }
            if(entry.getKey().equalsIgnoreCase("banana")){
                bananaQueue.add(new customerDTO(customer.getName(), entry.getValue().getItemName(), entry.getValue().getQuantity()));
                System.out.println(customer.getName() + "  " +  entry.getValue().getItemName() + " added to queue");
                output = "item added";
            }
            if(entry.getKey().equalsIgnoreCase("potato chips")){
                potatoChipQueue.add(new customerDTO());
                System.out.println(customer.getName() + "  " +  entry.getValue().getItemName() + " added to queue");
                output = "item added";
            }
            else output = "item does not exist";

        }
        return output;
    }


 public String printingWithPriorityQueue() {
     while(!bananaQueue.isEmpty()){
         System.out.println(bananaQueue.poll());
     }
     while(!barnQueue.isEmpty()){
         System.out.println(barnQueue.poll());
     }
     while(!potatoChipQueue.isEmpty()){
         System.out.println(potatoChipQueue.poll());
     }
     while(!wholeWheatQueue.isEmpty()){
         System.out.println(wholeWheatQueue.poll());
     }
     while(!carrotQueue.isEmpty()){
         System.out.println(carrotQueue.poll());
     }
    return "done";
 }
}





