package OOP2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer c = new Customer();

    @Test
    public void datetTest () {
        String date = "2023-07-01";
        LocalDate expectedDate = LocalDate.of(2023, 7, 1);
        LocalDate inccorectDate = LocalDate.of(2022,1,23);

        LocalDate newDate = c.stringToDate(date);
        c.setMembershipDate(newDate);
        LocalDate result = c.getMembershipDate();

        Assertions.assertEquals(expectedDate,result);
        Assertions.assertNotEquals(result,inccorectDate);
        System.out.println(result);
    }

}