package LeetCode;

public class NodeList {//環狀鍊表
    Node first;
    Node last;

    int size;

    public void addNode(int i){
        Node newNode=new Node(i);
        if(first==null){
            first=newNode;
            first.right=first;
            first.left=first;

        }else {
            newNode.right = first;
            newNode.left
                    = first.left;
            first.left = newNode;
        }

        size++;
    }

    public boolean removeData(){



        return  true;
    }

    public boolean insertData(int data,int pos){

        Node newNNode;

        int index;

        if(pos==1){


        }
        return true;
    }

    public boolean addFirst(int data){
        Node newNode=new Node(data);

        newNode.right=first;
        newNode.left = first.left;
        Node current=first;//作為指標
        if(first==null){
            first=newNode;
            last=newNode;

        }else{//如果有第一筆資料
            newNode.right=first;
            first.left=newNode;
            first=newNode;
            first.left=last;
            last.right=first;
        }
        size++;

        return true;
    }

    public void removeFirst(){
        if(first==null){

            System.out.println("沒有資料");
        }else if(size==1){
            first=null;
            last=null;
            

        }


    }


    class Node{
    int value;
    Node left;
    Node right;
    Node(int i){
        this.value=i;
        this.left =null;
        this.right =null;


    }

    }

    public static void main(String[] args) {

    }

}
