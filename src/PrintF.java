import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class PrintF {

    public static void main(String[] args) {
        int count = 999;
        double amount = 45.45;

        System.out.printf("count is %d and amount is %5.2f\n", count, amount);
        System.out.printf("%8d%8s%8.1f\n", 1234, "Java", 5.63);
        System.out.printf("%-8d%-8s%-8.1f\n", 1234, "Java", 5.63);




    }

}
