package View;

import javax.swing.*;
import java.awt.*;


public class ShowFlowLayout extends JFrame {
    public ShowFlowLayout() {
        super.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        add(new JLabel("姓名:"));
        add(new JTextField(10));
        add(new JLabel("郵箱:"));
        add(new JTextField(10));
        add(new JLabel("電話:"));
        add(new JTextField(10));
    }
}



