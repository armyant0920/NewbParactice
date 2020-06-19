package Poker;

import java.util.*;
import java.util.function.ToIntFunction;

public class PokerTest {

    static Deck mainDeck = new Deck();//主牌庫

    static ArrayList<Deck> playerDeck = new ArrayList<>();
    static ArrayList<Card> handDeck = new ArrayList<>();//暫時拿來確認手牌用的變數
    static int draws = 5, roundDraw = 1;//開頭抽五張,每回合抽一張
    static int playerNum = 4;//先假設只有一個人在抽牌
    static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {


        Card card1=new Card(0,2);
        Card card2=new Card(0,0);
        Card card3=new Card(0,3);
        Card card4=new Card(0,1);
        Card card5=new Card(1,2);
        Card card6=new Card(1,0);

        Card card7=new Card(1,3);

        Card card8=new Card(1,1);
        ArrayList<Card> testDeck=new ArrayList<>();
        testDeck.add(card1);
        testDeck.add(card5);
        testDeck.add(card2);
        testDeck.add(card6);
        testDeck.add(card3);
        testDeck.add(card7);
        testDeck.add(card4);

        

        testDeck.add(card8);


        System.out.println(testDeck);
        System.out.println("==========按照文字=========");
        Collections.sort(testDeck,Comparator.comparing(Card::getSuitText));

        System.out.println(testDeck);
        System.out.println("==========文字反向=========");
        Collections.sort(testDeck,Comparator.comparing(Card::getSuitText).reversed());
        System.out.println(testDeck);

        System.out.println("=========直接用lamda調用預設Comparator方法");
        Collections.sort(testDeck,Comparator.comparingInt(Card::getNumber));

        System.out.println(testDeck);
        System.out.println("==========調用另外寫的Comparator========");
        Collections.sort(testDeck,new CardComparator());
        System.out.println(testDeck);


        System.out.println("============反排============");
        Collections.sort(testDeck,Comparator.reverseOrder());
        System.out.println(testDeck);

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
        handDeck.forEach(c -> System.out.println(c.getNumber() + "/" + c.getSuitNum()));


    }


    static class CardComparator implements Comparator<Card> {

        @Override
        public int compare(Card card1, Card card2) {
            int sort = 0;
            int x = card1.getNumber() - card2.getNumber();
            if (x != 0) {
                sort = (x > 0) ? 1 : -1;

            } else {
                x = card1.getSuitNum() - card2.getSuitNum();
                if (x != 0) {
                    sort = (x > 0) ? 1 : -1;
                }
            }
            return sort;

        }


    }
}



