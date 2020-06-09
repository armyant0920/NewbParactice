package Efficiency;

import java.util.*;

public class Add_Reomve {
    static int size = 100000;
    static int times = 5;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("輸入要測試的筆數");
            size = input.nextInt();//自己定義筆數-->測驗開始
            System.out.println("測試筆數:" + size + ",測試開始");
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                nums.add(i);
            }
            Collection<Integer> arrayList = new ArrayList<>(nums);//ArrayList
            Collection<Integer> hashSet = new HashSet<>(nums);//HashSet
            //=======================================
            System.out.println("抓10個數字確認兩個集合都有資料");
            System.out.println("ArrayList first5");
            ArrayList<Integer> arrayList1 = (ArrayList) arrayList;
            for (int i = 0; i < 10; i++) {
                System.out.print(arrayList1.get(i) + ",");
            }
            System.out.println();
            System.out.println("HashSet random5");
            int checkTimes = 10;
            Iterator iterator2 = hashSet.iterator();
            while (iterator2.hasNext() && checkTimes > 0) {
                System.out.print(iterator2.next().toString() + ",");
                checkTimes--;
            }
            System.out.println();
            //===================================

            System.out.println("********ArrayList********");
            System.out.println(removeTimeTest(arrayList) + "millis");
            System.out.println("********hashSet********");
            System.out.println(removeTimeTest(hashSet) + "millis");

            System.out.println();
            times--;

        }
//        System.out.println(AddTest()+"millis");
//        System.out.println(ArrayListTest()+"millis");

    }


    public static long removeTimeTest(Collection<?> c) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            c.remove(i);
        }
        return System.currentTimeMillis() - start;//返回移除數據花的時間

    }

    public static long ArrayListTest() {
        long start = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);

        }
        return System.currentTimeMillis() - start;
    }
}
