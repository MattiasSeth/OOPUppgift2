package OOP2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class IoTest {

    Io i = new Io();
    @Test
    public void testInput() {

        String simulatedInput = "Hilmer Heur";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Io io = new Io();
        String result = io.input();
        //System.out.println(result);
        System.setIn(System.in);

        Assertions.assertEquals("Hilmer Heur", result);
        Assertions.assertNotEquals("Jicky Juul", result);
    }

    @Test
    public void testReadFile()  {
        String expectedString = "7703021234, Alhambra Aromes";
        LocalDate expectedDate = LocalDate.of(2023, 7, 1);

        String expectedString2 = "8906138493, Ida Idylle";
        LocalDate expectedDate2 = LocalDate.of(2018,3,7);

        ArrayList<LocalDate> dateArray = new ArrayList<>();
        ArrayList<String> stringArray = new ArrayList<>();

        i.readFile(stringArray,dateArray);

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
    public void writePtFileTest (){
        String printString = "Bear Belle : 8204021234 : 2019-12-02";
        String printString2 = "Chamade Coriola - 2018-03-12 - 8512021234";
        String readString = "";
        String readString2 = "";
        String testPath = "C:\\Users\\harry\\IdeaProjects\\OOPUppgift2\\src\\PT_File.txt";

        i.writePtFile(printString, testPath);
        i.writePtFile(printString2, testPath);

        try (Scanner sc = new Scanner(new File(testPath)); ) {
            while (sc.hasNext()){
                readString = sc.nextLine();
                readString2 = sc.nextLine();
            }
        } catch (FileNotFoundException e){
            System.out.println("Fel fil!");
        }

        Assertions.assertEquals(printString,printString);
        Assertions.assertEquals(printString2,readString2);
    }
}