package MapPractice;

import java.util.Map;
import java.util.TreeMap;

public class MapData {

    public static void main(String[] args) {
        //map練習區



        Map<String,Integer>myMap=new TreeMap<>();
        myMap.put("AAA",1111);
        myMap.put("BBB",2222);
        myMap.put("CCC",3333);
        myMap.put("CCC",3333);
        myMap.put("CCC",4444);
        myMap.put("DDDD",4444);
        myMap.put("EEEE",4444);
        for(Map.Entry<String,Integer> entry:myMap.entrySet()){

            System.out.println(entry);
            System.out.println("key:"+entry.getKey()+"/value:"+entry.getValue());
            System.out.println(entry.hashCode());


        }
        System.out.println("=========================block=========================" +
                "");
        myMap.forEach((a,b)->{
            System.out.println(a+"/"+b);
        });
        /*
        如果用map的資料結構建立遊戲地圖圖層
         */


    }
}
