package Extends;

public class GrandFather {
    private String firstName="first1";
    private String lastName="last1";
    private String bankAccunt="1111-2222-3333-4444";
    private int money=10000;

//    public AGrandFather() {
//
//    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBankAccunt(String bankAccunt) {
        this.bankAccunt = bankAccunt;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "GrandFather{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bankAccunt='" + bankAccunt + '\'' +
                ", money=" + money +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBankAccunt() {
        return bankAccunt;
    }

    public int getMoney() {
        return money;
    }
}
