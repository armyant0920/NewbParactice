import java.util.*;

public class PrintF {

    public static void main(String[] args) {
        int count = 999;
        double amount = 45.45;

        System.out.printf("count is %d and amount is %5.2f\n", count, amount);
        System.out.printf("%8d%8s%8.1f\n", 1234, "Java", 5.63);
        System.out.printf("%-8d%-8s%-8.1f\n", 1234, "Java", 5.63);

        Random rnd=new Random();
        boolean TF;
        for(int i=1;i<=10;i++){
            TF=rnd.nextBoolean();
            System.out.printf("this is test:%d,result is %s\n",i,TF);

        }






    }

}
