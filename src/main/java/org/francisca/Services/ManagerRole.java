package org.francisca.Services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.francisca.Models.Users;
import org.francisca.Roles;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ManagerRole {

    private  Roles roles;
    private Users users;



    public Users canHire(int age, String Qualification,  Users applicant, Users manager){

        if (manager.getRoles().equals(Roles.MANAGER) && (applicant.getRoles().equals(Roles.APPLICANT))){
            if (age >= 18 && age <= 35 && Qualification.equalsIgnoreCase("OND")) {
                System.out.println("congratulation! you are hired as the new cashier");
                return new Users(applicant.getName(), Roles.CASHIER);

            }
             else {
                System.out.println("Sorry you are not qualified");
                return  applicant;
             }
        }
        return applicant;
    }



}
