package Extends;

public class FamilyTest {
    public static void main(String[] args) {
        Father father=new Father();
        Son son=new Son();
        //father.getBankAccunt();
        System.out.println("=====Father=====");
        System.out.println("Father中沒有覆寫toString方法,所以印出來的是GrandFather裡的內容");
        System.out.println("Father toString="+father.toString());
        System.out.println("覆寫了getFirstName方法,以取得Father類中的firstName值");
        System.out.println("Father's getFisrstName="+father.getFirstName());

        System.out.println("在Father中刻意沒有去覆寫getLastName,所以會印出GrandFather的lastName,雖然實際上在Father類中,同名變數LastName已變更");
        System.out.println("Father's getLastName="+father.getLastName());//
        System.out.println("承上,在Father中另外建構一個方法,回傳這個類中lastName變數實際的值");
        System.out.println("Father's showRealLastName="+father.showRealLastName());
        System.out.println("可以在一個類的方法中調用父類的方法,以達到預期的效果\n以此例來說,要表達的是grandFather及father的money總和," +
                "\n因此覆寫了father的getMoney,使他回傳的除了this.money,還包含super.getMoney()");
        System.out.println("Father's getMoney"+father.getMoney());//此方法中除了father自己的money,還呼叫了grandFather的getMoney
        System.out.println("=======Son=======");
        System.out.println("下例改寫Son的getMoney,除了son自己的Money,還繼承了father的getMoney,\n而father的getMoney又包含自己的money與grandFather的money");
        System.out.println("Son's getMoney"+son.getMoney());
        System.out.println("父類與子類本來就不應該存在作用相同,容易產生混淆的變數,\n上面舉極端例子在祖父子三個類中都設置了同樣名稱&作用的firstName&lastName");

        //不同存取權限
        System.out.println("public String firstName=\"First2\";\n" +
                "    protected String lastName=\"Last2\";\n" +
                "    String bankAccunt=\"4444-3333-2222-1111\";\n" +
                "    private int money=30000;");
        System.out.println();

        System.out.println();

        NotPublic n=new NotPublic();
        System.out.println(n.x);
        System.out.println(n.y);
        System.out.println(n.showTotal());
    }
}
