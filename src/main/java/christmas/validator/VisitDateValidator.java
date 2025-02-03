package christmas.validator;

import static christmas.ErrorMessage.ERROR_INVALID_DATE;

public class VisitDateValidator {
    public static void validate(String day) {
        int dayInt;
        try {
            dayInt = Integer.parseInt(day);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_DATE);
        }
        if (dayInt < 1 || dayInt > 31) {
            throw new IllegalArgumentException(ERROR_INVALID_DATE);
        }
    }
}
