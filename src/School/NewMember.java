package School;

public class NewMember {

    public static void main(String[] args) {
        //二一大學王大明16歲Male學編1年級1班級3座號15
        SchoolMember people1=new Student("王大明",16,"Male",1,1,3,15);

        SchoolMember people2=new Teacher("王村姑",50,"Female",30000,"台銀123");

        SchoolMember people3=new PartTime("王小明",18,"Male");
        showInfo(people1);
        System.out.println("-------");
        Teacher teacher=(Teacher) people2;

        System.out.println("目前月薪:"+teacher.getMonthlyPaid());
        teacher.setBonus(1000);
        teacher.setUnpaidLeave(3);

        System.out.println("本月薪資結算"+teacher.getSalary());

        System.out.println("-------");
        showInfo(people3);
        PartTime pt=(PartTime) people3;
        pt.getSalary();

        pt.setHours(10.5);
        pt.setPerHour(200);

       pt.getSalary();



    }

    public static void showInfo(SchoolMember member){
        System.out.println(member.toString());


    }
}
