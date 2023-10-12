package Gym;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Readfile {


    // LocalDate ld = LocalDate.parse(sc.next());



    public void readFile (ArrayList<String> stringArray, ArrayList<LocalDate> dateArray) throws FileNotFoundException {

        try ( Scanner sc = new Scanner(new File("C:\\Users\\harry\\IdeaProjects\\OOPUppgift2\\src\\Customer.txt")); ) {
            while (sc.hasNext()){
                String tempString = sc.nextLine();
                LocalDate date = LocalDate.parse(sc.nextLine());
                stringArray.add(tempString);
                dateArray.add(date);
            }
        }
    }
}
