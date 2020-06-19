package LeeCode;

import StackParctice.LinkedListStack;

import javax.swing.*;
import java.util.ArrayList;

public class ListData {
    //為了方便模擬,規定只能輸入>0的值,刪除特定
    final static int DEFAULT_SIZE=10;
    static int[]datas;
    int size;

    public ListData(){
        size=0;
        datas=new int[DEFAULT_SIZE];

    }



    public void removeData(int index){

        
    }

    public void addData(int value){
        if(size<=DEFAULT_SIZE){



        }else{

            System.out.println("超出預設容量");
        }


    }



    class Data{
        int value;
        int index;
    }

    public static void main(String[] args) {
        ListData mylist=new ListData();


    }

}
