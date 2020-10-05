package SwingTest;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
/*
 * 演示JComboBox的基本用法，以及事件響應
 */
public class JComboBoxBasicUseDemo extends JFrame{
    private static final long serialVersionUID = -8161981948004677531L;
    int DEFAULT_WIDTH = 600;
    int DEFAULT_HEIGHT = 400;
    private JLabel label;
    private JComboBox<String> faceCombo;
    private static final int FONTSIZE = 12;
    @SuppressWarnings("unused")
    public JComboBoxBasicUseDemo(){
        setTitle("JComboBoxDemo - www.itread01.com");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        //新增label
        label = new JLabel("歡迎來到itread01.com www.itread01.com");
        label.setFont(new Font("Serif",Font.PLAIN, FONTSIZE));
        add(label, BorderLayout.CENTER);
        //actionListener
        ActionListener actionListener = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() instanceof JComboBox){
                    @SuppressWarnings({ "unchecked", "rawtypes" })
                    JComboBox<String> comboBox = (JComboBox)e.getSource();
                    String fontName = comboBox.getSelectedItem().toString();
                    label.setFont(new Font(fontName, Font.PLAIN, FONTSIZE));
                    System.out.printf("%s%n", "actionPerformed called");
                }
            }
        };
        //popupMenuListener
        PopupMenuListener popupMenuListener = new PopupMenuListener() {
            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                System.out.println("下拉選單取消");
            }
            @SuppressWarnings("unchecked")
            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                System.out.println("下拉選單合上");
                JComboBox<String> source = (JComboBox<String>)e.getSource();
            }
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                System.out.println("下拉選單彈出");
            }
        };
        //itemListener
        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                // TODO Auto-generated method stub
                if(ItemEvent.SELECTED == arg0.getStateChange()){
                    String selectedItem = arg0.getItem().toString();
                    label.setFont(new Font(selectedItem, Font.PLAIN, FONTSIZE));
                    System.out.printf("new selected item : %s%n",selectedItem);
                }
                if(ItemEvent.DESELECTED == arg0.getStateChange()){
                    String selectedItem = arg0.getItem().toString();
                    System.out.printf("deselected item : %s%n",selectedItem);
                }
            }
        };
        //新增一個JComboBox
        faceCombo = new JComboBox<String>();
        faceCombo.setEditable(true);
        //faceCombo.addActionListener(actionListener);
        //faceCombo.addPopupMenuListener(popupMenuListener);
        faceCombo.addItemListener(itemListener);
        faceCombo.setEnabled(true);
        faceCombo.addItem("Serif");
        faceCombo.addItem("SansSerif");
        faceCombo.addItem("Monospaced");
        faceCombo.addItem("Dialog");
        faceCombo.addItem("DialogInput");
        add(faceCombo, BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //建立窗體並指定標題
        JComboBoxBasicUseDemo frame = new JComboBoxBasicUseDemo();
        //關閉窗體後退出程式
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //自動適配所有控制元件大小
        //frame.pack();
        //設定窗體位置在螢幕中央
        frame.setLocationRelativeTo(null);
        //顯示窗體
        frame.setVisible(true);
    }
}