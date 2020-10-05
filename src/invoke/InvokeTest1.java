package invoke;

import java.lang.reflect.Method;
import java.util.Scanner;

public class InvokeTest1 {


    public static void message() {
        System.out.println("輸入1=1打2/輸入2=2打1");
    }

    public int method01001(Integer param1, Integer param2) {
        return param1.intValue() + param2.intValue();
    }

    public String method01002(String str1, String str2, String str3) {
        return str1 + str2 + str3;
    }

    public String method01003() {
        return "沒有參數";
    }

    public static void main(String[] args) throws Exception {
        //
        String s[] = {"招式", "對象->或直接是方法名稱字串", "威力"};

        //範例1:知道某一不明型別的的物件有什麼method，可以直接叫用

        Object obj = new invoke();//假設從遠端取得物件時，例如rmi方式
        Class c = obj.getClass();//取得類別型別
        //getMethod(method名稱,[參數1型別,參數2型別...])

        Method m = c.getMethod("showStr", new Class[]{"".getClass(), "".getClass()});
        Method mm = c.getMethod("showStrss");
        System.out.println(m);//印出此method的名稱與參數型別
        System.out.println(mm);
        //invoke呼叫obj物件的mehtod，並將要傳給method的參數宣告為Object陣列傳入method,變數result為存取method回傳的結果
        Object result = m.invoke(c.newInstance(), new Object[]{"2,2,2", "333"});
        System.out.println(result);

        //上面寫了一堆，其實只等於下面這一行
        System.out.println("===" + new invoke().showStr("2,2,2", "333"));
        //
        Object o2 = new InvokeTest1();
        Class c2 = o2.getClass();
        Method m2 = c2.getMethod("method01003", null);
        Object test = m2.invoke(c2.newInstance(), null);
        System.out.println(test);
        //
        Unit unit1 = new Unit("Bill", 10, 5, true);
        Unit unit2 = new Unit("Amenda", 15, 4, true);

        while (true) {
            message();
            Scanner keyin = new Scanner(System.in);
            int i = keyin.nextInt();
            Unit Attacker = null;
            Unit Attacked = null;
            if (i <= 2) {
                if (i == 1) {
                    Attacker = unit1;
                    Attacked = unit2;
                } else if (i == 2) {
                    Attacker = unit2;
                    Attacked = unit1;
                }
                //if(Attacker.isAlive() && Attacked.isAlive())
                Attacker.attack(Attacked, 1.5);
                if (Attacked.isAlive()) {
                    System.out.println(Attacked.getName() + "目前的生命值為" + Attacked.getHP());
                }
            }
            if (i == 3) {
                unit1.recovery(10);
                //Class u=unit1.getClass();
                //Method heal = u.getMethod("recovery",int);
                //invoke呼叫obj物件的mehtod，並將要傳給method的參數宣告為Object陣列傳入method,變數result為存取method回傳的結果
                // heal.invoke(u.newInstance(), new Object[]{10});

            }
        }

    }


}


