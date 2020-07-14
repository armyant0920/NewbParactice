package Example;

import java.util.*;

public class Popular {
    private static final int MAX_NAMETEXT = 5;


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int MAX_NUM;
        int MAX_SCORE;
        do {
            System.out.println("請輸入人數");


        } while (!input.hasNextInt());
        MAX_NUM = input.nextInt();

        do {
            System.out.println("請輸入分數上限");


        } while (!input.hasNextInt());
        MAX_SCORE=input.nextInt();




        Random rnd = new Random();
        ArrayList<Person> people = new ArrayList<>();

        for (int i = 0; i < MAX_NUM; i++) {

            people.add(new Person(createName(), rnd.nextInt(MAX_SCORE)+1));

        }
        System.out.println("先顯示一次一開始的名單"+people);//先顯示一次一開始的名單
        int maxLikes = Collections.max(people, Comparator.comparingInt(Person::getLikes)).getLikes();
        System.out.println("最高分是:"+maxLikes+",增加3個同分數的人進來");

        for (int i = 0; i <= 2; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append((char) (rnd.nextInt(27) + 65));
            for (int j = 0; j < rnd.nextInt(MAX_NAMETEXT); j++) {
                sb.append((char) (rnd.nextInt(27) + 97));
            }
            people.add(new Person(sb.toString(), maxLikes));


        }
        System.out.println("新的清單");
        System.out.println(people);
        System.out.println("印出所有最高分人選");
        for (Person p : people) {
            if (p.getLikes() == maxLikes) {
                System.out.println(p);
            }

        }
        System.out.println("=====end=====");


    }
    static String createName(){
        Random rnd=new Random();
        StringBuilder sb=new StringBuilder();
        sb.append((char) (rnd.nextInt(27) + 65));
        for (int j = 0; j <= rnd.nextInt(MAX_NAMETEXT)+1; j++) {
            sb.append((char) (rnd.nextInt(27) + 97));
        }
        return sb.toString();
    }

    static class Person {
        private String name;
        private int likes;

        Person(String name, int likes) {
            this.name = name;
            this.likes = likes;
        }

        public String getName() {
            return name;
        }


        public int getLikes() {
            return likes;
        }

        @Override
        public boolean equals(Object obj) {
            Person person=(Person)obj;
            return this.likes==person.getLikes();
        }

        @Override
        public String toString() {
            return "person{" +
                    "name='" + name + '\'' +
                    ", likes=" + likes +
                    '}';
        }
    }
}
