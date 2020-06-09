package Exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Multiple extends Question {
    private String qOption[];
    private ArrayList<Integer> answers;

    public Multiple(String qId, String qDes, String note, ArrayList<Integer> answers, String... options) {
        super(qId, qDes, note);
        this.qOption = options;
        this.answers = answers;
//        qOption=new String[options.length];
//        for(int i=0;i<options.length;i++){
//        qOption[i]=}
    }

    @Override
    public void Test() {
        //super.Test();
        System.out.println("this is Test(Muliiple)");
    }

    @Override
    public String toString() {

        return super.toString() + "Multiple{" +
                "qOption=" + Arrays.toString(qOption) +
                "qAns=" + answers +
                '}';
    }

    @Override
    public void printQuestion() {
        super.printQuestion();
        for (String s : qOption) {
            System.out.println(s);
        }
    }

    public void shuffleOption() {
        String[] ans = new String[answers.size()];
        System.out.println("原答案:");
        for (int i = 0; i < answers.size(); i++) {
            System.out.print((char) (65 + i));
            ans[i] = qOption[i];

        }
        System.out.println();
        answers.clear();

        ArrayList<String> options = new ArrayList<>();
        for (String s : qOption) {
            options.add(s);
        }
        Collections.shuffle(options);
        for (int i = 0; i < qOption.length; i++) {
            qOption[i] = options.get(i);

        }
        for (int i = 0; i < ans.length; i++) {

            for (int j = 0; j < qOption.length; j++) {
                if (qOption[j] == ans[i]) {
                    answers.add(j);
                }
            }

        }
        Collections.sort(answers);
        System.out.println("新答案:");
        for (Integer i : answers) {
            System.out.print((char) (65 + i));
        }
        System.out.println();


    }

    public void showAnswer() {


    }

}
