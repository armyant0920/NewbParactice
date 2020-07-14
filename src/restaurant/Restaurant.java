package restaurant;

import java.util.*;

public class Restaurant {

    private static int MAX_SIZE = 10;
    private static int TABLE_NUM = 5;

    private static Menu menu;
    private static ArrayList<Table> tables;

    public static void main(String[] args) {
        try {
            menu = new Menu();
            menu.getMenu();
            menu.printMenu();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("============================");
        Collections.sort(menu.getMenuList());
        menu.printMenu();

        tables = new ArrayList<>();
        for (int i = 1; i <= TABLE_NUM; i++) {//加入五張桌子
            int size = Math.max(2, (int) (Math.random() * MAX_SIZE) + 1);//最小2,最大MAX_SIZE
            Table table = new Table(size, i);
            tables.add(table);

        }
        for (int i = 0; i < tables.size(); i++) {
            System.out.println(tables.get(i));
        }


        while (true) {

            System.out.println(
                    "1.產生客人團體\n" +
                            "2.特定桌號客人離開\n" +
                            "3.查詢特定桌號目前情形\n" +
                            "4.全桌面查詢");
            int num = inputInteger();
            switch (num) {

                case 1:
                    order();

                    break;
                case 2:
                    System.out.println("輸入桌號");
                    clearTable(inputInteger());
                    break;
                case 3:
                    int pick = inputInteger();
                    if (pick > tables.size() || pick < 1)
                        throw new InputMismatchException("請輸入合法桌號");

                    System.out.println(tables.get(pick));
                    break;
                case 4:

                    for (int i = 0; i < tables.size(); i++) {
                        System.out.printf("桌號%d有%d個座位,目前%s\n",
                                tables.get(i).getTableID(),
                                tables.get(i).getSize(),
                                (tables.get(i).isHold()) ? "被占用,入場時間" + tables.get(i).getEnterTime()
                                        : "尚未占用,上組客人離場時間" + tables.get(i).getLeaveTime());

                    }

                    break;

                default:
                    System.out.println("沒有對應的指令");


            }


        }
    }

    public static void order() {

        //為了符合效率,應該盡量找數量剛好的桌
        //int people=(int)(Math.random()*MAX_SIZE)+1;
        System.out.println("輸入此批客人數量");
        int people = inputInteger();
        System.out.printf("客人數量:%d", people);
        //Table table = null;
        List<Table> tempList = new ArrayList<>();
        for (Table t : tables) {
            if (!t.isHold() && t.getSize() >= people) {
                tempList.add(t);
            }
        }
        tempList.sort(Table::sortSize);
        if (!tempList.isEmpty()) {

            tempList.get(0).customerEnter();
            System.out.println("入座:+\n" + tempList.get(0));

        } else {
            System.out.printf("訪客人數%d,沒有可符合的桌位\n", people);
        }

   /*     for(int i=0;i<tables.size();i++){
            if(!tables.get(i).isHold() && tables.get(i).getSize()>=people){

                tables.get(i).customerEnter();
                table=tables.get(i);
                break;

            }

        }*/
    }

    public static void clearTable(int i) {
        if (i < 1 || i > tables.size()) {

            System.out.printf("請輸入1~%d的桌號\n", tables.size());
        } else {
            if (tables.get(i-1).isHold()) {
                tables.get(i-1).customerLeave();
                System.out.println("離場:+\n" + tables.get(i - 1));
            }


        }

    }

    private static int inputInteger() {

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
}
