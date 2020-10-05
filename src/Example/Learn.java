package Example;

public class Learn {
    static  int a;
    public static void main(String[] args) {
        a=10;
        abc();
        System.out.println("3:a is "+a);

    }

    static void abc(){

        System.out.printf("1.:a is %d\n ",a);
        a=100;
        System.out.printf("2.:a is %d\n ",a);

    }

}
