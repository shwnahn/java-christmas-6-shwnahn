package christmas.model;

public class OrderItem {
    // 주문 내 개별 메뉴 종류와 개수 저장하는 클래스
    private final Menu menu;       // 메뉴 종류
    private final int quantity;    // 메뉴 개수

    public OrderItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }
}
