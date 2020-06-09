package TESTING;

import Exam.Multiple;
import Extends.Son;
import Poker.Card;
import Poker.Deck;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class ForTestOnly {



    public static void main(String[] args) {
        int x=100;
        int y=200;
        int z=x|y;
        System.out.printf("X=%d,二進制為%8s\n",x,Integer.toBinaryString(x));
        ;
        System.out.printf("Y=%d,二進制為%8s\n",y,Integer.toBinaryString(y));

        System.out.printf("Z=%d,二進制為%8s\n",z,Integer.toBinaryString(z));

        //
        Son son=new Son();

        System.out.println(son.firstName);
        System.out.println(son.getBankAccunt());
        System.out.println(son.getLastName());
        System.out.println(son.getMoney());
        //===========

        ArrayList<Integer> numbers=new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        List<Integer >arraylist =new ArrayList<>();
        arraylist.add(1);
        arraylist.add(0,2);
        System.out.println(arraylist);
        arraylist.addAll(numbers);
        System.out.println(arraylist);
        LinkedList<Integer> linklist =new LinkedList<>();
        linklist.add(1);

        linklist.add(1,3);
        linklist.addFirst(11);
        System.out.println(linklist);
        Integer removenum=11;
        linklist.remove(removenum);

        System.out.println(linklist);
        linklist.addAll(0,numbers);
        System.out.println(linklist);


        //============
        Integer i1=15;
        System.out.println(i1.equals(15));
        System.out.println(i1==15);
        Integer i2=new Integer(15);
        System.out.println(i1.equals(i2));
        System.out.println(i1==i2);
        i2=Integer.valueOf(15);
        System.out.println(i1.equals(i2));
        System.out.println(i1==i2);

        String s1="Java是一门伟大的程序设计语言，不论是移动端开发（Android）亦或是企业级开发（Spring Boot ，Java Web Application）Java都占据重要的地位。在风起云涌的计算机技术发展历程中，Java的身影随处可见，而且生命力极其强大。";

        String texts[]=s1.split("[，。]");
        for(String s:texts){
            System.out.println(s);
        }


//        String s2=String.valueOf(true);
//        System.out.println(s2+"is String:"+s2 instanceof String);
//        boolean bb=true;
//        int myBooleanInt=bb?1:0;
//        System.out.println(myBooleanInt);

        StringBuilder sb=new StringBuilder();
        sb.append(13465);
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        System.out.println(sb.toString());
        //set練習區

        Set set=new TreeSet();
        set.add("D");
        set.add("B");
        set.add("A");

        set.add("B");
        set.add("C");
        System.out.println(set.toString());

        Set set2=new HashSet();
        set2.add("D");
        set2.add("B");
        set2.add("A");

        set2.add("B");
        set2.add("C");
        set2.add("Z");
        set2.add("M");
        set2.add("N");
        set2.add("F");
        System.out.println("set2:"+set2.toString());


        sb.insert(3,"AAA");
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        System.out.println(sb.toString());
        //
        sb.replace(1,3,"BB");
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        System.out.println(sb.toString());
        char c='c';

        System.out.println((int)'c');



        Card card1=new Card(1,0);
        Card card2=new Card(1,0);
        System.out.println(card1.equals(card2));
        card2.setCard(2,0);
        System.out.println(card1.equals(card2));


        Card[]handDeck=new Card[5];
        for(int i=0;i<5;i++){
            int num=(int)(Math.random()*13);
            int spadeNum=(int)(Math.random()*4);
            Card card=new Card(num,spadeNum);
            handDeck[i]=card;

        }
        for(Card card:handDeck){
            System.out.println(card.toString());
        }
        System.out.println(handDeck);
        Arrays.sort(handDeck);
        for(Card card:handDeck){
            System.out.println(card.toString());

        }


    }
}
