package Poker;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Card implements Comparable<Card> {
    private final String suitString[] = {"spade", "hearts", "diamond", "club"};
    private final String rankText[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private final String ruleType[] = {"BJ", "Tt"};
    private String currentRule = ruleType[0];


    //預設值黑桃A
    private int number = 0;
    private int suitNum = 0;


    public Card() {


//        this.number=1;
//        this.suitNum =0;
    }

    public void setRule(int i) {//考慮用這種方式
        try {
            this.currentRule = ruleType[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("輸入的值不再預設範圍內");
        }
    }

    public int getNumber() {
        return number;
    }

    public String getRankText() {

        return rankText[this.getNumber()];
    }

    public String getSuitText() {
        return suitString[this.getSuitNum()];
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Card(int number, int suitID) {
        this.number = number;
        this.suitNum = suitID;
    }

    public void setCard(int number, int suitID) {
        this.number = number;
        this.suitNum = suitID;

    }

    public int getSuitNum() {
        return suitNum;
    }

    public void setSuitNum(int i) {

        this.suitNum = i;
    }

    public double getValue() {

        if (currentRule == ruleType[0]) {


            return BlackJackRule.cardPoint(this);
        }
        return 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return number == card.number &&
                suitNum == card.suitNum;

    }

    @Override
    public int compareTo(Card o) {//這邊我改寫的compareTo直接是按點數和花色排序,在不同規則下要把特殊集合的放一起,就不適用了

        if (getNumber() > o.getNumber()) {//數字比較大直接return
            return 1;
        } else if (getNumber() == o.getNumber()) {//數字一樣比花色
            if (getSuitNum() > o.getSuitNum()) {
                return 1;
            } else if (getSuitNum() == o.getSuitNum()) {
                return 0;
            } else if (getSuitNum() < o.getSuitNum()) {
                return -1;
            }
        } else if (getNumber() < o.getNumber()) {
            return -1;
        }
        return 0;

    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + rankText[number] +
                ", suitNum=" + suitString[suitNum] +
                '}';
    }

/*    @Override
    public int hashCode() {
        return Objects.hash(number, suitNum, value);
    }*/
}

