package Exam;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForTest {

    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 3, 2, 9};

        for (int i : arr) {
            System.out.print(i);

        }
        System.out.println("============");
        Arrays.parallelSort(arr, 3, 6);
        for (int i : arr) {
            System.out.print(i);

        }
        System.out.println();

        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(1);
        answer.add(2);
        Multiple multiple = new Multiple("第一題", "題目敘述:~~~", "備註", answer, "選項A", "選項B", "選項C", "選項D");

        multiple.Test();
        multiple.printQuestion();

        System.out.println(multiple.toString());

        System.out.println("===============test1End==================");

        multiple.shuffleOption();

        System.out.println(multiple.toString());


//        QuestionConvertTest question=new QuestionConvertTest();
//        List<QuestionConvertTest.QuestionBean>
//        question.setQuestion();


        String sql_select = "select * from exam2";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/exam_data", "root", null);
            if (conn != null) {
                System.out.println("connectOK");
                PreparedStatement preparedStatement = conn.prepareStatement(sql_select);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {

                    String ANS = resultSet.getString("ANS");
                    String QID = resultSet.getString("QID");
                    String QDES = resultSet.getString("QDES");

                    String[] OPTION = resultSet.getString("OPTION").split(",");

                    String NOTE = resultSet.getString("NOTE");

                    for (String s : OPTION) {
                        System.out.println(s);
                    }
                }


            }
            conn.close();
        } catch (SQLException throwables) {
            System.out.println("連線失敗");
            throwables.printStackTrace();
        }


    }
}
