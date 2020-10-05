package Example;

public class Learn2 {
    int a=1;
    public static void main(String[] args) {
        Learn2 instance = new Learn2();
        instance.abc();

        Test t1=new Test();

        System.out.println("t1 is "+t1.num);
        t1.num+=1;
        System.out.println("t1 is "+t1.num);
        
        Test t2=new Test();
        System.out.println("t2 is "+t2.num);

    }

    void abc() {

        System.out.println("a is "+a);
    }

    static class Test{

        int num=1;
//        static int rad=2;
        public int showText(){

            return num;
        }

    }
}
