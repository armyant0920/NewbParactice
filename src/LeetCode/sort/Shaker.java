package LeetCode.sort;

import java.util.Random;

public class Shaker {

    public static void main(String[] args) {
        Random rnd=new Random();
        int arr[]=new int[10];
        for(int i=0;i<arr.length;i++){

            arr[i]=rnd.nextInt(100);
            System.out.print("arr index "+i+"="+arr[i]+" ");
        }
        System.out.println();

        sortParactice(arr);

        for(int i=0;i<arr.length;i++){

            System.out.print("arr index "+i+"="+arr[i]);
        }



    }

    public static int[] sortParactice(int [] arr){

        //先練習傳統氣泡
        for(int i=0;i<arr.length;i++){

            for(int j=0;j<arr.length-1;j++){

                if(arr[j]>arr[j+1]){

                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }

        }
        return arr;


    }

    public static void sort2(int [] arr){

        int i,temp,left=0,right=arr.length-1,shift=0;
        while(left<right){//當左<右,表示還沒全排完
            for(i=left;i<right;i++){
                if(arr[i]>arr[i+1]){
                    temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    shift=i;
                }
            }
            right=shift;
            for(i=right;i>left;i--){
                if(arr[i]<arr[i-1]){
                    temp=arr[i];
                    arr[i]=arr[i-1];
                    arr[i-1]=temp;
                    shift=i;

                }

            }
            left=shift;

        }

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
