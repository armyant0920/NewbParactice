package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdvWindow extends BasicWindow {

    public AdvWindow() {
        super();

    }




    public static void main(String[] args) {
        BasicWindow bw=new BasicWindow();
        bw.setClosingMode(1);
        bw.createWindow();


        AdvWindow window = new AdvWindow();
        window.setParams("ADV",300,300,300,300,Color.BLUE,"Button");
        window.createWindow();
        /*3.EXIT_ON_CLOSE，关闭程序。（所有窗口和进程都会关闭）
         **2.DISPOSE_ON_CLOSE，只关闭本窗口。
         **1.HIDE_ON_CLOSE，只隐藏本窗口，不关闭。
         **0.DO_NOTHING_ON_CLOSE，不做任何事，点击关闭无效。*/
        window.setDefaultCloseOperation(3);

        ShowFlowLayout flow = new ShowFlowLayout();
        flow.setTitle("Flow");
        flow.setSize(500, 200);
        flow.setLocationRelativeTo(null);

        flow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        flow.setVisible(true);

        //===========================

        ShowGridLayout grid = new ShowGridLayout();

        grid.setTitle("GridLayout");

        grid.setSize(200, 125);

        grid.setLocationRelativeTo(null);

        grid.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        grid.setVisible(true);




    }


}
