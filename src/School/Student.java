package School;

public class Student extends SchoolMember{

    private int studentID;//這個學號應該當流水號
    private int grade;
    private int myClass;
    private int seatID;//該學生目前座號
    public Student(String name, int age, String gender, int studentID, int grade, int myClass,int seatID) {
        super(name, age, gender);
        this.studentID = studentID;
        this.grade = grade;
        this.myClass = myClass;
        this.seatID=seatID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getMyClass() {
        return myClass;
    }

    public void setMyClass(int myClass) {
        this.myClass = myClass;
    }



    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    @Override
    public String getDesc() {
        String desc= super.getDesc();
        desc+="Student{" +
                "grade="+grade+
                ", myClass=" + myClass +
                ", seatID='" + seatID + '\'' +
                '}';
        return  desc;
    }

    @Override
    public String toString() {

        return "Student{" +
                "School="+super.SchoolName+
                ", name='" + super.name  +
                ",grade=" + grade +
                ", myClass=" + myClass +
                ", seatID='" + seatID + '\'' +
                '}';
    }
}
