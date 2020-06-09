package Exam;

public class ExamPOJO {
    private String ans;
    private String qid;
    private String qdes;
    private String option_A;
    private String option_B;
    private String option_C;
    private String option_D;
    private String note;


    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getQdes() {
        return qdes;
    }

    public void setQdes(String qdes) {
        this.qdes = qdes;
    }

    public String getOption_A() {
        return option_A;
    }

    public void setOption_A(String option_A) {
        this.option_A = option_A;
    }

    public String getOption_B() {
        return option_B;
    }

    public void setOption_B(String option_B) {
        this.option_B = option_B;
    }

    public String getOption_C() {
        return option_C;
    }

    public void setOption_C(String option_C) {
        this.option_C = option_C;
    }

    public String getOption_D() {
        return option_D;
    }

    public void setOption_D(String option_D) {
        this.option_D = option_D;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ExamPOJO() {
    }

    @Override
    public String toString() {
        return "ExamPOJO{" +
                "ans='" + ans + '\'' +
                ", qid='" + qid + '\'' +
                ", qdes='" + qdes + '\'' +
                ", option_A='" + option_A + '\'' +
                ", option_B='" + option_B + '\'' +
                ", option_C='" + option_C + '\'' +
                ", option_D='" + option_D + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public ExamPOJO(String ans, String qid, String qdes, String option_A, String option_B, String option_C, String option_D, String note) {
        this.ans = ans;
        this.qid = qid;
        this.qdes = qdes;
        this.option_A = option_A;
        this.option_B = option_B;
        this.option_C = option_C;
        this.option_D = option_D;
        this.note = note;
    }
}
