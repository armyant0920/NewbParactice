package LeeCode;

import java.text.SimpleDateFormat;

import java.util.*;


/**
 * @author Kevin
 */
public class Dichotomy {

    public static void main(String[] args) {


        while (true) {
            System.out.println("選擇測試方式:" + "\n" +
                    "1.使用int[]及自訂sort" + "\n" +
                    "2.使用ArrayList及Collections.sort" + "\n" +
                    "3.使用int[]及改良bubble");
            try {
                int x = inputInteger();
                if (x < 1 || x > 3) {
                    throw new InputMismatchException("無效的code");
                }
                test(x);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());

            }

        }
    }

    private static String getTime() {
        //純粹是拿來少打一些重複的取日期字串..
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("hh:mm:ss:SSS");
        return sd.format(date);


    }
    private static String converDate(Date date){
        SimpleDateFormat sd = new SimpleDateFormat("hh:mm:ss:SSS");
        return sd.format(date);
    }

    private static void bubble(int[] arr) {

//        如果想要保留原本的陣列,也可以考慮拷貝到區域變數,回傳int[],就可以做新舊比較
//        int[] copy=arr.clone();


        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {
                int temp;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }

//       return arr;
    }

    private static void test(int code) {

        int size;
        int target;
        Random rnd = new Random();

        System.out.println("輸入測試筆數");
        size = inputInteger();
        if (code == 1) {
            //輸入code=1,使用int[]測驗
            String sortFunc="int[]存取&氣泡排序";
            int arr[] = new int[size];
            for (int i = 0; i < arr.length; i++) {
//               因為使用最小數值作為基數,直接使用nextInt可能會出現溢位(即大於int上限2^31),
//               這也是我對自己這個做法最不滿意的部分,

                arr[i] = rnd.nextInt((int) Math.pow(2, 30));//退一萬步來說,只要加上基數後不超過2^31即可,所以上限可以抓到2^30
                if (rnd.nextInt() < 0) {
                    arr[i] *= -1;
                }
            }
            printArr(arr);
            System.out.println("資料新增完畢");
            Date start = new Date();



            bubble(arr);
            Date end = new Date();

            printArr(arr);

           countTime(sortFunc,start,end);

            while (true) {
                System.out.println("輸入搜尋目標");
                target = inputInteger();
                System.out.println("輸入:" + target);

                int result = search(arr, target);
                System.out.println(result);
                System.out.println((result != -1) ? "目標位置在" + result : "找不到");

            }

        } else if (code == 2) {
            String sortFunc="ArrayList排序";
            //code=2,使用Arraylist測驗
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                list.add(rnd.nextInt());
            }
            printList(list);
            System.out.println("資料新增完畢");
            Date start = new Date();

            list.sort(Comparator.naturalOrder());
            printList(list);
            Date end = new Date();

            countTime(sortFunc,start,end);

            while (true) {
                System.out.println("輸入搜尋目標");
                target = inputInteger();
                System.out.println("輸入:" + target);
                int result = list.indexOf(target);
                System.out.println((result != -1) ? "目標位置在" + result : "找不到");
            }
        } else if (code == 3) {
            String sortFunc="int[]存取&shaker排序";
            //輸入code=1,使用int[]測驗
            int arr[] = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rnd.nextInt((int) Math.pow(2, 30));
                if (rnd.nextInt() < 0) {
                    arr[i] *= -1;
                }
            }
            printArr(arr);
            System.out.println("資料新增完畢");
            Date start = new Date();

            shaker(arr);
            Date end = new Date();

            printArr(arr);
            countTime(sortFunc,start,end);

            while (true) {
                System.out.println("輸入搜尋目標");
                target = inputInteger();
                System.out.println("輸入:" + target);

                int result = search(arr, target);
                System.out.println(result);
                System.out.println((result != -1) ? "目標位置在" + result : "找不到");
            }
        }
    }

    private static void printArr(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && i % 5 == 0) {
                System.out.println();
            }
            System.out.printf("(%d)%s\t", i, arr[i]);
        }
        System.out.println();

    }

    private static void printList(List<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && i % 5 == 0) {
                System.out.println();
            }

            System.out.printf("(%d)%s\t", i, list.get(i));
        }
        System.out.println();
    }

    private static void shaker(int[] arr) {
//        long begin,end;
        int i, temp, left = 0, right = arr.length - 1, shift = 0;
//        begin=System.nanoTime();
        while (left < right) {
            for (i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    shift = i;
                }
            }
            right = shift;
            for (i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    shift = i;
                }
            }
            left = shift;
        }
//        end=System.nanoTime();
//        System.out.println("花費時間"+(end-begin)+"ns");
    }


    private static int search(int[] arr, int target) {
        int pos = -1;
        int searchArr[] = arr.clone();
        int base = searchArr[0];
        if (base < 0) {
            target = target + Math.abs(base);
            for (int i = 0; i < searchArr.length; i++) {
                searchArr[i] = searchArr[i] + Math.abs(base);
            }
        }
        System.out.println("基準數為:" + base);

        int left = 0, right = searchArr.length, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid >= searchArr.length) {
                return pos;
            }
            if (searchArr[mid] == target) {

                return mid;
            } else if (target < searchArr[mid]) {
                right = mid - 1;

            } else if (target > searchArr[mid]) {
                left = mid + 1;
            }
        }
        return pos;
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

    private static void countTime(String s,Date t1,Date t2){

        long diff = t2.getTime() - t1.getTime();
        System.out.printf("%s開始時間:%s\n",s,converDate(t1));
        System.out.printf("%s結束時間:%s\n",s,converDate(t2));
        System.out.printf("%s花費時間 %dms\n",s, diff);



    }


}
