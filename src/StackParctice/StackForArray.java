package StackParctice;

public class StackForArray {
    public String[] names=new String[10];//設定一個固定大小10的文字陣列
    public int index;//記錄stack層位置

    StackForArray(){
        index=0;//初始化時尚未加入資料,位置為0
    }

    public void pushData(String s){//加入資料方法
        if(index<=names.length){//如果目前所在位置尚未到達頂端,允許從最上方加入

            names[index]=s;
            System.out.printf("加入資料-->[%s]\n",s);

            index++;


        }else{
            System.out.println("堆疊已滿");

        }
    }

    public void popData(){
        //從頂端開始吐資料,原則上應該要把資料刪除,不過既然是模擬的話就意思到就好(因為用index控制,反正也無法訪問)
        if(index>0){
            index--;
            String s=names[index];
            System.out.printf("移除資料-->[%s]\n",s);
            names[index]="";

        }else{

            System.out.println("堆疊已空");
        }
    }
    public void peekData(){//pop只差在有沒有刪除,所以index不動就好
        if(index>0){
            String s=names[index-1];
            System.out.printf("peek-->[%d],資料為-->[%s]\n",index,s);


        }

    }

    public void displayData(){//顯示所有資料,debug用
        if(index>0){

            for(int i=index;i>0;i--){
                System.out.printf("stack-->[%d],資料為-->[%s]\t",i,names[i-1]);


            }
            System.out.println();
        }else{
            System.out.println("堆疊已空");
        }

    }

    public static void main(String[] args) {

        StackForArray stk=new StackForArray();
        stk.pushData("ADA");
        stk.pushData("LEON");
        stk.peekData();
        stk.displayData();

        stk.pushData("Sherry");

        stk.popData();
        stk.popData();
        stk.popData();
        stk.popData();
        stk.displayData();
    }

}
