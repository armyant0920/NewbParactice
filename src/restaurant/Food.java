package restaurant;

public class Food implements Comparable{
    private String category;
    private String name;
    private int price;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Food(String category, String name, int price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {


        return getPrice()-((Food) o).getPrice();
    }
}
