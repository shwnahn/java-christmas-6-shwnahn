package christmas;

import christmas.model.Order;
import christmas.repository.MenuRepository;
import christmas.repository.OrderRepository;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OrderRepository orderRepository = new OrderRepository();
        MenuRepository menuRepository = new MenuRepository();
        InputView inputView = new InputView(orderRepository, menuRepository);
        OutputView outputView = new OutputView();

        // 1. 식당 방문 날짜 지정
        int visitDate = inputView.readDate();

        // 2. 주문 메뉴•개수 선택
        Order order = inputView.getOrder(visitDate);

        // 3. 이벤트 플래너에서 정보 제공
        outputView.printMenu(order.getOrderItems());
        outputView.printTotalPrice();
        outputView.printGift();
        outputView.printDiscount();
        outputView.printDiscountAmount();
        outputView.printFinalPrice();
        outputView.printBadges();


    }
}
