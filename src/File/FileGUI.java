package File;



import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class FileGUI {
    private Frame f;// 定義窗體
    private MenuBar bar;// 定義選單欄
    private TextArea ta;
    private Menu fileMenu;// 定義"檔案"和"子選單"選單
    private MenuItem openItem, saveItem, closeItem;// 定義條目"退出"和"子條目"選單項
    private FileDialog openDia, saveDia;// 定義"開啟 儲存"對話方塊
    private File file;//定義檔案

    FileGUI() {
        init();
    }

    //圖形使用者介面組建初始化
    public void init() {
        f = new Frame("Galesaur");//建立窗體物件
        f.setBounds(300, 100, 600, 500);//設定窗體位置和大小

        f.setVisible(true); //設定窗體可見
        bar = new MenuBar();// 建立選單欄
        ta = new TextArea();// 建立文字域

        fileMenu = new Menu("File");// 建立"檔案"選單

        openItem = new MenuItem("Open");//建立"開啟"選單項
        saveItem = new MenuItem("Save");//建立"儲存"選單項
        closeItem = new MenuItem("Exit");//建立“退出"選單項

        fileMenu.add(openItem);//將 開啟 選單項新增到 檔案 選單上
        fileMenu.add(saveItem);//將 儲存 選單項新增到 檔案 選單上
        fileMenu.add(closeItem);//將 退出 選單項新增到 檔案 選單上

        bar.add(fileMenu);//將檔案新增到選單欄上
        f.setMenuBar(bar);//將此窗體的選單欄設定為指定的選單欄.
        openDia = new FileDialog(f, "Open", FileDialog.LOAD);
        saveDia = new FileDialog(f, "Save", FileDialog.SAVE);
        f.add(ta);// 將文字域新增到窗體內
        myEvent();//載入事件處理
    }

    private void myEvent() {
        //開啟選單項監聽
        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openDia.setVisible(true); //顯得開啟檔案對話方塊
                String dirpath = openDia.getDirectory();//獲取開啟檔案路徑並且儲存
                String fileName = openDia.getFile();//獲取檔名並且儲存

                if (dirpath == null || fileName == null) //判斷路徑和檔案是否為空
                    return;
                else
                    ta.setText(null); //檔案不為空 清除原來檔案內容
                file = new File(dirpath, fileName); //建立新的路徑和名稱
                try {
                    BufferedReader bufr = new BufferedReader(new FileReader(file));//嘗試從檔案中讀東西
                    String line = null; //變數字串初始化為空
                    while ((line = bufr.readLine()) != null)
                        ta.append(line + "\r\n"); //顯示每一行內容
                    bufr.close();//關閉檔案

                } catch (FileNotFoundException e1) {
                    e1.printStackTrace(); // 丟擲檔案路徑找不到異常
                } catch (IOException e2) {
                    e2.printStackTrace();// 丟擲IO異常
                }
            }
        });

        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (file == null) {
                    saveDia.setVisible(true);//顯示儲存檔案對話方塊
                    String dirpath = saveDia.getDirectory();//獲取儲存檔案路徑並儲存到字串中。
                    String fileName = saveDia.getFile();////獲取打儲存檔名稱並儲存到字串中

                    if (dirpath == null || fileName == null)//判斷路徑和檔案是否為空
                        return;//空操作
                    else
                        file = new File(dirpath, fileName);//檔案不為空，新建一個路徑和名稱
                }
                try {
                    BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
                    String text = ta.getText();//獲取文字內容
                    bufw.write(text);//將獲取文字內容寫入到字元輸出流
                    bufw.close();//關閉檔案
                } catch (IOException e1) {
                    e1.printStackTrace();//丟擲IO異常
                }
            }
        });


        //窗體關閉監聽
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //退出選單項監聽
        closeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new FileGUI();
    }
}