package Exam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test3 {
    static String sql_select_all = "select * from exam3";

    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        try {
             conn= DriverManager.getConnection("jdbc:mariadb://localhost:3306/exam_data","root",null);
            if(conn!=null){
                System.out.println("connectOK");
                preparedStatement = conn.prepareStatement(sql_select_all);
                ResultSet resultSet = preparedStatement.executeQuery();
                ResultSetMetaData metaData=resultSet.getMetaData();
//                List<ExamPOJO> examPOJOList=new ArrayList<>();
                for(int i=1;i<=metaData.getColumnCount();i++){
                    System.out.printf("資料:%S,%S,%S\n",metaData.getTableName(i),metaData.getColumnName(i),metaData.getColumnTypeName(i));
                }





                conn.close();
            }
        } catch (SQLException throwables){

            System.out.println("fail");
            throwables.printStackTrace();
        }
        finally {
            if(preparedStatement!=null){

                try {
                    preparedStatement.close();

                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();

                }catch (SQLException e){
                    e.printStackTrace();
                }
            }


        }

    }
}
