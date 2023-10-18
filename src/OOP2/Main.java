package OOP2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public Main (){
        Gym bestGymEver = new Gym();
        Io io = new Io();

        ArrayList<String> stringArray = new ArrayList<>();
        ArrayList<LocalDate> dateArray = new ArrayList<>();
        io.readFile(stringArray,dateArray);

        bestGymEver.addCustomer(stringArray, dateArray);

        String userInputString = io.input();
        boolean gymMember = bestGymEver.getMembershipStatus(userInputString);

        if (gymMember){
            String temp = bestGymEver.memberToString(userInputString);
            io.writePtFile(temp, "C:\\Users\\harry\\IdeaProjects\\OOPUppgift2\\src\\PT_File.txt");
        }

    }
    public static void main(String[] args) {

        Main m = new Main();
    }
}
