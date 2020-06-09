package View;

import javax.swing.*;
import java.awt.*;

public class ShowGridLayout extends JFrame {

    public ShowGridLayout(){

        setLayout(new GridLayout(3,2,5,5));
        add(new JLabel("姓名:"));

        add(new JTextField(8));

        add(new JLabel("郵箱:"));

        add(new JTextField(8));

        add(new JLabel("電話:"));

        add(new JTextField(8));


    }
}
