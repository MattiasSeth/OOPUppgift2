package OOP2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;

class ReadfileTest {

    /*
    Readfile rf = new Readfile();

    @Test
    public void testReadFile() throws FileNotFoundException {
        String expectedString = "7703021234, Alhambra Aromes";
        LocalDate expectedDate = LocalDate.of(2023, 7, 1);

        String expectedString2 = "8906138493, Ida Idylle";
        LocalDate expectedDate2 = LocalDate.of(2018,3,7);


        ArrayList<LocalDate> dateArray = new ArrayList<>();
        ArrayList<String> stringArray = new ArrayList<>();

        rf.readFile(stringArray,dateArray);
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

        String[] stringArray=rf.separateString(inData);

        Assertions.assertEquals(expectedId, stringArray[0]);
        Assertions.assertEquals(expectedName, stringArray[1]);

        Assertions.assertNotEquals(stringArray[0],nameNotTrimed);
    }
    */
}