package compare;

public class StudentData {
    private int studentClass;
    private String studentName;
    private int studentID;

    public StudentData(int studentClass, String studentName, int studentID) {
        this.studentClass = studentClass;
        this.studentName = studentName;
        this.studentID = studentID;
    }

    public int getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(int studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "StudentData{" +
                "studentClass=" + studentClass +
                ", studentName='" + studentName + '\'' +
                ", studentID=" + studentID +
                '}';
    }
}
