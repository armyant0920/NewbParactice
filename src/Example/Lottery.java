package Example;

import java.util.*;

public class Lottery {
    private static int maxOne, maxTwo, pickNum;
    private static List<Integer> areaOne = new ArrayList<>();

    public static void main(String[] args) {
        init();
        while (true) {
            System.out.println("1.抽出一組號碼 2.開始新局 ");
            switch (getNumber()) {
                case 1:
                    System.out.println("抽出一組號碼");
                    lottery();
                    break;
                case 2:
                    System.out.println("開始新局");
                    init();
                    break;
            }
        }
    }

    static void init() {
        areaOne.clear();
        System.out.println("請輸入第一區號碼總數");
        maxOne = getNumber();
        System.out.println("請輸入取幾個號碼");
        pickNum = getNumber();
        System.out.println("請輸入第二區號碼總數");
        maxTwo = getNumber();

        for (int i = 1; i <= maxOne; i++) {
            areaOne.add(i);
        }
    }

    static void lottery() {
        Random rnd = new Random();
        List<Integer> removeList = new ArrayList<>();
        System.out.println("第一區號碼抽出:");
        for (int i = 0; i < pickNum; i++) {
            removeList.add(areaOne.get(rnd.nextInt(areaOne.size())));
            System.out.print("第" + (i + 1) + "個號碼:" + removeList.get(i) + "\t");
            areaOne.remove(removeList.get(i));
        }
        areaOne.addAll(removeList);
        System.out.println("");
        System.out.println("第二區號碼為" + (rnd.nextInt(maxTwo) + 1));
        
    }

    static int getNumber() {

        System.out.println("請輸入>0正整數");
        while (true) {
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()) {
                int x = input.nextInt();
                if (x > 0) {
                    return x;
                }
            }
            System.out.println("請檢查輸入");
        }
    }

}
