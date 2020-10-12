package School;

public class TestOfMember {

    public static void main(String[] args) {
        SchoolMember m1=new SchoolMember("m1",18,"male");
        SchoolMember m2=new Student("m2",20,"female",11111,80,3,10);
        System.out.println(m1.getDesc());
        System.out.println(m2.getDesc());
        Student student= (Student) m2;
        System.out.println(student.getDesc());
//        System.out.println(((Student)m2).getDesc());
        SchoolMember people2=new Teacher("王村姑",50,"Female",30000,"台銀123");
        System.out.println(((Teacher)people2).getSalary());
        Teacher teacher=(Teacher)people2;
        teacher.setUnpaidLeave(3);
        System.out.println(teacher.getSalary());
        System.out.println(((Teacher)people2).maxHours());

    }
}
