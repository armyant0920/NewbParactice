package compare;



import School.Student;

import java.util.*;

public class DataTest {

    public static void main(String[] args) {
        Random rnd=new Random();
        ArrayList<Data> dataList=new ArrayList<>();
        for(int i=0;i<13;i++){
            int dataType=rnd.nextInt(3)+1;
            if(dataType==1){//就加入字串
                String s="這是文字"+i;
                Data data=new Data(s);
                dataList.add(data);
            }else if(dataType==2){//就加入到100內的隨機整數
                Data data=new Data(rnd.nextInt(100));
                dataList.add(data);

            }else if(dataType==3){//就加入浮點數
                Data data=new Data(rnd.nextDouble());
                dataList.add(data);
            }


        }
//        for(int i=1;i<=4;i++){
//            Random rnd=new Random();
//
//        }
//        for(int i=1;i<=4;i++){
//            double d=i+i*0.1;
//            Data data=new Data(d);
//            dataList.add(data);
//        }

        System.out.println(dataList.toString());
        System.out.println("==============我是無敵分隔線==============");
        Collections.sort(dataList);
        System.out.println(dataList.toString());

        System.out.println("==============我是無敵分隔線==============");
        Set<StudentData>studentSet=new HashSet<>();
        ArrayList<StudentData>studentlist=new ArrayList<>();

        for(int i=0;i<9;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<4;j++){
                sb.append((char)(rnd.nextInt(26)+97));
            }
            String studentName=sb.toString();
            int studentClass=rnd.nextInt(10)+1;
            int studentNumber=rnd.nextInt(40)+1;
            StudentData student= new StudentData(studentClass,studentName,studentNumber);
            studentlist.add(student);
            studentSet.add(student);
        }

        for(StudentData student:studentSet){
            System.out.println(student);
        }
        System.out.println("====原始List");
        for(StudentData student:studentlist){
            System.out.println(student);
        }
        System.out.println("====排序List");
        Collections.sort(studentlist,Comparator.comparingInt(StudentData::getStudentClass));
        for(StudentData student:studentlist){
            System.out.println(student);
        }
        System.out.println("====實作Comparator");
        Collections.sort(studentlist,new StudentComparator());
        for(StudentData student:studentlist){
            System.out.println(student);
        }



        System.out.println("==============我是無敵分隔線==============");
        ArrayList<StockData> stockList=new ArrayList<>();
        StockData data1=new StockData("鴻海",1111,123.4);
        StockData data2=new StockData("富邦",2222,456.7);
        StockData data3=new StockData("華碩",3333,789.0);
        StockData data4=new StockData("三陽",4444,0.123);
        StockData data5=new StockData("大同",5555,40.12);
        StockData data6=new StockData("美光",6666,80.99);
        StockData data7=new StockData("索尼",7777,60.456);
        StockData data8=new StockData("福特",8888,65.47);
        stockList.add(data1);
        stockList.add(data2);
        stockList.add(data3);
        stockList.add(data4);
        stockList.add(data5);
        stockList.add(data6);
        stockList.add(data7);
        stockList.add(data8);
        stockList.add(data8);
        System.out.println("==============依序加入=============");
        for(StockData data:stockList){
            System.out.println(data);
        }

        stockList.sort(StockData::compareToByName);

        System.out.println("==============按照股票名=============");
        for(StockData data:stockList){
            System.out.println(data);
        }
        System.out.println("==============股票名反序==============");
        stockList.sort(StockData::compareToByName2);

        for(StockData data:stockList){
            System.out.println(data);
        }

        System.out.println("==============股票價格排序==============");
        stockList.sort(StockData::compareByPrice);

        for(StockData data:stockList){
            System.out.println(data);
        }

        System.out.println("==============股票價格反排序==============");
        stockList.sort(StockData::compareByPrice2);

        for(StockData data:stockList){
            System.out.println(data);
        }
        System.out.println("==============lamda語法排ref==============");
        Collections.sort(stockList, Comparator.comparingInt(StockData::getStockRef));
        for(StockData data:stockList){
            System.out.println(data);
        }
        System.out.println("==============lamda語法反排ref==============");
        Collections.sort(stockList,(o1,o2)-> -o1.getStockRef()-o2.getStockRef());
        for(StockData data:stockList){
            System.out.println(data);
        }
        System.out.println("==============lamda語法排Int==============");
        Collections.sort(stockList,Comparator.comparingInt(StockData::getStockRef));
        for(StockData data:stockList){
            System.out.println(data);
        }

        System.out.println("==============lamda語法排==============");
        Collections.sort(stockList,Comparator.naturalOrder());
//        System.out.println(stockList);
//        Collections.sort(stockList);
//        System.out.println(stockList);
//
//        Collections.sort(stockList,StockData::compareToByName);

    }

    public static class StudentComparator implements Comparator<StudentData>{


        @Override
        public int compare(StudentData o1, StudentData o2) {
            int sort=0;
            int x=o1.getStudentClass()-o2.getStudentClass();
            if(x!=0){
                sort=(x>0)?1:-1;
            }else {
                x=o1.getStudentID()-o2.getStudentID();
                if(x!=0){
                    sort=(x>0)?2:-2;
                }


            }
            return sort;
        }

        @Override
        public Comparator<StudentData> reversed() {
            return null;
        }
    }
}
