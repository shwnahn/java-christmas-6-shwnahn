package christmas;

import christmas.validator.OrderValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//[예외] (1) 메뉴판에 있는 메뉴가 아니면
//[예외] (2) 메뉴의 개수가 1 이상의 숫자가 아니면
//[예외] (3) 메뉴 형식이 예시와 다르면
//[예외] (4) 중복 메뉴를 입력하였으면
//[예외] (5) 음료만 주문 시, 주문할 수 없습니다.
//[예외] (6) 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.

public class OrderTest {
    String OrderErrorMessage = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    MenuRepository menuRepository = new MenuRepository();

    @Test
    void 메뉴판에_없는_메뉴() {
        // Given
        String invalidOrder = "햄버거-2,타코-3";

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> OrderValidator.validate(invalidOrder, menuRepository));

        // Then
        assertEquals(OrderErrorMessage, exception.getMessage());
    }

    @Test
    void 메뉴_개수가_1이상의_숫자가_아니면() {
        // Given
        String invalidOrder = "해산물파스타-0";

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> OrderValidator.validate(invalidOrder, menuRepository));

        // Then
        assertEquals(OrderErrorMessage, exception.getMessage());
    }

    @Test
    void 메뉴_형식이_다르면() {
        // Given
        String invalidOrder = "해산물파스타";

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> OrderValidator.validate(invalidOrder, menuRepository));

        // Then
        assertEquals(OrderErrorMessage, exception.getMessage());
    }

    @Test
    void 중복_메뉴_주문() {
        // Given
        String invalidOrder = "해산물파스타-1,해산물파스타-2";

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> OrderValidator.validate(invalidOrder, menuRepository));

        // Then
        assertEquals(OrderErrorMessage, exception.getMessage());
    }

    @Test
    void 음료만_주문() {
        // Given
        String invalidOrder = "제로콜라-2";

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> OrderValidator.validate(invalidOrder, menuRepository));

        // Then
        assertEquals(OrderErrorMessage, exception.getMessage());
    }

    @Test
    void 최대_주문_개수_초과_예외() {
        // Given
        String invalidOrder = "해산물파스타-21";

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> OrderValidator.validate(invalidOrder, menuRepository));

        // Then
        assertEquals(OrderErrorMessage, exception.getMessage());
    }
}
