package christmas.model;

public class Menu {
    // 카테고리, 이름, 가격
    private final String name;
    private final int price;
    private final String category;

    public Menu(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
