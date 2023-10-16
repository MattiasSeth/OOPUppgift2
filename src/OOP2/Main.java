package OOP2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public Main (){
        Gym bestGymEver = new Gym();

        ArrayList<String> stringArray = new ArrayList<>();
        ArrayList<LocalDate> dateArray = new ArrayList<>();
        bestGymEver.readFile(stringArray,dateArray);
        bestGymEver.addCustomerFromFile(stringArray, dateArray);

        StringBuilder sb = bestGymEver.CustomerBuilder();
        bestGymEver.printCustomer(sb);

    }
    public static void main(String[] args) {

        Main m = new Main();
    }
}
