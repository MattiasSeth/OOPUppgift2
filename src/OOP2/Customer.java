package OOP2;

import java.time.LocalDate;

public class Customer {

    private String name;
    private String id;
    private LocalDate membershipDate;

    public Customer () {

    }

    public Customer (String name, String id, LocalDate membershipDate){
        setId(id);
        setName(name);
        setMembershipDate(membershipDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(LocalDate membershipDate) {
        this.membershipDate = membershipDate;
    }
}
