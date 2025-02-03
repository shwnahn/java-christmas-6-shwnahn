package christmas.model;

import java.util.List;

public class Order {
    // 주문에 대한 전반적인 정보 저장하는 클래스
    private final List<OrderItem> orderItems; // 무슨 메뉴를 얼마나
    private final int visitDate; // 방문일
    private final int totalPrice; // 총 주문금액

    public Order(List<OrderItem> orderItems, int visitDate) {
        this.orderItems = orderItems;
        this.visitDate = visitDate;
        this.totalPrice = sumPrices();
    }

    private int sumPrices() {
        return orderItems.stream()
                .mapToInt(item -> item.getMenu().getPrice() * item.getQuantity())
                .sum();
    }

    public int getVisitDate() {
        return visitDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
