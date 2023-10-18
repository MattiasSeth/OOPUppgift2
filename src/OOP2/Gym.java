package OOP2;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Gym {

    private ArrayList<Customer> customerList = new ArrayList<>();

    public void addCustomer (Customer customer){
        customerList.add(customer);
    }


    public String[] separateString(String idName){
        String[] resultArray = idName.split(",");
        for (int i=0; i<resultArray.length; i++)
            resultArray[i] = resultArray[i].trim();
        return resultArray;
    }


    public void addCustomer(ArrayList<String> stringArray, ArrayList<LocalDate> dateArray){
        for (int i=0; i<stringArray.size(); i++){
            String[] tempArray = separateString(stringArray.get(i));
            Customer c = new Customer(tempArray[1],tempArray[0],dateArray.get(i));
            addCustomer(c);
        }
    }
    public String getCustomerId (String nameOrId){
        for (int i=0; i<customerList.size(); i++){
            if (customerList.get(i).getName().equalsIgnoreCase(nameOrId) || customerList.get(i).getId().equalsIgnoreCase(nameOrId)){
                return customerList.get(i).getId();
            }
        }
        return null;
    }
    public String getCustomerName (String nameOrId){
        for (int i=0; i<customerList.size(); i++){
            if (customerList.get(i).getName().equalsIgnoreCase(nameOrId) || customerList.get(i).getId().equalsIgnoreCase(nameOrId)){
                return customerList.get(i).getName();
            }
        }
        return null;
    }

    public LocalDate getCustomerDate (String nameOrId){  // retunerar medlemsdatum
        for (int i=0; i<customerList.size(); i++){
            if (customerList.get(i).getName().equalsIgnoreCase(nameOrId) || customerList.get(i).getId().equalsIgnoreCase(nameOrId)){
                return customerList.get(i).getMembershipDate();
            }
        }
        return null;
    }

    public boolean getMembershipStatus (String nameOrId){   // medlem, tidigare medlem, ej medlem
        try {
            LocalDate membershipDate = getCustomerDate(nameOrId);
            LocalDate ld = LocalDate.now();
            Period period = Period.between(membershipDate,ld);
            if (period.getYears() > 0){
                System.out.println("före detta kund");
                return false;
            }else {
                System.out.println("nuvarande medlem");
                return true;
            }

        }catch (NullPointerException e) {
            System.out.println("obehörig");
            return false;

        }
    }

    public String memberToString(String nameOrId) {
        String result = "";

        for (int i=0; i<customerList.size(); i++){
            if (customerList.get(i).getName().equalsIgnoreCase(nameOrId) || customerList.get(i).getId().equalsIgnoreCase(nameOrId)){
                LocalDate ld = LocalDate.now();
                result = customerList.get(i).getName()+", "+ customerList.get(i).getId() + " " +ld;
                break;
            }
        }
        return result;
    }
}
