package christmas.validator;

import christmas.model.Menu;
import christmas.model.OrderItem;
import christmas.repository.MenuRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static christmas.ErrorMessage.ERROR_INVALID_ORDER;
import static christmas.ErrorMessage.ERROR_INVALID_ORDER_ONLY_DRINKS;

public class OrderValidator {
    // 리팩토링: 변환된 OrderItem 리스트를 검증
    public static void validate(List<OrderItem> orderItems, MenuRepository menuRepository) {
        Set<String> uniqueMenus = new HashSet<>();
        boolean hasNonDrinkMenu = false;
        int totalMenuCount = 0;

        for (OrderItem orderItem : orderItems) {
            String menuName = orderItem.getMenu().getName();
            int menuCount = orderItem.getQuantity();

            //[예외] (1) 메뉴판에 있는 메뉴가 아니면
            Menu menu;
            try {
                menu = menuRepository.findByName(menuName);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(ERROR_INVALID_ORDER);
            }

            //[예외] (2) 메뉴의 개수가 1 이상의 숫자가 아니면
            if (menuCount < 1) {
                throw new IllegalArgumentException(ERROR_INVALID_ORDER);
            }

            //[예외] (4) 중복 메뉴를 입력하였으면
            if (!uniqueMenus.add(menuName)) { // uniqueMenus는 중복 허용안되는 HashSet이기에 add() 메서드가 false를 반환하면 중복된 것
                throw new IllegalArgumentException(ERROR_INVALID_ORDER);
            }

            //[예외] (5) 음료만 주문 시, 주문할 수 없습니다.
            if (!menu.getCategory().equals("음료")) { // 음료 카테고리가 아니면
                hasNonDrinkMenu = true;
            }

            totalMenuCount += menuCount;
        }

        if (!hasNonDrinkMenu) {
            throw new IllegalArgumentException(ERROR_INVALID_ORDER_ONLY_DRINKS);
        }

        //[예외] (6) 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.
        if (totalMenuCount > 20) {
            throw new IllegalArgumentException(ERROR_INVALID_ORDER);
        }
    }
}
