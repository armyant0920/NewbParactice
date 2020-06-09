package School;

public abstract class Employee extends SchoolMember{

    protected String job;
    protected int monthlyPaid;
    protected boolean perfectAttendance=true;

    public boolean isPerfectAttendance() {
        return perfectAttendance;
    }

    public void setPerfectAttendance(boolean perfectAttendance) {
        this.perfectAttendance = perfectAttendance;
    }

    public Employee(String name, int age, String gender, int monthlyPaid, String bankAccount) {
        super(name, age, gender);
        this.monthlyPaid = monthlyPaid;
        this.bankAccount = bankAccount;
    }

    public int getMonthlyPaid() {
        return monthlyPaid;
    }

    public void setMonthlyPaid(int monthlyPaid) {
        this.monthlyPaid = monthlyPaid;
    }

    protected String bankAccount;//銀行帳戶
    protected double personalLeave;//事假天數
    protected double paidLeave;//有薪假
    protected double sickLeave;//病假
    protected double officialLeave;//公假
    protected double unpaidLeave;//無薪假
    protected double lateHours;//遲到時數

    //正職員工通常領月薪,如果有請假(非有薪假)則按照請假天數比例

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }



    public double getPersonalLeave() {
        return personalLeave;
    }

    public void setPersonalLeave(double personalLeave) {
        this.personalLeave = personalLeave;
    }

    public double getPaidLeave() {
        return paidLeave;
    }

    public void setPaidLeave(double paidLeave) {
        this.paidLeave = paidLeave;
    }

    public double getSickLeave() {
        return sickLeave;
    }

    public void setSickLeave(double sickLeave) {
        this.sickLeave = sickLeave;
    }

    public double getOfficialLeave() {
        return officialLeave;
    }

    public void setOfficialLeave(double officialLeave) {
        this.officialLeave = officialLeave;
    }

    public double getUnpaidLeave() {
        return unpaidLeave;
    }

    public void setUnpaidLeave(double unpaidLeave) {
        this.unpaidLeave = unpaidLeave;
    }

    public Employee(String name, int age, String gender) {
        super(name, age, gender);


    }



    protected String monthAttendanceReport(){
        if(personalLeave+paidLeave+sickLeave+unpaidLeave+lateHours>0){
            perfectAttendance=false;
        }

        return "Employee{" +super.name+
                ",遲到時數"+lateHours+
                ",personalLeave=" + personalLeave +
                ", paidLeave=" + paidLeave +
                ", sickLeave=" + sickLeave +
                ", officialLeave=" + officialLeave +
                ", unpaidLeave=" + unpaidLeave +
                ",totalLeave="+(personalLeave+paidLeave+sickLeave+unpaidLeave)+"days"+
                '}';


    }

    public abstract double getSalary();

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
    //正式員工含老師&公友





}
