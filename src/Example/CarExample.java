package Example;

public class CarExample {
    String 車號="";
    int 目前速度;
    static int 速度=100;
    static void 顯示速度(){
        System.out.println("速度"+速度);
    }
    public static void main(String[] args) {
        顯示速度();//這樣的顯示結果有沒有覺得怪怪的
        CarExample car1=new CarExample();
        car1.車號="AAA";
        car1.目前速度=100;
        car1.顯示車號及速度();

        CarExample car2=new CarExample();
        car2.車號="BBB";
        car2.目前速度=200;
        car2.顯示車號及速度();
        速度=1000;
        顯示速度();
    }

    void 顯示車號及速度(){
        System.out.println("車號"+車號+":"+目前速度);

    }
}
