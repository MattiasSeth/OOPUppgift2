package OOP2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class Gym {

    private ArrayList<Customer> customerList = new ArrayList<>();

    public void addCustomer (Customer customer){
        customerList.add(customer);
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

    public String[] separateString(String idName){
        String[] resultArray = idName.split(",");
        for (int i=0; i<resultArray.length; i++)
            resultArray[i] = resultArray[i].trim();
        return resultArray;
    }


    public void addCustomerFromFile (ArrayList<String> stringArray, ArrayList<LocalDate> dateArray){
        for (int i=0; i<stringArray.size(); i++){
            String[] tempArray = separateString(stringArray.get(i));
            Customer c = new Customer(tempArray[1],tempArray[0],dateArray.get(i));
            addCustomer(c);
        }
    }

    public StringBuilder CustomerBuilder(){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<customerList.size(); i++){
            sb.append("Name: " + customerList.get(i).getName() +" Date: " +customerList.get(i).getMembershipDate() + " Id: " + customerList.get(i).getId() + "\n");
        }
        return sb;
    }

    public void printCustomer (StringBuilder sb){
        System.out.println(sb);
    }

    public LocalDate getCustomerDate(String nameOrId){

        for (int i=0; i<customerList.size(); i++){
            if (customerList.get(i).getName().equalsIgnoreCase(nameOrId) || customerList.get(i).getId().equalsIgnoreCase(nameOrId)){
                return customerList.get(i).getMembershipDate();
            }
        }
        return null;
    }

    public String getMembershipStatus (LocalDate membershipDate){

        try {
            LocalDate ld = LocalDate.now();
            Period period = Period.between(membershipDate,ld);
            if (period.getYears() > 0){
                return "före detta kund";
            }else
                return "nuvarande medlem";

        }catch (NullPointerException e) {
            return "obehörig";

        }
    }


}
