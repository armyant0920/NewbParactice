package restaurant;

import java.util.Comparator;
import java.util.Date;

public class Table  {
    //這裡是以常規布局的餐廳思考,傳統店面大家隨便拉隨便坐的就不考慮了
    //如果是私人桌,入座、離開的時間可以一起算,一但某一組人進入,該桌不管剩多少空位都不允許其他人加入
    //同樣的,客人人數若大於該桌最大位子數,也沒辦法入坐
    private int size;
    private int tableID;//記錄桌號
    private boolean hold;//是否已經被占用
    private Date enterTime;//紀錄入座時間
    private Date leaveTime;//紀錄入座時間

    public Table(int size, int tableID) {//設定這張私人桌有多少位子,ID多少
        this.size = size;
        this.tableID = tableID;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public boolean isHold() {
        return hold;
    }

    public void setHold(boolean hold) {
        this.hold = hold;
    }

    public Date getEnterTime() {
        return enterTime;
    }
    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public void customerEnter() {
        hold = true;//目前被占用
        setEnterTime(new Date());//更新此桌客人入座時間

    }

    public void customerLeave() {
        if(isHold()){
            hold = false;
            leaveTime = (new Date());//更新此桌客人入座時間
        }else{
            System.out.println(getTableID()+"號桌目前沒有客人");
        }

    }

    @Override
    public String toString() {
        return "Table{" +
                "size=" + size +
                ", tableID=" + tableID +
                ", hold=" + hold +
                ", enterTime=" + enterTime +
                ", leaveTime=" + leaveTime +
                '}';
    }



    public int sortSize(Table t) {

        int result = getSize() - t.getSize();
        if (result != 0) {
            return result;
        } else {
            return tableID-t.tableID;
        }
    }
}
