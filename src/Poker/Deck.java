package Poker;

import Poker.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class Deck {

    private ArrayList<Card> deck;

    public Deck() {//創建一個空的arraylist牌庫
        this.deck = new ArrayList<>();
    }

    public void clearDeck(){//清空牌庫
        this.deck=null;
    }

    public Deck(ArrayList<Card> deck) {//用一副牌創建新牌庫(感覺上好像不太可能用到,複製就好了)
        this.deck = deck;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public void setDeck(int i, Card card) {//試想by index直接設定指定位置的牌
        if (deck.size() - 1 >= i && deck.get(i) != null) {
            deck.get(i).setCard(card.getNumber(), card.getSuitNum());

        }

    }

    public void newDeck() {
        deck = new ArrayList<>();
        for (int i = 0; i <= 12; i++) {//上限值考慮也用final=12,目前是撲克牌應該還不用考慮太遠
            for (int j = 0; j <= 3; j++) {
                Card card = new Card(i, j);
                deck.add(card);
                Integer integer=15;
                integer.equals(15);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
        deck.forEach(c-> System.out.println(c.getRankText()+"/"+c.getSuitText()));

//        for (Card c : deck) {
//            System.out.println(c.getRankText() + "/" + c.getSuitText());
//        }

    }

    public void sorting() {
        System.out.println("--整理前--");
        for (Card c : deck) {

            System.out.println(c.getRankText() + "/" + c.getSuitText());
        }

        for (int i = 0; i < deck.size(); i++) {
            for (int j = 0; j < deck.size() - 1; j++) {
                if (deck.get(j).getNumber() > deck.get(j + 1).getNumber()) {
                    Collections.swap(deck, j, j + 1);

                } else if (deck.get(j) == deck.get(j + 1) && deck.get(j).getSuitNum() > deck.get(j + 1).getSuitNum()) {
                    Collections.swap(deck, j, j + 1);
                }

            }
        }
        System.out.println("--整理後--");

        for (Card c : deck) {
            System.out.println(c.getRankText() + "/" + c.getSuitText());
        }
        System.out.println("--NEXT--");
    }

    public void addCard(Card c) {
        deck.add(c);

    }

    public void removeCard(Card c) {
        deck.remove(c);

    }

    public void removeCard(Card[] cards) {//一次移除多張牌

        for (Card c : cards) {

            deck.remove(c);
        }
    }

    public void addCard(Card[] cards) {//一次加入多張牌
        for (Card c : cards) {
            deck.add(c);
        }

    }

    public void showDeck() {
        System.out.println("顯示牌堆");

        for(int i=0;i<deck.size();i++){

            System.out.println(i+":"+deck.get(i).getRankText()+"/"+deck.get(i).getSuitText());
        }
      /*  for (Poker.Card c : deck) {
            System.out.println(c.getRank() + "/" + c.getSuitText());

        }*/

    }

    public double countDeckValue(){
        double value=0;
        //
        for(Card c:this.getDeck()){
            value+=c.getValue();


        }
        return value;
    }

    public Card[] drawCardsFromTop(int drawNum) {

        //如果抽牌數超過牌組殘留張數
        if (drawNum > deck.size()) {
            drawNum = deck.size();

        }
        Card[] cards = new Card[drawNum];
        for (int i = 0; i < drawNum; i++) {
            try {
                cards[i] = deck.get(i);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("牌已經抽完了");
                break;
            }
        }
        System.out.println("顯示抽牌清單");
        for (Card c : cards) {

            System.out.println(c.getRankText() + "/" + c.getSuitText());
        }

        return cards;
    }

//    public double getValue(){
//        double d=0;
//        //假設是十點半或二十一點,也許做一個方法直接算出牌庫目前剩下的排點數加總,
//        //就可以很快的算出下一張牌的期望值
//        return d;
//    }
}
