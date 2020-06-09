import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckID {
    static BufferedReader keyin;

    public static void main(String[] args) throws IOException {
        char[] c;
        keyin = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            System.out.println("選擇功能,1:驗證身分證號碼有效性 2:依條件產生身分證號碼");
            String s=keyin.readLine();
            c=s.toCharArray();
//            c=   keyin.readline();
            System.out.println(s);
            switch (c[0]) {
                case '1':
                    verifyID();
                    break;
                case '2':
                    createID();
                default:
                    System.out.println("無效操作碼");
            }
            /*System.out.println("選擇功能,1:驗證身分證號碼有效性 2:依條件產生身分證號碼");

            System.out.print("請輸入身分證字號:");
            String s = keyin.readLine();

            *//* 檢查身分證字號長度 *//*
            if (s.length() != 10) {
                System.err.println("長度不正確");
                System.exit(0);
            }

            *//* 檢查身分證字號性別欄 *//*
            ch = s.charAt(1);
            if (ch < '1' || ch > '2') // if(ch !='1' && ch !='2')
            {
                System.err.println("性別欄不正確");
                System.exit(0);
            }

            *//*
             * 檢查第3~第10個字元 Character類別方法 isDigit()
             *//*
            for (int x = 2; x < 10; x++) {
                if (!Character.isDigit(s.charAt(x))) {
                    System.err.println("字元不正確");
                    System.exit(0);
                }
            }

            s = s.toUpperCase();
            ch = s.charAt(0);
            switch (ch) {
                case 'A':
                    n = 10;
                    break;
                case 'B':
                    n = 11;
                    break;
                case 'C':
                    n = 12;
                    break;
                case 'D':
                    n = 13;
                    break;
                case 'E':
                    n = 14;
                    break;
                case 'F':
                    n = 15;
                    break;
                case 'G':
                    n = 16;
                    break;
                case 'H':
                    n = 17;
                    break;
                case 'I':
                    n = 34;
                    break;
                case 'J':
                    n = 18;
                    break;
                case 'K':
                    n = 19;
                    break;
                case 'L':
                    n = 20;
                    break;
                case 'M':
                    n = 21;
                    break;
                case 'N':
                    n = 22;
                    break;
                case 'O':
                    n = 35;
                    break;
                case 'P':
                    n = 23;
                    break;
                case 'Q':
                    n = 24;
                    break;
                case 'R':
                    n = 25;
                    break;
                case 'S':
                    n = 26;
                    break;
                case 'T':
                    n = 27;
                    break;
                case 'U':
                    n = 28;
                    break;
                case 'V':
                    n = 29;
                    break;
                case 'W':
                    n = 30;
                    break;
                case 'X':
                    n = 31;
                    break;
                case 'Y':
                    n = 32;
                    break;
                case 'Z':
                    n = 33;
                default:
                    System.out.println("首字字元不正確");
                    System.exit(0);
            }

            // total=首字字元的權值
            total = n / 10 + (n % 10) * 9;
            System.out.println(total);
            char[] ID = s.toCharArray();
            int[] N = new int[9];
            for (int i = 1; i <= 9; i++) {
                N[i - 1] = Character.getNumericValue(ID[i]);
                total = total + N[i - 1] * (9 - i);
            }

            total = total + Character.getNumericValue(ID[9]);
            System.out.println(total);

            // total=total+其他字元的加權值

            if (total % 10 == 0) {
                System.out.println("是身分證字號");
            } else {
                System.out.println("不是身分證字號");
            }*/
        }

    }

    public static void verifyID() throws IOException {
        System.out.println("請輸入身分證字號:");
        char ch;
        int total = 0, n = 0;
        String s = keyin.readLine();

        /* 檢查身分證字號長度 */
        if (s.length() != 10) {
            System.err.println("長度不正確");
            System.exit(0);
        }

        /* 檢查身分證字號性別欄 */
        ch = s.charAt(1);
        if (ch < '1' || ch > '2') // if(ch !='1' && ch !='2')
        {
            System.err.println("性別欄不正確");
            System.exit(0);
        }

        /*
         * 檢查第3~第10個字元 Character類別方法 isDigit()
         */
        for (int x = 2; x < 10; x++) {
            if (!Character.isDigit(s.charAt(x))) {
                System.err.println("字元不正確");
                System.exit(0);
            }
        }

        s = s.toUpperCase();
        ch = s.charAt(0);
        switch (ch) {
            case 'A':
                n = 10;
                break;
            case 'B':
                n = 11;
                break;
            case 'C':
                n = 12;
                break;
            case 'D':
                n = 13;
                break;
            case 'E':
                n = 14;
                break;
            case 'F':
                n = 15;
                break;
            case 'G':
                n = 16;
                break;
            case 'H':
                n = 17;
                break;
            case 'I':
                n = 34;
                break;
            case 'J':
                n = 18;
                break;
            case 'K':
                n = 19;
                break;
            case 'L':
                n = 20;
                break;
            case 'M':
                n = 21;
                break;
            case 'N':
                n = 22;
                break;
            case 'O':
                n = 35;
                break;
            case 'P':
                n = 23;
                break;
            case 'Q':
                n = 24;
                break;
            case 'R':
                n = 25;
                break;
            case 'S':
                n = 26;
                break;
            case 'T':
                n = 27;
                break;
            case 'U':
                n = 28;
                break;
            case 'V':
                n = 29;
                break;
            case 'W':
                n = 30;
                break;
            case 'X':
                n = 31;
                break;
            case 'Y':
                n = 32;
                break;
            case 'Z':
                n = 33;
            default:
                System.out.println("首字字元不正確");
                System.exit(0);
        }

        // total=首字字元的權值
        total = n / 10 + (n % 10) * 9;
        System.out.println(total);
        char[] ID = s.toCharArray();
        int[] N = new int[9];
        for (int i = 1; i <= 9; i++) {
            N[i - 1] = Character.getNumericValue(ID[i]);
            total = total + N[i - 1] * (9 - i);
        }

        total = total + Character.getNumericValue(ID[9]);
        System.out.println(total);

        // total=total+其他字元的加權值

        if (total % 10 == 0) {
            System.out.println("是身分證字號");
        } else {
            System.out.println("不是身分證字號");
        }

    }

    public static void createID() throws IOException {
        System.out.print("身分證第一個字元");

        String s = keyin.readLine();

    }

}

