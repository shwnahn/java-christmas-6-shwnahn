package christmas.view;

import christmas.model.OrderItem;

import java.util.List;

public class OutputView {
    public void printMenu(List<OrderItem> orderItems) {
        System.out.println("<주문 메뉴>");
        for (OrderItem item : orderItems) {
            System.out.println(item.getMenu().getName() + " " + item.getQuantity() + "개");
        }
    }

    public void printTotalPrice() {
        System.out.println("<할인 전 총주문 금액>");
    }

    public void printGift() {
        System.out.println("<증정 메뉴>");
    }

    public void printDiscount() {
        System.out.println("<혜택 내역>");
    }

    public void printDiscountAmount() {
        System.out.println("<총혜택 금액>");
    }

    public void printFinalPrice() {
        System.out.println("<할인 후 예상 결제 금액>");
    }

    public void printBadges() {
        System.out.println("<12월 이벤트 배지>");
    }
}