package org.francisca.Models;

import org.francisca.Roles;
import org.francisca.Services.ManagerRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ManagerRoleTest {
    Users applicant;
    Roles roles;
    Users manager;
    ManagerRole managerRole;



    @org.junit.jupiter.api.Test
    void canHire() {
        ManagerRole managerRole = new ManagerRole();
        applicant = new Users("Maryv", Roles.APPLICANT);
        manager = new Users("Manjo", Roles.MANAGER);
        Users tester = managerRole.canHire(20, "OND", applicant, manager);
        Assertions.assertEquals(applicant.getName(), tester);
        Assertions.assertEquals(applicant.getRoles(), tester);
    }

    @Test
    void testCanHire() {
        ManagerRole managerRole = new ManagerRole();
        applicant = new Users("Mark", Roles.APPLICANT);
        manager = new Users("Miles", Roles.MANAGER);
        Users tester1 = managerRole.canHire(16, "BSC", applicant, manager);
        Assertions.assertNotEquals(applicant.getName(), tester1);
        Assertions.assertNotEquals(applicant.getRoles(), tester1);
    }

}