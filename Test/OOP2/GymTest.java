package OOP2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

class GymTest {

    Gym g = new Gym();
    Customer c = new Customer();


    @Test
    public void testReadFile()  {
        String expectedString = "7703021234, Alhambra Aromes";
        LocalDate expectedDate = LocalDate.of(2023, 7, 1);

        String expectedString2 = "8906138493, Ida Idylle";
        LocalDate expectedDate2 = LocalDate.of(2018,3,7);


        ArrayList<LocalDate> dateArray = new ArrayList<>();
        ArrayList<String> stringArray = new ArrayList<>();

        g.readFile(stringArray,dateArray);
        System.out.println(stringArray.get(0));
        System.out.println(dateArray.get(0));

        Assertions.assertEquals(expectedString,stringArray.get(0));
        Assertions.assertEquals(expectedDate, dateArray.get(0));

        System.out.println(expectedString2);
        System.out.println(expectedDate2);

        Assertions.assertEquals(expectedString2,stringArray.get(8));
        Assertions.assertEquals(expectedDate2, dateArray.get(8));
    }


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

        System.out.println(stringArray[0]);
        System.out.println(stringArray[1]);
    }

    @Test
    public void addCustomerFromFileTest()  {
        ArrayList<String> stringArray = new ArrayList<>();
        ArrayList<LocalDate> dateArray = new ArrayList<>();

        g.readFile(stringArray, dateArray);
        g.addCustomerFromFile(stringArray, dateArray);

        StringBuilder test = new StringBuilder(
                "Name: Alhambra Aromes Date: 2023-07-01 Id: 7703021234\n" +
                "Name: Bear Belle Date: 2019-12-02 Id: 8204021234\n" +
                "Name: Chamade Coriola Date: 2018-03-12 Id: 8512021234\n" +
                "Name: Diamanda Djedi Date: 2023-01-30 Id: 7608021234\n" +
                "Name: Elmer Ekorrsson Date: 2022-11-07 Id: 7605021234\n" +
                "Name: Fritjoff Flacon Date: 2018-12-16 Id: 7911061234\n" +
                "Name: Greger Ganache Date: 2023-03-23 Id: 7512166544\n" +
                "Name: Hilmer Heur Date: 2019-08-18 Id: 5711121234\n" +
                "Name: Ida Idylle Date: 2018-03-07 Id: 8906138493\n" +
                "Name: Jicky Juul Date: 2020-09-27 Id: 9902149834\n" +
                "Name: Kadine Karlsson Date: 2019-01-09 Id: 4604151234\n" +
                "Name: Liu Lingren Date: 2022-02-15 Id: 9110261234\n" +
                "Name: Mitsuko Mayotte Date: 2019-12-22 Id: 7907281234\n" +
                "Name: Nahema Ninsson Date: 2023-08-04 Id: 7805211234\n" );

        StringBuilder result = g.CustomerBuilder();
        //g.printCustomer(result);
        //System.out.println(test);


        Assertions.assertEquals(result, test);
    }

    @Test
    public void getCustoemrDateTest (){
        ArrayList<String> stringArray = new ArrayList<>();
        ArrayList<LocalDate> dateArray = new ArrayList<>();
        g.readFile(stringArray, dateArray);
        g.addCustomerFromFile(stringArray, dateArray);

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
        g.readFile(stringArray, dateArray);
        g.addCustomerFromFile(stringArray, dateArray);

        LocalDate ld = LocalDate.now();
        String customer1 = "Hilmer Heur"; // 2019-08-18
        String customer2 = "7805211234"; // 2023-08-04
        String customer3 = "Didier Drogba";

        String expectedString1 = "före detta kund";
        String expectedString2 = "nuvarande medlem";
        String expectedString3 = "obehörig";

        String resultString1 = g.getMembershipStatus(g.getCustomerDate(customer1));
        String resultString2 = g.getMembershipStatus(g.getCustomerDate(customer2));
        String resultString3 = g.getMembershipStatus(g.getCustomerDate(customer3));

        Assertions.assertEquals(expectedString1,resultString1);
        Assertions.assertEquals(expectedString2,resultString2);
        Assertions.assertEquals(expectedString3, resultString3);

    }

}