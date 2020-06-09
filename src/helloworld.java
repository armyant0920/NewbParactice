import Tool.Mask;

import java.util.Scanner;

public class helloworld {
    public static void main(String[] args) {
        System.out.println("HelloWorld");
        Scanner input=new Scanner(System.in);
        System.out.println("輸入測試文字");
        String s=input.nextLine();
        System.out.println("輸入開始位置");
        int start=input.nextInt();
        System.out.println("輸入遮罩長度");
        int length=input.nextInt();
        System.out.println("輸入遮罩文字");
        String replace=input.next();
        char c=replace.charAt(0);

        System.out.println("遮蔽結果:"+Mask.hideMessage(s,start,length,c));

        //Mask mask=new Mask();


       //System.out.println(mask.hideMessage(s,start,length,c));
    }
}
