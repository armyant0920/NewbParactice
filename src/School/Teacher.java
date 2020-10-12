package School;

public class Teacher extends Employee implements MyClass,Salary{

    private double bonus;//比如說預設全勤獎金為1000

    private double deduct;
    private boolean perfectAttendance=true;

    public Teacher(String name, int age, String gender, int monthlyPaid, String bankAccount) {
        super(name, age, gender, monthlyPaid, bankAccount);
    }
    //除了基本的學校成員都友的name/age/gender外,設定月薪及全勤獎金基數


    public boolean isPerfectAttendance() {
        return perfectAttendance;
    }

    public void setPerfectAttendance(boolean perfectAttendance) {
        perfectAttendance = perfectAttendance;
        System.out.println("本月全勤:"+this.perfectAttendance);
    }

    public int getMonthlyPaid() {
        return monthlyPaid;
    }

    public void setMonthlyPaid(int monthPaid) {
        this.monthlyPaid = monthPaid;
        System.out.println("月薪設定為"+this.monthlyPaid);
    }

    public double getBonus() {

        if(perfectAttendance){
            return bonus;

        }
        return 0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getDeduct() {
        return deduct;
    }

    public void setDeduct(double deduct) {
        this.deduct = deduct;
    }



    @Override
    public double getSalary() {
        int total=0;
        System.out.println(super.monthAttendanceReport());
        if(super.perfectAttendance){
            total+=bonus;
        }else{
            total+=super.monthlyPaid*((30-(personalLeave+sickLeave+unpaidLeave))/30);
        }



        return total;
    }

    @Override
    public void setAccount(int i) {

    }



    @Override
    public String getMyClass() {
        return null;
    }

    @Override
    public void setMyClass() {

    }
}
