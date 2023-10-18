package OOP2;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Io {

    private Scanner userInput = new Scanner(System.in);

    public String input () {
        System.out.println("Ange ditt namn eller personnummer:");
        String input = userInput.nextLine();

        return input;
    }

    public void readFile (ArrayList<String> stringArray, ArrayList<LocalDate> dateArray)  {

        try (Scanner sc = new Scanner(new File("C:\\Users\\harry\\IdeaProjects\\OOPUppgift2\\src\\Customer.txt")); ) {
            while (sc.hasNext()){
                String tempString = sc.nextLine();
                LocalDate date = LocalDate.parse(sc.nextLine());
                stringArray.add(tempString);
                dateArray.add(date);
            }
        } catch (FileNotFoundException e){
            System.out.println("Fel fil!");
        }
    }

    public void writePtFile(String nameIdDate, String path){
        try (PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));) {
            p.println(nameIdDate);
        }catch (IOException e) {
            System.out.println("Wrong file path!");
        }
    }


}
