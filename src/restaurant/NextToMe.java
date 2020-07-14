package restaurant;

import java.util.*;

public class NextToMe {
    private static int seatNum;
    private static Table table;
    private static Set<Integer> limitSeats;
    //private static int[] used;

    /**
     * 第一行為一個偶數 N（2<=N<=30），代表店裡的座位數，座位編號從 1 到 N
     * 第二行為一個數字 M（0<=M<=N），代表已經被佔走的座位數目
     * 接下來 M 行每一行都包含一個數字 A[i]，代表被佔走的座位編號
     * 解題以題目提供圖形,由左至右,從上到下的排序為基準,不做延伸變化
     * 其實我覺得這題有機會用二進位數解出來,懶得想
     */
    public static void main(String[] args) {

        while (true) {

            System.out.println("請輸入座位數量");
            seatNum = inputSeatNum();
            if (seatNum < 2 || seatNum % 2 != 0) {
                throw new InputMismatchException("請輸入>2偶數");
            }
            System.out.println("請輸入被占用的座號");

            limitSeats = inputLimits();
            table = new Table(seatNum, limitSeats);
            table.getResult();
        }

    }

    private static int inputSeatNum() {

        while (true) {
            System.out.println("plz input Integer");
            Scanner input = new Scanner(System.in);
            try {
                if (!input.hasNextInt()) {
                    throw new InputMismatchException("請輸入int整數");
                }
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private static Set<Integer> inputLimits() {
        Set<Integer> usedSeats = new TreeSet<>();
        System.out.println("請輸入被占用的座號,中間以\",\"隔開");
        Scanner input = new Scanner(System.in);
        String[] seats = input.nextLine().split(",");

        for (String s : seats) {
            Integer integer = Integer.parseInt(s);
            if (integer > seatNum || integer < 1) {
                throw new InputMismatchException("不得輸入小於1或大於座位上限的數");
            }
            usedSeats.add(Integer.parseInt(s));
        }
        System.out.println(usedSeats);
        return usedSeats;
    }


    static class Table {

        int seatNum;
        Set<Integer> usedSeat;

        public Table(int seatNum, Set<Integer> usedSeat) {
            this.seatNum = seatNum;
            for (Integer i : usedSeat) {
                if (i > seatNum || i < 1) {
                    throw new InputMismatchException("不得輸入小於1或大於座位上限的數");
                }
            }
            this.usedSeat = usedSeat;
        }

        public void getResult() {
            for (int i = 1; i < seatNum; i++) {
                if (!usedSeat.contains(i)) {//目前pick到的數不是被限制的
                    if (i % 2 != 0 && (!usedSeat.contains(i + 1) && i + 1 <= seatNum))
                        //先檢查橫向,如果為奇數位置,檢查下一個偶數位
                        System.out.printf("相鄰座位%d/%d\n", i, i + 1);
                    //檢查縱向相鄰位置
                    if (!usedSeat.contains(i + 2) && i + 2 <= seatNum)
                        System.out.printf("相鄰座位%d/%d\n", i, i + 2);
                }
            }
        }
    }

    static class Block{
        private int id;
        private int size;
        private boolean used;
        private Date enterTime;


    }
    static class Order{


    }
}


