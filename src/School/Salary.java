package School;

public interface Salary {
    //在interface裡面宣告"變數"應該沒意義,因為永遠不會實作,所以該變數只屬於這個class,無法在實例化後被修改
    //換言之等同於public static final的宣告,如果是要設定常數倒是可以

    public double getSalary();//取得薪資金額(考慮到因數可能會有小數點,回傳double// )
    public void setAccount(int i);//銀行帳戶

}
