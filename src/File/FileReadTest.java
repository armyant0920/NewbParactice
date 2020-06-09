package File;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

public class FileReadTest {
    //private static String[] columnName;
    private String[] columnName;
    public static void main(String[] args) throws IOException {
        FileReadTest Test=new FileReadTest();
        String path = "C:\\Users\\user\\OneDrive\\桌面\\測試文件\\MyCSV.csv";
        String text = "";
        ArrayList<String> rowData = new ArrayList<>();
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        while (br.ready()) {
            String s=br.readLine();
            text +=s;
            rowData.add(s);


        }
        fr.close();


        System.out.println(text);
        System.out.println("========================");
        for(int i=0;i<rowData.size();i++){

            if(i==0){
                Test.columnName=rowData.get(i).split(",");
                for(int j=0;j<Test.columnName.length;j++){
                    System.out.print("欄位"+j+Test.columnName[j]);
                }
                System.out.println("\n"+"*****************************************");

            }else{System.out.println("row:"+i+"="+rowData.get(i));}

        }
     /*   String textArray[]=text.split(",");
        for(String t:textArray){
        System.out.println(t);*/
    }


}

