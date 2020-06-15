package compare;

public class StockData implements Comparable<StockData> {

    private String stockName;
    private int stockRef;
    private double stockPrice;
    private final int BY_NAME = 1, BY_REF = 2, BY_PRICE = 3;
    private int compareType;

    public StockData(String stockName, int stockRef, double stockPrice) {
        this.stockName = stockName;
        this.stockRef = stockRef;
        this.stockPrice = stockPrice;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getStockRef() {
        return stockRef;
    }

    public void setStockRef(int stockRef) {
        this.stockRef = stockRef;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    @Override
    public String toString() {
        return "StockData{" +
                "stockName='" + stockName + '\'' +
                ", stockRef=" + stockRef +
                ", stockPrice=" + stockPrice +
                '}';
    }

    @Override
    public int compareTo(StockData o) {

        if (getStockRef() < o.getStockRef()) {
            return -1;
        } else if (getStockRef() == o.getStockRef()) {
            return 0;
        } else if (getStockRef() > o.getStockRef()) {
            return 1;
        }
        return 0;
    }

    public int compareToByName(StockData o) {
        int sort = getStockName().compareTo(o.stockName);
        if (sort > 0) {
            return 1;
        } else if (sort == 0) {
            return 0;
        } else {
            return -1;
        }

    }
    public int compareToByName2(StockData o) {
        int sort = getStockName().compareTo(o.stockName);
        if (sort > 0) {
            return -1;
        } else if (sort == 0) {
            return 0;
        } else {
            return 1;
        }

    }

    public int compareByPrice(StockData o){
        if(getStockPrice()>o.getStockPrice()){
            return 1;
        }else if(getStockPrice()<o.getStockPrice()){
            return -1;
        }else{
            return 0;
        }

    }

    public int compareByPrice2(StockData o){
        if(getStockPrice()>o.getStockPrice()){
            return -1;
        }else if(getStockPrice()<o.getStockPrice()){
            return 1;
        }else{
            return 0;
        }

    }





}
