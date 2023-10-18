package OOP2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GymTest {

    Gym g = new Gym();
    Customer c = new Customer();
    Io i = new Io();


    @Test
    public void separateStringTest(){
        String inData = "7703021234, Alhambra Aromes";
        String expectedId = "7703021234";
        String expectedName = "Alhambra Aromes";
        String nameNotTrimed = " Alhambra Aromes";

        String[] stringArray=g.separateString(inData);

        Assertions.assertEquals(expectedId, stringArray[0]);
        Assertions.assertEquals(expectedName, stringArray[1]);
        Assertions.assertNotEquals(stringArray[0],nameNotTrimed);

        //System.out.println(stringArray[0]);
        //System.out.println(stringArray[1]);
    }

    @Test
    public void addCustomerTest()  {
        ArrayList<String> stringArray = new ArrayList<>();
        ArrayList<LocalDate> dateArray = new ArrayList<>();
        i.readFile(stringArray, dateArray);
        g.addCustomer(stringArray, dateArray);

        LocalDate expectedDate = LocalDate.of(2023, 3,23);
        String expectedName = "Greger Ganache";
        String expectedId = "7512166544";

        Assertions.assertEquals(expectedId, g.getCustomerId("Greger Ganache"));
        Assertions.assertEquals(expectedDate,g.getCustomerDate("7512166544"));
        Assertions.assertEquals(expectedName,g.getCustomerName("7512166544"));


    }

    @Test
    public void getCustoemrDateTest (){
        ArrayList<String> stringArray = new ArrayList<>();
        ArrayList<LocalDate> dateArray = new ArrayList<>();
        i.readFile(stringArray, dateArray);
        g.addCustomer(stringArray, dateArray);

        String idTest = "9110261234"; // Liu Lingren 2022-02-15
        String nameTest = "Hilmer Heur"; // 2019-08-18

        LocalDate liuDate = LocalDate.of(2022, 2,15);
        LocalDate hilmerDate = LocalDate.of(2019, 8,18);

        LocalDate liuDateResult = g.getCustomerDate(idTest);
        LocalDate hilmerDateResult = g.getCustomerDate(nameTest);

        Assertions.assertEquals(liuDateResult,liuDate);
        Assertions.assertEquals(hilmerDateResult,hilmerDate);

        String wrongName = "Didier Drogba";
        LocalDate wrongDate = g.getCustomerDate(wrongName);

        Assertions.assertEquals(wrongDate, null);

    }

    @Test
    public void checkMembershipStatus(){
        ArrayList<String> stringArray = new ArrayList<>();
        ArrayList<LocalDate> dateArray = new ArrayList<>();
        i.readFile(stringArray, dateArray);
        g.addCustomer(stringArray, dateArray);

        LocalDate ld = LocalDate.now();
        String customer1 = "Hilmer Heur"; // 2019-08-18
        String customer2 = "7805211234"; // 2023-08-04
        String customer3 = "Didier Drogba";

        boolean expectedboolean = false;
        boolean expectedboolean2 = true;
        boolean expectedboolean3 = false;

        boolean result = g.getMembershipStatus(customer1);
        boolean result2 = g.getMembershipStatus(customer2);
        boolean result3 = g.getMembershipStatus(customer3);

        Assertions.assertEquals(result,expectedboolean);
        Assertions.assertEquals(result2,expectedboolean2);
        Assertions.assertEquals(result3, expectedboolean3);

    }

    @Test
    public void gymMemberStringTest(){
        ArrayList<String> stringArray = new ArrayList<>();
        ArrayList<LocalDate> dateArray = new ArrayList<>();
        i.readFile(stringArray, dateArray);
        g.addCustomer(stringArray, dateArray);

        LocalDate ld = LocalDate.now();
        String expectedString = "Greger Ganache, 7512166544 "+ld;

        String result = g.memberToString("Greger Ganache");
        //System.out.println(expectedString);
        //System.out.println(result);

        Assertions.assertEquals(expectedString,result);
        Assertions.assertNotEquals(result,"7512166544");

    }

    @Test
    public void CatchNullPointerExceptionTest (){
        boolean result = g.getMembershipStatus(null);
        assertFalse(result);
        assertTrue(!result);
    }
}