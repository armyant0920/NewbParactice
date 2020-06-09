package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class BasicWindow extends JFrame implements WindowListener {

    String title = "123";
    int width = 300, height = 300;
    Color color = Color.yellow;
    String buttonText = "Test";
    int x = 0, y = 0;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BasicWindow() {//,GraphicsConfiguration gc

        //Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//        Rectangle bounds =gc.getBounds();
//        Dimension dimension=bounds.getSize();

        //frame使用windowListener監聽,預設Closing是System.exit(0)
        //addWindowListener(this);
        //JFrame則是window的子類,透過傳遞參數使關閉按鈕生效
        setSize(width, height);
        /*3.EXIT_ON_CLOSE，关闭程序。（所有窗口和进程都会关闭）
         **2.DISPOSE_ON_CLOSE，只关闭本窗口。
         **1.HIDE_ON_CLOSE，只隐藏本窗口，不关闭。
         **0.DO_NOTHING_ON_CLOSE，不做任何事，点击关闭无效。*/
       // this.setDefaultCloseOperation(3);


    }

    public  void setParams(String title,int x,int y,int width,int height,Color color,String buttonText) {
        this.title =title;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.buttonText = buttonText;
    }

    public void setClosingMode(int i){
        /*3.EXIT_ON_CLOSE，关闭程序。（所有窗口和进程都会关闭）
        **2.DISPOSE_ON_CLOSE，只关闭本窗口。
        **1.HIDE_ON_CLOSE，只隐藏本窗口，不关闭。
        **0.DO_NOTHING_ON_CLOSE，不做任何事，点击关闭无效。*/
        this.setDefaultCloseOperation(i);



    }

    public void createWindow() {//String title, int x, int y, int width, int height, Color color, String buttonText

        BasicWindow window = new BasicWindow();
        window.setTitle(title);//以最後一次設定進來的title為準
        //System.out.println(window.getTitle());
        Panel panel = new Panel();
        panel.setLocation(x, y);
        panel.setSize(width, height);
        panel.setBackground(color);
        Button b = new Button(buttonText);
        panel.add(b);
        window.add(panel);
        window.setVisible(true);
    }


    @Override

    //windowActivated()	處理視窗成為焦點視窗事件
    //windowClosed()	處理視窗關閉後事件
    //windowClosing()	處理視窗關閉中事件
    //windowDeactivated()	處理視窗失去焦點事件
    //windowDeiconified()	處理視窗取消最小化事件
    //windowIconified()	處理視窗最小化事件
    //windowOpened()	處理開啟視窗事件
    public void windowOpened(WindowEvent e) {

        System.out.println("windowOpened");

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("windowClosing");
        System.exit(0);//0代表正常退出,非零整數為異常,應該是可以自己寫不同異常碼出現情形及對應


    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("windowClosed");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("windowIconified");

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("windowDeiconified");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("windowActivated");

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("windowDeactivated");
    }


}
