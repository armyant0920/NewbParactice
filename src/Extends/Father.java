package Extends;

public class Father extends GrandFather {

    private String firstName="First2";
    private String lastName="Last2";
    private String bankAccunt="4444-3333-2222-1111";
    private int money=20000;

    @Override
    public int getMoney() {
        return money+super.getMoney();
    }



    public Father() {

    }

    @Override
    public String getFirstName() {
        return firstName;
    }

//    @Override
//    public String toString() {
//        return "Father{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", bankAccunt='" + bankAccunt + '\'' +
//                ", money=" + money +
//                '}';
//    }
    public int showMoney(){
        return this.money+super.getMoney();

    }
    public String showRealLastName(){
        return this.lastName;

    }
}
