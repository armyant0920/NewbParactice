package View;

public class TestOf1 {


    public static class Emp{

        private String name;
        private int score;

        public Emp(String name,int score){

            this.name=name;
            this.score=score;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }

    public static void main(String[] args) {

        Emp emp=new Emp("ABC",100);
        System.out.println(emp.name);
        System.out.println(emp.score);

        updateScore(emp.score);
        System.out.println(emp.score);
        updateName(emp);
        System.out.println(emp.name);

    }

    public static  void updateScore(int score){
        System.out.println("score="+score);
        score=60;
        System.out.println("score="+score);
    }

    public static void updateName(Emp emp){
        emp.name="DEF";
        System.out.println(emp.name);

    }
}
