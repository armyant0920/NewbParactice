package Example;

/**
 * 計算質數
 *
 */
public class PrimeNum {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 1000) {
            if (i <= 2) {
                System.out.println(i);
            } else {
                int temp = 0;
                for (int j = 1; j <= i; j++) {
                    if (i % j == 0) {
                        temp++;
                        if (temp > 2) {
                            break;
                        }
                    }
                }
                if (temp == 2) {
                    System.out.println(i);

                }
            }

            i++;
        }

    }

}
