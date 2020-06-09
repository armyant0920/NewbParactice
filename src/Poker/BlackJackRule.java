package Poker;

public class BlackJackRule {

    private static final double MAX_DOUBLE = 21.0d;
    private static final String RuleDescription = "十點半規則:";

    private static final int drawNum=2;//如果是21點,一開始抽兩張



    //如果是21點,A還必須檢查目前手牌情形才回傳1or11...
    //new round建立時傳入適用規則
    //需判定大小時,再依對應規則計算
    public static double cardPoint(Card c) {//10點半沒有特殊的Ace計算,才能返回單張的值,而且其實返回單張的意義也不是很大

        if (c.getNumber() >= 0 && c.getNumber() <= 9) {
            return c.getNumber() + 1;

        } else if (c.getNumber() > 9 && c.getNumber() <= 12) {
            return 0.5;
        }
        return 0;
    }

    //21點適用傳牌組參數
    public static double cardPoint(Deck deck) {//21點的話,一開始就是發兩張牌,所以比較大小時必定是2張以上的手牌數字加總,所以參數為牌組
        int aceCount = 0;//用來統計ace出現次數
        double total = 0;
        for (Card c : deck.getDeck()) {
            if (c.getNumber() == 0) {
                aceCount++;
            }
            if (c.getNumber() > 0) {
                if (c.getNumber() <= 9) {
                    total += c.getNumber()+1;
                } else if (c.getNumber() <= 12) {
                    total += 10;
                }

            }
        }
        for (int i = 0; i < aceCount; i++) {
            if (total <= 10) {
                total += 11;
            } else {
                total++;
            }

        }
        return total;

    }


    //如果傳給這個方法的牌組點數超過常量,回傳true(爆排)
    public static boolean overLimit(Deck deck) {//這調用的是21點規則,10點半的之後再弄
        //return (deck.countDeckValue() > MAX_DOUBLE);
        double total = cardPoint(deck);
        if (total > MAX_DOUBLE) {
            return true;
        }
        return false;

    }
    //十點半下
//    public double getCardValue(Deck deck,Card card){
//        if (card.getNumber()>=0){
//            if(card.getNumber()<=9){
//                return card.getNumber()+1;
//            }
//        }
//
//        }
//        if(card.getNumber()<=12){
//            return 0.5;
//        }
//        System.out.println("傳入點數有誤");
//        return 0;
//    }
}
