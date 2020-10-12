package LeetCode;

import java.util.*;

public class Steal {

    public static void main(String[] args) {

        ArrayList<Item>items=new ArrayList<>();


        for(int i=0;i<10;i++){
            items.add(newItem());
        }

        System.out.println("先show目前清單");
        printList(items);

        System.out.println("照原始價值排");
        Collections.sort(items, Comparator.comparingDouble(Item::getValue).reversed());
        printList(items);

        System.out.println("重量權重排");
        Collections.sort(items,Comparator.comparingDouble(Item::calculateByWeight).reversed());
        printList(items);
    }
    static void printList(ArrayList<Item> items){
        for(int i=0;i<items.size();i++){
            System.out.println(items.get(i));
        }
        System.out.println("==============");

    }
    static Item newItem(){
        Random rnd=new Random();
        String name="item:";
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<5;i++){
            sb.append((char)rnd.nextInt(65)+27);
        }
        name.concat(sb.toString());
        double value=rnd.nextInt(100);
        double weight=rnd.nextDouble()*100;
        double size=rnd.nextDouble()*100;
        Item item=new Item(name,value,weight,size);
        return item;

    }


    static class Item{
        private String name;
        private double value;
        private double weight;
        private double size;
//        Item(){}


        public Item(String name, double value, double weight, double size) {
            this.name = name;
            this.value = value;
            this.weight = weight;
            this.size = size;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getValue() {
            return value;
        }
        public double calculateByWeight(){
            return value/weight;

        }
        public double calculateBySize(){
            return  value/size;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public double getSize() {
            return size;
        }

        public void setSize(double size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", value=" + value +
                    ", weight=" + weight +
                    ", size=" + size +
                    ",重量價值="+value/weight+
                    ",體積價值="+value/size+
                    '}';
        }
    }

    class Thief{

        private int maxCarry;
        private double overload;
        private double bagSize;

        //小偷策略,比較在重量限制 vs 大小限制下,哪個方案取得的value值最大
//      Arrays.asList()



    }
}
