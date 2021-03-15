package File;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadWebFile {


    public static void main(String[] args) {
        String path = "https://www.tsa.gov.tw/tsa/get_parkjason.aspx";
        try {
            java.net.URL url=new  java.net.URL(path);//設定URL物件
            int count=0;//
            Scanner input=new Scanner(url.openStream());
            while(input.hasNext()){
                String s=input.nextLine();
                System.out.println(s);
                count+=s.length();

            }
            System.out.println("this video size is "+count+"characters");
        } catch (java.net.MalformedURLException e) {
            System.out.println("Invalid URL");
            e.printStackTrace();
        }catch(IOException e){
            System.out.println("IOException");
        }

    }

}
