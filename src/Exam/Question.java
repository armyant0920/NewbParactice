package Exam;

public class Question {
    private String qId;
    private String qDes;
    private String note;

    public void Test(){
        System.out.println("this is Test(Question)");
    }
    public Question(String qId, String qDes, String note) {
        this.qId = qId;
        this.qDes = qDes;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Question{" +
                "qId='" + qId + '\'' +
                ", qDes='" + qDes + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public void printQuestion(){
        System.out.println(this.getqId());
        System.out.println(this.getqDes());
        System.out.println(this.getNote());
    }
    public String getqId() {
        return qId;
    }

    public void setqId(String qId) {
        this.qId = qId;
    }

    public String getqDes() {
        return qDes;
    }

    public void setqDes(String qDes) {
        this.qDes = qDes;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
