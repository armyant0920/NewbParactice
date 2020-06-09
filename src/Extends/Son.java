package Extends;

public class Son extends Father {


    public String firstName="First3";
    protected String lastName="Last3";
    String bankAccunt="xxxx-xxxx-xxxx-xxxx";
    private int money=30000;

    @Override
    public String getBankAccunt() {
        return bankAccunt;
    }

    @Override
    public void setBankAccunt(String bankAccunt) {
        super.setBankAccunt(bankAccunt);
    }

    @Override
    public int getMoney() {
        return super.getMoney()+this.money;

    }


}
