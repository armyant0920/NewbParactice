package restaurant;

import File.FileReadTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class Menu {
    private ArrayList<Food>menuList=new ArrayList<>();
    private static String[]columnName;
    public Menu() throws IOException {

    }
    public ArrayList<Food> getMenuList(){

        return menuList;
    }

    //Map<String,Integer>Menu=new HashMap<>();

    //讀取清單

    public void getMenu() throws IOException {



        String path = "C:\\Users\\user\\OneDrive\\桌面\\測試文件\\Menu.csv";
        String text = "";
        ArrayList<String> rowData = new ArrayList<>();
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        while (br.ready()) {
            String s = br.readLine();
            text += s;
            rowData.add(s);


        }
        fr.close();


        System.out.println(text);
        System.out.println("========================");
        for (int i = 0; i < rowData.size(); i++) {

            if (i == 0) {
                columnName = rowData.get(i).split(",");
                for (int j = 0; j <columnName.length; j++) {
                    System.out.printf("%15S|",columnName[j]);
                }
                System.out.println("\n" + "*****************************************");

            } else {
               String data[]=rowData.get(i).split(",");
               Food food=new Food(data[0],data[1],Integer.parseInt(data[2]));
               menuList.add(food);
               for(int j=0;j<data.length;j++){
                   String bigText="";
                   String regEx="[\\u4e00-\\u9fa5]";
                   Pattern p=Pattern.compile(regEx);
                   Matcher m=p.matcher(data[j]);
                   while(m.find()){
                       bigText+=" ";
                   }
                   //System.out.println(p.matches(regEx,data[j]));
                   System.out.printf("%-10S|",data[j]+bigText);//,中文%d個bigText.length()
               }
                System.out.println();

            }

        }


     /*   String textArray[]=text.split(",");
        for(String t:textArray){
        System.out.println(t);*/
    }

    public void printMenu(){

        for(Food food:menuList){
            System.out.println(food);

        }
    }
}



