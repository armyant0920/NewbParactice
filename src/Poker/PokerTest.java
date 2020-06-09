package Poker;

import java.util.*;

public class PokerTest {

    static Deck mainDeck = new Deck();//主牌庫

    static ArrayList<Deck> playerDeck = new ArrayList<>();
    static ArrayList<Card> handDeck = new ArrayList<>();//暫時拿來確認手牌用的變數
    static int draws = 5, roundDraw = 1;//開頭抽五張,每回合抽一張
    static int playerNum = 4;//先假設只有一個人在抽牌
    static Scanner input = new Scanner(System.in);

    //static Poker.Deck mainDeck=new Poker.Deck();


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        PokerTest round = new PokerTest();
        round.init();

        while (true) {
            System.out.println("輸入數字1抽牌,2確認牌組,3整理手牌,4變更下次抽牌數,5.開始新局,6.計算各牌庫點數");
            if (input.hasNextInt()) {

                switch (input.nextInt()) {
                    case 1:

                        drawAction();
                        break;
                    case 2:
                        mainDeck.showDeck();
                        for (Deck deck : playerDeck) {
                            deck.showDeck();
                        }
                        break;
                    case 3:
                        for (Deck deck : playerDeck) {
                            deck.sorting();

                        }
                        break;

                    case 4:
                        System.out.println("請輸入下次抽牌數");
                        if (input.hasNextInt()) {
                            draws = input.nextInt();
                            System.out.println("已設定下次抽" + draws + "張");
                        }
                        break;
                    case 5:
                        //重初始化一局
                        round.init();
                        break;
                    case 6:
                        //System.out.println("牌庫目前點數"+mainDeck.countDeckValue());
                        for (int i = 0; i < playerDeck.size(); i++) {
                            System.out.println("玩家" + i + "的點數總和為" + BlackJackRule.cardPoint(playerDeck.get(i)));
                            if (BlackJackRule.overLimit(playerDeck.get(i))) {
                                System.out.println("玩家" + i + "爆牌");
                            } else {
                                System.out.println("玩家" + i + "SAFE");
                            }
                        }
                        break;

                    default:
                        System.out.println("無效指令");

                }
            }
        }

       /* Poker.PokerTest round = new Poker.PokerTest();

        round.init();
        round.shuffle();
        round.drawCard(initDraw);
        round.showHandDeck();
        round.showDeck();*/

        //ArrayList<Poker.Card> deck=round.createDeck();


       /* ArrayList<Poker.Card> cards = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j <= 3; j++) {
                Poker.Card card = new Poker.Card(i, j);
                cards.add(card);

            }
        }
        for (Poker.Card c : cards) {

            System.out.println(c.getNumber() + "/" + c.getSuits());
        }

        System.out.println("用ArrayList創牌組,用Collections洗牌==================================");
        for (int i = 0; i < cards.size(); i++) {
            int j = (int) (Math.random() * cards.size());
            Collections.swap(cards, i, j);

        }

        for (Poker.Card c : cards) {

            System.out.println(c.getNumber() + "/" + c.getSuits());
        }

        System.out.println("下面用一般陣列創牌組並洗牌================================");
        Poker.Card[] cardDeck = new Poker.Card[52];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                cardDeck[i * 4 + j] = new Poker.Card(i + 1, j);

            }
        }
        for (int i = 0; i < cardDeck.length; i++) {
            int j = (int) (Math.random() * cardDeck.length);
            Poker.Card temp = cardDeck[i];
            cardDeck[i] = cardDeck[j];
            cardDeck[j] = temp;
        }
        for (Poker.Card c : cardDeck) {

            System.out.println(c.getNumber() + "/" + c.getSuits());
        }*/
    }

    public static void drawAction() {
        for (int i = 0; i < playerDeck.size(); i++) {
            Card[] tempCards = mainDeck.drawCardsFromTop(draws);
            playerDeck.get(i).addCard(tempCards);
            mainDeck.removeCard(tempCards);
        }

    }

    public void createPlayerDeck() {


    }


    public void init() {

        //第一個陣列,是拿來初始化牌庫的
//        if (!deck.isEmpty()) {
//            System.out.println("清除牌庫");
//
//        }
        mainDeck.clearDeck();//清空
        mainDeck.newDeck();//重新創一副52張牌的新牌庫
        System.out.println("創建新牌庫");
        mainDeck.shuffle();
        System.out.println("牌庫洗牌");

        playerDeck.clear();//玩家的牌庫也清空
        System.out.println("輸入玩家數量");

        playerNum = input.nextInt();
        for (int i = 0; i < playerNum; i++) {
            Deck deck = new Deck();
            playerDeck.add(deck);//根據玩家數量增加ArrayList長度
        }

    }


    //顯示手牌
    public void showHandDeck() {
        System.out.println("顯示目前手牌");
//        handDeck.sort((Comparator<? super Poker.Card>) handDeck);
        for (int i = 0; i < handDeck.size(); i++) {//這邊直接幫手牌作排序
            for (int j = 0; j < handDeck.size() - 1; j++) {
                if (handDeck.get(j).getNumber() > handDeck.get(j + 1).getNumber()) {
                    Collections.swap(handDeck, j, j + 1);
                }
            }

        }

//        for (Card c : handDeck) {
//            System.out.println(c.getNumber() + "/" + c.getSuitNum());
//
//        }
        handDeck.forEach(c -> System.out.println(c.getNumber()+"/"+c.getSuitNum()));


    }


    class deckSort implements Comparator {

        /*@Override
        public int compare(Poker.Card card1, Poker.Card card2) {
            int num1=card1.getNumber();
            int num2=card2.getNumber();
            String suit1=card1.getSuits();
            return 0;
        }*/

        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }
    }


}
