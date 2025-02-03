package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Order;
import christmas.repository.MenuRepository;
import christmas.repository.OrderRepository;
import christmas.service.OrderService;
import christmas.validator.VisitDateValidator;

public class InputView {
    private final OrderService orderService;
    public InputView(OrderRepository orderRepository, MenuRepository menuRepository) {
        this.orderService = new OrderService(orderRepository, menuRepository);
    }

    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        VisitDateValidator.validate(input);
        return Integer.parseInt(input);
    }

    public Order getOrder(int visitDate) {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();
        return orderService.makeOrder(input, visitDate);
    }
}