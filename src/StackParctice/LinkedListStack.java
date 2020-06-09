package StackParctice;

import org.w3c.dom.Node;

import java.util.function.DoubleToIntFunction;

public class LinkedListStack {
    Node top;//堆疊頂端參考
    int size;

    LinkedListStack() {
        this.size = 0;
        this.top = null;

    }

    public void pushData(String s) {//押入元素
        Node newNode = new Node(s);
        newNode.next = top;//單向鏈狀結構末尾為null,在模擬statck的情況下,stack最底層的下一指向為null
        top = newNode;
        size++;


    }

    public void popData() {//彈出元素

        if (top != null) {
            System.out.println("pop:" + top.item);
            top = top.next;
            size--;
        } else {

            System.out.println("堆疊已空");
        }

    }

    public void peekItem() {
        if (top != null) {
            System.out.println("peek:" + top.item);
        } else {
            System.out.println("none");
        }

    }

    public void displayData() {
        Node current = top;
        if (top == null) {
            System.out.println("堆疊已空 ");
        } else {
            while (current != null) {
                System.out.print(current.item+"\t");
                current = current.next;

            }
            System.out.println();
            System.out.println("目前stack大小:"+size);
        }
    }


    class Node {
        String item;//儲存資料
        Node next;

        Node(String s) {
            this.item = s;
            this.next = null;
        }

    }

    public static void main(String[] args) {
        LinkedListStack stk=new LinkedListStack();
        stk.pushData("ADA");
        stk.pushData("LEON");
        stk.pushData("Sherry");
        stk.pushData("WILLION");
        stk.pushData("WELISKER");
        stk.peekItem();
        stk.displayData();




        stk.popData();
        stk.popData();
        stk.displayData();
        stk.popData();
        stk.popData();
        stk.displayData();
    }
}
