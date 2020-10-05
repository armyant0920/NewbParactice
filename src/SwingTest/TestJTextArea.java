package SwingTest;


import javax.swing.*;
import java.awt.*;

public class TestJTextArea extends JFrame {
    //定义组件
    JTextArea mTextArea;
    JScrollPane jsp;
    JPanel jpl;
    JComboBox jcb;
    JTextField jtf;
    JButton jb;

    public static void main(String[] args) {
        new TestJTextArea();
    }

    public TestJTextArea() {
        //创建组件
        mTextArea = new JTextArea();
        jsp = new JScrollPane(mTextArea);//为文本区域设置带滚动条
        jpl = new JPanel();
        String[] chatter = {"毛二", "蘑菇", "炮灰"};
        jcb = new JComboBox(chatter);//为下拉列表设置选项
        jtf = new JTextField(10);
        jb = new JButton("发送");//为按钮添加说明
        //添加组件
        jpl.add(jcb);
        jpl.add(jtf);
        jpl.add(jb);
        this.add(jpl);
        this.add(jpl, BorderLayout.SOUTH);
        //设置容器的基本属性
        this.setTitle("测试JTextAreaBY毛二");
        this.setIconImage(new ImageIcon("1_u012270113.jpg").getImage());
        this.setSize(300, 200);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);

    }
}

