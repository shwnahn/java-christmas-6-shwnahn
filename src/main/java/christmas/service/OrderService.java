package christmas.service;

import christmas.model.Menu;
import christmas.model.Order;
import christmas.model.OrderItem;
import christmas.repository.MenuRepository;
import christmas.repository.OrderRepository;
import christmas.validator.OrderValidator;

import java.util.ArrayList;
import java.util.List;

import static christmas.ErrorMessage.ERROR_INVALID_ORDER;

public class OrderService {
    // Input 파싱 후, Order 객체 생성

    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;

    public OrderService(OrderRepository orderRepository, MenuRepository menuRepository) {
        this.orderRepository = orderRepository;
        this.menuRepository = menuRepository;
    }

    public Order makeOrder(String orderInput, int visitDate) {
        List<OrderItem> orderItems = parseOrder(orderInput);
        OrderValidator.validate(orderItems, menuRepository);

        Order order = new Order(orderItems, visitDate);
        orderRepository.addOrder(order);
        return order;
    }

    private List<OrderItem> parseOrder(String orderInput) {
        // 문자열을 파싱해서 OrderItem 리스트를 반환
        String[] orderItems = orderInput.split(",");
        List<OrderItem> orderItemList = new ArrayList<>();

        for (String orderItem : orderItems) {
            String[] parts = orderItem.split("-");

            //[예외] (3) 메뉴 형식이 예시와 다르면
            if (parts.length != 2) {
                throw new IllegalArgumentException(ERROR_INVALID_ORDER);
            }
            String menuName = parts[0].trim();
            int menuCount;
            try {
                menuCount = Integer.parseInt(parts[1].trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_INVALID_ORDER);
            }
            //[예외] (1) 메뉴판에 있는 메뉴가 아니면
            Menu menu;
            try {
                menu = menuRepository.findByName(menuName);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(ERROR_INVALID_ORDER);
            }

            orderItemList.add(new OrderItem(menu, menuCount));
        }
        return orderItemList;
    }
}
