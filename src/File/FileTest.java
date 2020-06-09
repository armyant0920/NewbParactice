package File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileTest {


    private static Object IOException;

    public static void main(String[] args) throws IOException {
        //檢查文件是否存在,不存在就create
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("輸入文件名稱");

            String s =input.nextLine()+".txt";

                    File file = new File(s);
            System.out.println(file.exists()?"exist":"not exist");
            if(!file.exists()){
                FileWriter fw=new FileWriter(s);
                fw.write("simple test file");
                fw.flush();
                fw.close();
                System.out.println("new file created ");
            }
            System.out.println("file size:"+file.length());
            System.out.println("readable:"+file.canRead());
            System.out.println("writeable:"+file.canWrite());
            System.out.println("is it a directory?"+file.isDirectory());
            System.out.println("is it a file?"+file.isFile());
            System.out.println("file is hidden?"+file.isHidden());
            System.out.println("file absolute path:"+file.getAbsolutePath());
            System.out.println("file last modified:"+new java.util.Date(file.lastModified()));
        }

    }
}
