package JTable;

import javax.swing.*;

public class JTableTest {

    public static void main(String[] args) {
        int total=0;
        String[] columnNames = {"英文","數字","中文"};
        Object[][] data =
                {
                        {"One", new Integer(1),"一"},
                        {"Two", new Integer(2),"二"},
                        {"Three", new Integer(3),"三"},
                        {"Four", new Integer(4),"四"},
                };

        JTable jtable=new JTable(data,columnNames);
        for(int i=0;i<jtable.getColumnCount();i++){
            System.out.print(jtable.getColumnName(i)+"\t");
        }
        System.out.println();
        for(int i=0;i<jtable.getRowCount();i++){

            for(int j=0;j<jtable.getColumnCount();j++){
                System.out.print(jtable.getValueAt(i,j)+"\t");
                if(j==1){
                    total+=(Integer)jtable.getValueAt(i,j);
                }
            }
            System.out.println();
        }
        System.out.println("total:"+total);


    }


}
