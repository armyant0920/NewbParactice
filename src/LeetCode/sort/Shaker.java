package LeetCode.sort;

public class Shaker {

    public static void main(String[] args) {



    }

    public static  void sort(int[] arr){

        int i, temp, left = 0, right = arr.length - 1, shift = 0;
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
    }

}
