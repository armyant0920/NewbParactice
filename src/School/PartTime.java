package School;

public class PartTime extends SchoolMember implements Salary{
    private double hours;//工作時數
    private int perHour;//時薪

    public PartTime(String name, int age, String gender) {
        super(name, age, gender);
    }

    public void setPerHour(int perHour) {
        System.out.println("更新前:"+this.perHour+"/perHour");
        this.perHour= perHour;
        System.out.println("改為:"+perHour+"/perHour");

    }

    public void setHours(double hours) {

        this.hours = hours;
        System.out.println("更新工作小時數:"+hours);

    }

    @Override
    public double getSalary() {

        System.out.println("目前時薪:"+perHour+"/目前工作時數:"+hours+"/累計薪資"+hours*perHour);
        return hours*perHour;//單純一點的情況,直接時數*時薪
    }

    @Override
    public void setAccount(int i) {

    }






}



