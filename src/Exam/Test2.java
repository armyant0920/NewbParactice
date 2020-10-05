package Exam;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test2 {
    static String sql_select_all = "select * from exam3";

    public static void main(String[] args) {
        try {
            Connection conn= DriverManager.getConnection("jdbc:mariadb://localhost:3306/exam_data","root",null);
if(conn!=null){
    System.out.println("connectOK");
    PreparedStatement preparedStatement = conn.prepareStatement(sql_select_all);
    ResultSet resultSet = preparedStatement.executeQuery();
List<ExamPOJO> examPOJOList=new ArrayList<>();
    while (resultSet.next()) {
        String ANS = resultSet.getString("ANS");
        String QID = resultSet.getString("QID");
        String QDES = resultSet.getNString("QDES");
        String OPTION_A = resultSet.getString("OPTION(A)");
        String OPTION_B = resultSet.getString("OPTION(B)");
        String OPTION_C = resultSet.getString("OPTION(C)");
        String OPTION_D = resultSet.getString("OPTION(D)");

        String NOTE = resultSet.getString("NOTE");
        ExamPOJO question = new ExamPOJO(ANS, QID, QDES, OPTION_A, OPTION_B, OPTION_C, OPTION_D, NOTE);
        examPOJOList.add(question);


    }
    for(ExamPOJO e:examPOJOList){
        System.out.println(e);
    }
    System.out.println(preparedStatement.getMaxRows());
conn.close();
}
        } catch (SQLException throwables){

            System.out.println("fail");
throwables.printStackTrace();
        }

    }
}
