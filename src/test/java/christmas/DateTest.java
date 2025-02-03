package christmas;

import christmas.validator.VisitDateValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest {
    String DateErrorMessage = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    @Test
    void 날짜_정상_입력_시_저장() {
        // Given
        String validDay = "15";
        // When, Then
        assertDoesNotThrow(() -> VisitDateValidator.validate(validDay));
    }

    @Test
    void 날짜_최소값_미만_예외() {
        // Given
        String invalidDay = "0";
        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> VisitDateValidator.validate(invalidDay));
        // Then
        assertEquals(DateErrorMessage, exception.getMessage());
    }

    @Test
    void 날짜_최대값_초과_예외() {
        // Given
        String invalidDay = "32";
        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> VisitDateValidator.validate(invalidDay));
        // Then
        assertEquals(DateErrorMessage, exception.getMessage());
    }

    @Test
    void 날짜_숫자이외입력_예외() {
        // Given
        String invalidString = "abc";
        String invalidDouble = "12.3";
        // When
        Exception exceptionString = assertThrows(IllegalArgumentException.class, () -> VisitDateValidator.validate(invalidString));
        Exception exceptionDouble = assertThrows(IllegalArgumentException.class, () -> VisitDateValidator.validate(invalidDouble));
        // Then
        assertEquals(DateErrorMessage, exceptionString.getMessage());
        assertEquals(DateErrorMessage, exceptionDouble.getMessage());
    }
}
